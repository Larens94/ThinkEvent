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
    public List<Booking> getAll() {
        return bookingDao.findAll();
    }

    @Override
    public Booking create(Booking service) {

        Boolean verifyExist = false;

        return bookingDao.save(service);
    }

    @Override
    public Booking update(Booking service) {
        return bookingDao.save(service);
    }

    @Override
    public void delete(Booking service) {
        bookingDao.delete(service);
    }
}
