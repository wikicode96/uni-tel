package com.github.wikicode96.costumer.service;

import com.github.wikicode96.costumer.command.CreateCostummerCommand;
import com.github.wikicode96.costumer.command.DeleteCostummerCommand;
import com.github.wikicode96.costumer.command.UpdateCostumerCommand;
import com.github.wikicode96.costumer.dto.CostumerDTO;
import com.github.wikicode96.costumer.entity.CostumerEntity;
import com.github.wikicode96.costumer.repository.CostumerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class CostumerServiceImpl implements CostumerService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private CostumerRepository repository;

    @Override
    public void createCostumer(CreateCostummerCommand costumer) {
        CostumerEntity entity = mapper.map(costumer, CostumerEntity.class);
        repository.save(entity);
    }

    @Override
    public CostumerDTO getCostumerById(int id) {
        CostumerEntity entity = repository.getReferenceById(id);
        return mapper.map(entity, CostumerDTO.class);
    }

    @Override
    public List<CostumerDTO> getAllCostumers() {
        List<CostumerEntity> entities = repository.findAll();
        List<CostumerDTO> dtos = new ArrayList<>();

        for(CostumerEntity entity: entities) {
            dtos.add(mapper.map(entity, CostumerDTO.class));
        }
        return dtos;
    }

    @Override
    public void updateCostumer(UpdateCostumerCommand costumer) {

        if (costumer.getId() > 0) {
            CostumerEntity entity = mapper.map(costumer, CostumerEntity.class);
            repository.save(entity);
        } else {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Customer ID is invalid");
        }
    }

    @Override
    public void deleteCostumerByEmail(DeleteCostummerCommand costumer) {
        CostumerEntity entity = repository.findByEmail(costumer.getEmail());

        if (entity != null) {
            repository.delete(entity);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found with email: " + costumer.getEmail());
        }
    }
}
