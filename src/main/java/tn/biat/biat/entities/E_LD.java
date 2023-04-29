package tn.biat.biat.entities;
import lombok.*;
import tn.biat.biat.entities.pk.E_LD_pk;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@IdClass(E_LD_pk.class)
@Entity
@Table(name = "\"E_LD\"", schema = "public")
@SequenceGenerator(schema = "public", name = "E_LD_seq", allocationSize = 1, sequenceName = "E_LD_seq")
public class E_LD implements Serializable{


    @Column(name = "CDRCONTMUTL")
    private int CDRCONTMUTL;

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "E_LD_seq", strategy = GenerationType.SEQUENCE)
    private String ID;

    @Column(name = "CUST_ID")
    private String CUST_ID;
    @Column(name = "CURR")
    private String CURR;
    @Column(name = "VALU_DATE")
    private int VALU_DATE;
    @Column(name = "FIN_MAT_DATE")
    private int FIN_MAT_DATE;
    @Column(name = "LIMT_REFR")
    private String LIMT_REFR;
    @Column(name = "CATG")
    private String CATG;
    @Column(name = "DRWD_ACCN")
    private String DRWD_ACCN;
    @Column(name = "INT_RATE_TYPE")
    private String INT_RATE_TYPE;
    @Column(name = "INTR_BASI")
    private String INTR_BASI;
    @Column(name = "INT_PAMT_METH")
    private String INT_PAMT_METH;
    @Column(name = "INTR_KEY")
    private String INTR_KEY;
    @Column(name = "INTR_SPRD")
    private float INTR_SPRD;
    @Column(name = "ACCR_PARM")
    private String ACCR_PARM;
    @Column(name = "LIQU_MODE")
    private String LIQU_MODE;
    @Column(name = "OVRD_STTS")
    private String OVRD_STTS;
    @Column(name = "GRAC_PERD")
    private String GRAC_PERD;
    @Column(name = "GRAC_AMNT")
    private String GRAC_AMNT;
    @Column(name = "PRIN_LIQ_ACCT")
    private String PRIN_LIQ_ACCT;
    @Column(name = "INT_LIQ_ACCT")
    private String INT_LIQ_ACCT;
    @Column(name = "CHRG_LIQ_ACCT")
    private String CHRG_LIQ_ACCT;
    @Column(name = "MIS_ACCT_OFFC")
    private String MIS_ACCT_OFFC;
    @Column(name = "AGRM_DATE")
    private int AGRM_DATE;
    @Column(name = "CONR_RISK")
    private String CONR_RISK;
    @Column(name = "CONT_EXPS")
    private String CONT_EXPS;
    @Column(name = "STTS")
    private String STTS;
    @Column(name = "DRWD_ISSU_PRC")
    private float DRWD_ISSU_PRC;
    @Column(name = "DRWD_NET_AMT")
    private float DRWD_NET_AMT;
    @Column(name = "REMB_AMNT")
    private float REMB_AMNT;
    @Column(name = "FEE_PAY_ACCNT")
    private float FEE_PAY_ACCNT;
    @Column(name = "AMNT_INCR")
    private String AMNT_INCR;
    @Column(name = "NEW_SPRD")
    private String NEW_SPRD;
    @Column(name = "SPRD_V_DATE")
    private String SPRD_V_DATE;
    @Column(name = "DRWD_ENT_DATE")
    private int DRWD_ENT_DATE;
    @Column(name = "CO_CODE")
    private String CO_CODE;
    @Column(name = "A_PRRG")
    private String A_PRRG;
    @Column(name = "A_RENV")
    private String A_RENV;
    @Column(name = "BANQ_TIRE")
    private String BANQ_TIRE;
    @Column(name = "BILL_NUMB")
    private String BILL_NUMB;
    @Column(name = "CHRG_AMNT")
    private String CHRG_AMNT;
    @Column(name = "CHRG_BOKD_ON")
    private int CHRG_BOKD_ON;
    @Column(name = "CHRG_CPTL")
    private String CHRG_CPTL;
    @Column(name = "CHRG_CLM_DATE")
    private int CHRG_CLM_DATE;
    @Column(name = "CHRG_CODE")
    private String CHRG_CODE;
    @Column(name = "CLE_TAUX_BASE")
    private int CLE_TAUX_BASE;
    @Column(name = "CONT_MARC")
    private String CONT_MARC;
    @Column(name = "DURE_CRDT")
    private float DURE_CRDT;
    @Column(name = "ENCR_INTL")
    private float ENCR_INTL;
    @Column(name = "INTR_RATE")
    private float INTR_RATE;
    @Column(name = "LD_INTR_NET")
    private float LD_INTR_NET;
    @Column(name = "LD_MARG")
    private float LD_MARG;
    @Column(name = "LD_MARG_INIT")
    private float LD_MARG_INIT;
    @Column(name = "LD_NANT")
    private String LD_NANT;
    @Column(name = "LIB_TYPE_ENG")
    private String LIB_TYPE_ENG;
    @Column(name = "MARG")
    private float MARG;
    @Column(name = "NIV_DELG_MAX")
    private String NIV_DELG_MAX;
    @Column(name = "NOM_TIRE")
    private String NOM_TIRE;
    @Column(name = "OUR_REMR")
    private String OUR_REMR;
    @Column(name = "REF_MARC")
    private String REF_MARC;
    @Column(name = "REF_TITR_CRDT")
    private String REF_TITR_CRDT;
    @Column(name = "RIB_TIRE")
    private String RIB_TIRE;
    @Column(name = "TAUX_BASE")
    private float TAUX_BASE;
    @Column(name = "TAUX_GLBL")
    private float TAUX_GLBL;
    @Column(name = "TIEG")
    private float TIEG;
    @Column(name = "TIEX")
    private float TIEX;
    @Column(name = "TITR")
    private String TITR;
    @Column(name = "TYPE_CRDT")
    private String TYPE_CRDT;
    @Column(name = "TYPE_ENG")
    private String TYPE_ENG;

    @Id
    @Column(name = "DATDEBVLD")
    @GeneratedValue(generator = "E_LD_seq", strategy = GenerationType.SEQUENCE)
    private int DATDEBVLD;

    @Column(name = "DATFINVLD")
    private int DATFINVLD;
    @Column(name = "DERSIT")
    private int DERSIT;
    @Column(name = "DATCHG")
    private int DATCHG;

}
