package lab5;

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
