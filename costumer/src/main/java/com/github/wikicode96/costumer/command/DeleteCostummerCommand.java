package com.github.wikicode96.costumer.command;

public class DeleteCostummerCommand {

    private int id;
    private String email;

    public DeleteCostummerCommand(int id) {
        this.id = id;
    }

    public DeleteCostummerCommand(String email) {
        this.email = email;
    }

    public DeleteCostummerCommand(int id, String email) {
        this.id = id;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
