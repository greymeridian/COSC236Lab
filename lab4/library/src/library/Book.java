package library;

public class Book {

	// GRASP Principle: Information Expert
	// Manages its own state (available or borrowed).
	private String title;
	private String author;
	private boolean isAvailable;

	// DONE: implement Book functionality
	public Book(String title, String author, boolean isAvailable) {
		this.title = title;
		this.author = author;
		this.isAvailable = isAvailable;
	}

	public void setIsAvailable(boolean b) {
		this.isAvailable = b;
	}

	public boolean borrow() {
		if (!isAvailable)
			return false;
		isAvailable = false;
		return true;
	}

	public void returnBook() {
		isAvailable = true;
	}

	public String getTitle() {
		return this.title;
	}

	public String getAuthor() {
		return this.author;
	}

	public boolean getAvailable() {
		return this.isAvailable;
	}
}
