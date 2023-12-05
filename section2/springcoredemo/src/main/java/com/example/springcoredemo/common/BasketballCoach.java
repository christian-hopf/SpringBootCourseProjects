package com.example.springcoredemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Lazy
//@Primary
public class BasketballCoach implements Coach {

    public BasketballCoach() {
        System.out.println("BasketballCoach constructor");
    }

    @Override
    public String getWorkout() {
        return "Practice basketball";
    }
}
