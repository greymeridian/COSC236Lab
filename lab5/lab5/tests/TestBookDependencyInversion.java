package lab5.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import lab5.*;

/**
 * COSC236 Lab 05
 * This file serves as a JUnit test for Dependency Inversion on my created Book interface.
 * Part 3 (Ronny): Added a test that catalogs, finds, borrows,
 * returns, and removes a book using a test-only Book implementation.
 * @author Ronald Lorette 300294189
 * @since 11-18-2026
 * @version 1.0
 */

class TestBookDependencyInversion {
	
	@Test
	void libraryAndMemberWorkWithAnotherBookImplementation() {
		Library library = new Library();
		Member member = new Member("Alice");
		Book book = new TestBook();
		
		library.addBook(book);
		assertSame(book, library.findBookByTitle(book.getTitle()));
		
		member.borrowBook(book);
		assertFalse(book.getIsAvailable());
		assertEquals(1, member.borrowedBooksCount());
		assertSame(book, member.getBorrowedBooks().get(0));
		
		member.returnBook(book);
		assertTrue(book.getIsAvailable());
		assertEquals(0, member.borrowedBooksCount());
		
		library.removeBook(book.getTitle());
		assertNull(library.findBookByTitle(book.getTitle()));
		
	}
	
	private static final class TestBook implements Book {
        private boolean available = true;

        @Override
        public String getTitle() {
            return "Test Title";
        }

        @Override
        public boolean getIsAvailable() {
            return available;
        }

        @Override
        public void setIsAvailable(boolean available) {
            this.available = available;
        }

        @Override
        public String toString() {
            return getTitle();
        }
    }
}