package tn.biat.biat.entities.otherDB;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "\"dwm_pd_payment_due_details\"", schema = "public")
public class dwm_pd_payment_due_details {

    @Id
    @Column(name = "s")
    private String s;

    private String id;
    private String periode;
    private String currency;
    private String customer;
    private String cpte_24;
    private String cpte;
    private String type_eng;
    private String lib_type_eng;
    private String reference;
    private String date_ech;
    private String imp_int;
    private String imp_int_os;
    private String imp_pr;
    private String imp_pr_os;
    private String imp_int_retard;
    private String imp_int_retard_os;
    private String imp_int_penalit;
    private String imp_int_penalit_os;

}
