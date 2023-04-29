package tn.biat.biat.entities.otherDB;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "\"tab1\"", schema = "public")
public class tab1 {

    private Date PERIODE;
    @Id
    private String CPTE;
    private String IDENTIF;
    private String NOM;
    private Long RISK_BRUT;
    private Long GARDED;
    private Long RISK_NET;
    private String CLASSE;
    private String MOTIF;
    private Long PROV_REQ;
    private Long AGIOS_RES;
    private Long PRO_CONS;
    private Long ECART_PROV;
    private String CODRISK;
    private Long POD;
    private Long HYPO;
    private Long DEPOTS;
    private Long ACTFIN;
    private Long ASSUR;
    private Long GARETAT;
    private Long GARBQ;
    private Long FNG;
    private Long AVALBQ;
    private Long COTUNACE;
    private Long ENGSIGA;
    private Long ENGSIGB;
    private Long AGIOS_ECH_INT;
    private Long AGIOS_EFF_IMP;
    private Long AGIOS_EFF_IMP_DEB;
    private Long SOLDE_AGIOS_DEB_TRI;
    private Long AGIOS_X;
    private Long GAR_EVEN;
    private String IDBCT;
    private String TYPEIDBCT;
    private Long PROV_ADIT;
    private Long ACT_BIAT;
    private Long DONT_CESUR;

}
