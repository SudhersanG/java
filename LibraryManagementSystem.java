import java.util.ArrayList;
import java.util.Scanner;

class Book {

    private int id;
    private String title;
    private String author;
    private boolean available;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.available = true;
    }

    public int getId() {
        return id;
    }

    public boolean isAvailable() {
        return available;
    }

    public void issueBook() {
        available = false;
    }

    public void returnBook() {
        available = true;
    }

    @Override
    public String toString() {
        return "ID: " + id +
               ", Title: " + title +
               ", Author: " + author +
               ", Available: " + available;
    }
}

public class LibraryManagementSystem {

    static ArrayList<Book> books = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n====== Library Management System ======");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Delete Book");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addBook();
                    break;

                case 2:
                    viewBooks();
                    break;

                case 3:
                    searchBook();
                    break;

                case 4:
                    issueBook();
                    break;

                case 5:
                    returnBook();
                    break;

                case 6:
                    deleteBook();
                    break;

                case 7:
                    System.out.println("Thank you!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    public static void addBook() {

        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author Name: ");
        String author = sc.nextLine();

        Book b = new Book(id, title, author);

        books.add(b);

        System.out.println("Book added successfully.");
    }

    public static void viewBooks() {

        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        System.out.println("\n------ Book List ------");

        for (Book b : books) {
            System.out.println(b);
        }
    }

    public static void searchBook() {

        System.out.print("Enter Book ID to search: ");
        int id = sc.nextInt();

        for (Book b : books) {

            if (b.getId() == id) {
                System.out.println("Book Found: " + b);
                return;
            }
        }

        System.out.println("Book not found.");
    }

    public static void issueBook() {

        System.out.print("Enter Book ID to issue: ");
        int id = sc.nextInt();

        for (Book b : books) {

            if (b.getId() == id) {

                if (b.isAvailable()) {
                    b.issueBook();
                    System.out.println("Book issued successfully.");
                } else {
                    System.out.println("Book already issued.");
                }

                return;
            }
        }

        System.out.println("Book not found.");
    }

    public static void returnBook() {

        System.out.print("Enter Book ID to return: ");
        int id = sc.nextInt();

        for (Book b : books) {

            if (b.getId() == id) {

                if (!b.isAvailable()) {
                    b.returnBook();
                    System.out.println("Book returned successfully.");
                } else {
                    System.out.println("Book was not issued.");
                }

                return;
            }
        }

        System.out.println("Book not found.");
    }

    public static void deleteBook() {

        System.out.print("Enter Book ID to delete: ");
        int id = sc.nextInt();

        for (Book b : books) {

            if (b.getId() == id) {
                books.remove(b);
                System.out.println("Book deleted successfully.");
                return;
            }
        }

        System.out.println("Book not found.");
    }
}