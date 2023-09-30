package com.example.petshelter.mapper;

import com.example.petshelter.dto.AnimalDto;
import com.example.petshelter.entity.Animal;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AnimalMapper {
    @Autowired
    ModelMapper modelMapper;


    public AnimalDto toDto(Animal animal) {
        return modelMapper.map(animal, AnimalDto.class);
    }

    public Animal toModel(AnimalDto animalDto) {
        return modelMapper.map(animalDto, Animal.class);
    }

    public List<AnimalDto> toDtoList(List<Animal> animalList) {
        return animalList.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public List<Animal> toModelList(List<AnimalDto> animalDtoList) {
        return animalDtoList.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }
}

