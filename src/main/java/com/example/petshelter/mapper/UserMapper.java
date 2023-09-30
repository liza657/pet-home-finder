package com.example.petshelter.mapper;

import com.example.petshelter.dto.AnimalDto;
import com.example.petshelter.dto.UserDto;
import com.example.petshelter.entity.Animal;
import com.example.petshelter.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {
    @Autowired
    ModelMapper modelMapper;


    public UserDto toDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }

    public User toModel(UserDto userDto) {
        return modelMapper.map(userDto, User.class);
    }

    public List<UserDto> toDtoList(List<User> userList) {
        return userList.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public List<User> toModelList(List<UserDto> userDtoList) {
        return userDtoList.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }
}
