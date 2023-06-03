package com.example.diplomalbina.service;

import com.example.diplomalbina.model.Adverts;
import com.example.diplomalbina.model.Responce;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Collection;

public interface AdvertsService {
    Responce createAdvert(Integer userId, String animalName, Integer animalAge, String animalHistory, String animalType, String animalPhoto, String animalCity, String animalCityType, String details, String date);
    Responce updateAdvert(Integer advertId, Integer userId, Integer animalId, String animalName, Integer animalAge, String animalHistory, String animalType, String animalPhoto, String animalCity, String animalCityType, String details, String date);

    void deleteAdvert(Integer id);

    ArrayList<Responce> getAllAd();

    ArrayList<Responce> getAllAdByType(String type);

    ArrayList<Responce> getAdByVolunteer(Integer userId);

    Responce getAdById(Integer id);



}
