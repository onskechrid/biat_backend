package tn.biat.biat.entities;
import lombok.*;
import tn.biat.biat.entities.pk.R_CODE_ENG_BCT_pk;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@IdClass(R_CODE_ENG_BCT_pk.class)
@Entity
@Table(name = "\"R_CODE_ENG_BCT\"", schema = "public")
@SequenceGenerator(schema = "public", name = "R_CODE_ENG_BCT_seq", allocationSize = 1, sequenceName = "R_CODE_ENG_BCT_seq")
public class R_CODE_ENG_BCT implements Serializable {

    @Id
    @Column(name = "CDRCODENGBCT")
    @GeneratedValue(generator = "R_CODE_ENG_BCT_seq", strategy = GenerationType.SEQUENCE)
    private int CDRCODENGBCT;


    @Id
    @Column(name = "CODE_BCT")
    @GeneratedValue(generator = "R_CODE_ENG_BCT_seq", strategy = GenerationType.SEQUENCE)
    private String CODE_BCT;

    @Column(name = "TYPE_CODE_BCT")
    private int TYPE_CODE_BCT;

    @Column(name = "LIBELLE_COURT_CODE_BCT")
    private String LIBELLE_COURT_CODE_BCT;

    @Column(name = "LIBELLE_LONG_CODE_BCT")
    private String LIBELLE_LONG_CODE_BCT;


    @Id
    @Column(name = "DATDEBVLD")
    @GeneratedValue(generator = "R_CODE_ENG_BCT_seq", strategy = GenerationType.SEQUENCE)
    private int DATDEBVLD;

    @Column(name = "DATFINVLD")
    private int DATFINVLD;
    @Column(name = "DERSIT")
    private int DERSIT;
    @Column(name = "DAT_CHG")
    private int DAT_CHG;
}
