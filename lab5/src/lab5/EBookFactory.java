package lab5;

public class EBookFactory extends BookFactory {
	
	@Override
	public Book createBook(String title) {
		return new EBook(title);
	}
}
