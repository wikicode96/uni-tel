package com.github.wikicode96.customer.controller;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.github.wikicode96.customer.command.CreateCustomerCommand;
import com.github.wikicode96.customer.command.DeleteCustomerCommand;
import com.github.wikicode96.customer.command.UpdateCustomerCommand;
import com.github.wikicode96.customer.dto.CustomerDTO;
import com.github.wikicode96.customer.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class CustomerControllerTest {

    @Mock
    private CustomerService service;

    @InjectMocks
    private CustomerController customerController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateCustomer() {
        // Given
        CreateCustomerCommand customerCommand = new CreateCustomerCommand();

        // When
        ResponseEntity<String> responseEntity = customerController.createCustomer(customerCommand);

        // Then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Customer created successfully", responseEntity.getBody());
        verify(service, times(1)).createCustomer(customerCommand);
    }

    @Test
    public void testGetCustomerById() {
        // Given
        int customerId = 1;
        CustomerDTO customerDTO = new CustomerDTO();
        when(service.getCustomerById(customerId)).thenReturn(customerDTO);

        // When
        ResponseEntity<CustomerDTO> responseEntity = customerController.getCustomerById(customerId);

        // Then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertSame(customerDTO, responseEntity.getBody());
    }

    @Test
    public void testGetAllCustomers() {
        // Given
        List<CustomerDTO> customerDTOs = new ArrayList<>();
        when(service.getAllCustomer()).thenReturn(customerDTOs);

        // When
        ResponseEntity<List<CustomerDTO>> responseEntity = customerController.getAllCustomers();

        // Then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertSame(customerDTOs, responseEntity.getBody());
    }

    @Test
    public void testUpdateCustomer() {
        // Given
        UpdateCustomerCommand customerCommand = new UpdateCustomerCommand();

        // When
        ResponseEntity<String> responseEntity = customerController.updateCustomer(customerCommand);

        // Then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Customer updated successfully", responseEntity.getBody());
        verify(service, times(1)).updateCustomer(customerCommand);
    }

    @Test
    public void testDeleteCustomerByEmail() {
        // Given
        DeleteCustomerCommand customerCommand = new DeleteCustomerCommand();

        // When
        ResponseEntity<String> responseEntity = customerController.deleteCustomerByEmail(customerCommand);

        // Then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Customer deleted successfully", responseEntity.getBody());
        verify(service, times(1)).deleteCustomerByEmail(customerCommand);
    }
}
