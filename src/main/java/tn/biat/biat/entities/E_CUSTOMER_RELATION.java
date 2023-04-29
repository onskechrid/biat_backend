package tn.biat.biat.entities;

import lombok.*;
import tn.biat.biat.entities.pk.E_CUSTOMER_RELATION_pk;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@IdClass(E_CUSTOMER_RELATION_pk.class)
@Entity
@Table(name = "\"E_CUSTOMER_RELATION\"", schema = "public")
@SequenceGenerator(schema = "public", name = "E_CUSTOMER_RELATION_seq", allocationSize = 1, sequenceName = "E_CUSTOMER_RELATION_seq")
public class E_CUSTOMER_RELATION implements Serializable {

    @Column(name = "CDRCUST")
    private int CDRCUST;
    @Column(name = "CDRRELTCUST")
    private int CDRRELTCUST;
    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "E_CUSTOMER_RELATION_seq", strategy = GenerationType.SEQUENCE)
    private String ID;
    @Id
    @Column(name = "RELT_CUST")
    @GeneratedValue(generator = "E_CUSTOMER_RELATION_seq", strategy = GenerationType.SEQUENCE)
    private String RELT_CUST;
    @Id
    @Column(name = "RELT_CODE")
    @GeneratedValue(generator = "E_CUSTOMER_RELATION_seq", strategy = GenerationType.SEQUENCE)
    private int RELT_CODE;
    @Column(name = "REVR_REL_CODE")
    private String REVR_REL_CODE;
    @Column(name = "CDRRELT")
    private int CDRRELT;
    @Id
    @Column(name = "DATDEBVLD")
    @GeneratedValue(generator = "E_CUSTOMER_RELATION_seq", strategy = GenerationType.SEQUENCE)
    private int DATDEBVLD;
    @Column(name = "DATFINVLD")
    private int DATFINVLD;
    @Column(name = "DERSIT")
    private int DERSIT;
    @Column(name = "DATCHG")
    private int DATCHG;
}
