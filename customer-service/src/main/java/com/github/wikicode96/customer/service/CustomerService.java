package com.github.wikicode96.customer.service;

import com.github.wikicode96.customer.command.CreateCustomerCommand;
import com.github.wikicode96.customer.command.DeleteCustomerCommand;
import com.github.wikicode96.customer.command.UpdateCustomerCommand;
import com.github.wikicode96.customer.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {

    // CRUD
    void createCustomer(CreateCustomerCommand customer);
    CustomerDTO getCustomerById(int id);
    List<CustomerDTO> getAllCustomer();
    void updateCustomer(UpdateCustomerCommand customer);
    void deleteCustomerByEmail(DeleteCustomerCommand customer);
}
