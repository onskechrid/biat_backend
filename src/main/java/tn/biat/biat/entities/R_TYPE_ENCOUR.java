package tn.biat.biat.entities;
import lombok.*;
import tn.biat.biat.entities.pk.R_TYPE_ENCOUR_pk;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@IdClass(R_TYPE_ENCOUR_pk.class)
@Entity
@Table(name = "\"R_TYPE_ENCOUR\"", schema = "public")
@SequenceGenerator(schema = "public", name = "R_TYPE_ENCOUR_seq", allocationSize = 1, sequenceName = "R_TYPE_ENCOUR_seq")
public class R_TYPE_ENCOUR implements Serializable{

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "R_TYPE_ENCOUR_seq", strategy = GenerationType.SEQUENCE)
    private int ID;

    @Column(name = "CDR_TYP_ENCR")
    private int CDR_TYP_ENCR;

    @Column(name = "LIB_LONG")
    private int LIB_LONG;

    @Column(name = "LIB_CORT")
    private int LIB_CORT;

    @Id
    @Column(name = "DATDEBVLD")
    @GeneratedValue(generator = "R_TYPE_ENCOUR_seq", strategy = GenerationType.SEQUENCE)
    private int DATDEBVLD;

    @Column(name = "DATFINVLD")
    private int DATFINVLD;
    @Column(name = "DERSIT")
    private int DERSIT;
    @Column(name = "DATCHG")
    private int DATCHG;
}
