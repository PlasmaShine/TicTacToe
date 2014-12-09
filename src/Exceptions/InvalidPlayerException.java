package Exceptions;

public class InvalidPlayerException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5429314640556818785L;

	public InvalidPlayerException() {
		// TODO Auto-generated constructor stub
	}

	public InvalidPlayerException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InvalidPlayerException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidPlayerException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
}
