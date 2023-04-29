package tn.biat.biat.entities.otherDB;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "\"Chat\"", schema = "public")
public class Chat implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long chat_id;

    private String name;
    @OneToMany
    private List<User> users;
    @OneToMany
    private List<Message> messages;
}
