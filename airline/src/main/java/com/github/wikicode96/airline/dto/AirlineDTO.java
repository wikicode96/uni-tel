package com.github.wikicode96.airline.dto;

public class AirlineDTO {

    private String name;
    private String imgLogo;

    public AirlineDTO() {
    }

    public AirlineDTO(String name, String imgLogo) {
        this.name = name;
        this.imgLogo = imgLogo;
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
