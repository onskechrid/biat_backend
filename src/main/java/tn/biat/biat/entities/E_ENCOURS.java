package tn.biat.biat.entities;

import lombok.*;
import tn.biat.biat.entities.pk.E_ENCOURS_pk;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@IdClass(E_ENCOURS_pk.class)
@Entity
@Table(name = "\"E_ENCOURS\"", schema = "public")
@SequenceGenerator(schema = "public", name = "encours_seq", allocationSize = 1, sequenceName = "encours_seq")
public class E_ENCOURS implements Serializable {

    @Column(name = "CDRCONTMUTL")
    private int CDRCONTMUTL;
    @Id
    @Column(name = "REF_CONT")
    @GeneratedValue(generator = "encours_seq", strategy = GenerationType.SEQUENCE)
    private String REF_CONT;
    @Column(name = "MONT_ENCR_INTL_TND")
    private double MONT_ENCR_INTL_TND;
    @Column(name = "MONT_ENCR_REDR_TND")
    private double MONT_ENCR_REDR_TND;
    @Column(name = "MONT_ENCR_INTL_DEV")
    private double MONT_ENCR_INTL_DEV;
    @Column(name = "MONT_ENCR_REDR_DEV")
    private double MONT_ENCR_REDR_DEV;
    @Id
    @Column(name = "CODE_TYP_ENCR")
    @GeneratedValue(generator = "encours_seq", strategy = GenerationType.SEQUENCE)
    private int CODE_TYP_ENCR;
    @Id
    @Column(name = "STATUT")
    @GeneratedValue(generator = "encours_seq", strategy = GenerationType.SEQUENCE)
    private String STATUT;
    @Column(name = "CDR_TYP_ENCR")
    private int CDR_TYP_ENCR;
    @Id
    @Column(name = "DAT_SIT")
    @GeneratedValue(generator = "encours_seq", strategy = GenerationType.SEQUENCE)
    private int DAT_SIT;
    @Column(name = "DERSIT")
    private int DERSIT;
    @Id
    @Column(name = "DAT_CHG")
    @GeneratedValue(generator = "encours_seq", strategy = GenerationType.SEQUENCE)
    private String DAT_CHG;
}
