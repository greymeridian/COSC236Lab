package lab5;

public class AudioBookFactory extends BookFactory {
	
	@Override
	public Book createBook(String title) {
		return new AudioBook(title);
	}
}
