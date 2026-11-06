package library;

import java.util.ArrayList;
import java.util.List;

public class Library {

	// GRASP Principles: Creator, Controller
	// Manage the catalog of books and members.
	// Track which books are borrowed and available

	private List<Book> catalog;
	private List<Member> members;

	public Library() {
		catalog = new ArrayList<>();
		members = new ArrayList<>();

	}

	public Book findBookByTitle(String title) {
		for (Book b : catalog) {
			if (b.getTitle().equalsIgnoreCase(title)) {
				return b;
			}
		}

		return null;
	}

	public Member findMemberByName(String name) {
		for (Member m : members) {
			if (m.getName().equalsIgnoreCase(name)) {
				return m;
			}
		}

		return null;
	}

	public List<Book> getAvailableBooks() {
		List<Book> available = new ArrayList<>();
		for (Book b : catalog) {
			if (b.isAvailable()) {
				available.add(b);
			}
		}
		
		return available;

	}

}
