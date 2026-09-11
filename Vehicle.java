package com.abstraction;
public interface Vehicle {

    int MAX_SPEED = 180; // implicitly public static final

    void start();          // implicitly public abstract
    void stop();

    // default method - implementing classes get this for free, can override it
    default void honk() {
        System.out.println("Beep beep!");
    }

    // static method - called on the interface itself
    static void showMaxSpeedLimit() {
        System.out.println("Max speed limit for all vehicles: " + MAX_SPEED);
    }
}

