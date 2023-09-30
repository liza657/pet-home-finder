package com.example.petshelter.service;

import com.example.petshelter.dto.UserDto;
import com.example.petshelter.entity.User;

import java.util.List;

public interface UserService {
    User addUser(User user);
    UserDto getUser(long userId);
    List<UserDto> getUsers();
    void deleteUser(long userId);
    void updateUser(long userId, UserDto userDTO);
    UserDto findByEmail(String email);

}
