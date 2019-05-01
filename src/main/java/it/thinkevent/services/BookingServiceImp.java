package it.thinkevent.services;

import it.thinkevent.daos.BookingDao;
import it.thinkevent.entities.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImp implements BookingService {

    @Autowired
    BookingDao bookingDao;

    @Override
    public Collection<Booking> findByStartBetweenEnd(String start, String end) {
        return bookingDao.findByStartBetweenEnd(start,end);
    }

    @Override
    public Collection<Booking> verifyBusyRoom(String start, String end) {
        return null;
    }

    @Override
    public List<Booking> getAll() {
        return bookingDao.findAll();
    }

    @Override
    public String create(Booking booking) {

        Optional<Booking> verifyBusyRoom1 = bookingDao.verifyBusyRoom(booking.getStart(),booking.getEnd());

            if(verifyBusyRoom1.isPresent()){
                //esiste
                System.out.println("La prenotazione non può avvenire");
                return "Room is busy in this date";
            }else{
                //bookingDao.save(booking);
                System.out.println("Prenotazione creata con successo");
                return "successful booking";
            }
    }

    @Override
    public void update(Booking booking) {
        try {
            Optional<Booking> book = bookingDao.verifyBusyRoom(booking.getStart(),booking.getEnd());
            if(book.isPresent()){
                //esiste
                System.out.println("La prenotazione non può avvenire");

            }else{
                //bookingDao.save(booking);
                System.out.println("La prenotazione può avvenire");
            }
        }catch (Exception e){

        }
    }

    @Override
    public void delete(Booking service) {
        bookingDao.delete(service);
    }
}
