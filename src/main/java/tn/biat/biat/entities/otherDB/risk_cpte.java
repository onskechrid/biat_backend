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
@Table(name = "\"risk_cpte\"", schema = "public")
public class risk_cpte implements Serializable {

    @Id
    @Column(name = "s")
    private String s;
    private String cpte;

    private String periode;
    private String risk_brut;
    private String graded;
    private String risk_net;
    private String classe;
    private String motif;
}
