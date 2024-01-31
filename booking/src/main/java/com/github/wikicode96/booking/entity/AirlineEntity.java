package com.github.wikicode96.booking.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "airlines")
public class AirlineEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "img_logo")
    private String imgLogo;

    public AirlineEntity() {
    }

    public AirlineEntity(Long id, String name, String imgLogo) {
        this.id = id;
        this.name = name;
        this.imgLogo = imgLogo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AirlineEntity entity = (AirlineEntity) o;
        return id == entity.id && Objects.equals(name, entity.name) && Objects.equals(imgLogo, entity.imgLogo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, imgLogo);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
