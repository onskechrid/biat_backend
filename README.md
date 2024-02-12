Caused by: Error : 904, Position : 169, SQL = create table RSQ.ONS_Menu (ID number(19,0) not null, active number(1,0) not null, checked number(1,0) not null, iconcomponent varchar2(255 char), idparent number(19,0), level number(10,0) not null, name varchar2(255 char), url varchar2(255 char), primary key (ID)), Original SQL = create table RSQ.ONS_Menu (ID number(19,0) not null, active number(1,0) not null, checked number(1,0) not null, iconcomponent varchar2(255 char), idparent number(19,0), level number(10,0) not null, name varchar2(255 char), url varchar2(255 char), primary key (ID)), Error Message = ORA-00904:  : identificateur non valide

        at oracle.jdbc.driver.T4CTTIoer11.processError(T4CTTIoer11.java:710)
        ... 49 more



 
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
@Table(schema = "RSQ")
public class ONS_Menu implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
    private Long id;

    private String name;
    private String url;
    private String iconcomponent;
    private boolean checked;
    private Long idparent;
    private int level;
    private boolean active;

    //@OneToMany
    //private List<ONS_Composant> composants;
}
