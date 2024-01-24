package com.github.wikicode96.costumer.service;

import com.github.wikicode96.costumer.entity.CostumerEntity;

import java.util.List;

public interface CostumerService {

    // CRUD
    CostumerEntity newUser(CostumerEntity user);
    CostumerEntity getUserById(int id);
    List<CostumerEntity> getAllUsers();
    CostumerEntity updateUser(CostumerEntity user);
    CostumerEntity deleteUser(CostumerEntity user);
}
