package tn.biat.biat.entities;
import lombok.*;
import tn.biat.biat.entities.pk.R_TARGET_pk;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@IdClass(R_TARGET_pk.class)
@Entity
@Table(name = "\"R_TARGET\"", schema = "public")
@SequenceGenerator(schema = "public", name = "R_TARGET_seq", allocationSize = 1, sequenceName = "R_TARGET_seq")
public class R_TARGET implements Serializable{

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "R_TARGET_seq", strategy = GenerationType.SEQUENCE)
    private int ID;

    @Id
    @Column(name = "CDRTARG")
    @GeneratedValue(generator = "R_TARGET_seq", strategy = GenerationType.SEQUENCE)
    private int CDRTARG;

    @Id
    @Column(name = "DATDEBVLD")
    @GeneratedValue(generator = "R_TARGET_seq", strategy = GenerationType.SEQUENCE)
    private int DATDEBVLD;

    @Column(name = "\"DESC\"")
    private String DESC;

    @Column(name = "SHRT_NAM")
    private String SHRT_NAM;

    @Column(name = "DATFINVLD")
    private int DATFINVLD;
    @Column(name = "DERSIT")
    private int DERSIT;
    @Column(name = "DAT_CHG")
    private int DAT_CHG;
}
