package com.example.diplomalbina.service;


import com.example.diplomalbina.model.Volunteers;
import jakarta.servlet.http.Cookie;

public interface VolunteersService {
    Volunteers registr(String email,  String name,  String sname, String pname, String password, String phone);
    Cookie login(String email, String pass);

    Volunteers getVolunteerById(Integer id);
}
