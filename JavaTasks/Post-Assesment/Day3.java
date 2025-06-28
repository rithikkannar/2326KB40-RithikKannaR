
package Day3;

import java.util.*;

class Book {
    private String title;
    private boolean isIssued;

    public Book(String title) {
        this.title = title;
        this.isIssued = false;
    }

    public String getTitle() {
        return title;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public void issue() {
        isIssued = true;
    }

    public void returnBook() {
        isIssued = false;
    }
}

class Library {
    private Map<String, Book> books = new HashMap<>();

    public void addBook(String title) {
        if (!books.containsKey(title)) {
            books.put(title, new Book(title));
            System.out.println("Book added: " + title);
        } else {
            System.out.println("Book already exists.");
        }
    }

    public void removeBook(String title) {
        if (books.containsKey(title)) {
            books.remove(title);
            System.out.println("Book removed: " + title);
        } else {
            System.out.println("Book not found.");
        }
    }

    public void issueBook(String title) {
        Book book = books.get(title);
        if (book == null) {
            System.out.println("Book not found.");
        } else if (book.isIssued()) {
            System.out.println("Book is already issued.");
        } else {
            book.issue();
            System.out.println("Book issued: " + title);
        }
    }

    public void showBooks() {
        if (books.isEmpty()) {
            System.out.println("Library is empty.");
        } else {
            System.out.println("\nBooks in Library:");
            for (Book book : books.values()) {
                String status = book.isIssued() ? "Issued" : "Available";
                System.out.println("- " + book.getTitle() + " (" + status + ")");
            }
        }
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Library lib = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Library Menu ===");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Issue Book");
            System.out.println("4. Show Books");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title to add: ");
                    String addTitle = scanner.nextLine();
                    lib.addBook(addTitle);
                    break;
                case 2:
                    System.out.print("Enter book title to remove: ");
                    String removeTitle = scanner.nextLine();
                    lib.removeBook(removeTitle);
                    break;
                case 3:
                    System.out.print("Enter book title to issue: ");
                    String issueTitle = scanner.nextLine();
                    lib.issueBook(issueTitle);
                    break;
                case 4:
                    lib.showBooks();
                    break;
                case 5:
                    System.out.println("Exiting system.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
