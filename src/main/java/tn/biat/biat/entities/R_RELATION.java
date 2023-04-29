package tn.biat.biat.entities;
import lombok.*;
import tn.biat.biat.entities.pk.R_RELATION_pk;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@IdClass(R_RELATION_pk.class)
@Entity
@Table(name = "\"R_RELATION\"", schema = "public")
@SequenceGenerator(schema = "public", name = "R_RELATION_seq", allocationSize = 1, sequenceName = "R_RELATION_seq")
public class R_RELATION implements Serializable{

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "R_RELATION_seq", strategy = GenerationType.SEQUENCE)
    private int ID;

    @Column(name = "\"DESC\"")
    private String DESC;

    @Id
    @Column(name = "CDRRELT")
    @GeneratedValue(generator = "R_RELATION_seq", strategy = GenerationType.SEQUENCE)
    private int CDRRELT;

    @Id
    @Column(name = "DATDEBVLD")
    @GeneratedValue(generator = "R_RELATION_seq", strategy = GenerationType.SEQUENCE)
    private int DATDEBVLD;

    @Column(name = "DATFINVLD")
    private int DATFINVLD;
    @Column(name = "DERSIT")
    private int DERSIT;
    @Column(name = "DATCHG")
    private int DATCHG;
}
