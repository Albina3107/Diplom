package com.example.diplomalbina.repository;

import com.example.diplomalbina.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
    City findCityByNAME(String name);
    City findCityByID(Integer id);
}
