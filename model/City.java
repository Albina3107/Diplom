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
@Table(name = "CITY")
public class City {

    private String NAME;
    private String TYPE;

    @Id
    @SequenceGenerator(name = "SEQ", sequenceName = "CITY_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    private Integer ID;

    public City(String NAME, String TYPE) {
        this.NAME = NAME;
        this.TYPE = TYPE;
    }
}