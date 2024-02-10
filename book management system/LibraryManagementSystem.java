import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private int bookId;
    private boolean isCheckedOut;

    public Book(String title, String author, int bookId) {
        this.title = title;
        this.author = author;
        this.bookId = bookId;
        this.isCheckedOut = false;
    }

    // Getters and setters for book properties
    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public void checkOut() {
        isCheckedOut = true;
    }

    public void checkIn() {
        isCheckedOut = false;
    }
}

class Library {
    private List<Book> catalog;

    public Library() {
        catalog = new ArrayList<>();
    }

    public void addBook(Book book) {
        catalog.add(book);
    }

    public void listBooks() {
        for (Book book : catalog) {
            System.out.println("Book ID: " + book.getBookId());
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Checked Out: " + (book.isCheckedOut() ? "Yes" : "No"));
            System.out.println();
        }
    }

    public Book findBook(int bookId) {
        for (Book book : catalog) {
            if (book.getBookId() == bookId) {
                return book;
            }
        }
        return null;
    }

    public void checkOutBook(int bookId) {
        Book book = findBook(bookId);
        if (book != null && !book.isCheckedOut()) {
            book.checkOut();
            System.out.println("You've checked out the book: " + book.getTitle());
        } else {
            System.out.println("Book not available for checkout.");
        }
    }

    public void checkInBook(int bookId) {
        Book book = findBook(bookId);
        if (book != null && book.isCheckedOut()) {
            book.checkIn();
            System.out.println("You've checked in the book: " + book.getTitle());
        } else {
            System.out.println("Book is not checked out or doesn't exist.");
        }
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book("Book 1", "Author 1", 1);
        Book book2 = new Book("Book 2", "Author 2", 2);

        library.addBook(book1);
        library.addBook(book2);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Library Management System");
            System.out.println("1. List Books");
            System.out.println("2. Check Out Book");
            System.out.println("3. Check In Book");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    library.listBooks();
                    break;
                case 2:
                    System.out.print("Enter book ID to check out: ");
                    int checkOutId = scanner.nextInt();
                    library.checkOutBook(checkOutId);
                    break;
                case 3:
                    System.out.print("Enter book ID to check in: ");
                    int checkInId = scanner.nextInt();
                    library.checkInBook(checkInId);
                    break;
                case 4:
                    System.out.println("Exiting the Library Management System.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
