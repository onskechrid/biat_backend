package tn.biat.biat.entities;

import lombok.*;
import tn.biat.biat.entities.pk.E_CUSTOMER_pk;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@IdClass(E_CUSTOMER_pk.class)
@Entity
@Table(name = "\"E_CUSTOMER\"", schema = "public")
@SequenceGenerator(schema = "public", name = "customer_seq", allocationSize = 1, sequenceName = "customer_seq")
public class E_CUSTOMER implements Serializable{

    @Id
    @Column(name = "CDRCUST")
    @GeneratedValue(generator = "customer_seq", strategy = GenerationType.SEQUENCE)
    private int CDRCUST ;
    @Column(name = "ID")
    private String ID;
    @Column(name = "GIVEN_NAMES")
    private String GIVEN_NAMES;
    @Column(name = "FAMILY_NAME")
    private String FAMILY_NAME;
    @Column(name = "DATE_OF_BIRTH")
    private String DATE_OF_BIRTH;
    @Column(name = "SHORT_NAME")
    private String SHORT_NAME;
    @Column(name = "NAME_1")
    private String NAME_1 ;
    @Column(name = "CIN")
    private String CIN ;
    @Column(name = "PASS")
    private String PASS;
    @Column(name = "DATE_EXPR_PASS")
    private String DATE_EXPR_PASS ;
    @Column(name = "NUM_BCT")
    private String NUM_BCT;
    @Column(name = "VISA")
    private String VISA;
    @Column(name = "AGRM")
    private String AGRM;
    @Column(name = "CART_SEJR")
    private String CART_SEJR;
    @Column(name = "IDNT_UNQ")
    private String IDNT_UNQ;
    @Column(name = "IDNT_FISC")
    private String IDNT_FISC;
    @Column(name = "MATR_FISC")
    private String MATR_FISC;
    @Column(name = "PATN")
    private String PATN;
    @Column(name = "NUMR_ANLT_CODE_PTT_GRFF")
    private String NUMR_ANLT_CODE_PTT_GRFF;
    @Column(name = "MNMN")
    private String MNMN;
    @Column(name = "SECT")
    private String SECT;
    @Column(name = "ACCN_OFFC")
    private String ACCN_OFFC;
    @Column(name = "INDS")
    private int INDS;
    @Column(name = "TARG")
    private int TARG;
    @Column(name = "NATN")
    private String NATN;
    @Column(name = "CUST_STTS")
    private int CUST_STTS;
    @Column(name = "RESD")
    private String RESD;
    @Column(name = "CONT_DATE")
    private String CONT_DATE;
    @Column(name = "BIRT_INCR_DATE")
    private String BIRT_INCR_DATE;
    @Column(name = "CUST_LIBL")
    private String CUST_LIBL;
    @Column(name = "LANG")
    private int LANG;
    @Column(name = "ISSU_CHQU")
    private String ISSU_CHQU;
    @Column(name = "TITL")
    private String TITL;
    @Column(name = "GEND")
    private String GEND;
    @Column(name = "MART_STTS")
    private String MART_STTS;
    @Column(name = "NET_MONT_IN")
    private String NET_MONT_IN;
    @Column(name = "NET_MONT_OUT")
    private String NET_MONT_OUT;
    @Column(name = "CUST_TYPE")
    private String CUST_TYPE;
    @Column(name = "MANL_RISK_CLSS")
    private String MANL_RISK_CLSS;
    @Column(name = "STRT")
    private String STRT;
    @Column(name = "TOWN_CONT")
    private String TOWN_CONT ;
    @Column(name = "POST_CODE")
    private String POST_CODE;
    @Column(name = "CONT")
    private String CONT;
    @Column(name = "OTHR_OFFC")
    private String OTHR_OFFC;
    @Column(name = "LEGL_EXP_DATE")
    private int LEGL_EXP_DATE;
    @Column(name = "POST_REST")
    private int POST_REST;
    @Column(name = "PHNE_1")
    private String PHNE_1;
    @Column(name = "SMS_1")
    private String SMS_1;
    @Column(name = "EMAL_1")
    private String EMAL_1;
    @Column(name = "EMPL_STTS")
    private String EMPL_STTS;
    @Column(name = "JOB_TITL")
    private String JOB_TITL;
    @Column(name = "CUST_CURR")
    private String CUST_CURR;
    @Column(name = "SALR")
    private String SALR;
    @Column(name = "ANNL_BONS")
    private String ANNL_BONS;
    @Column(name = "OTHR_NATN")
    private String OTHR_NATN;
    @Column(name = "OVRR_RESN")
    private String OVRR_RESN;
    @Column(name = "CU_ACTV")
    private String CU_ACTV;
    @Column(name = "CU_QULT")
    private String CU_QULT;
    @Column(name = "CU_GROP_AFFR")
    private String CU_GROP_AFFR;
    @Column(name = "CU_CODE_SIT_JUR")
    private int CU_CODE_SIT_JUR;
    @Column(name = "CU_DATE_SIT_JUR")
    private int CU_DATE_SIT_JUR;
    @Column(name = "CU_FORM_JUR")
    private int CU_FORM_JUR;
    @Column(name = "CU_CAPT_SOCL")
    private String CU_CAPT_SOCL;
    @Column(name = "CU_CHFF_AFFR")
    private float CU_CHFF_AFFR;
    @Column(name = "CU_ANNE_CA")
    private String CU_ANNE_CA;
    @Column(name = "CU_NB_EMPL")
    private String CU_NB_EMPL;
    @Column(name = "CU_TYPE_ADRS")
    private String CU_TYPE_ADRS;
    @Column(name = "CU_INTR_CHQ")
    private String CU_INTR_CHQ;
    @Column(name = "CU_DT_INTR_CHE")
    private String CU_DT_INTR_CHE;
    @Column(name = "CU_INTR_CART")
    private String CU_INTR_CART;
    @Column(name = "CU_DT_TRAN_CNTX")
    private int CU_DT_TRAN_CNTX;
    @Column(name = "CU_CAPC_JUR")
    private String CU_CAPC_JUR;
    @Column(name = "CU_PRFS")
    private String CU_PRFS;
    @Column(name = "CU_CODE_BCT")
    private String CU_CODE_BCT;
    @Column(name = "CU_POLE_GEST")
    private String CU_POLE_GEST;
    @Column(name = "DATE_AUT_BCT")
    private int DATE_AUT_BCT;
    @Column(name = "EXNR_TVA")
    private String EXNR_TVA;
    @Column(name = "CU_BLCK_LIST")
    private String CU_BLCK_LIST;
    @Column(name = "CU_PRSP_TRE")
    private String CU_PRSP_TRE;
    @Column(name = "ID_BCT")
    private String ID_BCT;
    @Column(name = "TYPE_ID_BCT")
    private String TYPE_ID_BCT;
    @Column(name = "SRC")
    private String SRC;
    @Column(name = "CDRINDS")
    private int CDRINDS;
    @Column(name = "CDRTARG")
    private int CDRTARG;
    @Column(name = "CDRBIATPRFS")
    private int CDRBIATPRFS;
    @Column(name = "CDRACTV")
    private int CDRACTV;
    @Id
    @Column(name = "DATDEBVLD")
    @GeneratedValue(generator = "customer_seq", strategy = GenerationType.SEQUENCE)
    private int DATDEBVLD;
    @Column(name = "DATFINVLD")
    private int DATFINVLD;
    @Column(name = "DERSIT")
    private int DERSIT;
    @Column(name = "DATCHG")
    private int DATCHG;



}
