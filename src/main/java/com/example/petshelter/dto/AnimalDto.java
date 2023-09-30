package com.example.petshelter.dto;

import com.example.petshelter.entity.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.JoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnimalDto {

    private String name;
    private String type;
    private Long age;
    private String sex;
    private String region;
    private String imageURL1;
    private String imageURL2;
    private String imageURL3;
    private String imageURL4;
    private String description;
    private String sterilization;
    @JsonProperty("user")
    private UserDto userDto;

}
