package tn.biat.biat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.biat.biat.entities.otherDB.Message;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    @Query(value = "SELECT COUNT(*) FROM \"Message\" m WHERE processStatus IN ('En cours de traitement', 'Déposée') and type = 'RECLAMATION';" , nativeQuery = true)
    public int numberUntreatedMessages();

    @Query(value = "SELECT COUNT(*) FROM \"Message\" m WHERE processStatus IN ('Traitée') and type = 'RECLAMATION';" , nativeQuery = true)
    public int numberTreatedMessages();

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
}
