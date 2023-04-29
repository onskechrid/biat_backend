package tn.biat.biat.entities.otherDB;

import lombok.*;
import tn.biat.biat.entities.otherDB.enumerations.Status;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "\"Users\"", schema = "public")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;
    private String userFirstName;
    private String userLastName;
    private String userPassword;
    private String email;
    private LocalDateTime registerdate; //time of last logout
    private LocalDateTime lastlogout;
    private String status;
    private String Libelle;
    private String initials;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "profile", referencedColumnName = "profileType")
    private Profile profile;

    @OneToMany
    private List<History> histories;
}