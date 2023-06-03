package com.example.diplomalbina.repository;

import com.example.diplomalbina.model.Adverts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface AdvertsRepository extends JpaRepository<Adverts, Integer> {
    Adverts findAdvertsByID(Integer id);
    void deleteAdvertsByID(Integer id);
    Collection<Adverts> findAllByVLNTR(Integer id);

}
