package tn.biat.biat.entities;
import lombok.*;
import tn.biat.biat.entities.pk.E_MG_pk;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@IdClass(E_MG_pk.class)
@Entity
@Table(name = "\"E_MG\"", schema = "public")
@SequenceGenerator(schema = "public", name = "E_MG_seq", allocationSize = 1, sequenceName = "E_MG_seq")
public class E_MG implements Serializable{


    @Column(name= "TERM")
    private float TERM;

    @Column(name= "MG_MARG")
    private float MG_MARG;

    @Column(name= "PRNC_AMNT")
    private float PRNC_AMNT;

    @Column(name= "REPM_AMNT")
    private float REPM_AMNT;

    @Column(name= "THRT_AMNT")
    private float THRT_AMNT;

    @Column(name= "TOTL_CHRG")
    private float TOTL_CHRG;

    @Column(name= "TOTL_CHG_TAX")
    private float TOTL_CHG_TAX;

    @Column(name= "INTL_RATE")
    private float INTL_RATE;

    @Column(name= "MG_TIEX")
    private float MG_TIEX;

    @Column(name= "MG_TIEG")
    private float MG_TIEG;

    @Column(name= "INTR_SPRD")
    private float INTR_SPRD;

    @Column(name= "MG_TAUX_BASE")
    private float MG_TAUX_BASE;

    @Column(name= "INTR_RATE")
    private float INTR_RATE;



    @Column(name= "CDRCONTMUTL")
    private int CDRCONTMUTL;

    @Column(name= "CONT_DATE")
    private int CONT_DATE;

    @Column(name= "VAL_DATE")
    private int VAL_DATE;

    @Column(name= "ORGN_MAT_DATE")
    private int ORGN_MAT_DATE;

    @Column(name= "MATR_DATE")
    private int MATR_DATE;

    @Column(name= "REDM_STRT_DATE")
    private int REDM_STRT_DATE;

    @Id
    @Column(name = "DATDEBVLD")
    @GeneratedValue(generator = "E_MG_seq", strategy = GenerationType.SEQUENCE)
    private int DATDEBVLD;

    @Column(name= "DATFINVLD")
    private int DATFINVLD;

    @Column(name= "DERSIT")
    private int DERSIT;

    @Column(name= "DATCHG")
    private int DATCHG;

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "E_MG_seq", strategy = GenerationType.SEQUENCE)
    private String ID;

    @Column(name= "CUST")
    private String CUST;

    @Column(name= "CONT_TYP")
    private String CONT_TYP;

    @Column(name= "CONT_STTS")
    private String CONT_STTS;

    @Column(name= "CURR")
    private String CURR;

    @Column(name= "CATG")
    private String CATG;

    @Column(name= "INTR_BASS")
    private String INTR_BASS;

    @Column(name= "EFFC_INT")
    private String EFFC_INT;

    @Column(name= "REPM_DATE")
    private String REPM_DATE;

    @Column(name= "REDM_DATE")
    private String REDM_DATE;

    @Column(name= "LIQU_MODE")
    private String LIQU_MODE;

    @Column(name= "OVRD_STTS")
    private String OVRD_STTS;

    @Column(name= "LIMT_REF")
    private String LIMT_REF;

    @Column(name= "MORT_ACCN")
    private String MORT_ACCN;

    @Column(name= "DRWD_ACCN")
    private String DRWD_ACCN;

    @Column(name= "MIS_ACCT_OFFC")
    private String MIS_ACCT_OFFC;

    @Column(name= "INT_LIQ_ACCT")
    private String INT_LIQ_ACCT;

    @Column(name= "CO_CODE")
    private String CO_CODE;

    @Column(name= "INTR_KEY")
    private String INTR_KEY;

    @Column(name= "MG_REF_CONV")
    private String MG_REF_CONV;

    @Column(name= "PAMN_TYPE")
    private String PAMN_TYPE;

    @Column(name= "FIXD_VAR_IND")
    private String FIXD_VAR_IND;

    @Column(name= "MG_REF_VERS")
    private String MG_REF_VERS;

    @Column(name= "DETL_BESN")
    private String DETL_BESN;

    @Column(name= "NIV_DELG_MAX")
    private String NIV_DELG_MAX;

    @Column(name= "MG_REF_DEMN")
    private String MG_REF_DEMN;

    @Column(name= "MG_REF_BESN")
    private String MG_REF_BESN;

    @Column(name= "OUR_REMR")
    private String OUR_REMR;

    @Column(name= "TYPE_CREDT")
    private String TYPE_CREDT;

    @Column(name= "CHRG_TAX_LCY")
    private String CHRG_TAX_LCY;

    @Column(name= "CHRG_CODE")
    private String CHRG_CODE;

    @Column(name= "CHRG_DATE")
    private String CHRG_DATE;

    @Column(name= "CHRG_CCY")
    private String CHRG_CCY;

    @Column(name= "CHRG_AMNT")
    private String CHRG_AMNT;

    @Column(name= "CHRG_ACCN")
    private String CHRG_ACCN;

    @Column(name= "TYPE_ENG")
    private String TYPE_ENG;

    @Column(name= "MG_REF_TITR_CR")
    private String MG_REF_TITR_CR;

    @Column(name= "CHRG_AMT_LCY")
    private String CHRG_AMT_LCY;

}
