package com.example.springcoredemo.config;

import com.example.springcoredemo.common.ChessCoach;
import com.example.springcoredemo.common.Coach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportsConfig {

    @Bean("chess")
    public Coach chessCoach() {
        return new ChessCoach();
    }
}
