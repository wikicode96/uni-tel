package com.github.wikicode96.costumer.service;

import com.github.wikicode96.costumer.entity.CostumerEntity;
import com.github.wikicode96.costumer.repository.CostumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CostumerServiceImpl implements CostumerService {

    @Autowired
    private CostumerRepository repository;

    @Override
    public CostumerEntity newUser(CostumerEntity user) {

        if(user.getId() == 0){
            try{
                repository.save(user);
                return user;
            }catch (Exception e){
                return null;
            }
        }
        return null;
    }

    @Override
    public CostumerEntity getUserById(int id) {
        if(id > 0) return repository.findById(id).orElse(null);
        else return null;
    }

    @Override
    public List<CostumerEntity> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public CostumerEntity updateUser(CostumerEntity user) {

        if(user.getId() > 0) {
            try{
                repository.save(user);
                return user;
            }catch (Exception e){
                return null;
            }
        }
        return null;
    }

    @Override
    public CostumerEntity deleteUser(CostumerEntity user) {

        if(user.getId() > 0) {
            try{
                repository.delete(user);
                return user;
            }catch (Exception e){
                return null;
            }
        }
        return null;
    }
}
