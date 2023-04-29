package tn.biat.biat.entities;
import lombok.*;
import tn.biat.biat.entities.pk.E_PD_pk;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@IdClass(E_PD_pk.class)
@Entity
@Table(name = "\"E_PD\"", schema = "public")
@SequenceGenerator(schema = "public", name = "E_PD_seq", allocationSize = 1, sequenceName = "E_PD_seq")
public class E_PD implements Serializable{

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "E_PD_seq", strategy = GenerationType.SEQUENCE)
    private String ID;
    @Column(name= "CUSTOMER")
    private String CUSTOMER;
    @Column(name= "CURRENCY")
    private String CURRENCY;
    @Column(name= "CURRENCY_MARKET")
    private String CURRENCY_MARKET;
    @Column(name= "POSITION_TYPE")
    private String POSITION_TYPE;
    @Column(name= "ACCOUNT_OFFICER")
    private String ACCOUNT_OFFICER;
    @Column(name= "CATEGORY")
    private String CATEGORY;
    @Column(name= "INTEREST_BASIS")
    private String INTEREST_BASIS;
    @Column(name= "PENALTY_RATE")
    private String PENALTY_RATE;
    @Column(name= "PENALTY_KEY")
    private String PENALTY_KEY;
    @Column(name= "PENALTY_SPREAD")
    private String PENALTY_SPREAD;
    @Column(name= "PARAMETER_RECORD")
    private String PARAMETER_RECORD;
    @Column(name= "LIMIT_REFERENCE")
    private String LIMIT_REFERENCE;
    @Column(name= "FINAL_DUE_DATE")
    private String FINAL_DUE_DATE;
    @Column(name= "REPAYMENT_ACCT")
    private String REPAYMENT_ACCT;
    @Column(name= "START_DATE")
    private String START_DATE;
    @Column(name= "CO_CODE")
    private String CO_CODE;
    @Column(name= "ACCRUAL_PARAM")
    private String ACCRUAL_PARAM;
    @Column(name= "ROUNDING_RULE")
    private String ROUNDING_RULE;
    @Column(name= "WAIVE_GRA_PE")
    private String WAIVE_GRA_PE;
    @Column(name= "WAIVE_GRA_PS")
    private String WAIVE_GRA_PS;
    @Column(name= "ORIG_STLMNT_ACT")
    private String ORIG_STLMNT_ACT;
    @Column(name= "REPAID_STATUS")
    private String REPAID_STATUS;
    @Column(name= "TYPE_CREDIT")
    private String TYPE_CREDIT;
    @Column(name= "TYPE_ENG")
    private String TYPE_ENG;
    @Column(name= "LIB_TYPE_ENG")
    private String LIB_TYPE_ENG;
    @Column(name= "PRIORITE_IMPAYE")
    private String PRIORITE_IMPAYE;
    @Column(name= "INTERVALLE_IMP")
    private String INTERVALLE_IMP;
    @Column(name= "ENV_RECOUV_EXT")
    private String ENV_RECOUV_EXT;
    @Column(name= "TYPE_RECOUV_EXT")
    private String TYPE_RECOUV_EXT;
    @Column(name= "RS_RECOUV_EXT")
    private String RS_RECOUV_EXT;
    @Column(name= "DOC_RECOUV_EXT")
    private String DOC_RECOUV_EXT;
    @Column(name= "NAT_DOC_RECOUV")
    private String NAT_DOC_RECOUV;
    @Column(name= "REFERENCE")
    private String REFERENCE;
    @Column(name= "COMPTE")
    private String COMPTE;
    @Column(name= "COURS_CHANGE")
    private String COURS_CHANGE;
    @Column(name= "LC_NUMBER_12")
    private String LC_NUMBER_12;


    @Column(name= "CDRCONTMUTL")
    private int CDRCONTMUTL;

    @Id
    @Column(name = "DATDEBVLD")
    @GeneratedValue(generator = "E_PD_seq", strategy = GenerationType.SEQUENCE)
    private int DATDEBVLD;

    @Column(name= "DATFINVLD")
    private int DATFINVLD;
    @Column(name= "DERSIT")
    private int DERSIT;
    @Column(name= "DATCHG")
    private int DATCHG;
}
