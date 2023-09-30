package com.example.petshelter.controller;

import com.example.petshelter.dto.AnimalDto;
import com.example.petshelter.entity.Animal;
import com.example.petshelter.service.AnimalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/api/auth")
@RestController
public class AnimalController {

   private AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }


    @PostMapping("createAnimal")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Animal> createAnimal(@RequestBody Animal animal) {
        return new  ResponseEntity<>(animalService.createAnimal(animal),HttpStatus.CREATED);
    }

    @GetMapping("/getAnimal/{id}")
    public ResponseEntity<AnimalDto> getAnimalById(@PathVariable("id") long animalId) {
        AnimalDto animalDto = animalService.getAnimalById(animalId);
        return ResponseEntity.ok(animalDto);
    }

    @GetMapping("/getAllAnimals")
    public List<AnimalDto> getAllAnimals() {
        return animalService.getAllAnimals();
    }

    @GetMapping("/getAnimalsByType/{type}")
    public List<AnimalDto> getAnimalsByType(@PathVariable("type") String type) {
        return animalService.getAnimalsByType(type);
    }

    @GetMapping("/getAnimalsByRegion/{region}")
    public List<AnimalDto> getAnimalsByRegion(@PathVariable("region") String region) {
        return animalService.getAnimalsByRegion(region);
    }

    @GetMapping("/getAnimalsBySex/{sex}")
    public List<AnimalDto> getAnimalsBySex(@PathVariable("sex") String sex) {
        return animalService.getAnimalsBySex(sex);
    }

    @GetMapping("/getAnimalsBySterilization/{sterilization}")
    public List<AnimalDto> getAnimalsBySterilization(@PathVariable("sterilization") String sterilization) {
        return animalService.getAnimalsBySterilization(sterilization);
    }

    @GetMapping("/getAnimalsByAge/{age}")
    public List<AnimalDto> getAnimalsByAge(@PathVariable("age") int age) {
        return animalService.getAnimalsByAge(age);
    }

    @PutMapping("/updateAnimal/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable("id") int userId, @RequestBody AnimalDto animalDto) {
        animalService.updateAnimal(userId, animalDto);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/deleteAnimal/{id}")
    public void deleteUser(@PathVariable("id") long animalId) {
        animalService.deleteAnimalById(animalId);
    }


}
