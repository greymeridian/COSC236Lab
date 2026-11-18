package lab5;

import java.util.ArrayList;
import java.util.Iterator;

public class Member {

	private String name;
	private ArrayList<PaperBook> borrowedBooks; // PaperBook class dependency
	
	public Member(String name) {
		this.name = name;
		this.borrowedBooks = new ArrayList<>();
	}
	public String getName() {
		return name;
	}
	public ArrayList<PaperBook> getBorrowedBooks() { 
		return borrowedBooks;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String toString() {
		return "Member: " + name;
	}
	public void borrowBook(PaperBook book) {
		if (book != null && book.getIsAvailable() == true) {
			borrowedBooks.add(book);
			book.setIsAvailable(false);
		}
	}
	public void returnBook(PaperBook book) {
		if (book != null) {
			borrowedBooks.remove(book);
			book.setIsAvailable(true);
		}
	}
	public void listBorrowedBooks() {
		for (PaperBook book : borrowedBooks)
			System.out.println(book); // book.toString()
	}
	public int borrowedBooksCount() {
		return borrowedBooks.size();
	}
	public void returnAllBooks() {
		Iterator<PaperBook> bookIterator = borrowedBooks.iterator();
	    while(bookIterator.hasNext()) {
		   	 PaperBook book = bookIterator.next();
		   	 book.setIsAvailable(true);
	    }
	    borrowedBooks.clear(); // clear array of borrowed books
	}
}
