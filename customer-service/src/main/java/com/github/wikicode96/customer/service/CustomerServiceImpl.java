package com.github.wikicode96.customer.service;

import com.github.wikicode96.customer.command.CreateCustomerCommand;
import com.github.wikicode96.customer.command.DeleteCustomerCommand;
import com.github.wikicode96.customer.command.UpdateCustomerCommand;
import com.github.wikicode96.customer.dto.CustomerDTO;
import com.github.wikicode96.customer.entity.CustomerEntity;
import com.github.wikicode96.customer.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CustomerRepository repository;

    @Override
    public void createCustomer(CreateCustomerCommand customer) {
        CustomerEntity entity = modelMapper.map(customer, CustomerEntity.class);
        repository.save(entity);
    }

    @Override
    public CustomerDTO getCustomerById(int id) {
        CustomerEntity entity = repository.getReferenceById(id);
        return modelMapper.map(entity, CustomerDTO.class);
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        List<CustomerEntity> entities = repository.findAll();
        List<CustomerDTO> dtos = new ArrayList<>();

        for(CustomerEntity entity: entities) {
            dtos.add(modelMapper.map(entity, CustomerDTO.class));
        }
        return dtos;
    }

    @Override
    public void updateCustomer(UpdateCustomerCommand customer) {

        if (customer.getId() > 0) {
            CustomerEntity entity = modelMapper.map(customer, CustomerEntity.class);
            repository.save(entity);
        } else {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Customer ID is invalid");
        }
    }

    @Override
    public void deleteCustomerByEmail(DeleteCustomerCommand customer) {
        CustomerEntity entity = repository.findByEmail(customer.getEmail());

        if (entity != null) {
            repository.delete(entity);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found with email: " + customer.getEmail());
        }
    }
}
