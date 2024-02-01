package com.github.wikicode96.costumer.service;

import com.github.wikicode96.costumer.command.CreateCostummerCommand;
import com.github.wikicode96.costumer.command.DeleteCostummerCommand;
import com.github.wikicode96.costumer.command.UpdateCostumerCommand;
import com.github.wikicode96.costumer.dto.CostumerDTO;
import com.github.wikicode96.costumer.entity.CostumerEntity;
import com.github.wikicode96.costumer.repository.CostumerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CostumerServiceImpl implements CostumerService {

    @Autowired
    ModelMapper mapper;

    @Autowired
    CostumerRepository repository;

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
        CostumerEntity entity = mapper.map(costumer, CostumerEntity.class);
        repository.save(entity);
    }

    @Override
    public void deleteCostumer(DeleteCostummerCommand costumer) {
        repository.deleteById(costumer.getId());
    }
}
