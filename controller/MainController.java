package com.example.diplomalbina.controller;

import com.example.diplomalbina.model.Responce;
import com.example.diplomalbina.model.Volunteers;
import com.example.diplomalbina.service.AdvertsService;
import com.example.diplomalbina.service.VolunteersService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class MainController {

    private VolunteersService volunteersService;
    private AdvertsService advertsService;

    @Autowired
    public MainController(VolunteersService volunteersService, AdvertsService advertsService) {
        this.volunteersService = volunteersService;
        this.advertsService = advertsService;
    }

    @GetMapping("/main")
    public String getMainPage(){
        return "main";
    }

    @GetMapping("/main2")
    public String getMain2Page(){
        return "main2";
    }

    @GetMapping("/choice")
    public String getcChoicePage(){
        return "choice";
    }

    @GetMapping("/choice2")
    public String getChoice2Page(){
        return "choice2";
    }


    @GetMapping("/registration")
    public String getRegistrationPage(){ return "registration"; }

    @GetMapping("/login")
    public String getLoginPage(){ return "login"; }

    @GetMapping("/form")
    public String getForm(){ return "form"; }

    @PostMapping("/login")
    public String postLogin(HttpServletResponse httpServletResponse, @RequestParam String email, @RequestParam String password) {
        Cookie volunteersCookie = volunteersService.login(email, password);
        if (volunteersCookie != null){
            httpServletResponse.addCookie(volunteersCookie);
            return "redirect:/main2";
        } else {
            return "redirect:/404";
        }
    }

    @PostMapping("/registration")
    public String postRegistration(@RequestParam String email, @RequestParam String phone, @RequestParam String name, @RequestParam String sname, @RequestParam String pname, @RequestParam String password, Model model) {
        Volunteers result = volunteersService.registr(email,name,sname, pname, password, phone);
        if (result!= null) {
            model.addAttribute("volunteer", result);
        }
        return "redirect:/main2";
    }

    @GetMapping("/logout")
    public String logOut(HttpServletResponse httpServletResponse){
        Cookie cookie = new Cookie("userId", "");
        cookie.setMaxAge(0);
        httpServletResponse.addCookie(cookie);
        return "redirect:/main";
    }

    @PostMapping("/create-adv")
    public String postAdv(@CookieValue("userId") String userId, @RequestParam String animalName,
                          @RequestParam String animalAge, @RequestParam String animalHistory,
                          @RequestParam String animalType, @RequestParam String animalPhoto,
                          @RequestParam String animalCity,  @RequestParam String animalCityType,
                          @RequestParam String details, @RequestParam String date, Model model) {
        Responce resp = advertsService.createAdvert(Integer.parseInt(userId), animalName, Integer.parseInt(animalAge), animalHistory, animalType, animalPhoto, animalCity, animalCityType, details, date);
        model.addAttribute("volunteer", resp.getVolunteers());
        return "redirect:/profile";
    }


    @GetMapping("/delete-adv/{id}")
    public String deleteAdv(@PathVariable String id) {
        advertsService.deleteAdvert(Integer.parseInt(id));
        return "redirect:/profile";
    }

    @GetMapping("/profile")
    public String getMyAdv(@CookieValue("userId") String userId, Model model) {
        ArrayList<Responce> res = advertsService.getAdByVolunteer(Integer.parseInt(userId));
        model.addAttribute("Responce", res);
        return "profile";
    }

    @GetMapping("/cat")
    public String getAdvertsByType( Model model){
        ArrayList<Responce> res = advertsService.getAllAdByType("Cats");
        model.addAttribute("Responce", res);
        return "cat";
    }

    @GetMapping("/cat2")
    public String getAdvertsByType2( Model model){
        ArrayList<Responce> res = advertsService.getAllAdByType("Cats");
        model.addAttribute("Responce", res);
        return "cat2";
    }

    @GetMapping("/dog")
    public String getAdvertsByType3( Model model){
        ArrayList<Responce> res = advertsService.getAllAdByType("Dogs");
        model.addAttribute("Responce", res);
        return "dog";
    }

    @GetMapping("/dog2")
    public String getAdvertsByType4( Model model){
        ArrayList<Responce> res = advertsService.getAllAdByType("Dogs");
        model.addAttribute("Responce", res);
        return "dog2";
    }

    @GetMapping("/otheranimals")
    public String getAdvertsByType5( Model model){
        ArrayList<Responce> res = advertsService.getAllAdByType("Others");
        model.addAttribute("Responce", res);
        return "otheranimals";
    }

    @GetMapping("/otheranimals2")
    public String getAdvertsByType6( Model model){
        ArrayList<Responce> res = advertsService.getAllAdByType("Others");
        model.addAttribute("Responce", res);
        return "otheranimals2";
    }

}
