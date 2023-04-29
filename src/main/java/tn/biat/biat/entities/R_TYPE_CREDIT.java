package tn.biat.biat.entities;
import lombok.*;
import tn.biat.biat.entities.pk.R_TYPE_CREDIT_pk;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@IdClass(R_TYPE_CREDIT_pk.class)
@Entity
@Table(name = "\"R_TYPE_CREDIT\"", schema = "public")
@SequenceGenerator(schema = "public", name = "R_TYPE_CREDIT_seq", allocationSize = 1, sequenceName = "R_TYPE_CREDIT_seq")
public class R_TYPE_CREDIT implements Serializable{

    @Column(name = "CDRCODENG")
    private int CDRCODENG;

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "R_TYPE_CREDIT_seq", strategy = GenerationType.SEQUENCE)
    private int ID;

    @Column(name = "LIBL")
    private String LIBL;

    @Column(name ="CATG")
    private int CATG;
    @Column(name ="LIGN_PRDT")
    private int LIGN_PRDT;
    @Column(name ="APPL")
    private String APPL;
    @Column(name ="LIMT_REF")
    private int LIMT_REF;
    @Column(name ="PRIO_IMP")
    private int PRIO_IMP;
    @Column(name ="DATE_DEBT")
    private int DATE_DEBT;
    @Column(name ="DATE_FIN")
    private int DATE_FIN;
    @Column(name ="TYPE_LIMT")
    private String TYPE_LIMT;
    @Column(name ="GEST_VERS")
    private int GEST_VERS;
    @Column(name ="IND_STND")
    private String IND_STND;
    @Column(name ="ELEG_REFN")
    private int ELEG_REFN;
    @Column(name ="ELEG_TITR")
    private int ELEG_TITR;
    @Column(name ="ELEG_SOTGR")
    private int ELEG_SOTGR;
    @Column(name ="ELEG_FNG")
    private int ELEG_FNG;
    @Column(name ="ELEG_COF")
    private int ELEG_COF;
    @Column(name ="RENV_PRRG")
    private String RENV_PRRG;
    @Column(name ="CAT_TIEX")
    private String CAT_TIEX;
    @Column(name ="CODE_KFCR")
    private int CODE_KFCR;
    @Column(name ="LIEN_EPRG")
    private int LIEN_EPRG;
    @Column(name ="MONT_MIN")
    private float MONT_MIN;
    @Column(name ="MONTT_MAX")
    private float MONTT_MAX;
    @Column(name ="MNT_NET_GLB_MAX")
    private float MNT_NET_GLB_MAX;
    @Column(name ="MNT_NET_MAX_TRX")
    private float MNT_NET_MAX_TRX;
    @Column(name ="TX_ENDT_MAX")
    private float TX_ENDT_MAX;
    @Column(name ="REF_MARC")
    private String REF_MARC;
    @Column(name ="REF_EXPR")
    private String REF_EXPR;
    @Column(name ="CLE_TX_BASE")
    private String CLE_TX_BASE;
    @Column(name ="TYPE_DECM")
    private String TYPE_DECM;
    @Column(name ="TYPE_INTR")
    private String TYPE_INTR;
    @Column(name ="BASE_INTR")
    private String BASE_INTR;
    @Column(name ="MARG_STD")
    private float MARG_STD;
    @Column(name ="MARG_MIN")
    private float MARG_MIN;
    @Column(name ="MARG_MAX")
    private float MARG_MAX;
    @Column(name ="TAUX_MIN")
    private float TAUX_MIN;
    @Column(name ="TAUX_MAX")
    private float TAUX_MAX;
    @Column(name ="MARG_PENL")
    private float MARG_PENL;
    @Column(name ="CHRG_CMP")
    private String CHRG_CMP;
    @Column(name ="CHRG_ETD_ACR")
    private String CHRG_ETD_ACR;
    @Column(name ="CHRG_ETD_REJ")
    private String CHRG_ETD_REJ;
    @Column(name ="CHRG_RB_ANTC")
    private String CHRG_RB_ANTC;
    @Column(name ="CHRG_REMB_ECH")
    private String CHRG_REMB_ECH;
    @Column(name ="CHRG_COM_ENG")
    private String CHRG_COM_ENG;
    @Column(name ="COMM_PC")
    private int COMM_PC;
    @Column(name ="COMM_G")
    private int COMM_G;
    @Column(name ="DURE_MIN")
    private String DURE_MIN;
    @Column(name ="DURE_MAX")
    private String DURE_MAX;
    @Column(name ="ECH_MAX")
    private int ECH_MAX;
    @Column(name ="DURE_MAX_GB")
    private String DURE_MAX_GB;
    @Column(name ="DEBL_TRNC")
    private int DEBL_TRNC;
    @Column(name ="SUPP_MOB")
    private String SUPP_MOB;
    @Column(name ="VALD_OFFR")
    private String VALD_OFFR;
    @Column(name ="FRCH_MIN_THQ")
    private String FRCH_MIN_THQ;
    @Column(name ="FRCH_MAX_THQ")
    private String FRCH_MAX_THQ;
    @Column(name ="ANTC_DEBL_MAX")
    private String ANTC_DEBL_MAX;
    @Column(name ="VALD_TC")
    private String VALD_TC;
    @Column(name ="FRCH_MIN_EFF")
    private String FRCH_MIN_EFF;
    @Column(name ="LIEU_CONS_VM")
    private String LIEU_CONS_VM;
    @Column(name ="RECC_IMP_BIAT")
    private String RECC_IMP_BIAT;
    @Column(name ="TYPE_DEBL")
    private String TYPE_DEBL;
    @Column(name ="COMM_MISE_IMP")
    private String COMM_MISE_IMP;
    @Column(name ="RECR_STTS")
    private String RECR_STTS;
    @Column(name ="CO_CODE")
    private String CO_CODE;
    @Column(name ="DEPT_CODE")
    private String DEPT_CODE;
    @Column(name ="DEVS")
    private String DEVS;
    @Column(name ="CATG_COMP")
    private String CATG_COMP;
    @Column(name ="TYPE_REMB")
    private String TYPE_REMB;
    @Column(name ="DATE_TIME")
    private float DATE_TIME;
    @Column(name ="PER_REMB_PPL")
    private String PER_REMB_PPL;
    @Column(name ="PER_REMB_INT")
    private String PER_REMB_INT;
    @Column(name ="OPTN_COMP")
    private String OPTN_COMP;

    @Id
    @Column(name = "DATDEBVLD")
    @GeneratedValue(generator = "R_TYPE_CREDIT_seq", strategy = GenerationType.SEQUENCE)
    private int DATDEBVLD;

    @Column(name = "DATFINVLD")
    private int DATFINVLD;
    @Column(name = "DERSIT")
    private int DERSIT;
    @Column(name = "DATCHG")
    private int DATCHG;

}
