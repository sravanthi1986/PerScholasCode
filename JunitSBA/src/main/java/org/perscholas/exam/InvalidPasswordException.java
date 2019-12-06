package org.perscholas.exam;

public class InvalidPasswordException extends Exception {
	private static final long serialVersionUID =1;
	public InvalidPasswordException(String message) {
		super(message);
	}

}
