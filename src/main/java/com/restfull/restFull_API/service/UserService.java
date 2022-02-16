package com.restfull.restFull_API.service;

import com.restfull.restFull_API.model.UserModel;
import com.restfull.restFull_API.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public ArrayList<UserModel> getAllUsers(){
        return (ArrayList<UserModel>) userRepository.findAll();
    }

    public UserModel postUser(UserModel user){
        return userRepository.save(user);
    }

    public Optional<UserModel> getById(Long id){
        return userRepository.findById(id);
    }

    public ArrayList<UserModel> findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public boolean deleteUser(Long id){
        try{
            userRepository.deleteById(id);
            return true;
        }
        catch (Exception err){
            return false;
        }
    }
}
