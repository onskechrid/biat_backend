package tn.biat.biat.services.implementations;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONArray;
import org.python.antlr.ast.Str;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import tn.biat.biat.entities.otherDB.*;
import tn.biat.biat.repository.AttachementReclamationRepository;
import tn.biat.biat.repository.AttachementRepository;
import tn.biat.biat.repository.MessageRepository;
import tn.biat.biat.repository.TreeRepository;
import tn.biat.biat.services.*;
import tn.biat.biat.utils.QueryExecutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.JapaneseDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MessageService implements IMessageService {

    @Autowired
    MessageRepository messageRepository;
    @Autowired
    AttachementRepository attachementRepository;
    @Autowired
    AttachementReclamationRepository attachementReclamationRepository;
    @Autowired
    QueryExecutor queryExecutor;
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
    @Autowired
    AnalyseService analyseService;

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
        message.setPre_classe(message.getPre_classe());
        message.setPre_motif(message.getPre_motif());
        message.setValidation(false);
        message.setText(message.getText());
        message.setTimestamp(LocalDateTime.now());
        message.setAttachements(null);
        message.setAttachementReclamations(null);
        message.setUrl(message.getUrl());
        if(message.getType().equals("MESSAGE")){
            message.setProcessStatus("Sent");
        }else if(message.getType().equals("CLASSIFICATION") || message.getType().equals("ReCLASSIFICATION")){
            message.setProcessStatus("PréDéposé");
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

    public static String extractDateValeur(String inputString) {
        // Regular expression pattern to match the date pattern "dd MMM yy"
        String pattern = "\\b\\d{2} [A-Z]{3} \\d{2}\\b";

        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(inputString);
        if (matcher.find()) {
            return matcher.group();
        }
        return null; // Return null if the date pattern is not found
    }
    public static String extractLibelleOperation(String inputString) {
        String date = extractDateValeur(inputString);
        String substringAfterDate = inputString.substring(inputString.indexOf(date) + date.length());
        String delimiter = " PD";
        int delimiterIndex = substringAfterDate.indexOf(delimiter);

        if (delimiterIndex != -1) {
            return substringAfterDate.substring(0, delimiterIndex).trim();
        }
        return null;

    }
    public static String extractLibelleOperation2(String inputString) {
        String date = extractDateValeur(inputString);
        String substringAfterDate = inputString.substring(inputString.indexOf(date) + date.length());
        String delimiter = " FT";
        int delimiterIndex = substringAfterDate.indexOf(delimiter);

        if (delimiterIndex != -1) {
            return substringAfterDate.substring(0, delimiterIndex).trim();
        }
        return null;

    }

    public static String extractMontant(String inputString) {
        String delimiter = " ";
        int delimiterIndex = inputString.lastIndexOf(delimiter);
        if (delimiterIndex != -1) {
            return inputString.substring(delimiterIndex + delimiter.length());
        }
        return null; // Return null if the delimiter or the substring are not found
    }

    public static String extractDateOperation(String inputString) {
        String pattern = "\\b\\d{2} [A-Z]{3} \\d{2}\\b";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(inputString);

        String secondDate = null;
        int count = 0;

        while (matcher.find()) {
            count++;
            if (count == 2) {
                secondDate = matcher.group();
                break;
            }
        }

        return secondDate;
    }

    public static String extractRef(String inputString) {
        String startSubstring = "PD";
        String endDelimiter = " ";
        int startIndex = inputString.indexOf(startSubstring);
        int endIndex = inputString.indexOf(endDelimiter, startIndex + startSubstring.length());

        if (startIndex != -1 && endIndex != -1) {
            String substring = inputString.substring(startIndex, endIndex);
            return substring.replaceAll("\\\\", ";");
        }
        return null; // Return null if the start substring or the substring are not found
    }
    public static String extractRef2(String inputString) {
        String startSubstring = "FT";
        String endDelimiter = " ";
        int startIndex = inputString.indexOf(startSubstring);
        int endIndex = inputString.indexOf(endDelimiter, startIndex + startSubstring.length());

        if (startIndex != -1 && endIndex != -1) {
            String substring = inputString.substring(startIndex, endIndex);
            return substring.replaceAll("\\\\", ";");
        }
        return null; // Return null if the start substring or the substring are not found
    }
    @Override
    public boolean updateReclamationAttachements(Long id, String name, String size, String type,String url){
        System.err.println(type);
        Message m = this.getById(id);
        if(m==null){
            return false;
        }else{
            List<String> list = new ArrayList<>();
            if (m.getType().equals("CLASSIFICATION") && type.equals("pdf")) {
                list = analyseService.extractLinesWithReferenceFromPdf();
                for(String line : list) {
                    AttachementReclamation attR = new AttachementReclamation();
                    if (extractLibelleOperation(line) != null){
                        attR.setName(name);
                        attR.setType(type);
                        attR.setSize(size);
                        attR.setPath(url);
                        attR.setNC(analyseService.extractNumeroCompteFromPdf());
                        attR.setSF(analyseService.extractSoldeFinValuesFromPdf());

                        attR.setDateValeur(extractDateValeur(line));
                        attR.setLibelleOperation(extractLibelleOperation(line));
                        attR.setRef(extractRef(line));
                        attR.setDateOperation(extractDateOperation(line));
                        attR.setMontant(extractMontant(line));

                        attachementReclamationRepository.save(attR);
                        String QUERY = "INSERT INTO public.\"Message_attachementReclamations\" (\"Message_id\", \"attachementReclamations_id\") VALUES(" + m.getId() + ", " + attR.getId() + ");";
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
                }
            }else if ((m.getType().equals("CLASSIFICATION") && type.contains("jpg")) || m.getType().equals("CLASSIFICATION") && type.contains("png") || m.getType().equals("CLASSIFICATION") && type.contains("jpeg")) {
                for(String line : analyseService.extractLinesWithReferenceFromImg()) {
                    AttachementReclamation attR = new AttachementReclamation();
                    System.err.println(line);
                    if (extractLibelleOperation2(line) != null){
                        attR.setName(name);
                        attR.setType(type);
                        attR.setSize(size);
                        attR.setPath(url);
                        attR.setNC(analyseService.extractNumeroCompteFromImg());
                        attR.setSF(analyseService.extractSoldeFinValuesFromImg());

                        attR.setDateValeur(extractDateValeur(line));
                        attR.setLibelleOperation(extractLibelleOperation2(line));
                        attR.setRef(extractRef2(line));
                        attR.setDateOperation(extractDateOperation(line));
                        attR.setMontant(extractMontant(line));

                        attachementReclamationRepository.save(attR);
                        String QUERY = "INSERT INTO public.\"Message_attachementReclamations\" (\"Message_id\", \"attachementReclamations_id\") VALUES(" + m.getId() + ", " + attR.getId() + ");";
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
                }
            }
            Attachement att = new Attachement();
            att.setName(name);
            att.setType(type);
            att.setSize(size);
            att.setPath(url);
            attachementRepository.save(att);
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
    public String getNumberJoursTotal(){
        String q = "WITH string_list (date_string) AS (\n" +
                "  SELECT date_ech\n" +
                "  FROM dwm_pd_payment_due_details\n" +
                "  WHERE cpte = 'K320022877'\n" +
                ") SELECT\n" +
                "  sum(TO_DATE('31/03/2023', 'DD/MM/YY') - TO_DATE(date_string, 'DD/MM/YY') + 1) AS days_between\n" +
                "FROM string_list;";
        JSONArray x = queryExecutor.queryinput(q);
        String ss = x.toString().replace("[{\"days_between\":","");
        ss = ss.replace("}]","");
        return ss;
    }

    @Override
    public String getPeriode(String cpte){
        String q = "select periode from risk_cpte rc where cpte = '"+cpte+"'";
        JSONArray j = queryExecutor.queryinput(q);
        String s = j.toString().replace("[{\"periode\":\"","");
        s = s.replace("\"}]","");
        s = s.replace("\\/","/");
        return s;
    }
    @Override
    public String getAgiosByDate(String periode, String date){ // hedhy taatyk agio selon date_ech fi periode mou3ayna
        String q = "WITH string_list (date_string) AS (\n" +
                "  SELECT date_ech FROM dwm_pd_payment_due_details WHERE cpte = 'K320022877'\n" +
                ")\n" +
                "SELECT (TO_DATE('"+periode+"', 'MM/DD/YYYY') - TO_DATE(date_string, 'DD/MM/YY') +1) AS days_between\n" +
                "FROM string_list\n" +
                "WHERE date_string = '"+date+"';\n;";
        JSONArray x = queryExecutor.queryinput(q);
        String ss = x.toString().replace("[{\"days_between\":","");
        ss = ss.replace("}]","");
        return ss;
    }

    @Override
    public JSONArray getAncImpTable(String cpte){
        String query = "select cpte, periode , date_ech, imp_int, imp_pr from dwm_pd_payment_due_details dppdd where cpte ='"+cpte+"'";
        JSONArray jsonArray = queryExecutor.queryinput(query);
        return jsonArray;
    }

    @Override
    public List<String> getPaiementPrincipal(Long id){
        Message message = getById(id);
        List<String> list = new ArrayList<>();
        if(message == null){
            return null;
        }else{
            List<AttachementReclamation> listPD = message.getAttachementReclamations();
            System.err.println(listPD);
            for (AttachementReclamation attR : listPD){
                System.err.println(attR.getLibelleOperation());
                if(attR.getLibelleOperation().startsWith("Paiement Principal")){
                    list.add(attR.getMontant().replace("-",""));
                }
            }
        }
        return list;
    }
    public String getDateEch(String montant){
        String s = "select date_ech from dwm_pd_payment_due_details dppdd where imp_pr = '"+montant+"'";
        JSONArray j = queryExecutor.queryinput(s);
        String ss = j.toString().replace("[{\"date_ech\":\"","");
        ss = ss.replace("\"}]","");
        ss = ss.replace("\\/","/");
        return ss;
    }

    @Override
    public String getMotif(String cpte){
        String s = "select motif from risk_cpte where cpte = '"+cpte+"'";
        JSONArray j = queryExecutor.queryinput(s);
        String ss = j.toString();
        ss = ss.replace("[{\"motif\":\"","");
        ss = ss.replace("\"}]","");
        return ss;
    }
    @Override
    public boolean classificationAutomatique(Long id){
        Message message = getById(id);
        if(message == null){
            return false;
        }else if(message.getType().equals("RECLAMATION")){
            return false;
        } else{
            List<AttachementReclamation> list = message.getAttachementReclamations();
            String cpte = list.get(0).getNC();
            String motif = this.getMotif(list.get(0).getNC());
            message.setPre_motif(motif);
            messageRepository.save(message);
            if(motif == "G"){
                String sf = list.get(0).getSF();
                if (Integer.parseInt(sf) >= 0){
                    message.setPre_classe(0);
                }else{
                    List<String> agios = getListAgiosG(cpte);
                    String solde = "";
                    solde = getSolde(cpte);
                    Double mvt = getMvt(solde,sf);
                    if(Integer.parseInt(agios.get(0)) < mvt ){ // classe 1 : agios < mvt
                        message.setPre_classe(1);
                    }else if(Integer.parseInt(agios.get(1)) < mvt){ // classe 2 : agios t-1 < mvt
                        message.setPre_classe(2);
                    }else if(Integer.parseInt(agios.get(1)) + Integer.parseInt(agios.get(2)) < mvt){ // classe 3 : agios t-1 + agios t-2< mvt
                        message.setPre_classe(3);
                    }else{ // sinon classe 4 : agios t-1 + agios t-2 + agios t-3
                        message.setPre_classe(4);
                    }
                    messageRepository.save(message);
                }
            }else{ // motif == "I"
                System.err.println("ppp");
                Integer totalAgios = 0;
                String periode = getPeriode(list.get(0).getNC());
                int nombreJoursTotal = Integer.parseInt(this.getNumberJoursTotal());// total agios
                totalAgios = getTotalAgios(id,periode);
                System.err.println(totalAgios);
                System.err.println(nombreJoursTotal);
                System.err.println("nombre "+(nombreJoursTotal-totalAgios));
                if(nombreJoursTotal - totalAgios > 360){
                    message.setPre_classe(4);
                }else if(nombreJoursTotal - totalAgios > 180){
                    message.setPre_classe(3);
                }else if(nombreJoursTotal - totalAgios > 90){
                    message.setPre_classe(2);
                }else{
                    message.setPre_classe(1);
                }
                message.setStatus("PréValidation");
                message.setProcessStatus("En attente");
                messageRepository.save(message);
            }
            return true;
        }
    }

    @Override
    public List<String> getListAgiosG(String cpte){
        String query = "SELECT agios FROM risk_classe where cpte = '"+cpte+"' ORDER BY to_date(periode, 'MM/DD/YYYY') desc";
        JSONArray j = queryExecutor.queryinput(query);
        String s = j.toString().replace("{\"agios\":\"","");
        s = s.replace("\"},{\"agios\":\"",",");
        s = s.replace("\"}]","]");
        String trimmedString = s.substring(1, s.length() - 1);
        String[] stringArray = trimmedString.split(",");
        List<String> agios = Arrays.asList(stringArray);
        return agios;
    }

    @Override
    public Double getMvt(String solde, String sf){
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
        try {
            // Parse solde and sf strings as numbers
            Number soldeNumber = numberFormat.parse(solde);
            Number sfNumber = numberFormat.parse(sf);

            // Calculate the mvt
            double mvt = soldeNumber.doubleValue() - sfNumber.doubleValue();

            return mvt;
        } catch (ParseException e) {
            e.printStackTrace();
            // Handle parsing error
        }
        return null;
    }

    @Override
    public String getSolde(String cpte){
        String query2 = "select sum(abs(soldcpte ::integer)) as sum from risk_classe rc where cpte = '"+cpte+"'";
        JSONArray j2 = queryExecutor.queryinput(query2);
        int startIndex = j2.toString().indexOf(":") + 1;
        int endIndex = j2.toString().indexOf("}");

        String numberSubstring = j2.toString().substring(startIndex, endIndex);
        System.err.println(numberSubstring);
        return numberSubstring;
    }

    @Override
    public Integer getTotalAgios(Long id,String periode){
        Integer totalAgios = 0;
        List<String> listPaiementPrincipal = getPaiementPrincipal(id);//liste des paiements illi aamalhom compte x
        System.err.println("liste paiement principals : "+listPaiementPrincipal);
        for(String montant : listPaiementPrincipal){

            totalAgios = totalAgios + (Integer.parseInt(getAgiosByDate(periode,this.getDateEch(montant))));
            System.err.println("total agios : "+totalAgios);
        }
        return totalAgios;
    }

    @Override
    public JSONArray getGelTable(String cpte){
        String query = "select cpte, agios, periode,soldcpte from risk_classe rc where cpte = '"+cpte+"' order by TO_DATE(periode, 'MM/DD/YYYY') desc ";
        JSONArray j = queryExecutor.queryinput(query);
        return j;
    }
    @Override
    public boolean valider(Long id){
        Message message = this.getById(id);
        if(message == null){
            return false;
        }else{
            message.setClasse(message.getPre_classe());
            message.setMotif(message.getPre_motif());
            message.setStatus("Acceptation");
            message.setProcessStatus("Classé");
            message.setValidation(true);
            messageRepository.save(message);
            this.sendEmail("RR@gmail.com", "La classification est validée", "Le traitement automatique de la classification que vous avez déposée est validée vous pouvez la consulter sur la plateforme !");
            return true;
        }
    }

    @Override
    public boolean refuser(Long id){
        Message message = this.getById(id);
        if(message == null){
            return false;
        }else{
            message.setClasse(null);
            message.setMotif(null);
            message.setStatus("Refus");
            message.setProcessStatus("Refus");
            message.setValidation(true);
            messageRepository.save(message);
            this.sendEmail("RR@gmail.com", "La classification est validée", "Le traitement automatique de la classification que vous avez déposée est refusée vous pouvez la consulter sur la plateforme !");
            return true;
        }
    }

    @Override
    public boolean ci(Long id){
        Message message = this.getById(id);
        if(message == null){
            return false;
        }else{
            message.setClasse(null);
            message.setMotif(null);
            message.setStatus("CI");
            message.setProcessStatus("En attente");
            message.setValidation(true);
            messageRepository.save(message);
            this.sendEmail("RR@gmail.com", "La classification est validée", "Le traitement automatique de la classification que vous avez déposée est mis en attente par le responsable. Il faut ajouter les informations manquantes pour pouvoir classer le client !");
            return true;
        }
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
        JSONArray json = queryExecutor.queryinput(query);

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
    public Integer getClassifiedClientsNumberRR(String libelle){
        Integer n = messageRepository.getClassifiedClientsNumberRR(libelle);
        return n;
    }
    @Override
    public Integer getClassifiedClientsNumberAgence(String libelle){
        Integer n = messageRepository.getClassifiedClientsNumberAgence(libelle);
        return n;
    }
    @Override
    public Integer getClassifiedClientsNumberPole(String libelle){
        Integer n = messageRepository.getClassifiedClientsNumberPole(libelle);
        return n;
    }
    @Override
    public Integer getClassifiedClientsNumberRegion(String libelle){
        Integer n = messageRepository.getClassifiedClientsNumberRegion(libelle);
        return n;
    }
    @Override
    public Integer getClassifiedClientsNumberZone(String libelle){
        Integer n = messageRepository.getClassifiedClientsNumberZone(libelle);
        return n;
    }


    @Override
    public Integer getEnattenteClientsNumberRR(){
        Integer n = messageRepository.getEnattenteClientsNumberRR();
        return n;
    }
    @Override
    public Integer getEnattenteClientsNumberZ(String libelle){
        Integer n = messageRepository.getEnattenteClientsNumberZ(libelle);
        return n;
    }
    @Override
    public Integer getEnattenteClientsNumberR(String libelle){
        Integer n = messageRepository.getEnattenteClientsNumberR(libelle);
        return n;
    }
    @Override
    public Integer getEnattenteClientsNumberA(String libelle){
        Integer n = messageRepository.getEnattenteClientsNumberA(libelle);
        return n;
    }
    @Override
    public Integer getEnattenteClientsNumberP(String libelle){
        Integer n = messageRepository.getEnattenteClientsNumberP(libelle);
        return n;
    }

    @Override
    public Integer getRefuseeClientsNumberRR(){
        Integer n = messageRepository.getRefuseeClientsNumberRR();
        return n;
    }
    @Override
    public Integer getRefuseeClientsNumberA(String libelle){
        Integer n = messageRepository.getRefuseeClientsNumberA(libelle);
        return n;
    }
    @Override
    public Integer getRefuseeClientsNumberR(String libelle){
        Integer n = messageRepository.getRefuseeClientsNumberR(libelle);
        return n;
    }
    @Override
    public Integer getRefuseeClientsNumberP(String libelle){
        Integer n = messageRepository.getRefuseeClientsNumberP(libelle);
        return n;
    }
    @Override
    public Integer getRefuseeClientsNumberZ(String libelle){
        Integer n = messageRepository.getRefuseeClientsNumberZ(libelle);
        return n;
    }
    @Override
    public Integer getDeposeClientsNumber(){
        Integer n = messageRepository.getDeposeClientsNumber();
        return n;
    }

    @Override
    public Integer getPreValidationCLientsNumberRR(){
        Integer n = messageRepository.getPreValidationCLientsNumberRR();
        return n;
    }
    @Override
    public Integer getPreValidationCLientsNumberR(String libelle){
        Integer n = messageRepository.getPreValidationCLientsNumberR(libelle);
        return n;
    }
    @Override
    public Integer getPreValidationCLientsNumberA(String libelle){
        Integer n = messageRepository.getPreValidationCLientsNumberA(libelle);
        return n;
    }
    @Override
    public Integer getPreValidationCLientsNumberZ(String libelle){
        Integer n = messageRepository.getPreValidationCLientsNumberZ(libelle);
        return n;
    }
    @Override
    public Integer getPreValidationCLientsNumberP(String libelle){
        Integer n = messageRepository.getPreValidationCLientsNumberP(libelle);
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
                    q = QUERY+" inner JOIN \"Message\" m ON t.cpte = m.compteclient where m.\"type\" = 'CLASSIFICATION' and m.processstatus = '"+processStatus+"'";
                }else if(!status.equals("null")){
                    q = QUERY+" inner JOIN \"Message\" m ON t.cpte = m.compteclient where m.\"type\" = 'CLASSIFICATION' and m.status = '"+status+"'";
                }else if(all.equals("yes")){
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
            String codes = AgenceByPole.stream().map(s -> "'" + s + "'").collect(Collectors.joining(", "));
            q = QUERY+" inner JOIN \"Message\" m ON t.cpte = m.compteclient where m.\"type\" = 'CLASSIFICATION' and cl.code in ("+codes+")";
        }else{
            getFilteredQuery(iduser,"null", "null", "no");
        }
        return q;
    }
}
