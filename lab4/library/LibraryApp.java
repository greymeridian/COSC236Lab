package library;

public class LibraryApp {

    public static void main(String[] args) {
        Library library = new Library();
        LibrarianController controller = new LibrarianController(library);

        // Creator: Library creates and manages books and members.
        library.addBook("Dune", "Frank Herbert");
        library.addBook("1984", "George Orwell");
        library.addBook("Moby Dick", "Herman Melville");

        library.registerMember("M001", "Alice");
        library.registerMember("M002", "Bob");

        System.out.println("Added Alice and Bob.");
        showAvailableBooks(library);

        // Look up a book and a member.
        Book dune = library.findBookByTitle("Dune");
        if (dune != null) {
            System.out.println(
                "Found book: " + dune.getTitle() + " by " + dune.getAuthor()
            );
        }

        Member alice = library.findMemberByName("Alice");
        if (alice != null) {
            System.out.println(
                "Found member: " + alice.getName()
                + " (" + alice.getMemberID() + ")"
            );
        }

        // Controller delegates borrowing to the domain objects.
        showResult("Alice borrows Dune",
            controller.borrowBook("M001", "Dune"));

        showResult("Bob borrows 1984",
            controller.borrowBook("M002", "1984"));

        // Reject the request because Dune is unavailable.
        showResult("Bob tries to borrow unavailable Dune",
            controller.borrowBook("M002", "Dune"));

        showAvailableBooks(library);

        // Reject removal while Alice has an outstanding loan.
        showResult("Remove Alice while she has Dune",
            library.removeMember("M001"));

        // Return the book, then let Bob borrow it.
        showResult("Alice returns Dune",
            controller.returnBook("M001", "Dune"));

        showResult("Bob borrows Dune",
            controller.borrowBook("M002", "Dune"));

        // Reject returning a book the member does not hold.
        showResult("Alice tries to return Bob's Dune",
            controller.returnBook("M001", "Dune"));

        // Reject removal of a borrowed book.
        showResult("Remove Dune while borrowed",
            library.removeBook("Dune"));

        showResult("Bob returns Dune",
            controller.returnBook("M002", "Dune"));

        showResult("Bob returns 1984",
            controller.returnBook("M002", "1984"));

        // Demonstrate successful book and member removal.
        showResult("Remove Moby Dick",
            library.removeBook("Moby Dick"));

        showResult("Remove Alice",
            library.removeMember("M001"));

        System.out.println("Alice no longer registered: "
            + (library.findMemberByName("Alice") == null));

        System.out.println("Moby Dick no longer in catalog: "
            + (library.findBookByTitle("Moby Dick") == null));

        showAvailableBooks(library);
    }

    private static void showResult(String action, boolean success) {
        System.out.println(action + ": "
            + (success ? "SUCCESS" : "REJECTED"));
    }

    private static void showAvailableBooks(Library library) {
        System.out.println("\nAvailable books:");

        for (Book book : library.getAvailableBooks()) {
            System.out.println(
                "- " + book.getTitle() + " by " + book.getAuthor()
            );
        }

        System.out.println();
    }
}