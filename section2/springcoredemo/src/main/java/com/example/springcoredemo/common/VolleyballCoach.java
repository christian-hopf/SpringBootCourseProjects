package com.example.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//@Lazy
//@Primary
public class VolleyballCoach implements Coach {

    public VolleyballCoach() {
        System.out.println("VolleyballCoach constructor");
    }

//    @PostConstruct
//    public void onInit() {
//        System.out.println("@PostConstruct method in VolleyballCoach");
//    }
//
//    @PreDestroy
//    public void onDestroy() {
//        System.out.println("@PreDestroy method in VolleyballCoach");
//    }

    @Override
    public String getWorkout() {
        return "Practice volleyball";
    }
}
