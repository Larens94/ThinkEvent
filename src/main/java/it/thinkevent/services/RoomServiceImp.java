package it.thinkevent.services;

import it.thinkevent.daos.RoomDao;
import it.thinkevent.entities.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImp implements RoomService {

    @Autowired
    RoomDao roomDao;

    @Override
    public List<Room> getAll() {
        return roomDao.findAll();
    }

    @Override
    public Room create(Room service) {
        return roomDao.save(service);
    }

    @Override
    public Room update(Room service) {
        return roomDao.save(service);
    }

    @Override
    public void delete(Room service) {
        roomDao.delete(service);
    }
}
