package com.exceptionhandling;

public class ExceptionHandlingTest {

    public static void main(String[] args) {

        // 1. Custom checked exception
        BankAccount acc = new BankAccount("AC1001", 5000);
        try {
            acc.withdraw(7000);
        } catch (InsufficientBalanceException e) {
            System.out.println("Caught custom exception: " + e.getMessage());
        } finally {
            System.out.println("Withdraw attempt finished.\n");
        }

        // 2. Built-in exceptions + multi-catch
        int[] numbers = {1, 2, 3};
        try {
            System.out.println(10 / 0);           // ArithmeticException
            System.out.println(numbers[5]);        // ArrayIndexOutOfBoundsException
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught: " + e.getClass().getSimpleName() + " -> " + e.getMessage());
        }

        // 3. try-with-resources style behaviour of finally (always runs)
        try {
            String str = null;
            System.out.println(str.length());     // NullPointerException
        } catch (NullPointerException e) {
            System.out.println("Caught NPE: " + e.getMessage());
        } finally {
            System.out.println("This finally block ALWAYS executes.");
        }
    }
}
