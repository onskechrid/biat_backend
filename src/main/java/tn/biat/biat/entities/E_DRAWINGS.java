package tn.biat.biat.entities;

import lombok.*;
import tn.biat.biat.entities.pk.E_DRAWINGS_pk;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@IdClass(E_DRAWINGS_pk.class)
@Entity
@Table(name = "\"E_DRAWINGS\"", schema = "public")
@SequenceGenerator(schema = "public", name = "E_DRAWINGS_seq", allocationSize = 1, sequenceName = "E_DRAWINGS_seq")
public class E_DRAWINGS implements Serializable{

    @Column(name = "CDRCONTMUTL")
    private int CDRCONTMUTL;
    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "E_DRAWINGS_seq", strategy = GenerationType.SEQUENCE)
    private String ID;
    @Column(name = "DRWN_TYPE")
    private String DRWN_TYPE;
    @Column(name = "DRW_CURR")
    private String DRW_CURR;
    @Column(name = "DOCM_AMNT")
    private float DOCM_AMNT;
    @Column(name = "VALU_DATE")
    private int VALU_DATE;
    @Column(name = "DRWD_ACCNT")
    private String DRWD_ACCNT;
    @Column(name = "PAMN_METH")
    private String PAMN_METH;
    @Column(name = "PAMN_ACCNT")
    private String PAMN_ACCNT;
    @Column(name = "PAMN_AMNT")
    private float PAMN_AMNT;
    @Column(name = "REMB_AMNT")
    private float REMB_AMNT;
    @Column(name = "LIMT_REFR")
    private String LIMT_REFR;
    @Column(name = "DOC_AMT_LOCL")
    private float DOC_AMT_LOCL;
    @Column(name = "DOC_AMT_LC_CCY")
    private float DOC_AMT_LC_CCY;
    @Column(name = "FULL_UTLS")
    private String FULL_UTLS;
    @Column(name = "LC_CRDT_TYPE")
    private String LC_CRDT_TYPE;
    @Column(name = "CUST_LINK")
    private String CUST_LINK;
    @Column(name = "PROV_AMT_REL")
    private String PROV_AMT_REL;
    @Column(name = "LC_LIAB_RELS")
    private float LC_LIAB_RELS;
    @Column(name = "LC_LIAB_REL_LCY")
    private float LC_LIAB_REL_LCY;
    @Column(name = "REMB_AMT_LCCY")
    private float REMB_AMT_LCCY;
    @Column(name = "PAY_AMT_LCCY")
    private float PAY_AMT_LCCY;
    @Column(name = "PROV_REL_LC_CCY")
    private float PROV_REL_LC_CCY;
    @Column(name = "PROV_REL_DOC_CCY")
    private float PROV_REL_DOC_CCY;
    @Column(name = "MATR_REVW")
    private int MATR_REVW;
    @Column(name = "CHRG_CODE")
    private String CHRG_CODE;
    @Column(name = "CHRG_CURR")
    private String CHRG_CURR;
    @Column(name = "CHRG_AMNT")
    private String CHRG_AMNT;
    @Column(name = "RELTED_DRWN")
    private String RELTED_DRWN;
    @Column(name = "CHRG_LCCY_AMT")
    private String CHRG_LCCY_AMT;
    @Column(name = "TYP_ENG")
    private String TYP_ENG;
    @Id
    @Column(name = "DATDEBVLD")
    @GeneratedValue(generator = "E_DRAWINGS_seq", strategy = GenerationType.SEQUENCE)
    private int DATDEBVLD;
    @Column(name = "DATFINVLD")
    private int DATFINVLD;
    @Column(name = "DERSIT")
    private int DERSIT;
    @Column(name = "DATCHG")
    private int DATCHG;
}
