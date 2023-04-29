package tn.biat.biat.entities;
import lombok.*;
import tn.biat.biat.entities.pk.R_TYPE_ENG_MD_pk;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@IdClass(R_TYPE_ENG_MD_pk.class)
@Entity
@Table(name = "\"R_TYPE_ENG_MD\"", schema = "public")
@SequenceGenerator(schema = "public", name = "R_TYPE_ENG_MD_seq", allocationSize = 1, sequenceName = "R_TYPE_ENG_MD_seq")
public class R_TYPE_ENG_MD implements Serializable{

    @Column(name = "CDRCODENG")
    private int CDRCODENG;

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "R_TYPE_ENG_MD_seq", strategy = GenerationType.SEQUENCE)
    private String ID;

    @Column(name = "CATG")
    private int CATG;
    @Column(name = "PRIO_IMP")
    private int PRIO_IMP;
    @Column(name = "DATE_DEBUT")
    private int DATE_DEBUT;
    @Column(name = "DATE_FIN")
    private int DATE_FIN;
    @Column(name = "LIMIT_REF")
    private int LIMIT_REF;



    @Column(name = "\"DESC\"")
    private String DESC;
    @Column(name = "LIGN_PRDT")
    private String LIGN_PRDT;
    @Column(name = "CODE_KFCR")
    private String CODE_KFCR;
    @Column(name = "TYPE_LIMT")
    private String TYPE_LIMT;

    @Column(name = "PERD_COM_RISQ")
    private String PERD_COM_RISQ;
    @Column(name = "COMM_RISQ")
    private String COMM_RISQ;
    @Column(name = "TX_FINN")
    private String TX_FINN;
    @Column(name = "REF_CNTR_MARC")
    private String REF_CNTR_MARC;
    @Column(name = "REF_MARC")
    private String REF_MARC;
    @Column(name = "MOIS_INDV")
    private String MOIS_INDV;
    @Column(name = "APR_ECH_AUT")
    private String APR_ECH_AUT;
    @Column(name = "APR_PART")
    private String APR_PART;
    @Column(name = "MODL")
    private String MODL;
    @Column(name = "TYPE_PRDT")
    private String TYPE_PRDT;



    @Column(name = "COMM_MEP_EPS")
    private String COMM_MEP_EPS;
    @Column(name = "COM_MODF_CLNT")
    private String COM_MODF_CLNT;
    @Column(name = "COMM_M_JEU")
    private String COMM_M_JEU;
    @Column(name = "RECC_BIAT")
    private String RECC_BIAT;
    @Column(name = "RECR_STTS")
    private String RECR_STTS;
    @Column(name = "CO_CODE")
    private String CO_CODE;
    @Column(name = "DEPT_CODE")
    private String DEPT_CODE;
    @Column(name = "DEVS")
    private String DEVS;
    @Column(name = "CATG_COMP")
    private String CATG_COMP;
    @Column(name = "COM_APRM")
    private String COM_APRM;

    @Id
    @Column(name = "DATDEBVLD")
    @GeneratedValue(generator = "R_TYPE_ENG_MD_seq", strategy = GenerationType.SEQUENCE)
    private int DATDEBVLD;

    @Column(name = "DATFINVLD")
    private int DATFINVLD;
    @Column(name = "DERSIT")
    private int DERSIT;
    @Column(name = "DATCHG")
    private int DATCHG;

}
