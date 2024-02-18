package com.github.wikicode96.booking.service;

import com.github.wikicode96.booking.entity.BookingEntity;
import com.github.wikicode96.booking.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    private BookingRepository repository;

    @Override
    public BookingEntity newBooking(BookingEntity booking) {

        if(booking.getId() == 0){
            try{
                repository.save(booking);
                return booking;
            }catch (Exception e){
                return null;
            }
        }
        return null;
    }

    @Override
    public BookingEntity getBookingById(int id) {
        if(id > 0) return repository.findById(id).orElse(null);
        else return null;
    }

    @Override
    public List<BookingEntity> getAllBookings() {
        return repository.findAll();
    }

    @Override
    public List<BookingEntity> getAllBookingsByUserId(Long idUser) {
        return repository.findByUserId(idUser);
    }

    @Override
    public BookingEntity updateBooking(BookingEntity booking) {

        if(booking.getId() > 0) {
            try{
                repository.save(booking);
                return booking;
            }catch (Exception e){
                return null;
            }
        }
        return null;
    }

    @Override
    public BookingEntity deleteBooking(BookingEntity booking) {

        if(booking.getId() > 0) {
            try{
                repository.delete(booking);
                return booking;
            }catch (Exception e){
                return null;
            }
        }
        return null;
    }
}
