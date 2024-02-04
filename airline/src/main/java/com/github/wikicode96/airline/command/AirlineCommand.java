package com.github.wikicode96.airline.command;

public class AirlineCommand {

    private int id;
    private String name;
    private String imgLogo;

    public AirlineCommand() {
    }

    public AirlineCommand(int id, String name, String imgLogo) {
        this.id = id;
        this.name = name;
        this.imgLogo = imgLogo;
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
