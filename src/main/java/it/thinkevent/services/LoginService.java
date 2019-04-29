package it.thinkevent.services;

import it.thinkevent.entities.User;
import it.thinkevent.utilis.UserNotLoggedException;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

public interface LoginService  {

    Optional<User> getUserFromDbAndVerifyPassword(String email, String password)throws UserNotLoggedException;

    String createJwt(String subject, String name, String permission, Date date)throws UnsupportedEncodingException;

    Map<String,Object> verifyJwtAndGetData(HttpServletRequest request)throws UserNotLoggedException,UnsupportedEncodingException;
}
