package com.example.diplomalbina.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Responce {
    private Animals animals;
    private City city;
    private AnimalType animalType;
    private Volunteers volunteers;
    private Adverts adverts;

    private PhoneNumber phoneNumber;
}
