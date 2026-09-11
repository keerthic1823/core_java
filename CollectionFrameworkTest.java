package com.collectionframework;

import java.util.*;

public class CollectionFrameworkTest {

    public static void main(String[] args) {

        // 1. ArrayList - ordered, allows duplicates, index-based
        List<String> fruits = new ArrayList<>();
        fruits.add("Mango");
        fruits.add("Apple");
        fruits.add("Mango"); // duplicate allowed
        System.out.println("ArrayList: " + fruits);

        // Iterating with Iterator
        Iterator<String> it = fruits.iterator();
        System.out.print("Iterator: ");
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        System.out.println("--------------------");

        // 2. HashSet - no duplicates, no guaranteed order
        Set<String> uniqueFruits = new HashSet<>(fruits);
        System.out.println("HashSet (duplicates removed): " + uniqueFruits);

        // TreeSet - no duplicates, sorted order
        Set<String> sortedFruits = new TreeSet<>(fruits);
        System.out.println("TreeSet (sorted): " + sortedFruits);

        System.out.println("--------------------");

        // 3. HashMap - key/value pairs, no duplicate keys
        Map<Integer, String> studentMap = new HashMap<>();
        studentMap.put(101, "Ravi");
        studentMap.put(102, "Priya");
        studentMap.put(101, "Ravi Updated"); // overwrites key 101

        for (Map.Entry<Integer, String> entry : studentMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("--------------------");

        // 4. Comparable vs Comparator
        List<Student> students = new ArrayList<>();
        students.add(new Student(103, "Kiran", 78.5));
        students.add(new Student(101, "Ravi", 92.0));
        students.add(new Student(102, "Priya", 85.5));

        // Comparable - natural order (sorts by rollNo, defined inside Student)
        Collections.sort(students);
        System.out.println("Sorted by rollNo (Comparable): " + students);

        // Comparator - custom order (sort by marks, defined here, no change to Student class needed)
        students.sort(Comparator.comparingDouble((Student s) -> s.marks).reversed());
        System.out.println("Sorted by marks desc (Comparator): " + students);
    }
}

