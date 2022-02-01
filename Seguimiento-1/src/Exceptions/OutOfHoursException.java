package Exceptions;

public class OutOfHoursException extends Exception{

	private static final long serialVersionUID = 1L;
	public OutOfHoursException() {
		super("Llegaste fuera de los espacios de hora");
	}
	
}
