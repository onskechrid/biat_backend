package tn.biat.biat.entities.otherDB;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "\"Message\"", schema = "public")
public class Message implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;
    private String sender;
    private String receiver;
    private String object;
    private String type; //MESSAGE // RECLAMATION
    private LocalDateTime timestamp;
    private boolean isImportant;
    private String processStatus; // Déposée - En cours de traitement - Traitée (Réclamation) // Sent - Read - Failed (Message)

    //Keni reclamation
    private String codeclient;
    private String compteclient;

    @OneToMany
    private List<Attachement> attachements;
    private Long idResponseMessage;
    private String status; // OK: validée - KO: Refusée - MI: Demande plus d'informations
}