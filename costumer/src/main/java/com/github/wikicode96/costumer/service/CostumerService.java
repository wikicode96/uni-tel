package com.github.wikicode96.costumer.service;

import com.github.wikicode96.costumer.command.CreateCostummerCommand;
import com.github.wikicode96.costumer.command.DeleteCostummerCommand;
import com.github.wikicode96.costumer.command.UpdateCostumerCommand;
import com.github.wikicode96.costumer.dto.CostumerDTO;
import com.github.wikicode96.costumer.entity.CostumerEntity;

import java.util.List;

public interface CostumerService {

    // CRUD
    void createCostumer(CreateCostummerCommand costumer);
    CostumerDTO getCostumerById(int id);
    List<CostumerDTO> getAllCostumers();
    void updateCostumer(UpdateCostumerCommand costumer);
    void deleteCostumer(DeleteCostummerCommand costumer);
}
