package Exceptions;

public class CannotEnterException extends Exception {

	
	private static final long serialVersionUID = 1L;
	
	public CannotEnterException() {
		super("No puede ingresar");
	}
	
}
