package com.github.wikicode96.booking.dto;

import com.github.wikicode96.booking.entity.CustomerEntity;
import com.github.wikicode96.booking.entity.FlightEntity;
import lombok.Data;

import java.sql.Date;

@Data
public class BookingDTO {
    private int id;
    private CustomerEntity costumer;
    private FlightEntity flight;
    private Date date;
}
