package library;

import java.util.ArrayList;

public class Member {

	// GRASP Principle: Information Expert and Low Coupling
	// Can borrow and return books.
	private String memberID;
	private String name;
	// private borrowedbBooks DONE: implement collection of borrowed books
	private ArrayList<Book> borrowedBooks;
	
	public Member(String memberID, String name, ArrayList<Book> borrowedBooks) {
		this.memberID = memberID;
		this.name = name;
		this.borrowedBooks = borrowedBooks;
	}

	// TODO: implement functionality of Member class
	
	public boolean borrowBook(Book book) {
		if (book.borrow()) {
			borrowedBooks.add(book);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean returnBook(Book book) {
		if (borrowedBooks.contains(book)) {
			borrowedBooks.remove(book);
			book.setIsAvailable(true);
			return true;
		} else {
			
		}
	}

}
