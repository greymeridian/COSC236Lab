package library;

public class Book {

	// GRASP Principle: Information Expert
	// Manages its own state (available or borrowed).
	private String title;
	private String author;
	private boolean isAvailable;

	// TODO: implement Book functionality
	public Book(String title, String author, boolean isAvailable) {
		this.title = title;
		this.author = author;
		this.isAvailable = true;
	}
	
	public void setIsAvailable(boolean b) {
		this.isAvailable = b;
	}
	
	public boolean borrow() {
		return isAvailable;
	}
	
	public void returnBook() {
		
	}
}
