package lab5;

/* Part 6 (Aman): New class. Holds the outcome of a borrow or return:
 * whether it succeeded and a message explaining why.
 * 
 */

public class BorrowingBookResult {

	private String borrowingMessage;
	private boolean isSuccess;

	public BorrowingBookResult(boolean isSuccess, String borrowingMessage) {
		this.borrowingMessage = borrowingMessage;
		this.isSuccess = isSuccess;
	}

	public String getBorrowingMessage() {
		return borrowingMessage;
	}

	public void setBorrowingMessage(String borrowingMessage) {
		this.borrowingMessage = borrowingMessage;
	}

	public void setIsSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public boolean getIsSuccess() {
		return isSuccess;
	}

}
