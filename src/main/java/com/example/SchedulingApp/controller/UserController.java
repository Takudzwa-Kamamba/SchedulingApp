package com.example.SchedulingApp.controller;

import com.example.SchedulingApp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.SchedulingApp.repository.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {

        if(userRepository.findByUsername(user.getUsername()) !=null){
            return ResponseEntity.badRequest().body("Username already exists.");
        }
        userRepository.save(user);
        return ResponseEntity.ok("User registered successfully");
    }

}
