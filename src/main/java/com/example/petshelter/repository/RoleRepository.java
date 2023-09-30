package com.example.petshelter.repository;

import com.example.petshelter.entity.Roles;
import com.example.petshelter.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Roles, Integer> {
    Roles findByName(String name);
}
