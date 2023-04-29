package tn.biat.biat.entities;
import lombok.*;
import tn.biat.biat.entities.pk.R_CODE_ENG_pk;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@IdClass(R_CODE_ENG_pk.class)
@Entity
@Table(name = "\"R_CODE_ENG\"", schema = "public")
@SequenceGenerator(schema = "public", name = "R_CODE_ENG_seq", allocationSize = 1, sequenceName = "R_CODE_ENG_seq")
public class R_CODE_ENG implements Serializable{

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "R_CODE_ENG_seq", strategy = GenerationType.SEQUENCE)
    private String ID;

    @Id
    @Column(name = "DATDEBVLD")
    @GeneratedValue(generator = "R_CODE_ENG_seq", strategy = GenerationType.SEQUENCE)
    private int DATDEBVLD;

    @Column(name = "DATFINVLD")
    private int DATFINVLD;
    @Column(name = "DERSIT")
    private int DERSIT;
    @Column(name = "DATCHG")
    private int DATCHG;

    @Column(name = "CDRCODENG")
    private int CDRCODENG;

    @Column(name = "\"DESC\"")
    private String DESC;

    @Column(name = "CDRCODENGBCT")
    private int CDRCODENGBCT;

    @Column(name = "COD_ENG_BCT")
    private String COD_ENG_BCT;

    @Column(name = "RECC_BIAT")
    private String RECC_BIAT;

    @Column(name = "CATG_COMP")
    private String CATG_COMP;

    @Column(name = "DEVS")
    private String DEVS;

    @Column(name = "TYPE_LIMT")
    private String TYPE_LIMT;

    @Column(name = "LIMT_REF")
    private int LIMT_REF;

    @Column(name = "DATE_FIN")
    private String DATE_FIN;

    @Column(name = "DATE_DEBT")
    private String DATE_DEBT;

    @Column(name = "PRIO_IMP")
    private String PRIO_IMP;

    @Column(name = "LIGN_PRDT")
    private String LIGN_PRDT;

    @Column(name = "CATG")
    private String CATG;


}
