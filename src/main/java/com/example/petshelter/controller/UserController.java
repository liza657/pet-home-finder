package com.example.petshelter.controller;

import com.example.petshelter.dto.AnimalDto;
import com.example.petshelter.dto.UserDto;
import com.example.petshelter.entity.User;
import com.example.petshelter.repository.UserRepository;
import com.example.petshelter.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserServiceImpl userServiceImpl;


    @PostMapping("/create")
    public ResponseEntity<User> createUser( @RequestBody User user) {
        User createdUser = userServiceImpl.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable("id") long userId) {
        UserDto userDto = userServiceImpl.getUser(userId);
        return ResponseEntity.ok(userDto);
    }

    @GetMapping("/getUsers")
    public List<UserDto> getAllUsers() {
        return userServiceImpl.getUsers();
    }


    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable("id") long userId) {
        userServiceImpl.deleteUser(userId);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable("id") int userId, @RequestBody UserDto userDto) {
        userServiceImpl.updateUser(userId, userDto);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getByEmail/{email}")
    public ResponseEntity<UserDto> getUserByEmail(@PathVariable String email) {
        UserDto userDTO = userServiceImpl.findByEmail(email);
        if (userDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

}
