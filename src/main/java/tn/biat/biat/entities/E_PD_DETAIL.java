package tn.biat.biat.entities;
import lombok.*;
import tn.biat.biat.entities.pk.E_CUSTOMER_pk;
import tn.biat.biat.entities.pk.E_PD_DETAIL_pk;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@IdClass(E_PD_DETAIL_pk.class)
@Entity
@Table(name = "\"E_PD_DETAIL\"", schema = "public")
@SequenceGenerator(schema = "public", name = "E_PD_DETAIL_seq", allocationSize = 1, sequenceName = "E_PD_DETAIL_seq")
public class E_PD_DETAIL implements Serializable {

    @Column(name = "CDRCONTMUTL")
    private int CDRCONTMUTL;
    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "E_PD_DETAIL_seq", strategy = GenerationType.SEQUENCE)
    private String ID;
    @Column(name = "DAT_ECHN")
    private String DAT_ECHN;
    @Column(name = "REF_CONT")
    private String REF_CONT;
    @Column(name = "ANCN")
    private String ANCN;
    @Column(name = "MONT_PRNC_INTL")
    private String MONT_PRNC_INTL;
    @Column(name = "MONT_PRNC_INTL_RED")
    private String MONT_PRNC_INTL_RED;
    @Column(name = "MONT_PRNC_INTL_TND")
    private String MONT_PRNC_INTL_TND;
    @Column(name = "MONT_PRNC_ACTL")
    private String MONT_PRNC_ACTL;
    @Column(name = "MONT_PRNC_ACTL_RED")
    private String MONT_PRNC_ACTL_RED;
    @Column(name = "MONT_PRNC_ACTL_TND")
    private String MONT_PRNC_ACTL_TND;
    @Column(name = "MONT_INTR_INTL")
    private String MONT_INTR_INTL;
    @Column(name = "MONT_INTR_INTL_RED")
    private String MONT_INTR_INTL_RED;
    @Column(name = "MONT_INTR_INTL_TND")
    private String MONT_INTR_INTL_TND;
    @Column(name = "MONT_INTR_ACTL")
    private String MONT_INTR_ACTL;
    @Column(name = "MONT_INTR_ACTL_RED")
    private String MONT_INTR_ACTL_RED;
    @Column(name = "MONT_INTR_ACTL_TND")
    private String MONT_INTR_ACTL_TND;
    @Column(name = "MONT_INTR_RETR_1_INTL")
    private String MONT_INTR_RETR_1_INTL;
    @Column(name = "MONT_INTR_RETR_1_INTL_RED")
    private String MONT_INTR_RETR_1_INTL_RED;
    @Column(name = "MONT_INTR_RETR_1_INTL_TND")
    private String MONT_INTR_RETR_1_INTL_TND;
    @Column(name = "MONT_INTR_RETR_1_ACTL")
    private String MONT_INTR_RETR_1_ACTL;
    @Column(name = "MONT_INTR_RETR_1_ACTL_RED")
    private String MONT_INTR_RETR_1_ACTL_RED;
    @Column(name = "MONT_INTR_RETR_1_ACTL_TND")
    private String MONT_INTR_RETR_1_ACTL_TND;
    @Column(name = "MONT_INTR_RETR_2_INTL")
    private String MONT_INTR_RETR_2_INTL;
    @Column(name = "MONT_INTR_RETR_2_INTL_RED")
    private String MONT_INTR_RETR_2_INTL_RED;
    @Column(name = "MONT_INTR_RETR_2_INTL_TND")
    private String MONT_INTR_RETR_2_INTL_TND;
    @Column(name = "MONT_INTR_RETR_2_ACTL")
    private String MONT_INTR_RETR_2_ACTL;
    @Column(name = "MONT_INTR_RETR_2_ACTL_RED")
    private String MONT_INTR_RETR_2_ACTL_RED;
    @Column(name = "MONT_INTR_RETR_2_ACTL_TND")
    private String MONT_INTR_RETR_2_ACTL_TND;
    @Column(name = "MONT_WS_INTL")
    private String MONT_WS_INTL;
    @Column(name = "MONT_WS_INTL_RED")
    private String MONT_WS_INTL_RED;
    @Column(name = "MONT_WS_INTL_TND")
    private String MONT_WS_INTL_TND;
    @Column(name = "MONT_WS_ACTL")
    private String MONT_WS_ACTL;
    @Column(name = "MONT_WS_ACTL_RED")
    private String MONT_WS_ACTL_RED;
    @Column(name = "MONT_WS_ACTL_TND")
    private String MONT_WS_ACTL_TND;
    @Column(name = "MONT_WE_INTL")
    private String MONT_WE_INTL;
    @Column(name = "MONT_WE_INTL_RED")
    private String MONT_WE_INTL_RED;
    @Column(name = "MONT_WE_INTL_TND")
    private String MONT_WE_INTL_TND;
    @Column(name = "MONT_WE_ACTL")
    private String MONT_WE_ACTL;
    @Column(name = "MONT_WE_ACTL_RED")
    private String MONT_WE_ACTL_RED;
    @Column(name = "MONT_WE_ACTL_TND")
    private String MONT_WE_ACTL_TND;
    @Id
    @Column(name = "DAT_SIT")
    @GeneratedValue(generator = "E_PD_DETAIL_seq", strategy = GenerationType.SEQUENCE)
    private int DAT_SIT;
    @Column(name = "DERSIT")
    private int DERSIT;
    @Id
    @Column(name = "DATCHG")
    @GeneratedValue(generator = "E_PD_DETAIL_seq", strategy = GenerationType.SEQUENCE)
    private String DATCHG;

}
