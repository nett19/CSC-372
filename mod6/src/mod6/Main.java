package mod6;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<User> user = new ArrayList<>();

        // 10 Student objects
        user.add(new User(10, "Zane", "Joined 01/08/2020"));
        user.add(new User(9, "Alice", "Joined 10/09/2020"));
        user.add(new User(8, "Charlie", "Joined 08/27/2010"));
        user.add(new User(7, "Bob", "Joined 12/20/2025"));
        user.add(new User(6, "Eve", "Joined 11/03/2021"));
        user.add(new User(5, "David", "Joined 04/19/2018"));
        user.add(new User(4, "Yara", "Joined 10/09/2009"));
        user.add(new User(3, "Frank", "Joined 09/10/2021"));
        user.add(new User(2, "Grace", "Joined 02/02/2001"));
        user.add(new User(1, "Heidi", "Joined 09/04/2007"));

        System.out.println("--- Original List ---");
        user.forEach(System.out::println);

        // Sort by Name
        SelectionSort.sort(user, new NameComparator());
        System.out.println("\n--- Sorted by Name ---");
        user.forEach(System.out::println);

        // Sort by Roll Number
        SelectionSort.sort(user, new RollNoComparator());
        System.out.println("\n--- Sorted by Roll Number ---");
        user.forEach(System.out::println);
    }
}