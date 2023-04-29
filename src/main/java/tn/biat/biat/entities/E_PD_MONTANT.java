package tn.biat.biat.entities;
import lombok.*;
import tn.biat.biat.entities.pk.E_PD_MONTANT_pk;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@IdClass(E_PD_MONTANT_pk.class)
@Entity
@Table(name = "\"E_PD_MONTANT\"", schema = "public")
@SequenceGenerator(schema = "public", name = "E_PD_MONTANT_seq", allocationSize = 1, sequenceName = "E_PD_MONTANT_seq")
public class E_PD_MONTANT implements Serializable{


    @Column(name = "CDRCONTMUTL")
    private int CDRCONTMUTL;

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "E_PD_MONTANT_seq", strategy = GenerationType.SEQUENCE)
    private String ID;

    @Column(name = "TOTAL_AMT_TO_REPAY")
    private String TOTAL_AMT_TO_REPAY;

    @Column(name = "ANCIENNETE_IMP")
    private String ANCIENNETE_IMP;

    @Column(name = "INTERET")
    private String INTERET;

    @Column(name = "PRINCIPAL")
    private String PRINCIPAL;

    @Column(name = "PENALITE_RETARD_PS")
    private String PENALITE_RETARD_PS;

    @Column(name = "PENALITE_RETARD_WE")
    private String PENALITE_RETARD_WE;

    @Column(name = "PENALITE_RETARD_WS")
    private String PENALITE_RETARD_WS;

    @Column(name = "PENALITE_RETARD_PE")
    private String PENALITE_RETARD_PE;

    @Column(name = "MONTANT")
    private String MONTANT;

    @Id
    @Column(name = "DAT_SIT")
    @GeneratedValue(generator = "E_PD_MONTANT_seq", strategy = GenerationType.SEQUENCE)
    private int DAT_SIT;

    @Column(name = "DERSIT")
    private int DERSIT;

    @Column(name = "DATCHG")
    private int DATCHG;
}
