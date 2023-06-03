package com.example.diplomalbina.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ANIMALS")
public class Animals {

    private Integer TYPE;
    private Integer CITY;
    private String NAME;
    private String HISTORY;
    private String PHOTO;
    private Integer AGE;
    @Id
    @SequenceGenerator(name = "SEQ", sequenceName = "ANIMALS_SEQ", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    private Integer ID;

    public Animals(Integer TYPE, Integer CITY, String NAME, String HISTORY, String PHOTO, Integer AGE) {
        this.TYPE = TYPE;
        this.CITY = CITY;
        this.NAME = NAME;
        this.HISTORY = HISTORY;
        this.PHOTO = PHOTO;
        this.AGE = AGE;
    }
}