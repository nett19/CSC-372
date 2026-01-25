package mod6;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();

        // 10 Student objects
        students.add(new Student(10, "Zane", "123 Maple St"));
        students.add(new Student(9, "Alice", "456 Oak Ave"));
        students.add(new Student(8, "Charlie", "789 Pine Ln"));
        students.add(new Student(7, "Bob", "321 Elm St"));
        students.add(new Student(6, "Eve", "654 Birch Dr"));
        students.add(new Student(5, "David", "987 Cedar Rd"));
        students.add(new Student(4, "Yara", "159 Walnut Ct"));
        students.add(new Student(3, "Frank", "753 Aspen Blvd"));
        students.add(new Student(2, "Grace", "246 Willow Wy"));
        students.add(new Student(1, "Heidi", "357 Cherry Cir"));

        System.out.println("--- Original List ---");
        students.forEach(System.out::println);

        // Sort by Name
        SelectionSort.sort(students, new NameComparator());
        System.out.println("\n--- Sorted by Name ---");
        students.forEach(System.out::println);

        // Sort by Roll Number
        SelectionSort.sort(students, new RollNoComparator());
        System.out.println("\n--- Sorted by Roll Number ---");
        students.forEach(System.out::println);
    }
}