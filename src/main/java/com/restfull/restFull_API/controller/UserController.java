package com.restfull.restFull_API.controller;

import com.restfull.restFull_API.model.UserModel;
import com.restfull.restFull_API.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping()
    @CrossOrigin
    public ArrayList<UserModel> getAllUsers(){
        return userService.getAllUsers();
    }

    @CrossOrigin
    @PostMapping()
    public UserModel postUser(@RequestBody UserModel user){
        return this.userService.postUser(user);
    }

    @CrossOrigin
    @GetMapping( path = "/{id}")
    public Optional<UserModel> getById(@PathVariable("id") Long id) {
        return this.userService.getById(id);
    }

    @CrossOrigin
    @GetMapping("/")
    public ArrayList<UserModel> findByUsername(@RequestParam("username") String username){
        return this.userService.findByUsername(username);
    }

    @CrossOrigin
    @DeleteMapping( path = "/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        boolean ok = this.userService.deleteUser(id);
        if (ok){
            return "User Deleted!";
        }else{
            return "User can't be Deleted!";
        }
    }
}
