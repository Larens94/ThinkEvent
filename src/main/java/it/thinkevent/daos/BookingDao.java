package it.thinkevent.daos;

import it.thinkevent.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface BookingDao extends JpaRepository<Booking,String>  {

    @Query("SELECT b FROM Booking b WHERE b.start >= :start AND b.end <= :end")
    List<Booking> findByStartBetweenEnd(@Param("start") String start, @Param("end") String end);

    @Query("SELECT b FROM Booking b WHERE b.start >= :start AND b.start < :end OR b.end >= :start AND b.end < :end")
    Optional<Booking> verifyBusyRoom(@Param("start") String start, @Param("end") String end);




}
