package tn.biat.biat.entities;

import lombok.*;
import tn.biat.biat.entities.pk.E_ACCOUNT_SOLDE_pk;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@IdClass(E_ACCOUNT_SOLDE_pk.class)
@Entity
@Table(name = "\"E_ACCOUNT_SOLDE_PERSO_BIAT\"", schema = "public")
@SequenceGenerator(schema = "public", name = "E_ACCOUNT_SOLDE_PERSO_BIAT_seq", allocationSize = 1, sequenceName = "E_ACCOUNT_SOLDE_PERSO_BIAT_seq")
public class E_ACCOUNT_SOLDE_PERSO_BIAT implements Serializable{

    @Column(name = "CDRCONTRH")
    private int CDRCONTRH;
    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "E_ACCOUNT_SOLDE_PERSO_BIAT_seq", strategy = GenerationType.SEQUENCE)
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
    @Column(name = "OPEN_ACTUAL_BAL")
    private String OPEN_ACTUAL_BAL;
    @Column(name = "OPEN_CLEARED_BAL")
    private String OPEN_CLEARED_BAL;
    @Column(name = "ONLINE_ACTUAL_BAL")
    private String ONLINE_ACTUAL_BAL;
    @Column(name = "ONLINE_CLEARED_BAL")
    private String ONLINE_CLEARED_BAL;
    @Column(name = "WORKING_BALANCE")
    private String WORKING_BALANCE;
    @Id
    @Column(name = "DATDEBVLD")
    @GeneratedValue(generator = "E_ACCOUNT_SOLDE_PERSO_BIAT_seq", strategy = GenerationType.SEQUENCE)
    private int DATDEBVLD;
    @Column(name = "DATFINVLD")
    private int DATFINVLD;
    @Column(name = "DERSIT")
    private int DERSIT;
    @Column(name = "DATCHG")
    private int DATCHG;

}
