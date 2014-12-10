package Exceptions;

public class InvalidBoardException extends Exception {

	private static final long serialVersionUID = -1706453239663384149L;

	public InvalidBoardException() {
		// TODO Auto-generated constructor stub
	}

	public InvalidBoardException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InvalidBoardException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidBoardException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

}
