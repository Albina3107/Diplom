package com.example.diplomalbina.repository;

import com.example.diplomalbina.model.Volunteers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VolonteersRepository extends JpaRepository<Volunteers, Integer>{
    Volunteers findVolunteersByEMAIL(String EMAIL);
    Volunteers findVolunteersByID(Integer id);

}


