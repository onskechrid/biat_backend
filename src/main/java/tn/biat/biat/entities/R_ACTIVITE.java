package tn.biat.biat.entities;
import lombok.*;
import tn.biat.biat.entities.pk.R_ACTIVITE_pk;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@IdClass(R_ACTIVITE_pk.class)
@Entity
@Table(name = "\"R_ACTIVITE\"", schema = "public")
@SequenceGenerator(schema = "public", name = "R_ACTIVITE_seq", allocationSize = 1, sequenceName = "R_ACTIVITE_seq")
public class R_ACTIVITE implements Serializable{

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "R_ACTIVITE_seq", strategy = GenerationType.SEQUENCE)
    private String ID;

    @Column(name = "LIBL")
    private String LIBL;

    @Column(name = "CORR_BCT")
    private String CORR_BCT;

    @Id
    @Column(name = "CDRACTV")
    @GeneratedValue(generator = "R_ACTIVITE_seq", strategy = GenerationType.SEQUENCE)
    private int CDRACTV;

    @Column(name = "CDRCONTMUTL")
    private int CDRCONTMUTL;

    @Id
    @Column(name = "DATDEBVLD")
    @GeneratedValue(generator = "R_ACTIVITE_seq", strategy = GenerationType.SEQUENCE)
    private int DATDEBVLD;

    @Column(name = "DATFINVLD")
    private int DATFINVLD;
    @Column(name = "DERSIT")
    private int DERSIT;
    @Column(name = "DATCHG")
    private int DATCHG;

}
