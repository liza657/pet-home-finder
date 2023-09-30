package com.example.petshelter.service.impl;

import com.example.petshelter.dto.AnimalDto;
import com.example.petshelter.dto.UserDto;
import com.example.petshelter.entity.Animal;
import com.example.petshelter.entity.User;
import com.example.petshelter.mapper.UserMapper;
import com.example.petshelter.repository.UserRepository;
import com.example.petshelter.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public UserDto getUser(long userId) {
        User user = this.userRepository.findById(userId).get();
        return this.modelMapper.map(user, UserDto.class);
    }

    @Override
    public List<UserDto> getUsers() {
        List<User> userList = userRepository.findAll();
        return userMapper.toDtoList(userList);
    }

    @Override
    public void deleteUser(long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public void updateUser(long id, UserDto userDto) {
        User userToUpdate = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        modelMapper.map(userDto, userToUpdate);
        userRepository.save(userToUpdate);
    }

    @Override
    public UserDto findByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        return modelMapper.map(user, UserDto.class);
    }

}
