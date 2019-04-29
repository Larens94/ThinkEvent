package it.thinkevent.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name="room")
public class Room {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private int id;

    @Column(name="NAME")
    @Getter @Setter
    private String name;

    @Column(name="COLOR",unique = true)
    @Getter @Setter
    private String color;



}
