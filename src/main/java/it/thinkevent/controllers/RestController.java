package it.thinkevent.controllers;

import io.jsonwebtoken.ExpiredJwtException;
import it.thinkevent.entities.Booking;
import it.thinkevent.entities.Room;
import it.thinkevent.entities.User;
import it.thinkevent.services.BookingServiceImp;
import it.thinkevent.services.LoginService;
import it.thinkevent.services.RoomServiceImp;
import it.thinkevent.services.UserServiceImp;
import it.thinkevent.utilis.UserNotLoggedException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.RequestPath;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {


    @Autowired
    UserServiceImp userServiceImp;

    @Autowired
    BookingServiceImp bookingServiceImp;

    @Autowired
    RoomServiceImp roomServiceImp;


    @Autowired
    LoginService loginService;



    @AllArgsConstructor
    public class JsonResponseBody{
        @Getter
        @Setter
        private int server;
        @Getter @Setter
        private Object response;
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResponseEntity<JsonResponseBody> loginUser(@RequestParam(value = "email") String email, @RequestParam(value = "password") String pwd){
        try {
            Optional<User> userr = loginService.getUserFromDbAndVerifyPassword(email, pwd);
            if(userr.isPresent()){
                //prendiamo l'istanza dell'utente
                User user = userr.get();
                //creiamo il JWT
                String jwt = loginService.createJwt(Integer.toString(user.getId()),user.getEmail(),user.getPermission(),new Date());
                //impostiamo nell'header il jwt e nel body ritorniamo il jsonresponsebody con la risposta e il messaggio (jackson library li converte in json
                return ResponseEntity.status(HttpStatus.OK).header("jwt",jwt).body(new JsonResponseBody(HttpStatus.OK.value(),"Autenticazione andata con successo"));
            }
        } catch (UserNotLoggedException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JsonResponseBody(HttpStatus.FORBIDDEN.value(),"Autenticazione fallita:"+e.getLocalizedMessage()));
        } catch (UnsupportedEncodingException e2) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JsonResponseBody(HttpStatus.FORBIDDEN.value(),"Token error:"+e2.getLocalizedMessage()));
        }


        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JsonResponseBody(HttpStatus.FORBIDDEN.value(),"Non c'è corrispondenza nel database con l'utente inserito"));
    }


    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public ResponseEntity<JsonResponseBody> getAllUser(HttpServletRequest request){
        try {
            loginService.verifyJwtAndGetData(request);
            //user verificato
            //restituiamo l'oggetto operationservice che filtra in base ad account risposta json per il front-end
            return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(),userServiceImp.getAll()));
        }catch (UnsupportedEncodingException e1){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JsonResponseBody(HttpStatus.FORBIDDEN.value(),"Unsupported Encoding"+e1.toString()));
        }catch (UserNotLoggedException e2){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JsonResponseBody(HttpStatus.FORBIDDEN.value(),"Utente non loggato correttamente:"+e2.toString()));
        }catch (ExpiredJwtException e3){
            return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).body(new JsonResponseBody(HttpStatus.GATEWAY_TIMEOUT.value(),"La sessione è scaduta:"+e3.toString()));
        }

    }

    @RequestMapping(value = "/users",method = RequestMethod.POST)
    public Object saveUser(@Valid User user){
        return userServiceImp.create(user);
    }


    @RequestMapping(value = "/users",method = RequestMethod.PUT)
    public Object updateUser(@Valid User user){
        return userServiceImp.update(user);
    }

    @RequestMapping(value = "/users",method = RequestMethod.DELETE)
    public void deleteUser(User user){
        try {
            userServiceImp.delete(user);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    @RequestMapping(value = "/rooms",method = RequestMethod.GET)
    public Collection<Room> getAllPost(){
        return roomServiceImp.getAll();
    }

    @RequestMapping(value = "/rooms",method = RequestMethod.POST)
    public Object savePost(@Valid Room post){
        return roomServiceImp.create(post);
    }


    @RequestMapping(value = "/rooms",method = RequestMethod.PUT)
    public Object updatePost(@Valid Room post){
        return roomServiceImp.update(post);
    }

    @RequestMapping(value = "/rooms",method = RequestMethod.DELETE)
    public void deletePost(Room post){
        try {
            roomServiceImp.delete(post);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    @RequestMapping(value = "/bookings",method = RequestMethod.GET)
    public Collection<Booking> getAllbooking(){
        return bookingServiceImp.getAll();
    }

    @RequestMapping(value = "/bookings/{start}/{end}",method = RequestMethod.GET)
    public Collection<Booking> getAllbookingByStartBeetweenEnd(@PathVariable(name="start") String start,@PathVariable(name = "end") String end){
        return bookingServiceImp.findByStartBetweenEnd(start,end);
    }

    @RequestMapping(value = "/bookings",method = RequestMethod.POST)
    public Object saveBooking(@Valid Booking booking){
        return bookingServiceImp.create(booking);
    }

    @RequestMapping(value = "/bookings",method = RequestMethod.PUT)
    public Object updateBooking(@Valid Booking booking){
        return bookingServiceImp.update(booking);
    }

    @RequestMapping(value = "/bookings",method = RequestMethod.DELETE)
    public void deleteBooking(Booking booking){
        try {
            bookingServiceImp.delete(booking);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
