package com.example.diplomalbina.service;

import com.example.diplomalbina.model.PhoneNumber;
import com.example.diplomalbina.model.Volunteers;
import com.example.diplomalbina.repository.PhoneNumberRepository;
import com.example.diplomalbina.repository.VolonteersRepository;
import jakarta.servlet.http.Cookie;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class VolunteersServiceImpl implements VolunteersService {


    private VolonteersRepository volonteersRepository;
    private PhoneNumberRepository phoneNumberRepository;

    @Autowired
    public VolunteersServiceImpl(VolonteersRepository volonteersRepository, PhoneNumberRepository phoneNumberRepository) {
        this.volonteersRepository = volonteersRepository;
        this.phoneNumberRepository = phoneNumberRepository;
    }

    @Transactional
    @Override
    public Volunteers registr(String email,  String name,  String sname, String pname, String password, String phone) {
        Volunteers volunteers = new Volunteers(email, name, pname, sname, password);
        Volunteers volun = volonteersRepository.findVolunteersByEMAIL(volunteers.getEMAIL());
        if (volun != null) {
            return null;
        } else {
            Volunteers vol = volonteersRepository.save(volunteers);
            System.out.println(phone);
            phoneNumberRepository.save(new PhoneNumber(vol.getID(), phone));
            return vol;
        }
    }

    @Override
    public Cookie login(String email, String pass) {
        Volunteers vol = volonteersRepository.findVolunteersByEMAIL(email);
        if (vol.getPASSWORD().equals(pass)) {
            return new Cookie("userId", vol.getID().toString());
        } else {
            return null;
        }
    }

    @Override
    public Volunteers getVolunteerById(Integer id) {
        return volonteersRepository.findVolunteersByID(id);
    }
}
