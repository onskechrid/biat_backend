package tn.biat.biat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import tn.biat.biat.entities.otherDB.Client;
import tn.biat.biat.entities.otherDB.Message;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    @Query(value = "SELECT COUNT(*) FROM \"Message\" m WHERE processStatus IN ('En cours de traitement', 'Déposée') and type = 'RECLAMATION';" , nativeQuery = true)
    public int numberUntreatedMessages();

    @Query(value = "SELECT COUNT(*) FROM \"Message\" m WHERE processStatus IN ('Traitée') and type = 'RECLAMATION';" , nativeQuery = true)
    public int numberTreatedMessages();

    @Query(value = "SELECT COUNT(*) FROM \"Message\" m WHERE processStatus IN ('Déposé') and type = 'CLASSIFICATION';" , nativeQuery = true)
    public int numberClass();

    @Query(value = "SELECT \"messages_id\" FROM \"Chat_messages\" cm WHERE \"Chat_chat_id\" = :id", nativeQuery = true)
    public List<Long> getMessagesForChat(@Param("id") Long id);

    @Query(value = "SELECT * FROM \"Message\" m WHERE processStatus IN ('En cours de traitement', 'Déposée') and type = 'RECLAMATION' order by \"timestamp\" DESC;", nativeQuery = true)
    public List<Message> untreatedReclamations();

    @Query(value = "SELECT * FROM \"Message\" m WHERE processStatus IN ('Traitée') and type = 'RECLAMATION' order by \"timestamp\" DESC;", nativeQuery = true)
    public List<Message> treatedReclamations();

    @Query(value = "SELECT * FROM \"Message\" m WHERE status='Refusée' and type = 'RECLAMATION' order by \"timestamp\" DESC;", nativeQuery = true)
    public List<Message> refusedReclamations();

    @Query(value = "SELECT * FROM \"Message\" m WHERE status='Manque d''informations' and type = 'RECLAMATION' order by \"timestamp\" DESC;", nativeQuery = true)
    public List<Message> miReclamations();

    @Query(value = "SELECT COUNT(*) FROM \"Message\" m WHERE status='Refusée' and type = 'RECLAMATION';" , nativeQuery = true)
    public int numberRefusedReclamations();

    @Query(value = "SELECT COUNT(*) FROM \"Message\" m WHERE status='Manque d''informations' and type = 'RECLAMATION';" , nativeQuery = true)
    public int numberMIReclamations();

    @Query(value = "select * from \"Message\" m where idresponsemessage = :id", nativeQuery = true)
    public Message getResponseMessage(@Param("id") Long id);

    @Query(value = "select * from \"Message\" m where idresponsemessage isnull", nativeQuery = true)
    public List<Message> getTopLevelMessages();

    @Query(value = "select * from \"Message\" m where compteclient = :account and type = 'CLASSIFICATION'" , nativeQuery = true)
    public Message getMessageBYCompteClient(@Param("account") String account);

    //////////////////////////////////////////////////////////////////////////////////////////////
    @Query(value = "select count(*) from \"Message\" m where \"type\" = 'CLASSIFICATION' and status = 'Acceptation'", nativeQuery = true)
    public Integer getClassifiedClientsNumberRR(@Param("libelle") String libelle);
    @Query(value = "select count(*) from \"Message\" m where \"type\" = 'CLASSIFICATION' and status = 'Acceptation' and compteclient in (select account from \"Client\" c where code = :libelle)", nativeQuery = true)
    public Integer getClassifiedClientsNumberAgence(@Param("libelle") String libelle);
    @Query(value = "select count(*) from \"Message\" m where \"type\" = 'CLASSIFICATION' and status = 'Acceptation' and compteclient in (select account from \"Client\" c where code IN (select agence from \"Tree\" t where \"pole\" = :libelle))", nativeQuery = true)
    public Integer getClassifiedClientsNumberPole(@Param("libelle") String libelle);
    @Query(value = "select count(*) from \"Message\" m where \"type\" = 'CLASSIFICATION' and status = 'Acceptation' and compteclient in (select account from \"Client\" c where code IN (select agence from \"Tree\" t where \"region\" = :libelle))", nativeQuery = true)
    public Integer getClassifiedClientsNumberRegion(@Param("libelle") String libelle);
    @Query(value = "select count(*) from \"Message\" m where \"type\" = 'CLASSIFICATION' and status = 'Acceptation' and compteclient in (select account from \"Client\" c where code IN (select agence from \"Tree\" t where \"zone\" = :libelle))", nativeQuery = true)
    public Integer getClassifiedClientsNumberZone(@Param("libelle") String libelle);
    ///////////////////////////////////////////////////////////////////////////////////////////////

    @Query(value = "select count(*) from \"Message\" m where \"type\" = 'CLASSIFICATION' and status = 'CI' and compteclient in (select account from \"Client\" c where code IN (select agence from \"Tree\" t where \"agence\" = :libelle ))", nativeQuery = true)
    public Integer getEnattenteClientsNumberA(@Param("libelle") String libelle);
    @Query(value = "select count(*) from \"Message\" m where \"type\" = 'CLASSIFICATION' and status = 'CI' and compteclient in (select account from \"Client\" c where code IN (select agence from \"Tree\" t where \"region\" = :libelle ))", nativeQuery = true)
    public Integer getEnattenteClientsNumberR(@Param("libelle") String libelle);
    @Query(value = "select count(*) from \"Message\" m where \"type\" = 'CLASSIFICATION' and status = 'CI' and compteclient in (select account from \"Client\" c where code IN (select agence from \"Tree\" t where \"pole\" = :libelle ))", nativeQuery = true)
    public Integer getEnattenteClientsNumberP(@Param("libelle") String libelle);
    @Query(value = "select count(*) from \"Message\" m where \"type\" = 'CLASSIFICATION' and status = 'CI' and compteclient in (select account from \"Client\" c where code IN (select agence from \"Tree\" t where \"zone\" = :libelle ))", nativeQuery = true)
    public Integer getEnattenteClientsNumberZ(@Param("libelle") String libelle);
    @Query(value = "select count(*) from \"Message\" m where \"type\" = 'CLASSIFICATION' and status = 'CI'", nativeQuery = true)
    public Integer getEnattenteClientsNumberRR();

    ///////////////////////////////////////////////////////////////////////////////////////////////////
    @Query(value = "select count(*) from \"Message\" m where \"type\" = 'CLASSIFICATION' and processstatus = 'Déposé'", nativeQuery = true)
    public Integer getDeposeClientsNumber();
    @Query(value = "select count(*) from \"Message\" m where \"type\" = 'CLASSIFICATION' and status = 'PréValidation' and compteclient in (select account from \"Client\" c where code IN (select agence from \"Tree\" t where \"agence\" = :libelle ))", nativeQuery = true)
    public Integer getPreValidationCLientsNumberA(@Param("libelle") String libelle);
    @Query(value = "select count(*) from \"Message\" m where \"type\" = 'CLASSIFICATION' and status = 'PréValidation' and compteclient in (select account from \"Client\" c where code IN (select agence from \"Tree\" t where \"region\" = :libelle ))", nativeQuery = true)
    public Integer getPreValidationCLientsNumberR(@Param("libelle") String libelle);
    @Query(value = "select count(*) from \"Message\" m where \"type\" = 'CLASSIFICATION' and status = 'PréValidation' and compteclient in (select account from \"Client\" c where code IN (select agence from \"Tree\" t where \"zone\" = :libelle ))", nativeQuery = true)
    public Integer getPreValidationCLientsNumberZ(@Param("libelle") String libelle);
    @Query(value = "select count(*) from \"Message\" m where \"type\" = 'CLASSIFICATION' and status = 'PréValidation' and compteclient in (select account from \"Client\" c where code IN (select agence from \"Tree\" t where \"pole\" = :libelle ))", nativeQuery = true)
    public Integer getPreValidationCLientsNumberP(@Param("libelle") String libelle);
    @Query(value = "select count(*) from \"Message\" m where \"type\" = 'CLASSIFICATION' and status = 'PréValidation'", nativeQuery = true)
    public Integer getPreValidationCLientsNumberRR();


    ///////////////////////////////////////////////////////////////////////////
    @Query(value = "select count(*) from \"Message\" m where \"type\" = 'CLASSIFICATION' and status = 'Refus' and compteclient in (select account from \"Client\" c where code IN (select agence from \"Tree\" t where \"region\" = :libelle))", nativeQuery = true)
    public Integer getRefuseeClientsNumberR(@Param("libelle") String libelle);
    @Query(value = "select count(*) from \"Message\" m where \"type\" = 'CLASSIFICATION' and status = 'Refus' and compteclient in (select account from \"Client\" c where code IN (select agence from \"Tree\" t where \"zone\" = :libelle))", nativeQuery = true)
    public Integer getRefuseeClientsNumberZ(@Param("libelle") String libelle);
    @Query(value = "select count(*) from \"Message\" m where \"type\" = 'CLASSIFICATION' and status = 'Refus' and compteclient in (select account from \"Client\" c where code IN (select agence from \"Tree\" t where \"pole\" = :libelle))", nativeQuery = true)
    public Integer getRefuseeClientsNumberP(@Param("libelle") String libelle);
    @Query(value = "select count(*) from \"Message\" m where \"type\" = 'CLASSIFICATION' and status = 'Refus' and compteclient in (select account from \"Client\" c where code = :libelle)", nativeQuery = true)
    public Integer getRefuseeClientsNumberA(@Param("libelle") String libelle);
    @Query(value = "select count(*) from \"Message\" m where \"type\" = 'CLASSIFICATION' and status = 'Refus'", nativeQuery = true)
    public Integer getRefuseeClientsNumberRR();
    ////////////////////////////////////////////////////////////////////////////////////////////

    @Query(value = "SELECT * FROM \"Message\" WHERE compteclient = :account", nativeQuery = true)
    public Client getClientByAccount(@Param("account") String account);

    @Query(value = "select motif from risk_cpte where cpte = ':cpte'", nativeQuery = true)
    public String getMotif(@Param("cpte") String cpte);

    @Query(value = "select periode from risk_cpte where cpte = ':cpte'", nativeQuery = true)
    public String getPeriode(@Param("cpte") String cpte);

    @Query(value = "select date_ech from dwm_pd_payment_due_details dppdd where imp_pr = ':montant'", nativeQuery = true)
    public String getDateEch(@Param("montant") String montant);
}
