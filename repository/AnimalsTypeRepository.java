package com.example.diplomalbina.repository;
import com.example.diplomalbina.model.AnimalType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalsTypeRepository extends JpaRepository<AnimalType, Integer> {
    AnimalType findAnimalTypeByTYPE(String type);
    AnimalType findAnimalTypeByID(Integer id);

}
