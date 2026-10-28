package library;
//Simplified verion of Library Management System

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class LibraryApp {

    public static void main(String[] args) {

        Library library = new Library();
        LibrarianController controller = new LibrarianController(library);

        System.out.println(" *** Library management system demo *** ");

        // Adding some books to the catalog
        System.out.println("\n *** Adding \"Dune\" to the library:");
        library.addBook("Dune", "Frank Herbert");

        System.out.println("\n *** Adding \"1984\" to the library:");
        library.addBook("1984", "George Orwell");

        System.out.println("\n *** Adding \"Moby Dick\" to the library:");
        library.addBook("Moby Dick", "Herman Melville");

        // Show available books
        System.out.println("\n *** Show all books:");
        library.showAvailableBooks();

        // Adding members
        System.out.println("\n *** Adding \"Alice\" to the library members");
        library.registerMember("M001", "Alice");

        System.out.println("\n *** Adding \"Bob\" to the library members");
        library.registerMember("M002", "Bob");

        // Show members
        System.out.println("\n *** Show all members");
        library.showMembers();

        // Borrow a book
        System.out.println("\n *** Alice borrows Dune:");
        library.borrowBook("Dune", "Alice");

        // Show available books after borrowing
        System.out.println("\n *** Show all books:");
        library.showAvailableBooks();

        System.out.println("\n *** Bob borrows 1984:");
        library.borrowBook(findMember().memberId, "1984");

        // Show available books after borrowing
        System.out.println("\n *** Show all books:");
        library.showAvailableBooks();

        System.out.println("\nBob borrows Dune:");
        library.borrowBook(findMember().memberId, "Dune");

        // Show available books after borrowing
        System.out.println("\n *** Show all books:");
        library.showAvailableBooks();

        // Return a book
        System.out.println("\n *** Alice returns Dune:");
        library.returnBook("M002", "Dune");

        // Show available books after returning
        System.out.println("\n *** Show all books:");
        library.showAvailableBooks();

        System.out.println("\n *** Bob borrows Dune:");
        library.borrowBook("M001", "Dune");

        // Show available books after borrowing
        System.out.println("\n *** Show all books:");
        library.showAvailableBooks();

    }
}