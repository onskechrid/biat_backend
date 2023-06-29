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
@Table(name = "\"AttachementReclamation\"", schema = "public")
public class AttachementReclamation implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String name;
    private String size;
    private String type;
    private String path;

    private String NC;
    private String SF;

    private String dateValeur;
    private String libelleOperation;
    private String Ref;
    private String dateOperation;
    private String montant;

}
