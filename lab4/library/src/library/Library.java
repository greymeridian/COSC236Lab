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

	public Member findMember(String memberId) {
		for (Member m : members) {
			if (m.getMemberID().equals(memberId)) {
				return m;
			}
		}

		return null;
	}

	public void addBook(String title, String author) {
		Book b = new Book(title, author, true);
		catalog.add(b);
	}

	public void registerMember(String memberId, String name) {
		Member m = new Member(memberId, name, new ArrayList<>());
		members.add(m);
	}

	public boolean borrowBook(String memberId, String title) {
		Member m = findMember(memberId);
		Book b = findBookByTitle(title);
		if (m == null || b == null) {
			return false;
		}
		return m.borrowBook(b);
	}

	public boolean returnBook(String memberId, String title) {
		Member m = findMember(memberId);
		Book b = findBookByTitle(title);
		if (m == null || b == null) {
			return false;
		}
		return m.returnBook(b);
	}

	public boolean removeBook(String title) {
		Book b = findBookByTitle(title);
		if (b == null || !b.isAvailable()) {
			return false;
		}
		catalog.remove(b);
		return true;
	}

	public boolean removeMember(String memberId) {
		Member m = findMember(memberId);
		if (m == null || !m.getBorrowedBooks().isEmpty()) {
			return false;
		}
		members.remove(m);
		return true;
	}

}
