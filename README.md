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
@Table(name = "ONS_ATTACHEMENTRECLAMATION", schema = "RSQ")
public class ONS_AttachementReclamation implements Serializable {


    @Id
    @GeneratedValue(generator = "ONS_AttachementReclamation_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(schema = "RSQ", name = "ONS_AttachementReclamation_seq", allocationSize = 1, sequenceName = "ONS_ATTACHEMENTRECLAMATION_SEQ")
    @Column(name = "ID")
    private Long id;

    private String name;
    private String size;
    private String type;
    private String path;

    private String NC;
    private String SF;

    private String dateValeur;
    private String libelleOperation;
    private String Ref;
    private String dateOperation;
    private String montant;

}




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
@Table(name="ONS_MENU", schema = "RSQ")
public class ONS_Menu implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "ONS_Menu_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(schema = "RSQ", name = "ONS_Menu_seq", allocationSize = 1, sequenceName = "ONS_MENU_SEQ")
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

