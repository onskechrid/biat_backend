package tn.biat.biat.entities;


import lombok.*;
import tn.biat.biat.entities.pk.E_ACCOUNT_pk;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@IdClass(E_ACCOUNT_pk.class)
@Entity
@Table(name = "\"E_ACCOUNT\"", schema = "public")
@SequenceGenerator(schema = "public", name = "account_seq", allocationSize = 1, sequenceName = "account_seq")
public class E_ACCOUNT implements Serializable {

    @Column(name = "CDRCONTMUTL")
    private int CDRCONTMUTL;
    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "account_seq", strategy = GenerationType.SEQUENCE)
    private String ID ;
    @Column(name = "CUST")
    private String CUST;
    @Column(name = "CATG")
    private String CATG;
    @Column(name = "ACCN_TITL_1")
    private String ACCN_TITL_1;
    @Column(name = "ACCN_TITL_2")
    private String ACCN_TITL_2;
    @Column(name = "SHRT_TITL")
    private String SHRT_TITL;
    @Column(name = "MNMN")
    private String MNMN;
    @Column(name = "CURR")
    private String CURR;
    @Column(name = "LIMT_REF")
    private String LIMT_REF;
    @Column(name = "ACCN_OFFC")
    private String ACCN_OFFC;
    @Column(name = "POST_REST")
    private String POST_REST;
    @Column(name = "INTR_COMP_ACCT")
    private String INTR_COMP_ACCT;
    @Column(name = "COND_GRP")
    private String COND_GRP;
    @Column(name = "INCT_MARK")
    private String INCT_MARK;
    @Column(name = "OPNN_DATE")
    private int OPNN_DATE;
    @Column(name = "LINK_TO_LIMIT")
    private String LINK_TO_LIMIT;
    @Column(name = "CLSR_DATE")
    private int CLSR_DATE;
    @Column(name = "CHRG_CCY")
    private String CHRG_CCY;
    @Column(name = "CHRG_MKT")
    private String CHRG_MKT;
    @Column(name = "INTR_CCY")
    private String INTR_CCY;
    @Column(name = "INTR_MKT")
    private String INTR_MKT;
    @Column(name = "ALL_NETT")
    private String ALL_NETT;
    @Column(name = "SING_LIMIT")
    private String SING_LIMIT;
    @Column(name = "CLSD_ONLN")
    private String CLSD_ONLN;
    @Column(name = "CO_CODE")
    private String CO_CODE;
    @Column(name = "RIB")
    private String RIB;
    @Column(name = "Comp_CTOS")
    private String Comp_CTOS;
    @Column(name = "AUTR_MOTF_OUV")
    private String AUTR_MOTF_OUV;
    @Column(name = "CART_EPRG")
    private String CART_EPRG;
    @Column(name = "CU_AUTR_REST")
    private String CU_AUTR_REST;
    @Column(name = "EMP_DEMR")
    private String EMP_DEMR;
    @Column(name = "FORW_MVMT")
    private String FORW_MVMT;
    @Column(name = "INT_LIQ_CCY")
    private String INT_LIQ_CCY;
    @Column(name = "INT_LIQU_ACCT")
    private String INT_LIQU_ACCT;
    @Column(name = "MOTF_OUVR")
    private String MOTF_OUVR;
    @Column(name = "NATR_COMP")
    private String NATR_COMP;
    @Column(name = "NUM_LIVR")
    private String NUM_LIVR;
    @Column(name = "OPT_SIGN")
    private String OPT_SIGN;
    @Column(name = "OPTN_COMP")
    private String OPTN_COMP;
    @Column(name = "OTHR_OFFC")
    private String OTHR_OFFC;
    @Column(name = "ACCT_CLSE_DATE")
    private int ACCT_CLSE_DATE;
    @Id
    @Column(name = "DATDEBVLD")
    @GeneratedValue(generator = "account_seq", strategy = GenerationType.SEQUENCE)
    private int DATDEBVLD;
    @Column(name = "DATFINVLD")
    private int DATFINVLD;
    @Column(name = "DERSIT")
    private int DERSIT;
    @Column(name = "DATCHG")
    private int DATCHG;
}
