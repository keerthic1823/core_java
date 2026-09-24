package com.polymorphism;
public class MOL {
 // ---- Check 1: exact match exists alongside other candidates ----
    
    static void add(int a, int b) {
        System.out.println("EXACT MATCH: add(int,int) called");
    }
    static void add(long a, long b) {
        System.out.println("WIDENING: add(long,long) called");
    }
    static void add(double a, double b) {
        System.out.println("WIDENING: add(double,double) called");
    }
    static void add(Integer a, Integer b) {
        System.out.println("AUTOBOXING: add(Integer,Integer) called");
    }
    static void add(int... nums) {
        System.out.println("VARARGS: add(int...) called, count=" + nums.length);
    }

    // ---- Check 2: no exact match - only widening candidates ----
    static void widenOnly(long a, long b) {
        System.out.println("WIDENING: widenOnly(long,long) called");
    }
    static void widenOnly(double a, double b) {
        System.out.println("WIDENING: widenOnly(double,double) called");
    }

    // ---- Check 3: no exact match, no widening - widening vs autoboxing ----
    static void widenVsBox(long a, long b) {
        System.out.println("WIDENING: widenVsBox(long,long) called");
    }
    static void widenVsBox(Integer a, Integer b) {
        System.out.println("AUTOBOXING: widenVsBox(Integer,Integer) called");
    }

    // ---- Check 4: no widening possible - autoboxing vs varargs ----
    static void boxVsVarargs(Integer a, Integer b) {
        System.out.println("AUTOBOXING: boxVsVarargs(Integer,Integer) called");
    }
    static void boxVsVarargs(int... nums) {
        System.out.println("VARARGS: boxVsVarargs(int...) called, count=" + nums.length);
    }

    // ---- Check 5: nothing else fits - varargs is the only option ----
    static void varargsOnly(int... nums) {
        System.out.println("VARARGS: varargsOnly(int...) called, count=" + nums.length);
    }

    public static void main(String[] args) {
        System.out.println("--- Check 1: exact match wins even with others available ---");
        add(2, 3);

        System.out.println("--- Check 2: only widening candidates exist ---");
        widenOnly(2, 3);

        System.out.println("--- Check 3: widening beats autoboxing ---");
        widenVsBox(2, 3);

        System.out.println("--- Check 4: autoboxing beats varargs ---");
        boxVsVarargs(2, 3);

        System.out.println("--- Check 5: varargs is the last resort ---");
        varargsOnly(2, 3, 4, 5);
    }
}

