package com.polymorphism;
public class MOL {
    public int add(int a, int b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }
    public double add(double a, double b) {
        return a + b;
    }
    public void display(String name, int age) {
        System.out.println("Name: " + name + ", Age: " + age);
    }
    public void display(int age, String name) {
        System.out.println("Age: " + age + ", Name: " + name);
    }
    public static void main(String[] args) {
        MOL d = new MOL();

        System.out.println("add(2,3) = " + d.add(2, 3));
        System.out.println("add(2,3,4) = " + d.add(2, 3, 4));
        System.out.println("add(2.5,3.5) = " + d.add(2.5, 3.5));

        d.display("Ravi", 24);
        d.display(24, "Ravi");
    }
}

