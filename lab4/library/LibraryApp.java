package library;
//Simplified verion of Library Management System

import java.util.ArrayList;
import java.util.HashMap;

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

//Show members of in the library
public void showMembers() {
   System.out.println("Library members:");
   for (String member : memberBorrowedBooks.keySet()) {
       System.out.println(member);
   }
}

public static void main(String[] args) {

	 LibraryApp library = new LibraryApp();

	 System.out.println(" *** Library management system demo *** ");

    // Adding some books to the catalog
	System.out.println("\n *** Adding \"Dune\" to the library:");
	library.addBook("Dune");

	System.out.println("\n *** Adding \"1984\" to the library:");
	library.addBook("1984");

	System.out.println("\n *** Adding \"Moby Dick\" to the library:");
    library.addBook("Moby Dick");

    // Show available books
    System.out.println("\n *** Show all books:");
    library.showAvailableBooks();

    // Adding members
    System.out.println("\n *** Adding \"Alice\" to the library members");
    library.addMember("Alice");

    System.out.println("\n *** Adding \"Bob\" to the library members");
    library.addMember("Bob");

    // Show members
    System.out.println("\n *** Show all members");
    library.showMembers();

    // Borrow a book
    System.out.println("\n *** Alice borrows Dune:");
    library.borrowBook("Dune", "Alice");

        System.out.println("\n *** Bob borrows 1984:");
        library.borrowBook(findMember().memberId, "1984");

    System.out.println("\n *** Bob borrows 1984:");
    library.borrowBook("1984", "Bob");

    // Show available books after borrowing
    System.out.println("\n *** Show all books:");
    library.showAvailableBooks();

    System.out.println("\nBob borrows Dune:");
    library.borrowBook("Dune", "Bob");

    // Show available books after borrowing
    System.out.println("\n *** Show all books:");
    library.showAvailableBooks();

    // Return a book
    System.out.println("\n *** Alice returns Dune:");
    library.returnBook("Dune", "Alice");

        System.out.println("\nBob borrows Dune:");
        library.borrowBook(findMember().memberId, "Dune");

    System.out.println("\n *** Bob borrows Dune:") ;
    library.borrowBook("Dune", "Bob");

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