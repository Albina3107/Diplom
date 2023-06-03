package com.example.diplomalbina.service;

import com.example.diplomalbina.model.*;
import com.example.diplomalbina.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

@Service
public class AdvertsServiceImpl implements AdvertsService {
    private AdvertsRepository advertsRepository;
    private VolonteersRepository volonteersRepository;
    private AnimalsTypeRepository animalsTypeRepository;
    private AnimalsRepository animalsRepository;
    private CityRepository cityRepository;
    private PhoneNumberRepository phoneNumberRepository;

            @Autowired
    public AdvertsServiceImpl(AdvertsRepository advertsRepository, VolonteersRepository volonteersRepository, AnimalsTypeRepository animalsTypeRepository, AnimalsRepository animalsRepository, CityRepository cityRepository, PhoneNumberRepository phoneNumberRepository) {
        this.advertsRepository = advertsRepository;
        this.volonteersRepository = volonteersRepository;
        this.animalsTypeRepository = animalsTypeRepository;
        this.animalsRepository = animalsRepository;
        this.cityRepository = cityRepository;
        this.phoneNumberRepository = phoneNumberRepository;
    }

    @Override
    @Transactional
    public Responce createAdvert(Integer userId, String animalName, Integer animalAge, String animalHistory, String animalType, String animalPhoto, String animalCity, String animalCityType, String details, String date) {
        Volunteers user = volonteersRepository.findVolunteersByID(userId);
        City city;
        if (cityRepository.findCityByNAME(animalCity) != null){
            city = cityRepository.findCityByNAME(animalCity);
            city.setTYPE(animalCityType);
            cityRepository.save(city);
        } else {
            city = cityRepository.save(new City(animalCity, animalCityType));
        }
        //animalsTypeRepository.save(new AnimalType("Dogs", "Breeds"));
        //animalsTypeRepository.save(new AnimalType("Cats", "Breeds"));
        //animalsTypeRepository.save(new AnimalType("Others", "Breeds"));
        AnimalType type = animalsTypeRepository.findAnimalTypeByTYPE(animalType);
        Animals animals = animalsRepository.save(new Animals(type.getID(), city.getID(),animalName, animalHistory, "9.png", animalAge));
        Adverts ad = advertsRepository.save(new Adverts(userId, animals.getID(),date, details ));
        PhoneNumber num = phoneNumberRepository.findPhoneNumberByVLNTR(userId);
       return new Responce(animals, city, type, user, ad, num);
    }

    public Responce updateAdvert(Integer advertId, Integer userId, Integer animalId, String animalName, Integer animalAge, String animalHistory, String animalType, String animalPhoto, String animalCity, String animalCityType, String details, String date) {
        Volunteers user = volonteersRepository.findVolunteersByID(userId);
        City city;
        if (cityRepository.findCityByNAME(animalCity) != null){
            city = cityRepository.findCityByNAME(animalCity);
            city.setTYPE(animalCityType);
            cityRepository.save(city);
        } else {
            city = cityRepository.save(new City(animalCity, animalCityType));
        }
        AnimalType type = animalsTypeRepository.findAnimalTypeByTYPE(animalType);
        Animals animals = animalsRepository.findAnimalsByID(animalId);
        animals.setTYPE(type.getID());
        animals.setCITY(city.getID());
        animals.setAGE(animalAge);
        animals.setNAME(animalName);
        animals.setHISTORY(animalHistory);
        animals.setPHOTO(animalPhoto);
        animalsRepository.save(animals);
        Adverts ad = advertsRepository.findAdvertsByID(advertId);
        ad.setDATE_ADV(date);
        ad.setANIMALS(animalId);
        ad.setTEXT_ADV(details);
        advertsRepository.save(ad);
        PhoneNumber num = phoneNumberRepository.findPhoneNumberByVLNTR(userId);
        return new Responce(animals, city, type, user, ad, num);
    }

    @Transactional
    public void deleteAdvert(Integer id) {
        advertsRepository.deleteAdvertsByID(id);
    }

    @Override
    public ArrayList<Responce> getAllAd() {
        ArrayList<Adverts> all = new ArrayList<>(advertsRepository.findAll());
        ArrayList<Responce> res = new ArrayList<>();
        for (Adverts ad: all) {
            res.add(getAdById(ad.getID()));
        }
        return res;
    }

    @Override
    public ArrayList<Responce> getAllAdByType(String type) {
        ArrayList<Adverts> all = new ArrayList<>(advertsRepository.findAll());
        ArrayList<Responce> res = new ArrayList<>();

        for (Adverts ad: all) {
            if (Objects.equals(animalsRepository.findAnimalsByID(ad.getANIMALS()).getTYPE(), animalsTypeRepository.findAnimalTypeByTYPE(type).getID())){
                res.add(getAdById(ad.getID()));
            }
        }
        return res;
    }

    @Override
    public ArrayList<Responce> getAdByVolunteer(Integer userId) {
        ArrayList<Adverts> all = new ArrayList<>(advertsRepository.findAllByVLNTR(userId));
        ArrayList<Responce> res = new ArrayList<>();
        for (Adverts ad: all) {
            res.add(getAdById(ad.getID()));
        }
        return res;
    }

    @Override
    public Responce getAdById(Integer id) {
        Adverts ad = advertsRepository.findAdvertsByID(id);
        Volunteers vol = volonteersRepository.findVolunteersByID(ad.getVLNTR());
        Animals animals = animalsRepository.findAnimalsByID(ad.getANIMALS());
        AnimalType type = animalsTypeRepository.findAnimalTypeByID(animals.getTYPE());
        Volunteers user = volonteersRepository.findVolunteersByID(ad.getVLNTR());
        PhoneNumber num = phoneNumberRepository.findPhoneNumberByVLNTR(user.getID());
        City city = cityRepository.findCityByID(animals.getCITY());
        return new Responce(animals, city, type, user, ad, num);
    }
}
