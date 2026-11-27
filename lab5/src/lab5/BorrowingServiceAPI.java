package lab5;

/*
 * Part 6 (Aman): borrowBook and returnBook return a BorrowingBookResult instead of a boolean.
 */

public interface BorrowingServiceAPI {
    public BorrowingBookResult borrowBook(Member member, Book book);

    public BorrowingBookResult returnBook(Member member, Book book);

}
