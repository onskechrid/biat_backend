package tn.biat.biat.entities;


import lombok.*;
import tn.biat.biat.entities.pk.E_CONTRAT_pk;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@IdClass(E_CONTRAT_pk.class)
@Entity
@Table(name = "\"E_CONTRAT\"", schema = "public")
@SequenceGenerator(schema = "public", name = "contrat_seq", allocationSize = 1, sequenceName = "contrat_seq")
public class E_CONTRAT implements Serializable {

    @Column(name = "CDRCONTMUTL")
    private int CDRCONTMUTL;
    @Id
    @Column(name = "REF_CONT")
    @GeneratedValue(generator = "contrat_seq", strategy = GenerationType.SEQUENCE)
    private String REF_CONT;
    @Column(name = "REF_CRDT")
    private String REF_CRDT;
    @Column(name = "CUST")
    private String CUST;
    @Column(name = "CURR")
    private String CURR;
    @Column(name = "CATG")
    private String CATG;
    @Column(name = "CONT_DATE")
    private String CONT_DATE;
    @Column(name = "VAL_DATE")
    private String VAL_DATE;
    @Column(name = "MATR_DATE")
    private String MATR_DATE;
    @Column(name = "LIMT_REF")
    private String LIMT_REF;
    @Column(name = "COMP")
    private String COMP;
    @Column(name = "ACCT_OFFC")
    private String ACCT_OFFC;
    @Column(name = "INTR_KEY")
    private String INTR_KEY;
    @Column(name = "TIEG")
    private String TIEG;
    @Column(name = "INTR_SPREAD")
    private String INTR_SPREAD;
    @Column(name = "TAUX_BASE")
    private String TAUX_BASE;
    @Column(name = "MARG")
    private String MARG;
    @Column(name = "INTR_RATE")
    private String INTR_RATE;
    @Column(name = "TYPE_ENG")
    private String TYPE_ENG;
    @Column(name = "REF_TITR_CR")
    private String REF_TITR_CR;
    @Column(name = "MONT_DEBL")
    private String MONT_DEBL;
    @Column(name = "CDRCUST")
    private int CDRCUST;
    @Column(name = "CDRCODENG")
    private int CDRCODENG;
    @Column(name = "CDRCURR")
    private int CDRCURR;
    @Column(name = "CDR_TITR")
    private int CDR_TITR;
    @Column(name = "CDRCATG")
    private int CDRCATG;
    @Id
    @Column(name = "DATDEBVLD")
    @GeneratedValue(generator = "contrat_seq", strategy = GenerationType.SEQUENCE)
    private int DATDEBVLD;
    @Column(name = "DATFINVLD")
    private int DATFINVLD;
    @Column(name = "DERSIT")
    private int DERSIT;
    @Column(name = "DATCHG")
    private int DATCHG;

}
