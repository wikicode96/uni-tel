package com.github.wikicode96.booking.service;

import com.github.wikicode96.booking.command.BookingCommand;
import com.github.wikicode96.booking.dto.BookingDTO;
import com.github.wikicode96.booking.entity.BookingEntity;
import com.github.wikicode96.booking.repository.BookingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BookingRepository repository;

    @Override
    public void createBooking(BookingCommand booking) {
        BookingEntity entity = modelMapper.map(booking, BookingEntity.class);
        repository.save(entity);
    }

    @Override
    public BookingDTO getBookingById(int id) {
        BookingEntity entity = repository.findById(id).orElseThrow();
        return modelMapper.map(entity, BookingDTO.class);
    }

    @Override
    public List<BookingDTO> getAllBookings() {
        List<BookingEntity> entities = repository.findAll();
        List<BookingDTO> dtos = new ArrayList<>();

        for(BookingEntity entity: entities) {
            dtos.add(modelMapper.map(entity, BookingDTO.class));
        }
        return dtos;
    }

    @Override
    public List<BookingDTO> getAllBookingsByUserId(int userId) {
        List<BookingEntity> entities = repository.findByUserId(userId);
        List<BookingDTO> dtos = new ArrayList<>();

        for(BookingEntity entity: entities) {
            dtos.add(modelMapper.map(entity, BookingDTO.class));
        }
        return dtos;
    }

    @Override
    public void updateBooking(BookingCommand booking) {

        if (booking.getId() > 0) {
            BookingEntity entity = modelMapper.map(booking, BookingEntity.class);
            repository.save(entity);
        } else {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Booking ID is invalid");
        }
    }

    @Override
    public void deleteBooking(BookingCommand booking) {
        BookingEntity entity = repository.findById(booking.getId()).orElseThrow();

        if (entity != null) {
            repository.delete(entity);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Booking not found with ID: " + booking.getId());
        }
    }
}
