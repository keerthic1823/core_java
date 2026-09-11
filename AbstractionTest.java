package com.abstraction;

public class AbstractionTest {
    public static void main(String[] args) {

        // Abstract class - can't do "new Shape()", must use a subclass
        Shape s1 = new Circle("Red", 5);
        Shape s2 = new Rectangle("Blue", 4, 6);
        s1.describe();
        s2.describe();

        System.out.println("--------------------");

        // Interface
        Vehicle car = new Car("Tesla Model 3");
        car.start();
        car.honk();          // default method
        car.stop();
        Vehicle.showMaxSpeedLimit(); // static interface method
    }
}
