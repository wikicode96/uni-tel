package com.github.wikicode96.customer.controller;

import com.github.wikicode96.customer.command.CreateCustomerCommand;
import com.github.wikicode96.customer.command.DeleteCustomerCommand;
import com.github.wikicode96.customer.command.UpdateCustomerCommand;
import com.github.wikicode96.customer.dto.CustomerDTO;
import com.github.wikicode96.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "customer")
public class CustomerController {

    @Autowired
    private CustomerService service;

    // CRUD
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> createCustomer(@RequestBody CreateCustomerCommand customer){
        service.createCustomer(customer);
        return ResponseEntity.ok("Customer created successfully");
    }

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CustomerDTO> getCustomerById(@PathVariable("id") int id){
        CustomerDTO response = service.getCustomerById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<CustomerDTO>> getAllCustomers(){
        List<CustomerDTO> response = service.getAllCustomer();
        return ResponseEntity.ok(response);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> updateCustomer(@RequestBody UpdateCustomerCommand customer){
        service.updateCustomer(customer);
        return ResponseEntity.ok("Customer updated successfully");
    }

    @DeleteMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> deleteCustomerByEmail(@RequestBody DeleteCustomerCommand customer){
        service.deleteCustomerByEmail(customer);
        return ResponseEntity.ok("Customer deleted successfully");
    }
}
