package in.lowes.app.exceptions;

/**
 * This class represent custom exception TransactionServiceException
 * @author bhujain
 *
 */
public class TransactionServiceException extends Exception {

	/**
	 * The serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The constructor
	 */
	public TransactionServiceException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 */
	public TransactionServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public TransactionServiceException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public TransactionServiceException(Throwable cause) {
		super(cause);
	}
}
