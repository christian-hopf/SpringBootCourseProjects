package com.example.springdemo.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DishController {

    @Value("${favorites.first}")
    private String firstFavorite;
    @Value("${favorites.second}")
    private String secondFavorite;
    @Value("${favorites.third}")
    private String thirdFavorite;

    @GetMapping("/hello")
    public String getHello() {
        return "hello";
    }

    @GetMapping("/")
    public String getDish() {
        return "Steak frites";
    }

    @GetMapping("/favorites")
    public String getFavoriteDishes() {
        return "Favorite dishes: 1. " + firstFavorite + ", 2. " + secondFavorite + ", 3. " + thirdFavorite;
    }

}
