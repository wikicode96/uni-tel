package com.github.wikicode96.admin.model;

import java.sql.Date;
import java.util.Objects;

public class Booking {

    private int id;
    private int idUser;
    private int idFlight;
    private Date date;

    public Booking() {
    }

    public Booking(int id, int idUser, int idFlight, Date date) {
        this.id = id;
        this.idUser = idUser;
        this.idFlight = idFlight;
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return id == booking.id && idUser == booking.idUser && idFlight == booking.idFlight && Objects.equals(date, booking.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idUser, idFlight, date);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdFlight() {
        return idFlight;
    }

    public void setIdFlight(int idFlight) {
        this.idFlight = idFlight;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
