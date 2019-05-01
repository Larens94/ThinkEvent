package it.thinkevent.services;

import it.thinkevent.daos.UserDao;
import it.thinkevent.entities.User;
import it.thinkevent.utilis.Encryption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    UserDao userDao;

    @Autowired
    Encryption encryption;

    @Override
    public List<User> getAll() {
        return userDao.findAll();
    }

    @Override
    public User create(User user) {
        String psw = user.getPassword();
        user.setPassword(encryption.encrypt(psw));
      return userDao.save(user);
    }

    @Override
    public User update(User user) {
        String psw = user.getPassword();
        user.setPassword(passwordEncoder.encode(psw));
        return userDao.save(user);
    }

    public void delete(User user) {
         userDao.delete(user);
    }

}
