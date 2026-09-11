package com.polymorphism;
import java.util.Scanner;

/**
 * PaymentMOV - Demonstrates METHOD OVERRIDING (Runtime Polymorphism) along with
 * EVERY major overriding rule covered in the Core Java notes:
 *
 *  1) final method       -> CANNOT be overridden
 *  2) private method     -> NOT inherited, so "redefining" it in a child is NOT overriding
 *  3) static method      -> redefining it is METHOD HIDING, not overriding (resolved at compile time)
 *  4) covariant return   -> overriding method may return a SUBTYPE of the parent's return type (Java 1.5+)
 *  5) access modifier    -> overriding method can WIDEN access (protected -> public), never narrow it
 *  6) checked exceptions -> overriding method can throw the SAME/NARROWER checked exception, or none
 *  7) varargs             -> can only override a vararg method with another vararg method
 *  8) dynamic dispatch    -> parent reference, child object -> actual method resolved at RUNTIME
 *  9) Object class method -> toString() can be overridden by any class
 */
public class PaymentMOV {
    static Scanner sc = new Scanner(System.in);

    // ---------- Rule 1: FINAL method -> cannot be overridden by any child ----------
    final void printFooter() {
        System.out.println("---- Thank you for using SecurePay ----");
    }

    // ---------- Rule 2: PRIVATE method -> not inherited, so it's simply unavailable to children ----------
    private void logTransaction() {
        System.out.println("[LOG] Generic transaction recorded.");
    }

    // ---------- Rule 3: STATIC method -> redefining with same signature in child = METHOD HIDING ----------
    static String getGatewayVersion() {
        return "Gateway v1.0 (Generic)";
    }

    // ---------- Rule 4: covariant return type base case (Object here, narrowed to String in child) ----------
    Object getPaymentSummary() {
        return "Generic payment summary";
    }

    // ---------- Rule 5: protected here -> children may widen this to public, but never narrow it ----------
    protected void authenticate() {
        System.out.println("Generic authentication check.");
    }

    // ---------- Rule 6: declares a checked exception -> overriders may throw same/narrower/none ----------
    void validateGateway() throws PaymentException {
        System.out.println("Validating generic payment gateway...");
    }

    // ---------- Rule 7: vararg method -> can only be overridden by another vararg method ----------
    void printAmounts(double... amounts) {
        for (double a : amounts) {
            System.out.println("Amount: " + a);
        }
    }

    // ---------- Rule 9: every class inherits toString() from Object and can override it ----------
    @Override
    public String toString() {
        return "PaymentMOV[genericPaymentRecord]";
    }

    void getCustomerDetails() {
        System.out.println("Enter customer name.");
        String customername = sc.next();
        System.out.println("Enter amount");
        double amount = sc.nextDouble();
    }

    // The core method every subclass overrides -> classic runtime polymorphism
    void pay() {
        System.out.println("Payment Done Successfully!!");
    }

    public static void main(String[] args) throws PaymentException {

        // Rule 8: DYNAMIC METHOD DISPATCH -> a PARENT type reference can hold ANY CHILD object.
        // Which pay() actually runs is decided by the JVM at RUNTIME based on the real object,
        // not by the reference type (that's what makes overriding "runtime polymorphism").
        PaymentMOV p;

        System.out.println("choose any one PaymentMethod: \n1:Creditcard\n2:UPI\n3:NetBanking");
        int choice = sc.nextInt();

        switch (choice) {
            case 1 -> p = new Creditcard();
            case 2 -> p = new UPI();
            case 3 -> p = new NetBanking();
            default -> {
                System.out.println("Invalid Input");
                return;
            }
        }

        p.getCustomerDetails();

        // Runtime polymorphism in action: same call, different behaviour per actual object
        p.pay();

        // final method: always runs PaymentMOV's own version - cannot be overridden by any child
        p.printFooter();

        // private method: only PaymentMOV's own logTransaction() is ever accessible here - not polymorphic
        p.logTransaction();

        // static method: resolved by REFERENCE TYPE at compile time (method hiding, not overriding)
        System.out.println(PaymentMOV.getGatewayVersion());

        // covariant return type: overridden version can legally return a more specific type
        System.out.println("Summary: " + p.getPaymentSummary());

        // access modifier widened from protected (parent) to public (child) - legal
        p.authenticate();

        // checked exception rule in action
        p.validateGateway();

        // vararg overriding in action
        p.printAmounts(100.0, 250.5, 999.99);

        // Overridden toString() - prints child's version when p is actually a Creditcard etc.
        System.out.println(p);
    }
}

/**
 * Custom checked exception used to demonstrate the "overriding + exceptions" rule:
 * an overriding method may throw the SAME checked exception, a SUBCLASS of it, or NONE -
 * but never a NEW or BROADER checked exception than the parent declared.
 */
class PaymentException extends Exception {
    public PaymentException(String message) {
        super(message);
    }
}

class Creditcard extends PaymentMOV {

    // Rule 4: covariant return type - parent returns Object, child returns String (a subtype) - LEGAL
    @Override
    String getPaymentSummary() {
        return "Credit Card Payment Summary";
    }

    // Rule 5: access widened protected -> public - LEGAL (narrowing public -> protected would NOT compile)
    @Override
    public void authenticate() {
        System.out.println("Credit Card OTP authentication passed.");
    }

    // Rule 6: same checked exception as parent - LEGAL
    @Override
    void validateGateway() throws PaymentException {
        System.out.println("Validating Credit Card gateway...");
    }

    // Rule 7: overriding a vararg method requires another vararg method - LEGAL
    @Override
    void printAmounts(double... amounts) {
        System.out.println("Credit Card amounts (with currency):");
        for (double a : amounts) {
            System.out.println("  Rs. " + a);
        }
    }

    // Rule 3: static method with the SAME signature as parent's static method = METHOD HIDING,
    // NOT overriding. Resolved by reference/class type at compile time. No @Override here on purpose -
    // the compiler would flag @Override as invalid on a static method anyway.
    static String getGatewayVersion() {
        return "Gateway v2.1 (Credit Card)";
    }

    // Rule 2: a private method with the same name as parent's private one is just a new,
    // unrelated method local to this class - NOT overriding, since private methods aren't inherited.
    private void logTransaction() {
        System.out.println("[LOG] Credit card transaction recorded separately.");
    }

    @Override
    public String toString() {
        return "Creditcard[secureCardPaymentRecord]";
    }

    @Override
    void pay() {
        System.out.println("Enter card Number");
        String cardnumber = sc.next();
        System.out.println("Enter cvv Number");
        String cvv = sc.next();
        System.out.println("Enter expirydate");
        String expirydate = sc.next();
        if (cardnumber.matches("[0-9]{16}") &&
            cvv.matches("[0-9]{3}") &&
            expirydate.matches("^(0[1-9]|1[0-2])\\/[0-9]{2}$")) {
            System.out.print("Processing Credit Card Payment...\n"
                           + "Checking Card Number...\n"
                           + "Validating CVV...\n"
                           + "Amount Paid Successfully.\n");
        } else {
            System.out.println("Invalid Details");
        }
    }

    // Rule 1 in practice: printFooter() is FINAL in PaymentMOV, so it CANNOT be overridden here.
    // Uncommenting the block below would give a compile-time error:
    // @Override
    // void printFooter() { }   // <-- ILLEGAL: overriding a final method
}

class UPI extends PaymentMOV {
    @Override
    void pay() {
        System.out.println("Enter UPI ID");
        String UPIID = sc.next();
        if (UPIID.matches("[a-zA-Z0-9.\\-_]{2,256}@[a-zA-Z]{2,64}")) {
            System.out.print("Validating UPI ID...\n"
                           + "Amount Paid Successfully.\n");
        } else {
            System.out.println("Invalid Details");
        }
    }

    @Override
    public String toString() {
        return "UPI[upiPaymentRecord]";
    }
}

class NetBanking extends PaymentMOV {
    String bankname, accountnumber;

    void getBankDetails() {
        System.out.println("Enter Bankname");
        bankname = sc.next();
        System.out.println("Enter AccountNumber");
        accountnumber = sc.next();
        System.out.println(bankname);
        System.out.println(accountnumber);
    }

    @Override
    void pay() {
        getBankDetails();
        if (accountnumber.matches("^[0-9]{9,18}$")) {
            System.out.print("Validating Account Number...\n"
                           + "Amount Paid Successfully.\n");
        } else {
            System.out.println("Invalid Details");
        }
    }

    @Override
    public String toString() {
        return "NetBanking[" + bankname + "]";
    }
}