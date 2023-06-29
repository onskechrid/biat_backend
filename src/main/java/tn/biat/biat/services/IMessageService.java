package tn.biat.biat.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import net.minidev.json.JSONArray;
import tn.biat.biat.entities.otherDB.Attachement;
import tn.biat.biat.entities.otherDB.Client;
import tn.biat.biat.entities.otherDB.Message;

import java.util.List;
import java.util.Map;

public interface IMessageService {

    List<Message> getAll();
    Message add(Message message);
    Message getById(Long id);
    boolean updateReclamationAttachements(Long id, String name, String size, String type, String url);
    boolean updateProcessStatus(Long id, String newStatus);
    boolean updateStatus(Long id, String newStatus);
    boolean updateMotifAndClasse(Long id, String motif, Integer classe);
    int numberUntreatedMessages();
    int numberTreatedMessages();
    int numberMIReclamations();
    int numberRefusedReclamations();
    boolean updateText(Long id, String newText);
    List<Long> getMessagesForChat(Long id);
    List<Message> untreatedReclamations();
    List<Message> treatedReclamations();
    List<Message> refusedReclamations();
    List<Message> miReclamations();
    Message getResponseMessage(Long id);
    List<Message> getTopLevelMessages();
    List<Long> getMessageChain(Long id);

    Map<String, String> getClassificationByIds3(List<String> list);
    Map<String, String> getClassificationByIds2(List<String> list);
    Map<String, Integer> getClassificationByIds(List<String> list);
    Integer getClassifiedClientsNumber();
    Integer getEnattenteClientsNumber();
    Integer getRefuseeClientsNumber();
    Integer getDeposeClientsNumber();
    Message getMessageBYCompteClient(String account);
    Client getClientByAccount(String account);

    String getFilteredQuery(Long iduser, String processStatus, String status , String all);
    String getFilteredQuery2(Long iduser, String agence,String zone, String region, String pole);


    boolean classificationAutomatique(Long id);
    String getNumberJoursTotal();
    String getAgiosByDate(String periode, String date);
    String getPeriode(String cpte);
    List<String> getPaiementPrincipal(Long id);

}
