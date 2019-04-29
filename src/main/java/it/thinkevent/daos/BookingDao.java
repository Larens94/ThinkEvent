package it.thinkevent.daos;

import it.thinkevent.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface BookingDao extends JpaRepository<Booking,String>  {

    @Query("SELECT b FROM Booking b WHERE b.start BETWEEN :start AND :end")
    Collection<Booking>  findByStartBetweenEnd(@Param("start") String start, @Param("end") String end);

    @Query("SELECT b FROM Booking b WHERE b.start BETWEEN :start AND :end")
    Collection<Booking>verifyBusyRoom(@Param("start") String start, @Param("end") String end);
}
