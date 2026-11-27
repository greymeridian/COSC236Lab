package lab5.tests;

/*
 * Part 6 (Aman): Tests read getIsSuccess() from BorrowingBookResult, check the
 * return failure messages, and test the 3-book limit.
 */

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
		service = BorrowingService.getInstance();
		alice = new Member("Alice", BorrowingService.getInstance());
		bob = new Member("Bob", BorrowingService.getInstance());
		paperBook = new PaperBook("Dune");
		eBook = new EBook("1984");
		audioBook = new AudioBook("Moby Dick");
	}

	@Test
	void testBorrowAvailableBookSucceeds() {
		BorrowingBookResult result = service.borrowBook(alice, paperBook);

		assertTrue(result.getIsSuccess(), "Borrowing an available book should succeed");
		assertFalse(paperBook.getIsAvailable(), "Borrowed book should be marked unavailable");
		assertEquals(1, alice.borrowedBooksCount(), "Member should have 1 borrowed book");
		assertTrue(alice.getBorrowedBooks().contains(paperBook), "Book should be in member's borrowed list");
	}

	@Test
	void testBorrowAlreadyBorrowedBySameMemberFails() {
		assertTrue(service.borrowBook(alice, paperBook).getIsSuccess());

		BorrowingBookResult secondAttempt = service.borrowBook(alice, paperBook);

		assertFalse(secondAttempt.getIsSuccess(), "Member should not be able to borrow the same book twice");
		assertEquals(1, alice.borrowedBooksCount(), "Book should not be added to borrowed list twice");
	}

	@Test
	void testBorrowUnavailableBookByAnotherMemberFails() {
		assertTrue(service.borrowBook(alice, eBook).getIsSuccess());

		BorrowingBookResult bobAttempt = service.borrowBook(bob, eBook);

		assertFalse(bobAttempt.getIsSuccess(), "Another member should not be able to borrow an unavailable book");
		assertEquals(0, bob.borrowedBooksCount(), "Second member should not receive the book");
	}

	@Test
	void testReturnBorrowedBookSucceeds() {
		service.borrowBook(alice, audioBook);

		BorrowingBookResult result = service.returnBook(alice, audioBook);

		assertTrue(result.getIsSuccess(), "Returning a borrowed book should succeed");
		assertTrue(audioBook.getIsAvailable(), "Returned book should be available again");
		assertEquals(0, alice.borrowedBooksCount(), "Returned book should be removed from member's list");
	}

	@Test
	void testReturnBookNotBorrowedByMemberFails() {
		BorrowingBookResult result = service.returnBook(alice, paperBook);

		assertFalse(result.getIsSuccess(), "Returning a book not borrowed by the member should fail");
		assertTrue(paperBook.getIsAvailable(), "Unborrowed book should remain available");
		assertTrue(result.getBorrowingMessage().contains("not checked out"), "Should say the book is not checked out");
	}

	@Test
	void testReturnBookBorrowedByDifferentMemberFails() {
		service.borrowBook(alice, paperBook);

		BorrowingBookResult bobReturn = service.returnBook(bob, paperBook);

		assertFalse(bobReturn.getIsSuccess(), "A member should not be able to return a book borrowed by someone else");
		assertFalse(paperBook.getIsAvailable(), "Book should remain unavailable since Alice still has it");
		assertEquals(1, alice.borrowedBooksCount(), "Book should remain in Alice's borrowed list");
		assertTrue(bobReturn.getBorrowingMessage().contains("has not borrowed"), "Should say Bob has not borrowed it");
	}

	@Test
	void testBorrowAndReturnWithNullInputsFail() {
		assertFalse(service.borrowBook(null, paperBook).getIsSuccess(), "Borrowing with null member should fail");
		assertFalse(service.borrowBook(alice, null).getIsSuccess(), "Borrowing with null book should fail");
		assertFalse(service.returnBook(null, paperBook).getIsSuccess(), "Returning with null member should fail");
		assertFalse(service.returnBook(alice, null).getIsSuccess(), "Returning with null book should fail");
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
	
	@Test
    void testBorrowingLimitBlocksFourthBook() {
        Book fourthBook = new PaperBook("Neuromancer");

        service.borrowBook(alice, paperBook);
        service.borrowBook(alice, eBook);
        service.borrowBook(alice, audioBook);

        BorrowingBookResult result = service.borrowBook(alice, fourthBook);

        assertFalse(result.getIsSuccess(), "Fourth borrow should be blocked by the limit");
        assertEquals(3, alice.borrowedBooksCount(), "Member should still have 3 books");
        assertTrue(fourthBook.getIsAvailable(), "Blocked book should stay available");
    }
}