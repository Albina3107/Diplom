package com.example.diplomalbina.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ADVERTS")
public class Adverts {

    private Integer VLNTR;
    private Integer ANIMALS;
    private String DATE_ADV;
    private String TEXT_ADV;

    @Id
    @SequenceGenerator(name = "SEQ", sequenceName = "ADVERTS_SEQ", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    private Integer ID;

    public Adverts(Integer VLNTR, Integer ANIMALS, String DATE_ADV, String TEXT_ADV) {
        this.VLNTR = VLNTR;
        this.ANIMALS = ANIMALS;
        this.DATE_ADV = DATE_ADV;
        this.TEXT_ADV = TEXT_ADV;
    }
}