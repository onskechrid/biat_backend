package tn.biat.biat.entities;
import lombok.*;
import tn.biat.biat.entities.pk.E_TITRE_CREDIT_ECHEANCIER_pk;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@IdClass(E_TITRE_CREDIT_ECHEANCIER_pk.class)
@Entity
@Table(name = "\"E_TITRE_CREDIT_ECHEANCIER\"", schema = "public")
@SequenceGenerator(schema = "public", name = "E_TITRE_CREDIT_ECHEANCIER_seq", allocationSize = 1, sequenceName = "E_TITRE_CREDIT_ECHEANCIER_seq")
public class E_TITRE_CREDIT_ECHEANCIER implements Serializable{


    @Column(name ="CDR_TITR")
    private int CDR_TITR;

    @Id
    @Column(name ="REF_TITR")
    @GeneratedValue(generator = "E_TITRE_CREDIT_ECHEANCIER_seq", strategy = GenerationType.SEQUENCE)
    private String REF_TITR;

    @Id
    @Column(name ="NUM_ECHN")
    @GeneratedValue(generator = "E_TITRE_CREDIT_ECHEANCIER_seq", strategy = GenerationType.SEQUENCE)
    private int NUM_ECHN;

    @Column(name ="DATE_ECH")
    private int DATE_ECH;

    @Column(name ="NB_JOURS_ECH")
    private int NB_JOURS_ECH;

    @Column(name ="ENCR_ECH")
    private double ENCR_ECH;

    @Column(name ="REF_CTOS_PPL")
    private String REF_CTOS_PPL;

    @Column(name ="MNT_PPL_ECH")
    private double MNT_PPL_ECH;

    @Column(name ="REF_CTOS_INT")
    private String REF_CTOS_INT;

    @Column(name ="MNT_INT_ECH")
    private double MNT_INT_ECH;

    @Column(name ="MNT_INT_COM_ECH")
    private double MNT_INT_COM_ECH;

    @Column(name ="MNT_TOT_ECH")
    private double MNT_TOT_ECH;

    @Id
    @Column(name ="DATDEBVLD")
    @GeneratedValue(generator = "E_TITRE_CREDIT_ECHEANCIER_seq", strategy = GenerationType.SEQUENCE)
    private int DATDEBVLD;

    @Column(name ="DATFINVLD")
    private int DATFINVLD;

    @Column(name ="DERSIT")
    private int DERSIT;

    @Column(name ="DATCHG")
    private int DATCHG;
}
