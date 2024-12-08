import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Book class to represent each book in the catalog
class Book {
    private String title;
    private String author;

    // Constructor
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author;
    }
}

// LibraryCatalog class to manage the collection of books
class LibraryCatalog {
    private List<Book> books;

    // Constructor
    public LibraryCatalog() {
        this.books = new ArrayList<>();
    }

    // Method to add a book
    public void addBook(String title, String author) {
        books.add(new Book(title, author));
        System.out.println("Book added successfully!");
    }

    // Method to search books by title
    public void searchByTitle(String title) {
        boolean found = false;
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No book found with the title \"" + title + "\".");
        }
    }

    // Method to search books by author
    public void searchByAuthor(String author) {
        boolean found = false;
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No book found by the author \"" + author + "\".");
        }
    }

    // Method to list all books
    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the catalog.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }
}

// Main class
public class LibraryCatalogSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibraryCatalog catalog = new LibraryCatalog();
        int choice;

        do {
            // Display menu
            System.out.println("\nLibrary Catalog System");
            System.out.println("1. Add Book");
            System.out.println("2. Search by Title");
            System.out.println("3. Search by Author");
            System.out.println("4. List All Books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            // Handle user choice
            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    catalog.addBook(title, author);
                    break;
                case 2:
                    System.out.print("Enter title to search: ");
                    String searchTitle = scanner.nextLine();
                    catalog.searchByTitle(searchTitle);
                    break;
                case 3:
                    System.out.print("Enter author to search: ");
                    String searchAuthor = scanner.nextLine();
                    catalog.searchByAuthor(searchAuthor);
                    break;
                case 4:
                    System.out.println("Books in the catalog:");
                    catalog.listBooks();
                    break;
                case 5:
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
