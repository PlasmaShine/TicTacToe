package Exceptions;

public class InvalidNumberOfPlayersException extends Exception {
	private static final long serialVersionUID = -3862143181553849197L;	
	
	public InvalidNumberOfPlayersException() {
		// TODO Auto-generated constructor stub
	}

	public InvalidNumberOfPlayersException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InvalidNumberOfPlayersException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidNumberOfPlayersException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

}
