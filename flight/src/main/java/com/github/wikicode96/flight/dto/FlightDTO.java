package com.github.wikicode96.flight.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class FlightDTO {
    private String airline;
    private String origin;
    private String destination;
    private Date depart;
}
