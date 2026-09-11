package com.exceptionhandling;

/**
 * Custom CHECKED exception (extends Exception, not RuntimeException).
 * Callers are forced to handle it (throws / try-catch) at compile time.
 * This pattern is very commonly asked about in interviews.
 */
public class InsufficientBalanceException extends Exception {

    public InsufficientBalanceException(String message) {
        super(message);
    }
}
