package tn.biat.biat.services.implementations;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import tn.biat.biat.entities.otherDB.*;
import tn.biat.biat.repository.AttachementRepository;
import tn.biat.biat.repository.MessageRepository;
import tn.biat.biat.repository.UserRepository;
import tn.biat.biat.services.IAttachementService;
import tn.biat.biat.services.IFunctionService;
import tn.biat.biat.services.IMessageService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class MessageService implements IMessageService {

    @Autowired
    MessageRepository messageRepository;
    @Autowired
    AttachementRepository attachementRepository;
    @Autowired
    IFunctionService iFunctionService;
    @Autowired
    CustomUserDetailsService userService;
    @Autowired
    UserRepository userRepository;
    HistoryService historyService;
    @Autowired
    JavaMailSender javaMailSender;

    @Value("${spring.datasource.url}")
    private String DBURL;
    @Value("${spring.datasource.username}")
    private String user;
    @Value("${spring.datasource.password}")
    private String password;


    @Autowired
    public MessageService( @Lazy HistoryService historyService){
        this.historyService = historyService;
    }

    @Override
    public List<Message> getAll(){
        return messageRepository.findAll();
    }


    @Override
    public Message add(Message message){
        message.setReceiver(message.getReceiver());
        message.setSender(userService.getLoggedInUser().getEmail());
        message.setIdResponseMessage(message.getIdResponseMessage());
        if(message.getIdResponseMessage() != null){
            Message m = messageRepository.findById(message.getIdResponseMessage()).orElse(null);
            System.out.println(m);
            if(m == null){
                return null;
            }else{
                message.setObject(m.getObject());
                message.setCodeclient(m.getCodeclient());
                message.setCompteclient(m.getCompteclient());
                message.setType(message.getType());
            }
        }else{
            message.setObject(message.getObject());
            message.setCodeclient(message.getCodeclient());
            message.setCompteclient(message.getCompteclient());
            message.setType(message.getType());
        }
        message.setText(message.getText());
        message.setTimestamp(LocalDateTime.now());
        message.setAttachements(null);
        message.setImportant(false);
        if(message.getType().equals("MESSAGE")){
            message.setProcessStatus("Sent");
        }else {
            message.setProcessStatus("Déposée");
        }
        message.setStatus(null);
        messageRepository.save(message);
        if(Objects.equals(message.getType(),"RECLAMATION")){
            historyService.updateUserHistories("ADD","passé une réclamation de type '"+message.getObject()+"'");
        }else{
            historyService.updateUserHistories("ADD","envoyé un message à '"+message.getReceiver()+"'");
        }
        this.sendEmail("onskechrid1999@gmail.com","Réclamation : "+message.getType(), "Bonjour,\n" +
                "\n" +
                "Je souhaite vous informer qu'une nouvelle réclamation a été ajoutée par "+message.getSender()+" concernant la situation du client titulaire du compte "+message.getCompteclient()+" et du code "+message.getCodeclient()+".\n" +
                "\n" +
                "Cordialement,");

        return message;
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
    public Message getById(Long id){
        return messageRepository.findById(id).orElse(null);
    }


    @Override
    public boolean updateProcessStatus(Long id, String newStatus){
        Message m = this.getById(id);
        if(m == null){
            return false;
        }else{
            m.setProcessStatus(newStatus);
            messageRepository.save(m);
            return true;
        }
    }

    @Override
    public boolean updateStatus(Long id, String newStatus){
        Message m = this.getById(id);
        if(m == null){
            return false;
        }else{
            if(newStatus == null){
                m.setStatus(null);
            }else{
                m.setStatus(newStatus);
            }
            messageRepository.save(m);
            return true;
        }
    }

    @Override
    public boolean updateReclamationAttachements(Long id, String name, String size, String type,String url){
        Message m = this.getById(id);
        if(m==null){
            return false;
        }else{
            Attachement att = new Attachement();
            att.setName(name);
            att.setType(type);
            att.setSize(size);
            att.setPath(url);
            attachementRepository.save(att);
            System.out.println(att);
            String QUERY ="INSERT INTO public.\"Message_attachements\" (\"Message_id\", attachements_id) VALUES ("+m.getId()+","+att.getId()+");";
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
        historyService.updateUserHistories("UPDATE", "Update menu attachements");
        return true;
    }

    @Override
    public int numberUntreatedMessages(){
        int i = messageRepository.numberUntreatedMessages();
        return i;
    }

    @Override
    public int numberTreatedMessages(){
        int i = messageRepository.numberTreatedMessages();
        return i;
    }

    @Override
    public int numberRefusedReclamations(){
        int i = messageRepository.numberRefusedReclamations();
        return i;
    }

    @Override
    public int numberMIReclamations(){
        int i = messageRepository.numberMIReclamations();
        return i;
    }

    @Override
    public boolean updateText(Long id, String newText){
        Message m = this.getById(id);
        if(m == null){
            return false;
        }else{
            m.setText(newText);
            m.setTimestamp(LocalDateTime.now());
            messageRepository.save(m);
            return true;
        }
    }


    @Override
    public List<Long> getMessagesForChat(Long id){
        List<Long> list = messageRepository.getMessagesForChat(id);
        return list;
    }

    @Override
    public List<Message> untreatedReclamations(){
        List<Message> list = messageRepository.untreatedReclamations();
        return list;
    }

    @Override
    public List<Message> treatedReclamations(){
        List<Message> list = messageRepository.treatedReclamations();
        return list;
    }

    @Override
    public List<Message> miReclamations(){
        List<Message> list = messageRepository.miReclamations();
        return list;
    }

    @Override
    public List<Message> refusedReclamations(){
        List<Message> list = messageRepository.refusedReclamations();
        return list;
    }

    @Override
    public Message getResponseMessage(Long id){
        Message message = messageRepository.getResponseMessage(id);
        return message;
    }

    @Override
    public List<Message> getTopLevelMessages(){
        List list = messageRepository.getTopLevelMessages();
        return list;
    }



    @Override
    public List<Long> getMessageChain(Long idd) {
        String query = "WITH RECURSIVE message_chain AS (\n" +
                "  SELECT id FROM \"Message\" m WHERE id ="+ idd +"UNION \n" +
                "  SELECT m2.id FROM \"Message\" m2 JOIN message_chain mc ON m2.idresponsemessage = mc.id\n" +
                ")\n" +
                "SELECT id FROM \"Message\" WHERE id IN (SELECT id FROM message_chain) ORDER BY timestamp DESC";
        JSONArray json = iFunctionService.queryinput(query);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonArray = null;
        try {
            jsonArray = mapper.readTree(String.valueOf(json));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        List list = new ArrayList();
        for (JsonNode jsonNode : jsonArray) {
            Long id = jsonNode.get("id").asLong();
            list.add(id);
        }
        System.out.println(list);
        return list;
    }
}
