package it.thinkevent.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor   //Lombok annotations
@Entity
@Table(name="booking")
public class Booking {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Integer id;

    @Column(name="TITLE")
    @Getter @Setter
    private String title;

    @Column(name="START")
    @Getter @Setter
    private String start;

    @Column(name="END")
    @Getter @Setter
    private String end;

    @Column(name="NOTES")
    @Getter @Setter
    private String notes;

    @Column(name="room_id")
    @Getter @Setter
    private String fkRoomId;

    @Column(name="user_id")
    @Getter @Setter
    private String fkUserId;

}
