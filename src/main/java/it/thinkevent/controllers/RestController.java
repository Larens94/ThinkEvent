package it.thinkevent.controllers;

import it.thinkevent.entities.Booking;
import it.thinkevent.entities.Room;
import it.thinkevent.entities.User;
import it.thinkevent.services.BookingServiceImp;
import it.thinkevent.services.RoomServiceImp;
import it.thinkevent.services.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
public class RestController {

    @Autowired
    UserServiceImp userServiceImp;

    @Autowired
    BookingServiceImp bookingServiceImp;

    @Autowired
    RoomServiceImp roomServiceImp;


   /* @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(HttpServletRequest request){
        //restituiamo l'oggetto operationservice che filtra in base ad account risposta json per il front-end
        return "login";
    }

    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String home(HttpServletRequest request){
        //restituiamo l'oggetto operationservice che filtra in base ad account risposta json per il front-end
        return "home";
    }*/


    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String home(HttpServletRequest request){
        //restituiamo l'oggetto operationservice che filtra in base ad account risposta json per il front-end
        return "home.jsp";
    }

    @RequestMapping("/login")
    public String loginPage()
    {
        return "login.jsp";
    }

    @RequestMapping("/logout-success")
    public String logoutPage()
    {
        return "logout.jsp";
    }

   /* @RequestMapping(value = "/users",method = RequestMethod.GET)
    public List<User> getAllUser(HttpServletRequest request){
            //restituiamo l'oggetto operationservice che filtra in base ad account risposta json per il front-end
         return userServiceImp.getAll();
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
    public List<Room> getAllRoom(HttpServletRequest request){
            //restituiamo l'oggetto operationservice che filtra in base ad account risposta json per il front-end
            return roomServiceImp.getAll();
    }

    @RequestMapping(value = "/rooms",method = RequestMethod.POST)
    public Room savePost(@Valid Room post,HttpServletRequest request){
       return roomServiceImp.create(post);
    }


    @RequestMapping(value = "/rooms",method = RequestMethod.PUT)
    public Room updatePost(@Valid Room room,HttpServletRequest request){
            return roomServiceImp.update(room);

    }

    @RequestMapping(value = "/rooms",method = RequestMethod.DELETE)
    public void deletePost(Room room,HttpServletRequest request){
            roomServiceImp.delete(room);
    }


    @RequestMapping(value = "/bookings",method = RequestMethod.GET)
    public List<Booking> getAllbooking(HttpServletRequest request){
            //restituiamo l'oggetto operationservice che filtra in base ad account risposta json per il front-end
            return bookingServiceImp.getAll();

    }

    @RequestMapping(value = "/bookings/{start}/{end}",method = RequestMethod.GET)
    public List<Booking> getAllbookingByStartBeetweenEnd(@PathVariable(name="start") String start,@PathVariable(name = "end") String end,HttpServletRequest request){
            return bookingServiceImp.findByStartBetweenEnd(start,end);

      }

    @RequestMapping(value = "/bookings",method = RequestMethod.POST)
    public String saveBooking(@Valid Booking booking,HttpServletRequest request){
            return bookingServiceImp.create(booking);
    }

    @RequestMapping(value = "/bookings",method = RequestMethod.PUT)
    public String updateBooking(@Valid Booking booking,HttpServletRequest request){
           return bookingServiceImp.update(booking);
    }

    @RequestMapping(value = "/bookings",method = RequestMethod.DELETE)
    public void deleteBooking(Booking booking,HttpServletRequest request){
            bookingServiceImp.delete(booking);
    }
    */

}
