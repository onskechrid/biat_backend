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
@Table(name="RC_URL",schema = "RSQ")
public class RC_Url implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "RC_Url_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(schema = "RSQ", name = "RC_Url_seq", allocationSize = 1, sequenceName = "RC_Url_SEQ")
    private Long id;

    private String url;
    private String component;
}
