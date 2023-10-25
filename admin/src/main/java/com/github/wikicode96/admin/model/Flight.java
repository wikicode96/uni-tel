package com.github.wikicode96.admin.model;

import java.sql.Date;
import java.util.Objects;

public class Flight {

    private int id;
    private int idAirline;
    private String origin;
    private String destination;
    private Date depart;
    private Airline airline;

    public Flight() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return id == flight.id && idAirline == flight.idAirline && Objects.equals(origin, flight.origin) && Objects.equals(destination, flight.destination) && Objects.equals(depart, flight.depart) && Objects.equals(airline, flight.airline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idAirline, origin, destination, depart, airline);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAirline() {
        return idAirline;
    }

    public void setIdAirline(int idAirline) {
        this.idAirline = idAirline;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDepart() {
        return depart;
    }

    public void setDepart(Date depart) {
        this.depart = depart;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }
}
