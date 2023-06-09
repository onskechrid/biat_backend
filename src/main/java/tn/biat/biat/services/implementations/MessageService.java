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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tn.biat.biat.entities.otherDB.*;
import tn.biat.biat.repository.AttachementRepository;
import tn.biat.biat.repository.MessageRepository;
import tn.biat.biat.repository.TreeRepository;
import tn.biat.biat.repository.UserRepository;
import tn.biat.biat.services.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

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
    ITreeService iTreeService;
    @Autowired
    TreeRepository treeRepository;
    @Autowired
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
        }else {
            message.setObject(message.getObject());
            message.setCodeclient(message.getCodeclient());
            message.setCompteclient(message.getCompteclient());
            message.setType(message.getType());
        }
        message.setMotif(message.getMotif());
        message.setClasse(message.getClasse());
        message.setText(message.getText());
        message.setTimestamp(LocalDateTime.now());
        message.setAttachements(null);
        message.setUrl(message.getUrl());
        if(message.getType().equals("MESSAGE")){
            message.setProcessStatus("Sent");
        }else if(message.getType().equals("CLASSIFICATION") || message.getType().equals("ReCLASSIFICATION")){
            message.setProcessStatus("Déposé");
        }else {
            message.setProcessStatus("Déposée");
        }
        message.setStatus(null);
        messageRepository.save(message);
        if(Objects.equals(message.getType(),"RECLAMATION")){
            historyService.updateUserHistories("ADD","passé une réclamation de type '"+message.getObject()+"'");
        }else if(Objects.equals(message.getType(), "MESSAGE")){
            historyService.updateUserHistories("ADD","envoyé un message à '"+message.getReceiver()+"'");
        }else{
            historyService.updateUserHistories("ADD","passé une réclamation de classification '");
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
    public boolean updateMotifAndClasse(Long id, String motif, Integer classe){
        Message m = this.getById(id);
        if(m == null){
            return false;
        }else{
            m.setClasse(classe);
            m.setMotif(motif);
            messageRepository.save(m);
            return true;
        }
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

////////////////////////////////////////////// CLASSIFICATION

    @Override
    public Map<String, Integer> getClassificationByIds(List<String> list){
        Map<String, Integer> map = new HashMap<>();
        for(String acc : list){
            Message cc =messageRepository.getMessageBYCompteClient(acc);
            if(cc != null)
                map.put(acc, cc.getClasse());
            else
                map.put(acc, -1);
        }
        return map;
    }
    @Override
    public Map<String, String> getClassificationByIds2(List<String> list){
        Map<String, String> map = new HashMap<>();
        for(String acc : list){
            Message cc =messageRepository.getMessageBYCompteClient(acc);
            if(cc != null)
                map.put(acc, cc.getStatus());
            else
                map.put(acc, null);
        }
        return map;
    }

    @Override
    public Map<String, String> getClassificationByIds3(List<String> list){
        System.err.println("dkhalllllllll");
        Map<String, String> map = new HashMap<>();
        for(String acc : list){
            Message cc = messageRepository.getMessageBYCompteClient(acc);
            if(cc != null)
                map.put(acc, cc.getProcessStatus());
            else
                map.put(acc, null);
        }
        return map;
    }

    @Override
    public Integer getClassifiedClientsNumber(){
        Integer n = messageRepository.getClassifiedClientsNumber();
        return n;
    }

    @Override
    public Integer getEnattenteClientsNumber(){
        Integer n = messageRepository.getEnattenteClientsNumber();
        return n;
    }

    @Override
    public Integer getRefuseeClientsNumber(){
        Integer n = messageRepository.getRefuseeClientsNumber();
        return n;
    }

    @Override
    public Integer getDeposeClientsNumber(){
        Integer n = messageRepository.getDeposeClientsNumber();
        return n;
    }

    @Override
    public Message getMessageBYCompteClient(String account){
        Message m = messageRepository.getMessageBYCompteClient(account);
        return m;
    }

    @Autowired
    IClientService iClientService;
    @Override
    public Client getClientByAccount(String account){
        Client c = iClientService.getById(account);
        return c;
    }

    //All Clients
    public static String QUERY = "SELECT cl.code as code,t.cpte, nom, risk_brut, garded, risk_net, agios_res, prov_req, t.classe,\n" +
            "t2.clasimp, t2.clasgel, t2.classub, t2.clascon, t.motif FROM tab1 t \n" +
            "INNER JOIN tab2 t2 ON t.cpte = t2.cpte inner join \"Client\" cl on t.cpte = cl.account ";

    @Override
    public String getFilteredQuery(Long iduser, String processStatus, String status , String all){ //Classé ou En attente ou Refusé ou All
        String q = "";
        User u = userService.getUserById(iduser);
        if(u == null){
            return null;
        }else{
            if(u.getProfile().getProfileType().equals("AGENCE") || u.getProfile().getProfileType().equals("CA")){
                if(!processStatus.equals("null")){
                    q = QUERY+" inner JOIN \"Message\" m ON t.cpte = m.compteclient where m.\"type\" = 'CLASSIFICATION' and m.processstatus = '"+processStatus+"' and cl.code ='"+u.getLibelle()+"'";
                }else if(!status.equals("null")){
                    q = QUERY+" inner JOIN \"Message\" m ON t.cpte = m.compteclient where m.\"type\" = 'CLASSIFICATION' and m.status = '"+status+"' and cl.code ='"+u.getLibelle()+"'";
                }else if(all.equals("yes")) {
                    q = QUERY + " where cl.code ='" + u.getLibelle() + "'";
                }else{
                    q = QUERY + " inner JOIN \"Message\" m ON t.cpte = m.compteclient where m.\"type\" = 'CLASSIFICATION' and cl.code ='" + u.getLibelle() + "'";
                }
            }else if(u.getProfile().getProfileType().equals("ZONE")||u.getProfile().getProfileType().equals("GROUPE")){
                List<String> AgenceByZone = iTreeService.getAgenceByZone(u.getId());
                String codes = AgenceByZone.stream().map(s -> "'" + s + "'").collect(Collectors.joining(", "));
                if(!processStatus.equals("null")){
                    q = QUERY+" inner JOIN \"Message\" m ON t.cpte = m.compteclient where m.\"type\" = 'CLASSIFICATION' and m.processstatus = '"+processStatus+"' and cl.code in ("+u.getLibelle()+")";
                }else if(!status.equals("null")){
                    q = QUERY+" inner JOIN \"Message\" m ON t.cpte = m.compteclient where m.\"type\" = 'CLASSIFICATION' and m.status = '"+status+"' and cl.code in ("+codes+")";
                }else if(all.equals("yes")){
                    q = QUERY+" where cl.code in ("+codes+")";
                }else{
                    q = QUERY+" inner JOIN \"Message\" m ON t.cpte = m.compteclient where m.\"type\" = 'CLASSIFICATION' and cl.code in ("+codes+")";
                }
            }else if(Objects.equals(u.getProfile().getProfileType(), "REGION")) {
                List<String> AgenceByRegion = iTreeService.getAgenceByRegion(u.getId());
                String codes = AgenceByRegion.stream().map(s -> "'" + s + "'").collect(Collectors.joining(", "));
                if(!processStatus.equals("null")){
                    q = QUERY+" inner JOIN \"Message\" m ON t.cpte = m.compteclient where m.\"type\" = 'CLASSIFICATION' and m.processstatus = '"+processStatus+"' and cl.code in ("+u.getLibelle()+")";
                }else if(!status.equals("null")){
                    q = QUERY+" inner JOIN \"Message\" m ON t.cpte = m.compteclient where m.\"type\" = 'CLASSIFICATION' and m.status = '"+status+"' and cl.code in ("+codes+")";
                }else if(all.equals("yes")){
                    q = QUERY+" where cl.code in ("+codes+")";
                }else{
                    q = QUERY+" inner JOIN \"Message\" m ON t.cpte = m.compteclient where m.\"type\" = 'CLASSIFICATION' and cl.code in ("+codes+")";
                }
            }else if(Objects.equals(u.getProfile().getProfileType(), "PCB") || Objects.equals(u.getProfile().getProfileType(), "PBD")) {
                List<String> AgenceByPole = iTreeService.getAgenceByPole(u.getId());
                System.out.println(AgenceByPole);
                String codes = AgenceByPole.stream().map(s -> "'" + s + "'").collect(Collectors.joining(", "));
                if(!processStatus.equals("null")){
                    q = QUERY+" inner JOIN \"Message\" m ON t.cpte = m.compteclient where m.\"type\" = 'CLASSIFICATION' and m.processstatus = '"+processStatus+"' and cl.code in ("+u.getLibelle()+")";
                }else if(!status.equals("null")){
                    q = QUERY+" inner JOIN \"Message\" m ON t.cpte = m.compteclient where m.\"type\" = 'CLASSIFICATION' and m.status = '"+status+"' and cl.code in ("+codes+")";
                }else if(all.equals("yes")){
                    q = QUERY+" where cl.code in ("+codes+")";
                }else{
                    q = QUERY+" inner JOIN \"Message\" m ON t.cpte = m.compteclient where m.\"type\" = 'CLASSIFICATION' and cl.code in ("+codes+")";
                }
            }else{
                if(!processStatus.equals("null")){
                    System.err.println(processStatus);
                    q = QUERY+" inner JOIN \"Message\" m ON t.cpte = m.compteclient where m.\"type\" = 'CLASSIFICATION' and m.processstatus = '"+processStatus+"'";
                }else if(!status.equals("null")){
                    System.err.println("s "+status);
                    q = QUERY+" inner JOIN \"Message\" m ON t.cpte = m.compteclient where m.\"type\" = 'CLASSIFICATION' and m.status = '"+status+"'";
                }else if(all.equals("yes")){
                    System.err.println(all);
                    q = QUERY;
                }else{
                    q = QUERY+" inner JOIN \"Message\" m ON t.cpte = m.compteclient where m.\"type\" = 'CLASSIFICATION' and m.processstatus = 'Déposé' and m.status isnull";
                }
            }
            return q;
        }
    }


    public String getFilteredQuery22(String profileType,String value){
        String q = "";

        System.err.println(profileType +" " + value);
        if(profileType.equals("AGENCE") || profileType.equals("CA")){
            q = QUERY + " inner JOIN \"Message\" m ON t.cpte = m.compteclient where m.\"type\" = 'CLASSIFICATION' and cl.code ='" + value + "'";
        }else if(profileType.equals("ZONE")||profileType.equals("GROUPE")){
            List<String> AgenceByZone = treeRepository.getAgencesByZone(value);
            String codes = AgenceByZone.stream().map(s -> "'" + s + "'").collect(Collectors.joining(", "));
            q = QUERY+" inner JOIN \"Message\" m ON t.cpte = m.compteclient where m.\"type\" = 'CLASSIFICATION' and cl.code in ("+codes+")";
        }else if(profileType.equals("REGION")) {
            List<String> AgenceByRegion = treeRepository.getAgencesByRegion(value);
            String codes = AgenceByRegion.stream().map(s -> "'" + s + "'").collect(Collectors.joining(", "));
            q = QUERY+" inner JOIN \"Message\" m ON t.cpte = m.compteclient where m.\"type\" = 'CLASSIFICATION' and cl.code in ("+codes+")";
        }else if(profileType.equals("PCB") || profileType.equals("PBD")) {
            List<String> AgenceByPole = treeRepository.getAgencesByPole(value);
            System.out.println(AgenceByPole);
            String codes = AgenceByPole.stream().map(s -> "'" + s + "'").collect(Collectors.joining(", "));
            q = QUERY+" inner JOIN \"Message\" m ON t.cpte = m.compteclient where m.\"type\" = 'CLASSIFICATION' and cl.code in ("+codes+")";
        }else{
            q = QUERY+" inner JOIN \"Message\" m ON t.cpte = m.compteclient where m.\"type\" = 'CLASSIFICATION' and m.processstatus = 'En attente'";
        }
        return q;
    }

    @Override
    public String getFilteredQuery2(Long iduser, String agence,String zone, String region, String pole){
        String q = "";
        if(!agence.equals("null") && !agence.equals("default")){
            q = QUERY + " inner JOIN \"Message\" m ON t.cpte = m.compteclient where m.\"type\" = 'CLASSIFICATION' and cl.code ='" + agence + "'";
        }else if(!zone.equals("null") && !zone.equals("default")){
            List<String> AgenceByZone = treeRepository.getAgencesByZone(zone);
            String codes = AgenceByZone.stream().map(s -> "'" + s + "'").collect(Collectors.joining(", "));
            q = QUERY+" inner JOIN \"Message\" m ON t.cpte = m.compteclient where m.\"type\" = 'CLASSIFICATION' and cl.code in ("+codes+")";
        }else if(!region.equals("null") && !region.equals("default")) {
            List<String> AgenceByRegion = treeRepository.getAgencesByRegion(region);
            String codes = AgenceByRegion.stream().map(s -> "'" + s + "'").collect(Collectors.joining(", "));
            q = QUERY+" inner JOIN \"Message\" m ON t.cpte = m.compteclient where m.\"type\" = 'CLASSIFICATION' and cl.code in ("+codes+")";
        }else if(!pole.equals("null") && !pole.equals("default")) {
            List<String> AgenceByPole = treeRepository.getAgencesByPole(pole);
            System.out.println(AgenceByPole);
            String codes = AgenceByPole.stream().map(s -> "'" + s + "'").collect(Collectors.joining(", "));
            q = QUERY+" inner JOIN \"Message\" m ON t.cpte = m.compteclient where m.\"type\" = 'CLASSIFICATION' and cl.code in ("+codes+")";
        }else{
            getFilteredQuery(iduser,"null", "null", "no");
        }
        return q;
    }
}
