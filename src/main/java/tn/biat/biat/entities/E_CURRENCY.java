package tn.biat.biat.entities;

import lombok.*;
import tn.biat.biat.entities.pk.E_CURRENCY_pk;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@IdClass(E_CURRENCY_pk.class)
@Entity
@Table(name = "\"E_CURRENCY\"", schema = "public")
@SequenceGenerator(schema = "public", name = "E_CURRENCY_seq", allocationSize = 1, sequenceName = "E_CURRENCY_seq")
public class E_CURRENCY implements Serializable{

    @Id
    @Column(name = "CDR_CURR")
    @GeneratedValue(generator = "E_CURRENCY_seq", strategy = GenerationType.SEQUENCE)
    private int CDR_CURR;
    @Column(name = "ID")
    private String ID;
    @Column(name = "RANK")
    private int RANK;
    @Column(name = "NUMR_CCY_CODE")
    private int NUMR_CCY_CODE;
    @Column(name = "INTR_DAY_BASS")
    private String INTR_DAY_BASS;
    @Column(name = "CONT_CODE")
    private String CONT_CODE;
    @Column(name = "REVL_RATE")
    private String REVL_RATE;
    @Column(name = "UNTE")
    private String UNTE;
    @Column(name = "\"DESC\"")
    private String DESC;
    @Id
    @Column(name = "DATDEBVLD")
    @GeneratedValue(generator = "E_CURRENCY_seq", strategy = GenerationType.SEQUENCE)
    private int DATDEBVLD;
    @Column(name = "DERSIT")
    private int DERSIT;
    @Column(name = "DATCHG")
    private int DATCHG;
    @Column(name = "DATFINVLD")
    private int DATFINVLD;

}
