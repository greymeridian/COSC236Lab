package lab5;

/**
 * Part 3 (Ronny): Made PaperBook implement the Book interface
 * using its existing methods.
 **/
public class PaperBook implements Book {
	
	private String title;
	private boolean isAvailable;
	
	public PaperBook(String title) {
		this.title = title;
		this.isAvailable = true;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String toString() {
		return "PaperBook: " + title;
	}
	public void setIsAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public boolean getIsAvailable() {
		return isAvailable;
	}
}
