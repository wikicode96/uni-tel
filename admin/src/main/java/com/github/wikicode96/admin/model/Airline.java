package com.github.wikicode96.admin.model;

import java.util.Objects;

public class Airline {

    private int id;
    private String name;
    private String imgLogo;

    public Airline() {
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
