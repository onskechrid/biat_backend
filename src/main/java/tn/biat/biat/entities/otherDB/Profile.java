package tn.biat.biat.entities.otherDB;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "\"Profile\"", schema = "public")
public class Profile implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String profileType;

    @OneToMany
    private List<Permissions> permissions;
}

