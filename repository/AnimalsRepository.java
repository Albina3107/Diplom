package com.example.diplomalbina.repository;

import com.example.diplomalbina.model.Animals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalsRepository extends JpaRepository<Animals, Animals> {
    Animals findAnimalsByID(Integer id);
}
