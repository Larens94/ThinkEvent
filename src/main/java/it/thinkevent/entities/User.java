package it.thinkevent.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name="user")
public class User {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private int id;

    @Column(name="NAME")
    @Getter @Setter
    private String name;


    @Column(name="EMAIL",unique = true)
    @Getter @Setter
    private String email;

    @Column(name="PASSWORD")
    @Getter @Setter
    private String password;


    @Column(name="PERMISSION")
    @Getter @Setter
    private String permission;

}
