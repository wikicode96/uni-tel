package com.github.wikicode96.booking.command;

import com.github.wikicode96.booking.entity.CustomerEntity;
import com.github.wikicode96.booking.entity.FlightEntity;
import lombok.Data;

import java.sql.Date;

@Data
public class BookingCommand {
    private int id;
    private CustomerEntity costumer;
    private FlightEntity flight;
    private Date date;
}
