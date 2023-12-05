package com.example.springcoredemo.common;

public class ChessCoach implements Coach {

    public ChessCoach() {
        System.out.println("ChessCoach constructor");
    }

    @Override
    public String getWorkout() {
        return "Practice chess";
    }
}
