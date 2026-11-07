package library;

import java.util.ArrayList;
import java.util.List;

public class Library {

	// GRASP Principles: Creator, Controller
	// Manage the catalog of books and members.
	// Track which books are borrowed and available

	// Attributes:
	// private catalog (list of Book)
	// private members (list of Members)

	// TODO: implement functionality of Member class

	private List<Book> catalog;
	private List<Member> members;

	public Library() {
		catalog = new ArrayList<>();
		members = new ArrayList<>();
	}

	public void addBook(String title, String author) {
		Book newBook = new Book(title, author, true);
		catalog.add(newBook);
	}

	public void removeBook(Book book) {
		catalog.remove(book);
	}

	public void registerMember(String memberId, String name) {
		Member newMember = new Member(memberId, name, new ArrayList<>());
		members.add(newMember);
	}

	public void removeMember(Member member) {
		members.remove(member);
	}

	public Book findBookByTitle(String title) {
		for (Book b : catalog) {
			if (b.getTitle().equals(title)) {
				return b;
			}
		}
		return null;
	}

	public Member findMember(String memberId) { 
		for (Member m : members) {
			if (m.getMemberID().equals(memberId)) { 
				return m;
			}
		}
		return null;
	}

	public List<Book> getAvailableBooks() {
		List<Book> available = new ArrayList<>();
		for (Book b : catalog) {
			if (b.getAvailable()) {
				available.add(b);
			}
		}
		return available;
	}

	public boolean borrowBook(String memberId, String title) {
		Member member = findMember(memberId);
		Book book = findBookByTitle(title);

		if (member != null && book != null) {
			return member.borrowBook(book);
		}
		return false;
	}

	public boolean returnBook(String memberId, String title) {
		Member member = findMember(memberId);
		Book book = findBookByTitle(title);

		if (member != null && book != null) {
			return member.returnBook(book);
		}
		return false;
	}

	public void showAvailableBooks() {
		System.out.println("Available Books:");
		for (Book b : getAvailableBooks()) {
			System.out.println("- " + b.getTitle());
		}
	}

	public void showMembers() {
		System.out.println("Library members:");
		for (Member m : members) {
			System.out.println("- " + m.getName() + " (ID: " + m.getMemberID() + ")");
		}
	}
}
