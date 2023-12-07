package com.supraja.com.AOPDemo.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TrafficFortuneServiceImpl implements  TrafficFortuneService{

    @Override
    public String getFortune() {
        return getFortune(false);
    }

    @Override
    public String getFortune(boolean tripWire) {

        // Simulate exception
        if (tripWire) {
            throw new RuntimeException("Exception thrown for Around Advice");
        }

        // simulate a delay
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // return a fortune
        return "Expected heavy traffic this morning";
    }
}
