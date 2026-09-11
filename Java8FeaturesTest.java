package com.java8features;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class Java8FeaturesTest {

    public static void main(String[] args) {

        // 1. Lambda Expressions + Functional Interface
        // Functional interface = exactly ONE abstract method (e.g. Runnable, Comparator, or custom)
        Calculator addition = (a, b) -> a + b;
        Calculator multiplication = (a, b) -> a * b;
        System.out.println("5 + 3 = " + addition.operate(5, 3));
        System.out.println("5 * 3 = " + multiplication.operate(5, 3));

        // Built-in functional interfaces
        Function<Integer, Integer> square = x -> x * x;
        Predicate<Integer> isEven = x -> x % 2 == 0;
        Consumer<String> printer = msg -> System.out.println("Consumed: " + msg);
        Supplier<String> greeting = () -> "Hello from Supplier!";

        System.out.println("square(6) = " + square.apply(6));
        System.out.println("isEven(7) = " + isEven.test(7));
        printer.accept("Java 8 rocks");
        System.out.println(greeting.get());

        System.out.println("--------------------");

        // 2. Stream API - filter, map, sorted, collect
        List<String> names = Arrays.asList("Ravi", "Priya", "Kiran", "Anil", "Sneha");

        List<String> result = names.stream()
                .filter(name -> name.length() > 4)     // keep names longer than 4 chars
                .map(String::toUpperCase)                // transform to uppercase
                .sorted()                                 // sort alphabetically
                .collect(Collectors.toList());            // gather into a List

        System.out.println("Filtered + mapped + sorted: " + result);

        // Sum of squares of even numbers using Stream - classic interview POC
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int sumOfSquaresOfEvens = numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(n -> n * n)
                .sum();
        System.out.println("Sum of squares of even numbers: " + sumOfSquaresOfEvens);

        System.out.println("--------------------");

        // 3. Optional - avoids NullPointerException, forces explicit null-handling
        Optional<String> optionalName = findNameById(2);
        System.out.println("Found: " + optionalName.orElse("No name found"));

        Optional<String> missingName = findNameById(99);
        System.out.println("Found: " + missingName.orElse("No name found"));
    }

    static Optional<String> findNameById(int id) {
        Map<Integer, String> data = Map.of(1, "Ravi", 2, "Priya", 3, "Kiran");
        return Optional.ofNullable(data.get(id));
    }

    // Custom functional interface for the lambda demo above
    @FunctionalInterface
    interface Calculator {
        int operate(int a, int b);
    }
}

