package com.example.petshelter.service;

import com.example.petshelter.dto.AnimalDto;
import com.example.petshelter.entity.Animal;

import java.util.List;

public interface AnimalService {
    Animal createAnimal(Animal animal);
    AnimalDto getAnimalById(long animalId);
    List<AnimalDto> getAllAnimals();

    List<AnimalDto> getAnimalsByType(String type);

    List<AnimalDto> getAnimalsBySex(String sex);

    List<AnimalDto> getAnimalsByAge(int age);

    List<AnimalDto> getAnimalsBySterilization(String sterilization);

    List<AnimalDto> getAnimalsByRegion(String region);

    void deleteAnimalById(long animalId);
    void updateAnimal(long animalId,AnimalDto animalDto);



}
