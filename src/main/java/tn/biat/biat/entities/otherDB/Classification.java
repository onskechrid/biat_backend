package tn.biat.biat.entities.otherDB;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "\"Classification\"", schema = "public")
public class Classification implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String commentaire;
    private String decision;
    private Integer classe;
    private String motif;

    @OneToOne
    private Client client;

    @OneToMany
    private List<Attachement> attachements;
}
