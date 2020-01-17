package in.lowes.app.exceptions;

/**
 * This class represent custom exception i.e. TransactionDBException 
 * @author bhujain
 *
 */
public class TransactionDBException extends Exception {

	/**
	 * The serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The constructor
	 */
	public TransactionDBException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 */
	public TransactionDBException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public TransactionDBException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public TransactionDBException(Throwable cause) {
		super(cause);
	}

}
