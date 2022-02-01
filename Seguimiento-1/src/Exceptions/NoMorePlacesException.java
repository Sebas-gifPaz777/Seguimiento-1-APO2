package Exceptions;

public class NoMorePlacesException extends Exception {

	
	private static final long serialVersionUID = 1L;
	public NoMorePlacesException() {
		super("No hay mas cupos");
	}

}
