package com.github.wikicode96.booking.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "bookings")
public class BookingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_costumers", nullable = false)
    private CostumerEntity costumer;

    @ManyToOne
    @JoinColumn(name = "id_flight", nullable = false)
    private FlightEntity flight;

    @Column(name = "date", nullable = false)
    private Date date;

    public BookingEntity() {
    }

    public BookingEntity(Long id, CostumerEntity costumer, FlightEntity flight, Date date) {
        this.id = id;
        this.costumer = costumer;
        this.flight = flight;
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingEntity booking = (BookingEntity) o;
        return id == booking.id && costumer == booking.costumer && flight == booking.flight && Objects.equals(date, booking.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, costumer, flight, date);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CostumerEntity getCostumer() {
        return costumer;
    }

    public void setCostumer(CostumerEntity costumer) {
        this.costumer = costumer;
    }

    public FlightEntity getFlight() {
        return flight;
    }

    public void setFlight(FlightEntity flight) {
        this.flight = flight;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
