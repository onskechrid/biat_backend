package tn.biat.biat.entities;
import lombok.*;
import tn.biat.biat.entities.pk.R_INDUSTRY_pk;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@IdClass(R_INDUSTRY_pk.class)
@Entity
@Table(name = "\"R_INDUSTRY\"", schema = "public")
@SequenceGenerator(schema = "public", name = "R_INDUSTRY_seq", allocationSize = 1, sequenceName = "R_INDUSTRY_seq")
public class R_INDUSTRY implements Serializable{

    @Id
    @Column(name = "CDRINDS")
    @GeneratedValue(generator = "R_INDUSTRY_seq", strategy = GenerationType.SEQUENCE)
    private int CDRINDS;

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "R_INDUSTRY_seq", strategy = GenerationType.SEQUENCE)
    private int ID;

    @Column(name = "\"DESC\"")
    private String DESC;


    @Id
    @Column(name = "DATDEBVLD")
    @GeneratedValue(generator = "R_INDUSTRY_seq", strategy = GenerationType.SEQUENCE)
    private int DATDEBVLD;

    @Column(name = "DATFINVLD")
    private int DATFINVLD;
    @Column(name = "DERSIT")
    private int DERSIT;
    @Column(name = "DATCHG")
    private int DATCHG;
}
