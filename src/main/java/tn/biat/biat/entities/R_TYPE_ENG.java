package tn.biat.biat.entities;
import lombok.*;
import tn.biat.biat.entities.pk.R_TYPE_ENG_pk;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@IdClass(R_TYPE_ENG_pk.class)
@Entity
@Table(name = "\"R_TYPE_ENG\"", schema = "public")
@SequenceGenerator(schema = "public", name = "R_TYPE_ENG_seq", allocationSize = 1, sequenceName = "R_TYPE_ENG_seq")
public class R_TYPE_ENG implements Serializable{

    @Column(name="DATE_TIME")
    private float DATE_TIME;

    @Column(name="CDRCODENG")
    private int CDRCODENG;
    @Column(name="LIMT_REF")
    private int LIMT_REF;
    @Column(name="RECC_BIAT")
    private int RECC_BIAT;
    @Column(name="CURR_NO")
    private int CURR_NO;

    @Id
    @Column(name = "DATDEBVLD")
    @GeneratedValue(generator = "R_TYPE_ENG_seq", strategy = GenerationType.SEQUENCE)
    private int DATDEBVLD;

    @Column(name = "DATFINVLD")
    private int DATFINVLD;
    @Column(name = "DERSIT")
    private int DERSIT;
    @Column(name = "DATCHG")
    private int DATCHG;

    @Id
    @Column(name="ID")
    @GeneratedValue(generator = "R_TYPE_ENG_seq", strategy = GenerationType.SEQUENCE)
    private String ID;

    @Column(name="LIBL")
    private String LIBL;
    @Column(name="FAML_PRCS")
    private String FAML_PRCS;
    @Column(name="LIGN_PRDT")
    private String LIGN_PRDT;
    @Column(name="CATG")
    private String CATG;
    @Column(name="TYPE_LIMT")
    private String TYPE_LIMT;
    @Column(name="MODL_STD_MEP")
    private String MODL_STD_MEP;
    @Column(name="AUTR_DEVS")
    private String AUTR_DEVS;
    @Column(name="DATE_DEBT")
    private String DATE_DEBT;
    @Column(name="DATE_FIN")
    private String DATE_FIN;
    @Column(name="IND_STND")
    private String IND_STND;
    @Column(name="LIEN_EPRG")
    private String LIEN_EPRG;
    @Column(name="ELEG_COF")
    private String ELEG_COF;
    @Column(name="TABL_REFR")
    private String TABL_REFR;
    @Column(name="TYPE_NOTF")
    private String TYPE_NOTF;
    @Column(name="ETAP_NOTF")
    private String ETAP_NOTF;
    @Column(name="DELS_NOTF")
    private String DELS_NOTF;
    @Column(name="RECR_STTS")
    private String RECR_STTS;
    @Column(name="DEPT_CODE")
    private String DEPT_CODE;
    @Column(name="DEVS")
    private String DEVS;
    @Column(name="DEVS_ENG")
    private String DEVS_ENG;
    @Column(name="TX_ENDT_MAX")
    private String TX_ENDT_MAX;
    @Column(name="DEVS_TX")
    private String DEVS_TX;
    @Column(name="REVN_MIN")
    private String REVN_MIN;
    @Column(name="REVN_MAX")
    private String REVN_MAX;
    @Column(name="CODE_KFCR")
    private String CODE_KFCR;
    @Column(name="SUPP_MOB")
    private String SUPP_MOB;
    @Column(name="LIEU_CONS_VM")
    private String LIEU_CONS_VM;
    @Column(name="QUTT_FIN")
    private String QUTT_FIN;
    @Column(name="ELGB_TRE")
    private String ELGB_TRE;
    @Column(name="QUTT_FIN_TRE")
    private String QUTT_FIN_TRE;
    @Column(name="FRCH_THQ_INT")
    private String FRCH_THQ_INT;
    @Column(name="MONT")
    private String MONT;
    @Column(name="MNT_NET_GLB")
    private String MNT_NET_GLB;
    @Column(name="MNT_NET_TRX")
    private String MNT_NET_TRX;
    @Column(name="CAT_TIEX")
    private String CAT_TIEX;
    @Column(name="CLE_TX_BASE")
    private String CLE_TX_BASE;
    @Column(name="TYPE_DECM")
    private String TYPE_DECM;
    @Column(name="TYPE_INTR")
    private String TYPE_INTR;
    @Column(name="BASE_INTR")
    private String BASE_INTR;
    @Column(name="MARG_STD")
    private String MARG_STD;
    @Column(name="MARG")
    private String MARG;
    @Column(name="CHRG_CMP")
    private String CHRG_CMP;
    @Column(name="CHRG_ETD_ACR")
    private String CHRG_ETD_ACR;
    @Column(name="CHRG_ETD_REJ")
    private String CHRG_ETD_REJ;
    @Column(name="CHRG_RB_ANTC")
    private String CHRG_RB_ANTC;
    @Column(name="CHRG_REMB_ECH")
    private String CHRG_REMB_ECH;
    @Column(name="CHRG_COM_ENG")
    private String CHRG_COM_ENG;
    @Column(name="COMM_PCG")
    private String COMM_PCG;
    @Column(name="COMM_MISE_IMP")
    private String COMM_MISE_IMP;
    @Column(name="TYPE_REMB")
    private String TYPE_REMB;
    @Column(name="DEBL_TRNC")
    private String DEBL_TRNC;
    @Column(name="NBR_TRC")
    private String NBR_TRC;
    @Column(name="PER_REMB_PPL")
    private String PER_REMB_PPL;
    @Column(name="PER_REMB_INT")
    private String PER_REMB_INT;
    @Column(name="DURE")
    private String DURE;
    @Column(name="VALD_OFFR")
    private String VALD_OFFR;
    @Column(name="PERD_LATN")
    private String PERD_LATN;
    @Column(name="FRCH_THQ_PPL")
    private String FRCH_THQ_PPL;
    @Column(name="ANTC_DEBL")
    private String ANTC_DEBL;
    @Column(name="VALD_TC")
    private String VALD_TC;
    @Column(name="ELEG_REFN")
    private String ELEG_REFN;
    @Column(name="ELEG_TITR")
    private String ELEG_TITR;
    @Column(name="ELEG_SOTG")
    private String ELEG_SOTG;
    @Column(name="ELEG_FNG")
    private String ELEG_FNG;
    @Column(name="LIEN_PROM_IMMO")
    private String LIEN_PROM_IMMO;
    @Column(name="CATG_COMP")
    private String CATG_COMP;
    @Column(name="PRIO_IMP")
    private String PRIO_IMP;
    @Column(name="ELEG_DHMN")
    private String ELEG_DHMN;
    @Column(name="CRD_AUTR_TYPE_TAUX")
    private String CRD_AUTR_TYPE_TAUX;
    @Column(name="TYPS_ENG_LIES")
    private String TYPS_ENG_LIES;
    @Column(name="MRG_B_FONDS")
    private String MRG_B_FONDS;
    @Column(name="ELEG_TUNS")
    private String ELEG_TUNS;
    @Column(name="CALC_TUNS_CH")
    private String CALC_TUNS_CH;
    @Column(name="METH_MEP")
    private String METH_MEP;
    @Column(name="EXEC_VIR_DEBL")
    private String EXEC_VIR_DEBL;
    @Column(name="CPT_INTR_DEBL")
    private String CPT_INTR_DEBL;
    @Column(name="TAUX_EQUV")
    private String TAUX_EQUV;
    @Column(name="CPT_INT_TRES_A_RECV")
    private String CPT_INT_TRES_A_RECV;
    @Column(name="CPT_PL_TRES_A_RECV")
    private String CPT_PL_TRES_A_RECV;
    @Column(name="CPT_INT_TRES_RECV")
    private String CPT_INT_TRES_RECV;
    @Column(name="CPT_INT_TRES_IMP")
    private String CPT_INT_TRES_IMP;
    @Column(name="CPT_PPL_IMP")
    private String CPT_PPL_IMP;
    @Column(name="CPT_PPL_RECV")
    private String CPT_PPL_RECV;
    @Column(name="INDIC_FOND_ETAT")
    private String INDIC_FOND_ETAT;
    @Column(name="RAPP_GAR_CRD")
    private String RAPP_GAR_CRD;
    @Column(name="MNT_INV_MAX")
    private String MNT_INV_MAX;
    @Column(name="OPTN_COMP")
    private String OPTN_COMP;
    @Column(name="CPT_INT_RETR_TRES_A_RECV")
    private String CPT_INT_RETR_TRES_A_RECV;
    @Column(name="CPT_PL_INT_RETAR_TRES")
    private String CPT_PL_INT_RETAR_TRES;
    @Column(name="CPT_INT_RETR_RECV")
    private String CPT_INT_RETR_RECV;
    @Column(name="COMP_FOND")
    private String COMP_FOND;
    @Column(name="ELIG_FGIC")
    private String ELIG_FGIC;
    @Column(name="ELEG_SARE")
    private String ELEG_SARE;
}
