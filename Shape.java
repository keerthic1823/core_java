package com.abstraction;

/**
 * Abstract class: can have abstract methods (no body) AND concrete methods.
 * Cannot be instantiated directly - must be extended.
 */
public abstract class Shape {

    String color;

    Shape(String color) {
        this.color = color;
    }

    // abstract method - every subclass MUST implement this
    abstract double area();

    // concrete method - shared by all subclasses, can be reused/overridden
    void describe() {
        System.out.println(this.getClass().getSimpleName() + " [" + color + "] Area = " + area());
    }
}

