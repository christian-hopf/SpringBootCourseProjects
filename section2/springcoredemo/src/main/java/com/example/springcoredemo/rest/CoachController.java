package com.example.springcoredemo.rest;

import com.example.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoachController {

    private Coach coach;
//    private Coach coach2;

    @Autowired
    public CoachController(@Qualifier("chess") Coach coach) {
        System.out.println("CoachController constructor");
        this.coach = coach;
//        this.coach2 = coach2;
    }
//    @Autowired
//    public void setCoach(Coach coach){
//        this.coach = coach;
//    }

    @GetMapping("/workout")
    public String getWorkout() {
        return this.coach.getWorkout();
    }

//    @GetMapping("/scopes")
//    public String checkBeanScopes() {
//        return "Comparing bean scopes: coach == coach2 is " + (coach == coach2);
//    }
}
