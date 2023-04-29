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
@Table(name = "\"Client\"", schema = "public")
public class Client implements Serializable{

    @Id
    @Column(name = "account")
    private String account;

    private String username;
    private String profile;
    private String code;
}
