package tn.biat.biat.entities.otherDB;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "\"Permissions\"", schema = "public")
public class Permissions implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Menu menu;
}


//tejbed el menuet el kol eli fl base
//2 tched tprcourihom el menuet bl wa7da bl wa7da
//3 idha ken thama menu option mawjouda fi permission ml permissionet mta3 el profile eli theb tafichih donc tdhaherha m cochia
