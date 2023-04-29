package tn.biat.biat.entities;

import lombok.*;
import tn.biat.biat.entities.pk.E_CONTRAT_PERSO_BIAT_pk;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@IdClass(E_CONTRAT_PERSO_BIAT_pk.class)
@Entity
@Table(name = "\"E_CONTRAT_PERSO_BIAT\"", schema = "public")
@SequenceGenerator(schema = "public", name = "E_CONTRAT_PERSO_BIAT_seq", allocationSize = 1, sequenceName = "E_CONTRAT_PERSO_BIAT_seq")
public class E_CONTRAT_PERSO_BIAT implements Serializable{

    @Id
    @Column(name = "CDRCONTRH")
    @GeneratedValue(generator = "E_CONTRAT_PERSO_BIAT_seq", strategy = GenerationType.SEQUENCE)
    private int CDRCONTRH;
    @Id
    @Column(name = "REF_CONT")
    @GeneratedValue(generator = "E_CONTRAT_PERSO_BIAT_seq", strategy = GenerationType.SEQUENCE)
    private String REF_CONT;

    @Column(name = "CODE_ENGG")
    private String CODE_ENGG;
    @Column(name = "COMP_CTOS")
    private String COMP_CTOS;
    @Column(name = "PRSN_NOM")
    private String PRSN_NOM;
    @Column(name = "DATE_DEBL")
    private int DATE_DEBL;
    @Column(name = "MONT_DEBL")
    private float MONT_DEBL;
    @Column(name = "MNT_PPL_ECH")
    private float MNT_PPL_ECH;
    @Column(name = "MNT_INT_ECH")
    private float MNT_INT_ECH;
    @Column(name = "DATE_DEBT_REMB")
    private int DATE_DEBT_REMB;
    @Column(name = "MATR_DATE")
    private int MATR_DATE;
    @Column(name = "TAUX_INTR")
    private float TAUX_INTR;
    @Column(name = "TAUX_INTR_WR")
    private float TAUX_INTR_WR;
    @Column(name = "INTR_BASS")
    private String INTR_BASS;
    @Column(name = "RANG_CREDT")
    private int RANG_CREDT;
    @Column(name = "NBRE")
    private int NBRE;
    @Column(name = "REF_TITR_CR")
    private String REF_TITR_CR;
    @Column(name = "COMP")
    private String COMP;
    @Column(name = "CODE_CLNT")
    private String CODE_CLNT;
    @Column(name = "MATR")
    private String MATR;
    @Column(name = "LIMT_REF")
    private String LIMT_REF;
    @Column(name = "CURR")
    private String CURR;
    @Column(name = "CATG")
    private String CATG;
    @Column(name = "CDRCUST")
    private int CDRCUST;
    @Column(name = "CDRCODENGRH")
    private int CDRCODENGRH;
    @Id
    @Column(name = "DATDEBVLD")
    @GeneratedValue(generator = "E_CONTRAT_PERSO_BIAT_seq", strategy = GenerationType.SEQUENCE)
    private int DATDEBVLD;

    @Column(name = "DATFINVLD")
    private int DATFINVLD;
    @Column(name = "DERSIT")
    private int DERSIT;
    @Column(name = "DAT_CHG")
    private int DAT_CHG;

}
