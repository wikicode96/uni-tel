package com.github.wikicode96.booking.service;

import com.github.wikicode96.booking.command.BookingCommand;
import com.github.wikicode96.booking.dto.BookingDTO;
import com.github.wikicode96.booking.repository.BookingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BookingRepository repository;
    
    @Override
    public void createBooking(BookingCommand booking) {

    }

    @Override
    public BookingDTO getBookingById(int id) {
        return null;
    }

    @Override
    public List<BookingDTO> getAllBookings() {
        return null;
    }

    @Override
    public List<BookingDTO> getAllBookingsByUserId(int userId) {
        return null;
    }

    @Override
    public BookingDTO updateBooking(BookingCommand booking) {
        return null;
    }

    @Override
    public BookingDTO deleteBooking(BookingCommand booking) {
        return null;
    }
}
