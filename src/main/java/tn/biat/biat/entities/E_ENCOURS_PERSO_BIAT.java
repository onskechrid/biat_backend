package tn.biat.biat.entities;

import lombok.*;
import tn.biat.biat.entities.pk.E_ENCOURS_PERSO_BIAT_pk;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@IdClass(E_ENCOURS_PERSO_BIAT_pk.class)
@Entity
@Table(name = "\"E_ENCOURS_PERSO_BIAT\"", schema = "public")
@SequenceGenerator(schema = "public", name = "E_ENCOURS_PERSO_BIAT_seq", allocationSize = 1, sequenceName = "E_ENCOURS_PERSO_BIAT_seq")
public class E_ENCOURS_PERSO_BIAT implements Serializable{


    @Column(name = "CDRCONTMUTL")
    private int CDRCONTMUTL;

    @Id
    @Column(name = "REF_CONT")
    @GeneratedValue(generator = "E_ENCOURS_PERSO_BIAT_seq", strategy = GenerationType.SEQUENCE)
    private String REF_CONT;

    @Column(name = "MONT_ENCR_INTL")
    private double MONT_ENCR_INTL;

    @Column(name = "MONT_ENCR")
    private double MONT_ENCR;

    @Column(name = "MONT_ENCR_TND")
    private double MONT_ENCR_TND;

    @Id
    @Column(name = "CODE_TYP_ENCR")
    @GeneratedValue(generator = "E_ENCOURS_PERSO_BIAT_seq", strategy = GenerationType.SEQUENCE)
    private int CODE_TYP_ENCR;

    @Id
    @Column(name = "STATUT")
    @GeneratedValue(generator = "E_ENCOURS_PERSO_BIAT_seq", strategy = GenerationType.SEQUENCE)
    private String STATUT;

    @Id
    @Column(name = "DAT_SIT")
    @GeneratedValue(generator = "E_ENCOURS_PERSO_BIAT_seq", strategy = GenerationType.SEQUENCE)
    private int DAT_SIT;

    @Column(name = "DERSIT")
    private int DERSIT;

    @Id
    @Column(name = "DAT_CHG")
    @GeneratedValue(generator = "E_ENCOURS_PERSO_BIAT_seq", strategy = GenerationType.SEQUENCE)
    private String DAT_CHG;

}
