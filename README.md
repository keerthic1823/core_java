# Core Java – Proof of Concepts

A collection of small, focused Java programs demonstrating core Java concepts: OOP principles, exception handling, collections, multithreading, Java 8 features, and string handling.

---

## Encapsulation

Demonstrates data hiding using private fields with public getters/setters, so an object's internal state can only be accessed or changed through controlled methods.

**Files:** `Customer.java`, `CustomerTest.java`

---

## Polymorphism – Overriding

A multi-gateway payment example (Credit Card, UPI, NetBanking) showing runtime polymorphism, where the same method call behaves differently depending on the actual object type (dynamic method dispatch).

**Files:** `PaymentMOV.java`

---

## Polymorphism – Overloading

Shows compile-time polymorphism by defining multiple methods with the same name but different parameter lists (varying count, type, or order). Also demonstrates the compiler's overload resolution order — exact match, then widening, then autoboxing, then varargs — only one type of match is possible at a time.

**Files:** `MOL.java`

---

## Abstraction

Uses abstract classes and interfaces to define a contract without specifying implementation details. Includes shape and vehicle examples, along with Java 8 default/static interface methods.

**Files:** `AbstractionTest.java`, `Shape.java`, `Circle.java`, `Rectangle.java`, `Vehicle.java`, `Car.java`, `Student.java`

---

## Exception Handling

A custom checked exception built for a simple BankAccount module, showing try-catch-finally and multi-catch blocks for handling error conditions like insufficient balance.

**Files:** `BankAccount.java`, `InsufficientBalanceException.java`, `ExceptionHandlingTest.java`

---

## Collections Framework

Examples using `ArrayList`, `HashSet`, and `HashMap`, along with custom sorting logic implemented via `Comparable` and `Comparator`.

**Files:** `CollectionFrameworkTest.java`

---

## Multithreading

Demonstrates creating concurrent threads using `Thread` and `Runnable`, and preventing race conditions on shared resources using `synchronized` methods.

**Files:** `MultithreadingTest.class`, `MyThread.class`, `MyRunnable.class`, `Counter.class`

---

## Java 8 Features

Covers lambda expressions, functional interfaces, and the Stream API (`filter`, `map`, `collect`) for processing collections in a declarative style.

**Files:** `Java8FeaturesTest.java`

---

## String Handling

Explores String immutability, the String pool, and mutable alternatives (`StringBuilder` / `StringBuffer`) for efficient string manipulation.

**Files:** `StringHandlingTest.java`

---

### Tech Stack
Java (Core Java, Java 8)

### How to Run
Each concept can be compiled and run independently using its corresponding `*Test.java` file, e.g.:
```bash
javac CustomerTest.java
java CustomerTest
```
