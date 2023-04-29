package tn.biat.biat.entities.otherDB;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "\"tab2\"", schema = "public")
public class tab2 {
    private Date PERIODE;
    @Id
    private String CPTE;
    private String IDENTIF;
    private String CLASIMP;
    private String CLASGEL;
    private String CLASSUB;
    private String MTF_SUB;
    private String CLASCON;
    private String MTF_CON;
    private String CLASMAXIDENT;
    private Long AGIOS;
    private Long MVT;
    private Long IMPPRINC;
    private Long IMPINTER;
    private String ECH_ANC;
    private Long SOLDCPTE;
    private String CLOTURE;
    private String DATCLOTURE;

}
