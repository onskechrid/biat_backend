package tn.biat.biat.entities;
import lombok.*;
import tn.biat.biat.entities.pk.E_TITRE_CREDIT_pk;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@IdClass(E_TITRE_CREDIT_pk.class)
@Entity
@Table(name = "\"E_TITRE_CREDIT\"", schema = "public")
@SequenceGenerator(schema = "public", name = "E_TITRE_CREDIT_seq", allocationSize = 1, sequenceName = "E_TITRE_CREDIT_seq")
public class E_TITRE_CREDIT implements Serializable{




    @Id
    @Column(name = "CDR_TITR")
    @GeneratedValue(generator = "E_TITRE_CREDIT_seq", strategy = GenerationType.SEQUENCE)
    private int CDR_TITR;

    @Id
    @Column(name = "REF_TITRE")
    @GeneratedValue(generator = "E_TITRE_CREDIT_seq", strategy = GenerationType.SEQUENCE)
    private String REF_TITRE;

    @Column(name = "REF_CREDIT")
    private String REF_CREDIT;

    @Column(name = "DATE_GENR")
    private String DATE_GENR;

    @Column(name = "ORDRE_TRNC")
    private String ORDRE_TRNC;

    @Column(name = "CODE_CLNT")
    private String CODE_CLNT;

    @Column(name = "COM_CLNT")
    private String COM_CLNT;

    @Column(name = "ADRS_CLNT")
    private String ADRS_CLNT;

    @Column(name = "DOMC_BANC")
    private String DOMC_BANC;

    @Column(name = "COMP_CLNT")
    private String COMP_CLNT;

    @Column(name = "CPTE_CLT_CTOS")
    private String CPTE_CLT_CTOS;

    @Column(name = "RIB_CLNT")
    private String RIB_CLNT;

    @Column(name = "CATG")
    private String CATG;

    @Column(name = "TYP_CRDT")
    private String TYP_CRDT;

    @Column(name = "TYP_INTR")
    private String TYP_INTR;

    @Column(name = "DUREE")
    private String DUREE;

    @Column(name = "DAT_SOSC")
    private String DAT_SOSC;

    @Column(name = "LIEU_SOSC")
    private String LIEU_SOSC;

    @Column(name = "TAUX_CMP")
    private String TAUX_CMP;

    @Column(name = "MONT_CMP")
    private String MONT_CMP;

    @Column(name = "TAUX_CETD")
    private String TAUX_CETD;

    @Column(name = "MONT_CETD")
    private String MONT_CETD;

    @Column(name = "TAUX_COM_ENG")
    private String TAUX_COM_ENG;

    @Column(name = "TAUX_CONT_FNG")
    private String TAUX_CONT_FNG;

    @Column(name = "TAUX_SOTUGAR")
    private String TAUX_SOTUGAR;

    @Column(name = "MONT_DEBL")
    private String MONT_DEBL;

    @Column(name = "TAUX_BASE")
    private String TAUX_BASE;

    @Column(name = "MARG")
    private String MARG;

    @Column(name = "TAUX_APPL")
    private String TAUX_APPL;

    @Column(name = "TIEG")
    private String TIEG;

    @Column(name = "TAUX_CPG")
    private String TAUX_CPG;

    @Column(name = "TAUX_CG")
    private String TAUX_CG;

    @Column(name = "MNT_TOT_INT")
    private String MNT_TOT_INT;

    @Column(name = "TYPE_REMB")
    private String TYPE_REMB;

    @Column(name = "DAT_DEBLC_THQ")
    private String DAT_DEBLC_THQ;

    @Column(name = "DAT_DEBLC_EFF")
    private String DAT_DEBLC_EFF;

    @Column(name = "DAT_SIGN_CNTR")
    private String DAT_SIGN_CNTR;

    @Column(name = "DAT_P_ECH_INT")
    private String DAT_P_ECH_INT;

    @Column(name = "DAT_P_ECH_PPL")
    private String DAT_P_ECH_PPL;

    @Column(name = "PERDCT_PPL")
    private String PERDCT_PPL;

    @Column(name = "PERDCT_INT")
    private String PERDCT_INT;

    @Column(name = "ANNTE")
    private String ANNTE;

    @Column(name = "NB_ECHN")
    private String NB_ECHN;

    @Id
    @Column(name = "DATDEBVLD")
    @GeneratedValue(generator = "E_TITRE_CREDIT_seq", strategy = GenerationType.SEQUENCE)
    private int DATDEBVLD;

    @Column(name = "DATFINVLD")
    private int DATFINVLD;

    @Column(name = "DERSIT")
    private int DERSIT;

    @Column(name = "DATCHG")
    private int DATCHG;

}
