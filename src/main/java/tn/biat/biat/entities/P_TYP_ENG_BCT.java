package tn.biat.biat.entities;
import lombok.*;
import tn.biat.biat.entities.pk.P_TYP_ENG_BCT_pk;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@IdClass(P_TYP_ENG_BCT_pk.class)
@Entity
@Table(name = "\"P_TYP_ENG_BCT\"", schema = "public")
@SequenceGenerator(schema = "public", name = "P_TYP_ENG_BCT_seq", allocationSize = 1, sequenceName = "P_TYP_ENG_BCT_seq")
public class P_TYP_ENG_BCT implements Serializable{

    @Id
    @Column(name = "TYPE_ENCR")
    @GeneratedValue(generator = "P_TYP_ENG_BCT_seq", strategy = GenerationType.SEQUENCE)
    private String TYPE_ENCR;

    @Id
    @Column(name = "TYPE_ENG")
    @GeneratedValue(generator = "P_TYP_ENG_BCT_seq", strategy = GenerationType.SEQUENCE)
    private String TYPE_ENG;

    @Column(name = "CODE_BCT")
    private String CODE_BCT;

    @Column(name = "USG")
    private String USG;

    @Id
    @Column(name = "DATDEBVLD")
    @GeneratedValue(generator = "P_TYP_ENG_BCT_seq", strategy = GenerationType.SEQUENCE)
    private int DATDEBVLD;

    @Column(name = "DATFINVLD")
    private int DATFINVLD;

    @Column(name = "DERSIT")
    private int DERSIT;

    @Column(name = "DATCHG")
    private int DATCHG;
}
