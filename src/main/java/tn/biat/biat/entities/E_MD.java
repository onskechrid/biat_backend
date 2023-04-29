package tn.biat.biat.entities;
import lombok.*;
import tn.biat.biat.entities.pk.E_MD_pk;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@IdClass(E_MD_pk.class)
@Entity
@Table(name = "\"E_MD\"", schema = "public")
@SequenceGenerator(schema = "public", name = "E_MD_seq", allocationSize = 1, sequenceName = "E_MD_seq")
public class E_MD implements Serializable{


    @Column(name = "CDRCONTMUTL")
    private int CDRCONTMUTL;

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "E_MD_seq", strategy = GenerationType.SEQUENCE)
    private String ID;

    @Column(name = "CUST")
    private String CUST;

    @Column(name = "CURR")
    private String CURR;

    @Column(name = "ACCN")
    private String ACCN;

    @Column(name = "TYP_ENG")
    private String TYP_ENG;

    @Column(name = "VALU_DATE")
    private String VALU_DATE;

    @Column(name = "MATR_DATE")
    private String MATR_DATE;

    @Column(name = "EPS_MONT_INI")
    private String EPS_MONT_INI;

    @Column(name = "CCY_MARK")
    private String CCY_MARK;

    @Column(name = "PRNC_AMNT")
    private String PRNC_AMNT;

    @Column(name = "DEAL_DATE")
    private String DEAL_DATE;

    @Column(name = "CONT_TYPE")
    private String CONT_TYPE;

    @Column(name = "DEAL_SUB_TYPE")
    private String DEAL_SUB_TYPE;

    @Column(name = "CATG")
    private String CATG;

    @Column(name = "LIMT_UPD_REQD")
    private String LIMT_UPD_REQD;

    @Column(name = "LIMT_REFR")
    private String LIMT_REFR;

    @Column(name = "ACCN_OFFC")
    private String ACCN_OFFC;

    @Column(name = "CONT_RISK")
    private String CONT_RISK;

    @Column(name = "CONT_EXPS")
    private String CONT_EXPS;

    @Column(name = "LIMT_AMNT")
    private String LIMT_AMNT;

    @Column(name = "STTS")
    private String STTS;

    @Column(name = "NET_PRIN_AMNT")
    private String NET_PRIN_AMNT;

    @Column(name = "INCL_PRVS")
    private String INCL_PRVS;

    @Column(name = "PRVS")
    private String PRVS;

    @Column(name = "PROV_DR_ACCNT")
    private String PROV_DR_ACCNT;

    @Column(name = "PROV_PERC")
    private String PROV_PERC;

    @Column(name = "PROV_AMNT")
    private String PROV_AMNT;

    @Column(name = "PROV_REL_DATE")
    private int PROV_REL_DATE;

    @Column(name = "PROV_REL_ACCN")
    private String PROV_REL_ACCN;

    @Column(name = "AUTO_EXPR")
    private String AUTO_EXPR;

    @Column(name = "ALTR_ID")
    private String ALTR_ID;

    @Column(name = "LIQD_MODE")
    private String LIQD_MODE;

    @Column(name = "CHRG_DATE")
    private String CHRG_DATE;

    @Column(name = "CHRG_CURR")
    private String CHRG_CURR;

    @Column(name = "CHRG_ACCN")
    private String CHRG_ACCN;

    @Column(name = "TAX_CODE")
    private String TAX_CODE;

    @Column(name = "BEN_ADDR")
    private String BEN_ADDR;

    @Column(name = "EPS_REF_MARC")
    private String EPS_REF_MARC;

    @Column(name = "EPS_MOTF_APUR")
    private String EPS_MOTF_APUR;

    @Column(name = "EPS_MODF")
    private String EPS_MODF;

    @Column(name = "EPS_ECH_INTL")
    private int EPS_ECH_INTL;

    @Column(name = "EPS_TYPE_DOC")
    private String EPS_TYPE_DOC;

    @Column(name = "EPS_DELV")
    private String EPS_DELV;


    @Column(name = "EPS_AVIS_MJEU")
    private String EPS_AVIS_MJEU;


    @Column(name = "EPS_CAUT_MODL")
    private String EPS_CAUT_MODL;

    @Column(name = "EPS_RECP")
    private String EPS_RECP;


    @Column(name = "EPS_DELV_REMP")
    private String EPS_DELV_REMP;

    @Column(name = "EPS_DT_RECP_MJ")
    private int EPS_DT_RECP_MJ;


    @Column(name = "EPS_PIST_CMC7")
    private String EPS_PIST_CMC7;


    @Column(name = "EPS_MONTN_EFF")
    private String EPS_MONTN_EFF;

    @Column(name = "EPS_ECH_EFFT")
    private int EPS_ECH_EFFT;

    @Column(name = "EPS_RIB_DEST")
    private String EPS_RIB_DEST;

    @Column(name = "EPS_PAMN_MJ")
    private String EPS_PAMN_MJ;

    @Column(name = "EPS_DEST")
    private String EPS_DEST;

    @Column(name = "EPS_DT_REMS_C")
    private int EPS_DT_REMS_C;

    @Column(name = "EPS_NBJR_VALI")
    private int EPS_NBJR_VALI;

    @Column(name = "EPS_PORC_CD")
    private int EPS_PORC_CD;


    @Column(name = "EPS_MOTF_ANNL")
    private String EPS_MOTF_ANNL;

    @Column(name = "EPS_CONT_MAR")
    private String EPS_CONT_MAR;

    @Column(name = "EPS_ACCN")
    private String EPS_ACCN;

    @Column(name = "MIGR")
    private String MIGR;

    @Column(name = "NIV_DELG_MAX")
    private String NIV_DELG_MAX;

    @Column(name = "EPS_VALD")
    private String EPS_VALD;

    @Column(name = "EPS_MODL")
    private String EPS_MODL;

    @Column(name = "EPS_APR_PART")
    private String EPS_APR_PART;


    @Column(name = "EPS_APR_ECH_AUT")
    private String EPS_APR_ECH_AUT;


    @Column(name = "EPS_MOIS_INDV")
    private String EPS_MOIS_INDV;

    @Column(name = "LIB_TYPE_ENG")
    private String LIB_TYPE_ENG;

    @Column(name = "EPS_TEMP_INV")
    private float EPS_TEMP_INV;

    @Column(name = "EPS_TEMP_PROV")
    private float EPS_TEMP_PROV;


    @Id
    @Column(name = "DATDEBVLD")
    @GeneratedValue(generator = "E_MD_seq", strategy = GenerationType.SEQUENCE)
    private int DATDEBVLD;

    @Column(name = "DATFINVLD")
    private int DATFINVLD;
    @Column(name = "DERSIT")
    private int DERSIT;
    @Column(name = "DATCHG")
    private int DATCHG;

}
