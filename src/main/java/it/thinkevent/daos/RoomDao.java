package it.thinkevent.daos;

import it.thinkevent.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomDao extends JpaRepository<Room,String>  {

}
