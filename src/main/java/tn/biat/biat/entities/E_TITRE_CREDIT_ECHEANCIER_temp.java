package tn.biat.biat.entities;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "\"E_TITRE_CREDIT_ECHEANCIER_temp\"", schema = "public")
@SequenceGenerator(schema = "public", name = "E_TITRE_CREDIT_ECHEANCIER_temp_seq", allocationSize = 1, sequenceName = "E_TITRE_CREDIT_ECHEANCIER_temp_seq")
public class E_TITRE_CREDIT_ECHEANCIER_temp implements Serializable{
    @Id
    @Column(name="ID")
    private String ID;
    @Column(name="BLOC")
    private String BLOC;
    @Column(name="CHAMP")
    private String CHAMP;
    @Column(name="VALEUR")
    private String VALEUR;
    @Column(name="DAT_SIT")
    private int DAT_SIT;
    @Column(name="DAT_CHG")
    private int DAT_CHG;
    @Column(name="DAT_CSO")
    private int DAT_CSO;
}
