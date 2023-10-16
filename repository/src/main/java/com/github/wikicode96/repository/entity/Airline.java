package com.github.wikicode96.repository.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "airlines")
public class Airline implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "img_logo")
    private String imgLogo;

    public Airline() {
    }

    public Airline(int id, String name, String imgLogo) {
        this.id = id;
        this.name = name;
        this.imgLogo = imgLogo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airline airline = (Airline) o;
        return id == airline.id && Objects.equals(name, airline.name) && Objects.equals(imgLogo, airline.imgLogo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, imgLogo);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgLogo() {
        return imgLogo;
    }

    public void setImgLogo(String imgLogo) {
        this.imgLogo = imgLogo;
    }
}
