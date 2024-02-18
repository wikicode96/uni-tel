package com.github.wikicode96.customer.command;

import lombok.Data;

@Data
public class UpdateCustomerCommand {
    private int id;
    private String newFirstName;
    private String newLastName;
    private String newEmail;
    private String newPassword;
}
