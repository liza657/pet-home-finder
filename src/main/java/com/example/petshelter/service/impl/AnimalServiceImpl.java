package com.example.petshelter.service.impl;

import com.example.petshelter.dto.AnimalDto;
import com.example.petshelter.dto.UserDto;
import com.example.petshelter.entity.Animal;
import com.example.petshelter.entity.User;
import com.example.petshelter.mapper.AnimalMapper;
import com.example.petshelter.repository.AnimalRepository;
import com.example.petshelter.service.AnimalService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalServiceImpl implements AnimalService {
    @Autowired
    private AnimalRepository animalRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private AnimalMapper animalMapper;

    @Override
    public Animal createAnimal(Animal animal) {
        Animal newAnimal = new Animal();
        newAnimal.setName(animal.getName());
        newAnimal.setType(animal.getType());
        newAnimal.setRegion(animal.getRegion());
        newAnimal.setAge(animal.getAge());
        newAnimal.setSex(animal.getSex());
        newAnimal.setDescription(animal.getDescription());
        newAnimal.setSterilization(animal.getSex());
        newAnimal.setSex(animal.getSex());
        newAnimal.setImageURL1(animal.getImageURL1());
        newAnimal.setImageURL2(animal.getImageURL2());
        newAnimal.setImageURL3(animal.getImageURL3());
        newAnimal.setImageURL4(animal.getImageURL4());
        newAnimal.setUser(animal.getUser());
        return animalRepository.save(newAnimal);
    }

    @Override
    public AnimalDto getAnimalById(long animalId) {
        Animal animal = this.animalRepository.findById(animalId).get();
        return this.modelMapper.map(animal, AnimalDto.class);
    }

    @Override
    public List<AnimalDto> getAllAnimals() {
        List<Animal> animalList = animalRepository.findAll();
        return animalMapper.toDtoList(animalList);
    }

    @Override
    public List<AnimalDto> getAnimalsByType(String type) {
        List<Animal> animalList = animalRepository.findAnimalByType(type);
        return animalMapper.toDtoList(animalList);
    }

    @Override
    public List<AnimalDto> getAnimalsBySex(String sex) {
        List<Animal> animalList = animalRepository.findAnimalBySex(sex);
        return animalMapper.toDtoList(animalList);
    }

    @Override
    public List<AnimalDto> getAnimalsByAge(int age) {
        List<Animal> animalList = animalRepository.findAnimalByAge(age);
        return animalMapper.toDtoList(animalList);
    }

    @Override
    public List<AnimalDto> getAnimalsBySterilization(String sterilization) {
        List<Animal> animalList = animalRepository.findAnimalBySterilization(sterilization);
        return animalMapper.toDtoList(animalList);
    }

    @Override
    public List<AnimalDto> getAnimalsByRegion(String region) {
        List<Animal> animalList = animalRepository.findAnimalByRegion(region);
        return animalMapper.toDtoList(animalList);
    }

    @Override
    public void deleteAnimalById(long animalId) {
        animalRepository.deleteById(animalId);
    }

    @Override
    public void updateAnimal(long id, AnimalDto animalDto) {
        Animal animalToUpdate = animalRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        modelMapper.map(animalDto, animalToUpdate);
        animalRepository.save(animalToUpdate);
    }
}
