package com.github.wikicode96.costumer.command;

public class DeleteCostummerCommand {

    private String email;

    public DeleteCostummerCommand() {
    }

    public DeleteCostummerCommand(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
