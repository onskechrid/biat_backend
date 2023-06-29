package tn.biat.biat.entities.otherDB;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "\"risk_classe\"", schema = "public")
public class risk_classe implements Serializable {

    @Id
    @Column(name = "s")
    private String s;
    private String identif;

    private String periode;
    private String cpte;
    private String clasimp;
    private String clasgel;
    private String classub;
    private String mtf_sub;
    private String clascon;
    private String mtf_con;
    private String clasmaxident;
    private String agios;
    private String mvt;
    private String impprinc;
    private String impinter;
    private String ech_anc;
    private String soldcpte;
    private String cloture;
    private String datcloture;
}
