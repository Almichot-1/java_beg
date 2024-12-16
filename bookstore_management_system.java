import java.util.*;

abstract class Book {
    protected String bookname;
    protected String bookId;

    public Book(String bookname, String bookId) {
        this.bookId = bookId;
        this.bookname = bookname;
    }

    void Displaydatainfo() {
        System.out.println("Book name is: " + bookname);
        System.out.println("Book Id is: " + bookId);
    }
}

class ConcreteBook extends Book {
    public ConcreteBook(String bookname, String bookId) {
        super(bookname, bookId);
    }
}

public class Main {
    private static List<Book> books = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Enter your choice:");
            System.out.println("1. Add book");
            System.out.println("2. Edit the book");
            System.out.println("3. Delete the book");
            System.out.println("4. Display all books");
            System.out.println("5. Exit");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> addbook(scanner);
                case 2 -> Editbook(scanner);
                case 3 -> Deletebook(scanner);
                case 4 -> Displaybooks();
                case 5 -> System.out.println("Exiting the program...");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }

    private static void addbook(Scanner scanner) {
        scanner.nextLine(); // Consume the leftover newline from previous input
        System.out.println("Please enter the Book name:");
        String bookName = scanner.nextLine();
        System.out.println("Please enter the Book ID:");
        String bookId = scanner.nextLine();

        Book newBook = new ConcreteBook(bookName, bookId);
        books.add(newBook);

        System.out.println("Book added successfully!");
    }

    private static void Editbook(Scanner scanner) {
        scanner.nextLine(); // Consume leftover newline
        System.out.println("Enter the Book ID of the book you want to edit:");
        String bookId = scanner.nextLine();

        // Find the book with the given ID
        for (Book book : books) {
            if (book.bookId.equals(bookId)) {
                System.out.println("Book found. Enter new name:");
                String newName = scanner.nextLine();
                System.out.println("Enter new Book ID:");
                String newId = scanner.nextLine();

                book.bookname = newName;
                book.bookId = newId;

                System.out.println("Book updated successfully!");
                return;
            }
        }

        System.out.println("Book with ID " + bookId + " not found.");
    }

    private static void Deletebook(Scanner scanner) {
        scanner.nextLine(); // Consume leftover newline
        System.out.println("Enter the Book ID of the book you want to delete:");
        String bookId = scanner.nextLine();

        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.bookId.equals(bookId)) {
                iterator.remove();
                System.out.println("Book deleted successfully!");
                return;
            }
        }

        System.out.println("Book with ID " + bookId + " not found.");
    }

    private static void Displaybooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            System.out.println("Books in the library:");
            for (Book book : books) {
                book.Displaydatainfo();
                System.out.println("-------------------");
            }
        }
    }
}
