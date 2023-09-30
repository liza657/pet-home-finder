package com.example.petshelter.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
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
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User User;


}
