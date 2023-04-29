package tn.biat.biat.services;

import net.minidev.json.JSONArray;
import tn.biat.biat.entities.otherDB.Attachement;
import tn.biat.biat.entities.otherDB.Message;

import java.util.List;

public interface IMessageService {

    List<Message> getAll();
    Message add(Message message);
    Message getById(Long id);
    boolean updateReclamationAttachements(Long id, String name, String size, String type, String url);
    boolean updateProcessStatus(Long id, String newStatus);
    boolean updateStatus(Long id, String newStatus);
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
}
