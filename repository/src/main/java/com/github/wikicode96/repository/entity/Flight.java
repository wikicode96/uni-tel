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

    @Column(name = "from")
    private String from;

    @Column(name = "destination")
    private String destination;

    @Column(name = "depart")
    private Date depart;

    public Flight() {
    }

    public Flight(int id, int idAirline, String from, String destination, Date depart) {
        this.id = id;
        this.idAirline = idAirline;
        this.from = from;
        this.destination = destination;
        this.depart = depart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return id == flight.id && idAirline == flight.idAirline && Objects.equals(from, flight.from) && Objects.equals(destination, flight.destination) && Objects.equals(depart, flight.depart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idAirline, from, destination, depart);
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

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
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
