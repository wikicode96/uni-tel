package com.github.wikicode96.flight.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "flights")
public class FlightEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_airline", nullable = false)
    private AirlineEntity airline;

    @Column(name = "origin")
    private String origin;

    @Column(name = "destination")
    private String destination;

    @Column(name = "depart")
    private Date depart;

    public FlightEntity() {
    }

    public FlightEntity(Long id, AirlineEntity airline, String origin, String destination, Date depart) {
        this.id = id;
        this.airline = airline;
        this.origin = origin;
        this.destination = destination;
        this.depart = depart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightEntity flight = (FlightEntity) o;
        return id == flight.id && airline == flight.airline && Objects.equals(origin, flight.origin) && Objects.equals(destination, flight.destination) && Objects.equals(depart, flight.depart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, airline, origin, destination, depart);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AirlineEntity getAirline() {
        return airline;
    }

    public void setAirline(AirlineEntity idAirline) {
        this.airline = airline;
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
