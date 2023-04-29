package tn.biat.biat.services.implementations;

import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import tn.biat.biat.entities.otherDB.*;
import tn.biat.biat.repository.AttachementRepository;
import tn.biat.biat.repository.ClassificationRepository;
import tn.biat.biat.repository.UserRepository;
import tn.biat.biat.services.IClassificationService;
import tn.biat.biat.services.IFunctionService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@Slf4j
public class ClassificationService implements IClassificationService {

    @Autowired
    ClassificationRepository classificationRepository;
    @Autowired
    IFunctionService iFunctionService;
    @Autowired
    AttachementRepository attachementRepository;
    @Autowired
    UserRepository userRepository;

    @Value("${spring.datasource.url}")
    private String DBURL;
    @Value("${spring.datasource.username}")
    private String user;
    @Value("${spring.datasource.password}")
    private String password;
    @Autowired
    JavaMailSender javaMailSender;

    /*public Client getClientByCompte(String cpte){
        String query = "select * from \"Client\" c where account ='" + cpte + "'";
        JSONArray json = iFunctionService.queryinput(query);
        JSONObject jsonObject = (JSONObject) json.get(0);
        Client client = new Client();
        client.setAccount(jsonObject.getAsString("account"));
        client.setCode(jsonObject.getAsString("code"));
        client.setProfile(jsonObject.getAsString("profile"));
        client.setUsername(jsonObject.getAsString("username"));
        return client;
    }*/
    @Override
    public Client getClientByCompte(String cpte){
        List<Classification> list = classificationRepository.findAll();
        Client client;
        for (Classification c : list){
            if(c.getClient().getAccount().equals(cpte)){
                client = c.getClient();
                return client;
            }else {
                return null;
            }
        }
        System.out.println("khrajj");
        return null;
    }

    @Override
    public Client getClient(String account){
        String query = "select * from \"Client\" c where account ='" + account + "'";
        JSONArray json = iFunctionService.queryinput(query);
        JSONObject jsonObject = (JSONObject) json.get(0);
        Client client = new Client();
        client.setAccount(jsonObject.getAsString("account"));
        client.setCode(jsonObject.getAsString("code"));
        client.setProfile(jsonObject.getAsString("profile"));
        client.setUsername(jsonObject.getAsString("username"));
        return client;
    }

    @Override
    public Classification add(Classification classification,String cpte){
        Client c = this.getClient(cpte);
        if(c == null){
            return null;
        }else{
            System.out.println(c);
            classification.setCommentaire(classification.getCommentaire());
            classification.setDecision(classification.getDecision());
            classification.setClasse(classification.getClasse());
            classification.setMotif(classification.getMotif());
            classification.setClient(c);
            classificationRepository.save(classification);
            System.out.println("classification  "+classification);
            return classification;
        }
    }

    public Classification getById(Long id){
        return classificationRepository.findById(id).orElse(null);
    }

    @Override
    public Classification getClassificationByClientaccount(String account){
        Classification c = classificationRepository.getClassificationByClientaccount(account);
        return c;
    }

    @Override
    public boolean isDeposited(String account){
        Classification c = classificationRepository.getClassificationByClientaccount(account);
        if(c == null){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public boolean updateClassification(String account, String motif, String decision, Integer classe){
        Classification c = this.getClassificationByClientaccount(account);
        if(c == null){
            return false;
        }else{
            c.setClasse(classe);
            c.setMotif(motif);
            c.setDecision(decision);
            classificationRepository.save(c);
            List<User> agencies = this.userRepository.geAlltByLib(c.getClient().getCode());
            System.err.println(agencies.toString());
            for(User ag : agencies){
                this.sendEmail(ag.getEmail(), "Classement du client : "+c.getClient().getAccount(), "Bonjour "+ag.getUserFirstName()+" "+ag.getUserLastName()+",\n" +
                        "\n" +
                        "Je voulais vous informer que notre client '"+c.getClient().getUsername()+"', titulaire du compte '"+c.getClient().getAccount()+"', a été classé. Si vous avez des questions, n'hésitez pas à me contacter.\n" +
                        "\n" +
                        "Cordialement.");
            }
            return true;
        }
    }

    @Override
    public boolean updateClassificationAttachements(Long id, String name, String size, String type,String url){
        Classification c = this.getById(id);
        if(c==null){
            return false;
        }else{
            Attachement att = new Attachement();
            att.setName(name);
            att.setType(type);
            att.setSize(size);
            att.setPath(url);
            attachementRepository.save(att);
            System.out.println(att);
            String QUERY ="INSERT INTO public.\"Classification_attachements\" (\"Classification_id\", attachements_id) VALUES("+c.getId()+","+att.getId()+");\n";
            try (Connection conn = DriverManager.getConnection(DBURL, user, password);) {
                try (PreparedStatement st = conn.prepareStatement(QUERY)) {
                    int result = st.executeUpdate(); // execute update query

                    // check if the query affected any rows
                    if (result == 0) {
                        System.out.println("No rows affected.");
                    } else {
                        System.out.println(result + " rows affected.");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return true;
    }

    @Async
    public void sendEmail(String to, String sub, String msg){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(to);
        mailMessage.setSubject(sub);
        mailMessage.setText(msg);
        mailMessage.setFrom("ons.kechrid@esprit.tn");
        javaMailSender.send(mailMessage);
    }
    @Override
    public Map<String, Integer> getClassificationByIds(List<String> list){
        Map<String, Integer> map = new HashMap<>();
        for(String acc : list){
            Classification cc =this.classificationRepository.getClassificationByClientaccount(acc);
            if(cc != null)
                map.put(acc, cc.getClasse());
            else
                map.put(acc, -1);
        }
        return map;
    }

}
