package it.thinkevent.daos;

import it.thinkevent.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDao extends JpaRepository<User,String>  {

    User findByUsername(String username);

}
