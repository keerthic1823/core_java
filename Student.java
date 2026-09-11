package com.collectionframework;

public class Student implements Comparable<Student> {

    int rollNo;
    String name;
    double marks;

    public Student(int rollNo, String name, double marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }

    // Natural ordering - used when you just call Collections.sort(list)
    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.rollNo, other.rollNo);
    }

    @Override
    public String toString() {
        return rollNo + " - " + name + " - " + marks;
    }
}
