package com.abstraction;

public class Car implements Vehicle {

    private String model;

    public Car(String model) {
        this.model = model;
    }

    @Override
    public void start() {
        System.out.println(model + " started.");
    }

    @Override
    public void stop() {
        System.out.println(model + " stopped.");
    }
    // honk() is inherited as-is from the interface default method
}

