package com.example.petshelter.repository;

import com.example.petshelter.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
    List<Animal> findAnimalByAge(long age);

    List<Animal> findAnimalByType(String type);

    List<Animal> findAnimalBySex(String sex);

    List<Animal> findAnimalBySterilization(String sterilization);

    List<Animal> findAnimalByRegion(String region);



}
