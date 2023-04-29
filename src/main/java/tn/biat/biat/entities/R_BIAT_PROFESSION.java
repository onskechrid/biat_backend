package tn.biat.biat.entities;
import lombok.*;
import tn.biat.biat.entities.pk.R_BIAT_PROFESSION_pk;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@IdClass(R_BIAT_PROFESSION_pk.class)
@Entity
@Table(name = "\"R_BIAT_PROFESSION\"", schema = "public")
@SequenceGenerator(schema = "public", name = "R_BIAT_PROFESSION_seq", allocationSize = 1, sequenceName = "R_BIAT_PROFESSION_seq")
public class R_BIAT_PROFESSION implements Serializable{

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "R_BIAT_PROFESSION_seq", strategy = GenerationType.SEQUENCE)
    private String ID;

    @Column(name = "LIBL")
    private String LIBL;

    @Column(name = "CORR_BCT")
    private String CORR_BCT;

    @Id
    @Column(name = "CDRBIATPRFS")
    @GeneratedValue(generator = "R_BIAT_PROFESSION_seq", strategy = GenerationType.SEQUENCE)
    private int CDRBIATPRFS;

    @Id
    @Column(name = "DATDEBVLD")
    @GeneratedValue(generator = "R_BIAT_PROFESSION_seq", strategy = GenerationType.SEQUENCE)
    private int DATDEBVLD;

    @Column(name = "DATFINVLD")
    private int DATFINVLD;
    @Column(name = "DERSIT")
    private int DERSIT;
    @Column(name = "DAT_CHG")
    private int DAT_CHG;
}
