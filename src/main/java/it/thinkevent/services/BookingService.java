package it.thinkevent.services;

import it.thinkevent.entities.Booking;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.*;

public interface BookingService {

    Collection<Booking>  findByStartBetweenEnd(String start,String end);

    Collection<Booking>  verifyBusyRoom(String start,String end);
    List<Booking> getAll();
    Booking create(Booking user);
    Booking update(Booking user);
    void delete(Booking user);

}
