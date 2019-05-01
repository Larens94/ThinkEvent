package it.thinkevent.services;

import it.thinkevent.entities.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User create(User user);
    User update(User user);
    void delete(User user);
}
