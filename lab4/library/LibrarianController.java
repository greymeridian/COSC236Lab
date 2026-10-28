package library;

public class LibrarianController {
	
	public Library library;
	
	public LibrarianController(Library library) {
		this.library = library;
	}
	// GRASP Controller: System event for borrowing a book
	public boolean borrowBook(String memberId, String title) {
		return library.borrowBook(memberId, title);
	} 
	// GRASP Controller: System event for returning a book
	public boolean returnBook(String memberId, String title) {
		return library.returnBook(memberId, title);
	}


}
