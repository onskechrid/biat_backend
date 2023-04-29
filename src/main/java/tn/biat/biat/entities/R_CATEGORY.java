package tn.biat.biat.entities;
import lombok.*;
import tn.biat.biat.entities.pk.R_CATEGORY_pk;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@IdClass(R_CATEGORY_pk.class)
@Entity
@Table(name = "\"R_CATEGORY\"", schema = "public")
@SequenceGenerator(schema = "public", name = "R_CATEGORY_seq", allocationSize = 1, sequenceName = "R_CATEGORY_seq")
public class R_CATEGORY implements Serializable{

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "R_CATEGORY_seq", strategy = GenerationType.SEQUENCE)
    private String ID;

    @Id
    @Column(name = "DATDEBVLD")
    @GeneratedValue(generator = "R_CATEGORY_seq", strategy = GenerationType.SEQUENCE)
    private int DATDEBVLD;

    @Id
    @Column(name = "CDRCATG")
    @GeneratedValue(generator = "R_CATEGORY_seq", strategy = GenerationType.SEQUENCE)
    private int CDRCATG;


    @Column(name = "DATFINVLD")
    private int DATFINVLD;
    @Column(name = "DERSIT")
    private int DERSIT;
    @Column(name = "DATCHG")
    private int DATCHG;



    @Column(name = "SYST_IND")
    private String SYST_IND;

    @Column(name = "MNMN")
    private String MNMN;

    @Column(name = "TAXB")
    private String TAXB;


    @Column(name = "LIGN_PRD")
    private String LIGN_PRD;

    @Column(name = "SHRT_NAM")
    private String SHRT_NAM;

    @Column(name = "\"DESC\"")
    private String DESC;


    @Column(name = "AC_CONT")
    private String AC_CONT;

}
