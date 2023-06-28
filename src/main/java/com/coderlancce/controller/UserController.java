package com.coderlancce.controller;

import com.coderlancce.NewUserRequest;
import com.coderlancce.Service.UserService;
import com.coderlancce.Entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }


    @PostMapping("/users")
    public void addUser(@RequestBody NewUserRequest request){
        userService.addUser(request);
    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable("userId") Integer id,
                                           @RequestBody User userDetails){
        return userService.updateUser(id, userDetails);
    }

    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable("userId") Integer id){
        userService.deleteUser(id);
    }
}
