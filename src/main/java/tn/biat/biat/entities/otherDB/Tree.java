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
@Table(name = "\"Tree\"", schema = "public")
public class Tree implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String Pole;
    private String Region;
    private String Zone;
    private String Agence;
}
