package tn.biat.biat.entities;
import lombok.*;
import tn.biat.biat.entities.pk.R_CODE_ENG_PERSO_BIAT_pk;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@IdClass(R_CODE_ENG_PERSO_BIAT_pk.class)
@Entity
@Table(name = "\"R_CODE_ENG_PERSO_BIAT\"", schema = "public")
@SequenceGenerator(schema = "public", name = "R_CODE_ENG_PERSO_BIAT_seq", allocationSize = 1, sequenceName = "R_CODE_ENG_PERSO_BIAT_seq")
public class R_CODE_ENG_PERSO_BIAT implements Serializable{

    @Id
    @Column(name = "CDRCODENGRH")
    @GeneratedValue(generator = "R_CODE_ENG_PERSO_BIAT_seq", strategy = GenerationType.SEQUENCE)
    private int CDRCODENGRH;

    @Id
    @Column(name = "CODE_ENGG")
    @GeneratedValue(generator = "R_CODE_ENG_PERSO_BIAT_seq", strategy = GenerationType.SEQUENCE)
    private String CODE_ENGG;

    @Column(name = "CODE_CRDT")
    private String CODE_CRDT;

    @Column(name = "LIBL")
    private String LIBL;

    @Id
    @Column(name = "DATDEBVLD")
    @GeneratedValue(generator = "R_CODE_ENG_PERSO_BIAT_seq", strategy = GenerationType.SEQUENCE)
    private int DATDEBVLD;

    @Column(name = "DATFINVLD")
    private int DATFINVLD;
    @Column(name = "DERSIT")
    private int DERSIT;
    @Column(name = "DATCHG")
    private int DATCHG;
}
