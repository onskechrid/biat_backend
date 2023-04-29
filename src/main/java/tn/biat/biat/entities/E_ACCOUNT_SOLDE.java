package tn.biat.biat.entities;

import lombok.*;
import tn.biat.biat.entities.pk.E_ACCOUNT_SOLDE_pk;
import tn.biat.biat.entities.pk.E_CUSTOMER_pk;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@IdClass(E_ACCOUNT_SOLDE_pk.class)
@Entity
@Table(name = "\"E_ACCOUNT_SOLDE\"", schema = "public")
@SequenceGenerator(schema = "public", name = "E_ACCOUNT_SOLDE_seq", allocationSize = 1, sequenceName = "E_ACCOUNT_SOLDE_seq")
public class E_ACCOUNT_SOLDE implements Serializable {

    @Column(name = "CDRCONTMUTL")
    private int CDRCONTMUTL;
    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "E_ACCOUNT_SOLDE_seq", strategy = GenerationType.SEQUENCE)
    private String ID;
    @Column(name = "ACCR_CHG_AMNT")
    private String ACCR_CHG_AMNT;
    @Column(name = "ACCR_CHG_CATG")
    private String ACCR_CHG_CATG;
    @Column(name = "ACCR_CR_AMNT")
    private String ACCR_CR_AMNT;
    @Column(name = "ACCR_CR_CATG")
    private String ACCR_CR_CATG;
    @Column(name = "ACCR_DR_AMNT")
    private String ACCR_DR_AMNT;
    @Column(name = "ACCR_DR_CATG")
    private String ACCR_DR_CATG;
    @Column(name = "OPEN_ACTL_BAL")
    private String OPEN_ACTL_BAL;
    @Column(name = "OPEN_CLRD_BAL")
    private String OPEN_CLRD_BAL;
    @Column(name = "ONLN_ACTL_BAL")
    private String ONLN_ACTL_BAL;
    @Column(name = "ONLN_CLRD_BAL")
    private String ONLN_CLRD_BAL;
    @Column(name = "WORK_BALN")
    private String WORK_BALN;
    @Id
    @Column(name = "DATDEBVLD")
    @GeneratedValue(generator = "E_ACCOUNT_SOLDE_seq", strategy = GenerationType.SEQUENCE)
    private int DATDEBVLD;
    @Column(name = "DATFINVLD")
    private int DATFINVLD;
    @Column(name = "DERSIT")
    private int DERSIT;
    @Column(name = "DATCHG")
    private int DATCHG;

}
