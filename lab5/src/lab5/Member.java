package lab5;

import java.util.ArrayList;
import java.util.Iterator;

/*
 * Part 3 (Ronny): Member now uses the Book interface for its
 * borrowed-books list and its borrow and return methods.
 * Part 5 (Mike): Delegated borrowBooks and returnBook methods to BorrowingService class.
 * Part 6 (Aman): borrowBook and returnBook print the BorrowingBookResult from the service.
 */
public class Member {

	private String name;
	private ArrayList<Book> borrowedBooks; // Book interface dependency
	private BorrowingService borrowingService;

	public Member(String name, BorrowingService service) {
		this.name = name;
		this.borrowedBooks = new ArrayList<>();
		this.borrowingService = service;
	}

	public BorrowingService getBorrowingService() {
		return this.borrowingService;
	}

	public String getName() {
		return name;
	}

	public ArrayList<Book> getBorrowedBooks() {
		return borrowedBooks;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return "Member: " + name;
	}

	public void borrowBook(Book book) {
		BorrowingBookResult result = borrowingService.borrowBook(this, book);
		System.out.println("Success: " + result.getIsSuccess() + ": " + result.getBorrowingMessage());
	}

	public void returnBook(Book book) {
		BorrowingBookResult result = borrowingService.returnBook(this, book);
		System.out.println("Success: " + result.getIsSuccess() + ": " + result.getBorrowingMessage());

	}

	public void listBorrowedBooks() {
		for (Book book : borrowedBooks)
			System.out.println(book); // book.toString()
	}

	public int borrowedBooksCount() {
		return borrowedBooks.size();
	}

	public void returnAllBooks() {
		Iterator<Book> bookIterator = borrowedBooks.iterator();
		while (bookIterator.hasNext()) {
			Book book = bookIterator.next();
			book.setIsAvailable(true);
		}
		borrowedBooks.clear(); // clear array of borrowed books
	}
}
