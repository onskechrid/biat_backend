package tn.biat.biat.entities.otherDB;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="ONS_ATTACHEMENT" ,schema = "RSQ")
public class ONS_Attachement implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "customer_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(schema = "RSQ", name = "customer_seq", allocationSize = 1, sequenceName = "customer_seq")
    private Long ID;

    private String NAME;
    private String SIZE;
    private String TYPE;
    private String PATH;

}
