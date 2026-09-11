package com.stringhandling;

public class StringHandlingTest {

    public static void main(String[] args) {

        // 1. String immutability + String Pool
        String s1 = "Hello";
        String s2 = "Hello";
        String s3 = new String("Hello");

        System.out.println("s1 == s2 (both from pool): " + (s1 == s2));       // true
        System.out.println("s1 == s3 (s3 is new object): " + (s1 == s3));     // false
        System.out.println("s1.equals(s3) (content check): " + s1.equals(s3)); // true

        // Any "modification" actually creates a NEW string object
        String s4 = s1.concat(" World");
        System.out.println("s1 unchanged: " + s1);
        System.out.println("s4 is new object: " + s4);

        System.out.println("--------------------");

        // 2. StringBuilder - mutable, NOT thread-safe, faster
        StringBuilder sb = new StringBuilder("Java");
        sb.append(" is").append(" fun");
        sb.insert(0, "Learning ");
        sb.reverse();
        System.out.println("StringBuilder reversed: " + sb);
        sb.reverse(); // put it back
        System.out.println("StringBuilder final: " + sb);

        System.out.println("--------------------");

        // 3. StringBuffer - mutable, thread-safe (synchronized methods), slightly slower
        StringBuffer sbuf = new StringBuffer("Thread");
        sbuf.append("-Safe");
        System.out.println("StringBuffer: " + sbuf);

        System.out.println("--------------------");

        String text = "  Core Java POCs  ";
        System.out.println("trim(): [" + text.trim() + "]");
        System.out.println("toUpperCase(): " + text.trim().toUpperCase());
        System.out.println("substring(5): " + text.trim().substring(5));
        System.out.println("replace(): " + text.trim().replace("Java", "Java8+"));
        System.out.println("split by space: " + java.util.Arrays.toString(text.trim().split(" ")));
        System.out.println("charAt(0): " + text.trim().charAt(0));
        System.out.println("indexOf(\"Java\"): " + text.trim().indexOf("Java"));

        // Palindrome check - very common interview mini-POC
        System.out.println("--------------------");
        String word = "madam";
        System.out.println(word + " is palindrome? " + isPalindrome(word));
    }

    static boolean isPalindrome(String str) {
        return str.equals(new StringBuilder(str).reverse().toString());
    }
}
