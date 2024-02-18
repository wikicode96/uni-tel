package com.github.wikicode96.customer.command;

import lombok.Data;

@Data
public class CreateCustomerCommand {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
