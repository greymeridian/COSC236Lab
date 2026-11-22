package lab5.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import lab5.*;

public class TestBorrowingService {

	private BorrowingServiceAPI service;
	private Member alice;
	private Member bob;
	private Book paperBook;
	private Book eBook;
	private Book audioBook;

	@BeforeEach
	void setUp() {
		service = new BorrowingService();
		alice = new Member("Alice");
		bob = new Member("Bob");
		paperBook = new PaperBook("Dune");
		eBook = new EBook("1984");
		audioBook = new AudioBook("Moby Dick");
	}

	@Test
	void testBorrowAvailableBookSucceeds() {
		boolean result = service.borrowBook(alice, paperBook);

		assertTrue(result, "Borrowing an available book should succeed");
		assertFalse(paperBook.getIsAvailable(), "Borrowed book should be marked unavailable");
		assertEquals(1, alice.borrowedBooksCount(), "Member should have 1 borrowed book");
		assertTrue(alice.getBorrowedBooks().contains(paperBook), "Book should be in member's borrowed list");
	}

	@Test
	void testBorrowAlreadyBorrowedBySameMemberFails() {
		assertTrue(service.borrowBook(alice, paperBook));

		boolean secondAttempt = service.borrowBook(alice, paperBook);

		assertFalse(secondAttempt, "Member should not be able to borrow the same book twice");
		assertEquals(1, alice.borrowedBooksCount(), "Book should not be added to borrowed list twice");
	}

	@Test
	void testBorrowUnavailableBookByAnotherMemberFails() {
		assertTrue(service.borrowBook(alice, eBook));

		boolean bobAttempt = service.borrowBook(bob, eBook);

		assertFalse(bobAttempt, "Another member should not be able to borrow an unavailable book");
		assertEquals(0, bob.borrowedBooksCount(), "Second member should not receive the book");
	}

	@Test
	void testReturnBorrowedBookSucceeds() {
		service.borrowBook(alice, audioBook);

		boolean result = service.returnBook(alice, audioBook);

		assertTrue(result, "Returning a borrowed book should succeed");
		assertTrue(audioBook.getIsAvailable(), "Returned book should be available again");
		assertEquals(0, alice.borrowedBooksCount(), "Returned book should be removed from member's list");
	}

	@Test
	void testReturnBookNotBorrowedByMemberFails() {
		boolean result = service.returnBook(alice, paperBook);

		assertFalse(result, "Returning a book not borrowed by the member should fail");
		assertTrue(paperBook.getIsAvailable(), "Unborrowed book should remain available");
	}

	@Test
	void testReturnBookBorrowedByDifferentMemberFails() {
		service.borrowBook(alice, paperBook);

		boolean bobReturn = service.returnBook(bob, paperBook);

		assertFalse(bobReturn, "A member should not be able to return a book borrowed by someone else");
		assertFalse(paperBook.getIsAvailable(), "Book should remain unavailable since Alice still has it");
		assertEquals(1, alice.borrowedBooksCount(), "Book should remain in Alice's borrowed list");
	}

	@Test
	void testBorrowAndReturnWithNullInputsFail() {
		assertFalse(service.borrowBook(null, paperBook), "Borrowing with null member should fail");
		assertFalse(service.borrowBook(alice, null), "Borrowing with null book should fail");
		assertFalse(service.returnBook(null, paperBook), "Returning with null member should fail");
		assertFalse(service.returnBook(alice, null), "Returning with null book should fail");
	}

	@Test
	void testMemberDelegatesToBorrowingService() {
		alice.borrowBook(eBook);
		assertFalse(eBook.getIsAvailable());
		assertEquals(1, alice.borrowedBooksCount());

		alice.returnBook(eBook);
		assertTrue(eBook.getIsAvailable());
		assertEquals(0, alice.borrowedBooksCount());
	}
}