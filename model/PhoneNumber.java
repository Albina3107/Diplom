package com.example.diplomalbina.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PHONE_NUMBERS")
public class PhoneNumber {

    private Integer VLNTR;
    private String NUMBERS;

    @Id
    @SequenceGenerator(name = "SEQ", sequenceName = "PHONE_NUMBERS_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    private Integer ID;

    public PhoneNumber(Integer VLNTR, String NUMBERS) {
        this.VLNTR = VLNTR;
        this.NUMBERS = NUMBERS;
    }
}