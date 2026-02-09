package Library;

import java.util.ArrayList;

public class inventory {
    private ArrayList<Book> mainInventory = new ArrayList<>();
    private ArrayList<Book> borrowedBooks = new ArrayList<>();

    public void addBook(Book book) {
        mainInventory.add(book);
        System.out.println("Book added to the library.");
    }

    public void borrowBook(int id) {
        Book foundBook = null;
        for (Book b : mainInventory) {
            if (b.getId() == id) {
                foundBook = b;
                break;
            }
        }

        if (foundBook != null) {
            mainInventory.remove(foundBook);
            borrowedBooks.add(foundBook);
            System.out.println("Book successfully borrowed.");
        } else {
            System.out.println("Book not found.");
        }
    }

    public void returnBook(int id) {
        Book foundBook = null;
        for (Book b : borrowedBooks) {
            if (b.getId() == id) {
                foundBook = b;
                break;
            }
        }

        if (foundBook != null) {
            borrowedBooks.remove(foundBook);
            mainInventory.add(foundBook);
            System.out.println("Book successfully returned.");
        } else {
            System.out.println("Error: book not in library.");
        }
    }

    public void searchByTitle(String title) {
        boolean found = false;
        for (Book b : mainInventory) {
            if (b.getTitle().toLowerCase().contains(title.toLowerCase())) {
                b.printBookInfo();
                found = true;
            }
        }
        if (!found) System.out.println("No book found.");
    }

    public void printAll() {
        if (mainInventory.isEmpty()) {
            System.out.println("inventory is currently empty.");
        } else {
            for (Book b : mainInventory) {
                b.printBookInfo();
            }
        }
    }
}