package com.github.wikicode96.costumer.dto;

public class CostumerDTO {

    private String firstName;
    private String lastName;

    public CostumerDTO() {
    }

    public CostumerDTO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
