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
    @GeneratedValue(generator = "attachement_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(schema = "RSQ", name = "attachement_seq", allocationSize = 1, sequenceName = "ONS_ATTACHEMENT_SEQ")
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SIZE")
    private String size;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "PATH")
    private String path;

}
