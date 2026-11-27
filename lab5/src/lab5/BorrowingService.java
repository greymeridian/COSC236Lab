package lab5;

/*
 * Part 6 (Aman): borrowBook and returnBook now return a BorrowingBookResult with a
 * message for each outcome, and members are limited to 3 borrowed books.
 */

public class BorrowingService implements BorrowingServiceAPI {

	private static volatile BorrowingService instance;
	private int borrowingLimit;

	private BorrowingService() {
		this.borrowingLimit = 3;
	}

	public static BorrowingService getInstance() {
		if (instance == null) {
			synchronized (BorrowingService.class) {
				if (instance == null) {
					instance = new BorrowingService();
				}
			}
		}
		return instance;
	}

	@Override
	public BorrowingBookResult borrowBook(Member member, Book book) {
		if (member == null || book == null) {
			return new BorrowingBookResult(false, "Member or book not found.");
		}
		// Prevent borrowing if the member already has this book
		if (member.getBorrowedBooks().contains(book)) {
			return new BorrowingBookResult(false, member.getName() + " already has " + book.getTitle());
		}
		// Prevent borrowing if the book is currently unavailable
		if (!book.getIsAvailable()) {
			return new BorrowingBookResult(false, book.getTitle() + " not available.");
		}

		if (member.borrowedBooksCount() == borrowingLimit) {
			return new BorrowingBookResult(false, "Member borrowing limit reached.");
		}

		member.getBorrowedBooks().add(book);
		book.setIsAvailable(false);
		return new BorrowingBookResult(true, member.getName() + " borrowed " + book.getTitle());
	}

	@Override
	public BorrowingBookResult returnBook(Member member, Book book) {
		if (member == null || book == null) {
			return new BorrowingBookResult(false, "Member or book not found.");
		}

		if (!member.getBorrowedBooks().contains(book)) {
			if (book.getIsAvailable()) {
				return new BorrowingBookResult(false, book.getTitle() + " is not checked out, nothing to return.");
			} else {
				return new BorrowingBookResult(false, member.getName() + " has not borrowed " + book.getTitle());
			}
		}

		member.getBorrowedBooks().remove(book);
		book.setIsAvailable(true);
		return new BorrowingBookResult(true, member.getName() + " returned " + book.getTitle());
	}
}
