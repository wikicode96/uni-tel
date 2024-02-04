package com.github.wikicode96.costumer.command;

import lombok.Data;

@Data
public class UpdateCostumerCommand {
    private int id;
    private String newFirstName;
    private String newLastName;
    private String newEmail;
    private String newPassword;
}
