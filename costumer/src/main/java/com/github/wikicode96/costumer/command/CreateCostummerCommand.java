package com.github.wikicode96.costumer.command;

import lombok.Data;

@Data
public class CreateCostummerCommand {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
