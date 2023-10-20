package com.github.wikicode96.repository.service;

import com.github.wikicode96.repository.entity.User;
import com.github.wikicode96.repository.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository repository;

    @Override
    public User newUser(User user) {

        if(user.getId() == 0){
            try{
                repository.save(user);
                return user;
            }catch (Exception e){
                return null;
            }
        }else{
            return null;
        }
    }

    @Override
    public User getUserById(int id) {

        if(id > 0) {
            try {
                User user = repository.findById(id).orElse(null);

                if (user != null) return user;
                else return null;

            } catch (Exception e) {
                return null;
            }
        } else {
            return null;
        }
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public User updateUser(User user) {

        if(user.getId() > 0) {
            try{
                repository.save(user);
                return user;
            }catch (Exception e){
                return null;
            }
        }else{
            return null;
        }
    }

    @Override
    public User deleteUser(User user) {

        if(user.getId() > 0) {
            try{
                repository.delete(user);
                return user;
            }catch (Exception e){
                return null;
            }
        }else{
            return null;
        }
    }
}
