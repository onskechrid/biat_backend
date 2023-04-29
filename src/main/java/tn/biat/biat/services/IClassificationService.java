package tn.biat.biat.services;


import tn.biat.biat.entities.otherDB.Classification;
import tn.biat.biat.entities.otherDB.Client;

import java.util.List;
import java.util.Map;

public interface IClassificationService {

    Client getClient(String account);
    Client getClientByCompte(String cpte);
    Classification add(Classification classification, String cpte);
    boolean updateClassificationAttachements(Long id, String name, String size, String type,String url);
    Classification getClassificationByClientaccount(String account);
    boolean isDeposited(String account);
    boolean updateClassification(String account, String motif, String decision, Integer classe);
    Map<String, Integer> getClassificationByIds(List<String> list);

}
