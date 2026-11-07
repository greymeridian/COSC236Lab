package library;
//Simplified verion of Library Management System

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

        // borrow a book
        System.out.println("\n *** Alice borrows Dune:");
        boolean success1 = controller.borrowBook("M001", "Dune");
        System.out.println("Success: " + success1);

        // show available books after borrowing
        System.out.println("\n *** Show all books:");
        library.showAvailableBooks();

        System.out.println("\n *** Bob borrows 1984:");
        boolean success2 = controller.borrowBook("M002", "1984");
        System.out.println("Success: " + success2);

        // show available books after borrowing
        System.out.println("\n *** Show all books:");
        library.showAvailableBooks();

        // use-case extension:(dune is already borrowed by alice == reject)
        System.out.println("\n *** Bob (M002) attempts to borrow Dune:");
        boolean success3 = controller.borrowBook("M002", "Dune");
        System.out.println("Success: " + success3 + " (Request Rejected)");

        // show available books
        System.out.println("\n *** Show all books:");
        library.showAvailableBooks();

        // return a book
        System.out.println("\n *** Alice (M001) returns Dune:");
        boolean success4 = controller.returnBook("M001", "Dune");
        System.out.println("Success: " + success4);

        // show available books after reterning
        System.out.println("\n *** Show all books:");
        library.showAvailableBooks();

        System.out.println("\n *** Bob (M002) borrows Dune:");
        boolean success5 = controller.borrowBook("M002", "Dune");
        System.out.println("Success: " + success5);

        // show available books after borrowing
        System.out.println("\n *** Show all books:");
        library.showAvailableBooks();

        // task 6: Lookup a book and lookup a member
        System.out.println("\n *** Lookup Member 'M001':");
        Member foundMember = library.findMember("M001");
        if (foundMember != null) {
            System.out.println("Found: " + foundMember.getName());
        }

        System.out.println("\n *** Lookup Book '1984':");
        Book foundBook = library.findBookByTitle("1984");
        if (foundBook != null) {
            System.out.println("Found: " + foundBook.getTitle());
        }
    }
}