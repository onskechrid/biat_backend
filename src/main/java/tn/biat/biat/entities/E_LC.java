package tn.biat.biat.entities;

import lombok.*;
import tn.biat.biat.entities.pk.E_LC_pk;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@IdClass(E_LC_pk.class)
@Entity
@Table(name = "\"E_LC\"", schema = "public")
@SequenceGenerator(schema = "public", name = "E_LC_seq", allocationSize = 1, sequenceName = "E_LC_seq")
public class E_LC implements Serializable{


    @Column(name = "CDRCONTMUTL")
    private int CDRCONTMUTL;

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "E_LC_seq", strategy = GenerationType.SEQUENCE)
    private String ID;

    @Column(name = "CUST")
    private String CUST;

    @Column(name = "CURR")
    private String CURR;

    @Column(name = "ACCN")
    private String ACCN;

    @Column(name = "TYPE_ENG")
    private String TYPE_ENG;

    @Column(name = "ISSU_DATE")
    private int ISSU_DATE;

    @Column(name = "EXPR_DATE")
    private int EXPR_DATE;

    @Column(name = "OPRT")
    private String OPRT;

    @Column(name = "LC_TYPE")
    private String LC_TYPE;

    @Column(name = "EXTR_REFR")
    private String EXTR_REFR;

    @Column(name = "CHRG_ACCN")
    private String CHRG_ACCN;

    @Column(name = "LC_AMNT")
    private float LC_AMNT;

    @Column(name = "DAY_BASS")
    private String DAY_BASS;

    @Column(name = "CURR_MARK")
    private String CURR_MARK;

    @Column(name = "POST_TYPE")
    private String POST_TYPE;

    @Column(name = "LIMT_REFR")
    private String LIMT_REFR;

    @Column(name = "EXPR_PLAC")
    private String EXPR_PLAC;

    @Column(name = "CLSN_DATE")
    private int CLSN_DATE;

    @Column(name = "BENF_CUST")
    private String BENF_CUST;

    @Column(name = "CATG_CODE")
    private String CATG_CODE;

    @Column(name = "ACCN_OFFC")
    private String ACCN_OFFC;

    @Column(name = "LIBL_AMT")
    private float LIBL_AMT;

    @Column(name = "LC_AMNT_LOCL")
    private float LC_AMNT_LOCL;

    @Column(name = "DRWN")
    private float DRWN;

    @Column(name = "NEXT_DRWN")
    private String NEXT_DRWN;

    @Column(name = "PAMN_AMT")
    private float PAMN_AMT;

    @Column(name = "APPL_CUST")
    private String APPL_CUST;

    @Column(name = "APPL_ACC")
    private String APPL_ACC;

    @Column(name = "FULLY_UTLS")
    private String FULLY_UTLS;

    @Column(name = "PRVS_PERC")
    private String PRVS_PERC;

    @Column(name = "PRVS_AMNT")
    private float PRVS_AMNT;

    @Column(name = "PRO_OUT_AMNT")
    private float PRO_OUT_AMNT;

    @Column(name = "PRO_AWAT_REL")
    private float PRO_AWAT_REL;

    @Column(name = "PRVS_RATE")
    private float PRVS_RATE;

    @Column(name = "BENF")
    private String BENF;

    @Column(name = "DRAW_TYPE")
    private String DRAW_TYPE;

    @Column(name = "LIAB_PORT_AMT")
    private float LIAB_PORT_AMT;

    @Column(name = "LCY_PORT_AMT")
    private float LCY_PORT_AMT;

    @Column(name = "LR_EFF_AVAL")
    private String LR_EFF_AVAL;

    @Column(name = "LR_REF_AVAL")
    private String LR_REF_AVAL;

    @Column(name = "NUMR_COMP")
    private String NUMR_COMP;

    @Id
    @Column(name = "DATDEBVLD")
    @GeneratedValue(generator = "E_LC_seq", strategy = GenerationType.SEQUENCE)
    private int DATDEBVLD;

    @Column(name = "DATFINVLD")
    private int DATFINVLD;

    @Column(name = "DERSIT")
    private int DERSIT;

    @Column(name = "DATCHG")
    private int DATCHG;


}
