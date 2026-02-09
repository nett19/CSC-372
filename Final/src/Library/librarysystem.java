package Library;

import java.util.Scanner;

public class librarysystem {
    public static void main(String[] args) {
        inventory library = new inventory();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 6) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book      2. Borrow Book");
            System.out.println("3. Return Book   4. Search book Title");
            System.out.println("5. Print All     6. Exit");
            System.out.print("Enter choice: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("Enter ID: ");
                        int id = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter Title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter Author: ");
                        String author = scanner.nextLine();
                        System.out.print("Enter ISBN: ");
                        String isbn = scanner.nextLine();
                        System.out.print("Enter Pages: ");
                        int pages = Integer.parseInt(scanner.nextLine());
                        
                        library.addBook(new Book(id, title, author, isbn, pages));
                        break;
                    case 2:
                        System.out.print("Enter ID to borrow: ");
                        int bId = Integer.parseInt(scanner.nextLine());
                        library.borrowBook(bId);
                        break;
                    case 3:
                        System.out.print("Enter ID to return: ");
                        int rId = Integer.parseInt(scanner.nextLine());
                        library.returnBook(rId);
                        break;
                    case 4:
                        System.out.print("Enter title: ");
                        String sTitle = scanner.nextLine();
                        library.searchByTitle(sTitle);
                        break;
                    case 5:
                        library.printAll();
                        break;
                    case 6:
                        System.out.println("Exiting the program. See yah!");
                        break;
                    default:
                        System.out.println("Invalid option, Try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid numerical value.");
            } catch (Exception e) {
                System.out.println(" unexpected error occurred: " + e.getMessage());
            
        }
        scanner.close();
    }
    }
}