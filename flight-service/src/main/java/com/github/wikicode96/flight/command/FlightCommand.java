package com.github.wikicode96.flight.command;

import lombok.Data;

import java.sql.Date;

@Data
public class FlightCommand {
    private int id;
    private String airline;
    private String origin;
    private String destination;
    private Date depart;
}
