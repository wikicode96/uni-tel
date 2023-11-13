package com.github.wikicode96.repository.repository;

import com.github.wikicode96.repository.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

    // Custom method to get bookings by user id
    @Query("SELECT b FROM Booking b WHERE b.idUser = :idUser")
    List<Booking> findByUserId(int idUser);
}
