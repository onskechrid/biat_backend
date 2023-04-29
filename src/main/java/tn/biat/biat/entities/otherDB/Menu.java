
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
@Table(name = "\"Menu\"", schema = "public")
public class Menu implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String url;
    private String iconcomponent;
    private boolean checked;
    private Long idparent;
    private int level;
    private boolean active;

    @OneToMany
    private List<Composant> composants;
}
