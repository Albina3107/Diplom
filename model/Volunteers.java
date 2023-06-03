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
@Table(name = "VOLUNTEERS")
public class Volunteers {

    private String EMAIL;
    private String FNAME;
    private String SNAME;
    private String PNAME;
    private String PASSWORD;

    @Id
    @SequenceGenerator(name = "SEQ", sequenceName = "VOLUNTEERS_SEQ", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    private Integer ID;

    public Volunteers(String EMAIL, String FNAME, String SNAME, String PNAME, String PASSWORD) {
        this.EMAIL = EMAIL;
        this.FNAME = FNAME;
        this.SNAME = SNAME;
        this.PNAME = PNAME;
        this.PASSWORD = PASSWORD;
    }


}