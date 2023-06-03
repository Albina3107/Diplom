package com.example.diplomalbina.repository;

import com.example.diplomalbina.model.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneNumberRepository extends JpaRepository<PhoneNumber, Integer> {
    PhoneNumber findPhoneNumberByVLNTR(Integer id);
}
