package it.thinkevent.services;

import it.thinkevent.entities.Room;

import java.util.List;

public interface RoomService {

    List<Room> getAll();
    Room create(Room user);
    Room update(Room user);
    void delete(Room user);
}
