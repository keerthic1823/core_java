package com.exceptionhandling;

public class BankAccount {

    private String accountNo;
    private double balance;

    public BankAccount(String accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException(
                    "Insufficient balance in account " + accountNo + ". Available: " + balance);
        }
        balance -= amount;
        System.out.println("Withdrawn: " + amount + " | Remaining balance: " + balance);
    }
}
