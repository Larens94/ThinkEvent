package it.thinkevent.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Table(name="user")
public class User {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="USERNAME",unique = true)
    private String username;



    @Column(name="NAME")
    private String name;


    @Column(name="EMAIL",unique = true)
    private String email;

    @Column(name="PASSWORD")
    private String password;


    @Column(name="PERMISSION")
    private String permission;

}
