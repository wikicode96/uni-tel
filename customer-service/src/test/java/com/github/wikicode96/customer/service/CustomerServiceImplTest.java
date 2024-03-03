package com.github.wikicode96.customer.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.github.wikicode96.customer.command.CreateCustomerCommand;
import com.github.wikicode96.customer.command.DeleteCustomerCommand;
import com.github.wikicode96.customer.command.UpdateCustomerCommand;
import com.github.wikicode96.customer.dto.CustomerDTO;
import com.github.wikicode96.customer.entity.CustomerEntity;
import com.github.wikicode96.customer.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImplTest {

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private CustomerRepository repository;

    @InjectMocks
    private CustomerServiceImpl customerService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateCustomer() {
        // Given
        CreateCustomerCommand customerCommand = new CreateCustomerCommand();
        CustomerEntity customerEntity = new CustomerEntity();
        when(modelMapper.map(customerCommand, CustomerEntity.class)).thenReturn(customerEntity);

        // When
        assertDoesNotThrow(() -> customerService.createCustomer(customerCommand));
    }

    @Test
    public void testGetCustomerById() {
        // Given
        int customerId = 1;
        CustomerEntity customerEntity = new CustomerEntity();
        when(repository.getReferenceById(customerId)).thenReturn(customerEntity);
        when(modelMapper.map(customerEntity, CustomerDTO.class)).thenReturn(new CustomerDTO());

        // When
        CustomerDTO customerDTO = customerService.getCustomerById(customerId);

        // Then
        assertNotNull(customerDTO);
    }

    @Test
    public void testGetAllCustomer() {
        // Given
        List<CustomerEntity> customerEntities = new ArrayList<>();
        customerEntities.add(new CustomerEntity());
        when(repository.findAll()).thenReturn(customerEntities);

        // When
        List<CustomerDTO> customerDTOs = customerService.getAllCustomer();

        // Then
        assertNotNull(customerDTOs);
        assertEquals(1, customerDTOs.size());
    }

    @Test
    public void testUpdateCustomer_WithValidId() {
        // Given
        UpdateCustomerCommand customerCommand = new UpdateCustomerCommand();
        customerCommand.setId(1);

        // When & Then
        assertDoesNotThrow(() -> customerService.updateCustomer(customerCommand));
    }

    @Test
    public void testUpdateCustomer_WithInvalidId() {
        // Given
        UpdateCustomerCommand customerCommand = new UpdateCustomerCommand();

        // When & Then
        assertThrows(ResponseStatusException.class, () -> customerService.updateCustomer(customerCommand));
    }

    @Test
    public void testDeleteCustomerByEmail() {
        // Given
        String email = "test@example.com";
        DeleteCustomerCommand customerCommand = new DeleteCustomerCommand();
        customerCommand.setEmail(email);
        CustomerEntity customerEntity = new CustomerEntity();
        when(repository.findByEmail(email)).thenReturn(customerEntity);

        // When & Then
        assertDoesNotThrow(() -> customerService.deleteCustomerByEmail(customerCommand));
    }

    @Test
    public void testDeleteCustomerByEmail_NotFound() {
        // Given
        String email = "nonexistent@example.com";
        DeleteCustomerCommand customerCommand = new DeleteCustomerCommand();
        customerCommand.setEmail(email);
        when(repository.findByEmail(email)).thenReturn(null);

        // When & Then
        assertThrows(ResponseStatusException.class, () -> customerService.deleteCustomerByEmail(customerCommand));
    }
}
