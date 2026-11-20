package lab5;

/**
 * Part 4 (Theo): Made EBook class implementing Book.
 **/
public class EBook implements Book {
	
	private String title;
	private boolean isAvailable;
	
	public EBook(String title) {
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
		return "EBook: " + title;
	}
	public void setIsAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public boolean getIsAvailable() {
		return isAvailable;
	}
}
