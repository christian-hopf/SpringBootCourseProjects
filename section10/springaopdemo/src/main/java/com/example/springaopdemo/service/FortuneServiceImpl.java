package com.example.springaopdemo.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class FortuneServiceImpl implements FortuneService {
    @Override
    public String getFortune() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            return "getFortune() interrupted";
        }
        return "You will sleep well tonight";
    }

    @Override
    public String getFortune(boolean flag) {
        if (flag) {
            throw new RuntimeException("Fortune error");
        }
        return "You will sleep well tonight";
    }
}
