package it.thinkevent.services;

import it.thinkevent.daos.UserDao;
import it.thinkevent.entities.User;
import it.thinkevent.utilis.Encryption;
import it.thinkevent.utilis.JwtUtils;
import it.thinkevent.utilis.UserNotLoggedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

@Service
public class LoginServiceImp implements  LoginService {

    private static final Logger log = LoggerFactory.getLogger(LoginServiceImp.class);

    @Autowired
    UserDao userDao;

    @Autowired
    Encryption encryption;

    @Override
    public Optional<User> getUserFromDbAndVerifyPassword(String email, String password) throws UserNotLoggedException{
        Optional<User> userr = userDao.findByEmail(email);
        if(userr.isPresent()){
            User user = userr.get();
            if(encryption.decrypt(user.getPassword()).equals(password)){
                log.info("Email e Password verificata");
            }else{
                log.info("Email verificato, la password no.");
                throw  new UserNotLoggedException("Email o password errata.");
            }
        }
        return userr;
    }


    @Override
    public String createJwt(String subject, String name, String permission, Date datenow)throws UnsupportedEncodingException {
        Date expDate = datenow;

        expDate.setTime(datenow.getTime() + (30000*10000));
        log.info("JWT creazione. Scadenza tempo: "+expDate.getTime());
        String token = JwtUtils.generateJwt(subject,expDate,name,permission);
        return token;
    }


    @Override
    public Map<String, Object> verifyJwtAndGetData(HttpServletRequest request) throws UserNotLoggedException, UnsupportedEncodingException{
        String jwt = JwtUtils.getJwtFromHttpRequest(request);
        if(jwt == null){
            throw new UserNotLoggedException("Autenticazione il token non è stato trovato nella richiesta");
        }
        Map<String,Object> userData = JwtUtils.jwt2Map(jwt);
        return userData;
    }
}
