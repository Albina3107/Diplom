package com.example.diplomalbina.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ANIMALS_TYPE")
public class AnimalType {

    private String TYPE;
    private String DESCRIPTION;

    @Id
    @SequenceGenerator(name = "SEQ", sequenceName = "TYPE_ANIMALS_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    private Integer ID;

    public AnimalType(String TYPE, String DESCRIPTION) {
        this.TYPE = TYPE;
        this.DESCRIPTION = DESCRIPTION;
    }
}