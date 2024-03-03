package com.github.wikicode96.booking.repository;

import com.github.wikicode96.booking.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntity, Integer> {

    // Custom method to get bookings by user id
    @Query("SELECT b FROM BookingEntity b WHERE b.costumer.id = :idUser")
    List<BookingEntity> findByUserId(int idUser);
}
