package fr.eni.projetenchere.bll;

public class BLLException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2847519315279722484L;

	public BLLException() {
		super();
	}

	public BLLException(String message) {
		super(message);
	}

	public BLLException(Throwable cause) {
		super(cause);
	}

	public BLLException(String message, Throwable cause) {
		super(message, cause);
	}

	public BLLException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
