package tn.biat.biat.entities;
import lombok.*;
import tn.biat.biat.entities.pk.R_LIMITES_pk;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@IdClass(R_LIMITES_pk.class)
@Entity
@Table(name = "\"R_LIMITES\"", schema = "public")
@SequenceGenerator(schema = "public", name = "R_LIMITES_seq", allocationSize = 1, sequenceName = "R_LIMITES_seq")
public class R_LIMITES implements Serializable{

    @Id
    @Column(name = "CDRLIMT")
    @GeneratedValue(generator = "R_LIMITES_seq", strategy = GenerationType.SEQUENCE)
    private int CDRLIMT;

    @Column(name = "SHRT_NAM")
    private String SHRT_NAM;

    @Column(name = "FX_OR_TIME_BAND")
    private String FX_OR_TIME_BAND;

    @Column(name = "REDC_LIMT")
    private String REDC_LIMT;

    @Column(name = "LIMT_MNMN")
    private String LIMT_MNMN;

    @Column(name = "LIMT_KEY_TYP")
    private String LIMT_KEY_TYP;

    @Column(name = "LIMT_PERC")
    private String LIMT_PERC;

    @Column(name = "DEFL_CHCK")
    private String DEFL_CHCK;

    @Column(name = "PARN_REFR")
    private String PARN_REFR;

    @Column(name = "\"DESC\"")
    private String DESC;

    @Column(name = "ID")
    private int ID;

    @Id
    @Column(name = "DATDEBVLD")
    @GeneratedValue(generator = "R_LIMITES_seq", strategy = GenerationType.SEQUENCE)
    private int DATDEBVLD;

    @Column(name = "DATFINVLD")
    private int DATFINVLD;
    @Column(name = "DERSIT")
    private int DERSIT;
    @Column(name = "DAT_CHG")
    private int DAT_CHG;
}
