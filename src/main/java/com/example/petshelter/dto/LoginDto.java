package com.example.petshelter.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class LoginDto {
    String email;
    String password;
}
