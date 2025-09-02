package Controller;

import Model.Book;
import Repository.BookRepository;
import Service.BookService;

import java.util.List;
import java.util.Scanner;

public class BookController {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        BookRepository bookRepository = new BookRepository();
        BookService bookService = new BookService(bookRepository);

        boolean running = true;
        while (running) {
            System.out.println("\n--- Book Library Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. Show All Books");
            System.out.println("3. Find Book by ID");
            System.out.println("4. Delete Book by ID");
            System.out.println("5. Find Books by Author");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1->{
                    System.out.print("Enter Book ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();

                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();

                    System.out.print("Enter Year: ");
                    int year = scanner.nextInt();
                    scanner.nextLine();

                    bookService.save(id, title, author, year);
                    System.out.println("Book added successfully!");
                }
                case 2->{
                    List<Book> books = bookService.getAllBooks();
                    if (books.isEmpty()) {
                        System.out.println("No books found.");
                    } else {
                        books.forEach(System.out::println);
                    }
                }
                case 3->{
                    System.out.print("Enter Book ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    Book book = bookService.getBookById(id);
                    if (book == null) {
                        System.out.println("Book not found.");
                    }
                    else {
                        System.out.println(book);
                    }
                }
                case 4->{
                    System.out.print("Enter Book ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    boolean deleted = bookService.deleteBookById(id);
                    if (deleted){
                        System.out.println("Book deleted successfully!");
                    }
                    else{
                        System.out.println("Book with ID " + id + " not found.");
                    }
                }
                case 5->{
                    System.out.print("Enter Author name: ");
                    String author = scanner.nextLine();

                    List<Book> books = bookService.getBooksByAuthor(author);
                    if (books.isEmpty()) {
                        System.out.println("No books found.");
                    }
                    else {
                        books.forEach(System.out::println);
                    }
                }
                case 6->{
                    running = false;
                    System.out.println("Exiting program...");
                }
                default -> System.out.println("Invalid option! Try again.");
            }
        }
        scanner.close();
    }
}

