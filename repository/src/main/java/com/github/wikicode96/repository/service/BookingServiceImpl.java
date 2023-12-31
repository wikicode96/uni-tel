package com.github.wikicode96.repository.service;

import com.github.wikicode96.repository.entity.Booking;
import com.github.wikicode96.repository.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    private BookingRepository repository;

    @Override
    public Booking newBooking(Booking booking) {

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
    public Booking getBookingById(int id) {
        if(id > 0) return repository.findById(id).orElse(null);
        else return null;
    }

    @Override
    public List<Booking> getAllBookings() {
        return repository.findAll();
    }

    @Override
    public List<Booking> getAllBookingsByUserId(int idUser) {
        return repository.findByUserId(idUser);
    }

    @Override
    public Booking updateBooking(Booking booking) {

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
    public Booking deleteBooking(Booking booking) {

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
