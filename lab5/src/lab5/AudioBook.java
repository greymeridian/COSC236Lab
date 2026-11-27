package lab5;

/**
 * Part 4 (Theo): Made AudioBook class implementing Book.
 **/
public class AudioBook implements Book {
	
	private String title;
	private boolean isAvailable;
	
	public AudioBook(String title) {
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
		return "AudioBook: " + title;
	}
	public void setIsAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public boolean getIsAvailable() {
		return isAvailable;
	}
}
