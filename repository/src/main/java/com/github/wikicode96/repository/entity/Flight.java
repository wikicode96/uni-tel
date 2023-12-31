package com.github.wikicode96.repository.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "flights")
public class Flight implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "id_airline")
    private int idAirline;

    @Column(name = "origin")
    private String origin;

    @Column(name = "destination")
    private String destination;

    @Column(name = "depart")
    private Date depart;

    public Flight() {
    }

    public Flight(int id, int idAirline, String origin, String destination, Date depart) {
        this.id = id;
        this.idAirline = idAirline;
        this.origin = origin;
        this.destination = destination;
        this.depart = depart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return id == flight.id && idAirline == flight.idAirline && Objects.equals(origin, flight.origin) && Objects.equals(destination, flight.destination) && Objects.equals(depart, flight.depart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idAirline, origin, destination, depart);
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
}
