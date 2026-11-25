package lab5;

public class BorrowingService implements BorrowingServiceAPI {

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

		member.getBorrowedBooks().add(book);
		book.setIsAvailable(false);
		return new BorrowingBookResult(true, member.getName() + " borrowed " + book.getTitle());
	}

	@Override
	public BorrowingBookResult returnBook(Member member, Book book) {
		if (member == null || book == null) {
			return new BorrowingBookResult(false, "Member or book not found.");
		}

		// Prevent returning if the book is not in the member's borrowed list
		if (!member.getBorrowedBooks().contains(book)) {
			return new BorrowingBookResult(false, book.getTitle() + " not in " + member.getName() + " borrowed list.");
		}

		member.getBorrowedBooks().remove(book);
		book.setIsAvailable(true);
		return new BorrowingBookResult(true, member.getName() + " returned " + book.getTitle());
	}
}
