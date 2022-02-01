package model;

import java.util.Calendar;

import Exceptions.CannotEnterException;
import Exceptions.NoMorePlacesException;
import Exceptions.OutOfHoursException;

public class Parking {

	public final static int MAX_CARS=100;
	public final static int MAX_MOTORCYCLE=100;
	public Driver[]carList;
	public Driver[]motorList;
	public final static char[]alphabet={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	public int spaceCars;
	public int spaceMotors;
	
	public Parking() {
		carList= new Driver[MAX_CARS];
		motorList= new Driver[MAX_MOTORCYCLE];
		spaceCars=100;
		spaceMotors=200;
	}
	public String registVehicule(String plate,String vehicule,String id) throws NumberFormatException, OutOfHoursException, CannotEnterException, NoMorePlacesException {
		
		String message="";
		Calendar cl= Calendar.getInstance();
		int hour=cl.get(Calendar.HOUR_OF_DAY);
		int day=cl.get(Calendar.DAY_OF_WEEK);
		
		if(validateDocument(Integer.parseInt(id),day)) {
			if(vehicule.equalsIgnoreCase("Automovil")) {
				if(validatePlateC(plate.charAt(0), hour)) {
					if(spaceCars!=0) {
						message="Se ha registrado un vehiculo tipo carro con estos datos:\nPlaca:"+plate+"\nDocumento:"+id;
						spaceCars--;
					}
					else
						throw new NoMorePlacesException();
				}
			}
			else {
				if(validatePlateM(plate.charAt(3),plate.charAt(4), hour)) {
					if(spaceMotors!=0) {
						message="Se ha registrado un vehiculo tipo moto con estos datos:\nPlaca:"+plate+"\nDocumento:"+id;
						spaceMotors--;
					}
					else
						throw new NoMorePlacesException();
						
				}
			}
		}
		
		return message;
	}
	
	public boolean validateDocument(int document, int dayOfWeek) throws OutOfHoursException, CannotEnterException {
		int lastDigit = document % 10;
		if (	((lastDigit == 0 || lastDigit == 1) && dayOfWeek == 2)
			||  ((lastDigit == 2 || lastDigit == 3) && dayOfWeek == 3)
			||  ((lastDigit == 4 || lastDigit == 5) && dayOfWeek == 4)
			||  ((lastDigit == 6 || lastDigit == 7) && dayOfWeek == 5)
			||  ((lastDigit == 8 || lastDigit == 9) && dayOfWeek == 6)
		){
			throw new CannotEnterException();
		}
		return true;
	}
	
	public boolean validatePlateC(char index, int hr) throws OutOfHoursException {
		boolean next=true;
		int letter=27;
		boolean valid=false;
		
		for(int i=0;i<alphabet.length && next;i++) {
			if(alphabet[i]==index) {
				letter=i;
				next=false;
			}
		}
		
		if(letter<=12 && hr<14 && hr>=7) 
			valid=true;
		
		else if(letter<=26 && letter>=13 && hr>=14 && hr<22)
			valid=true;
		else
			throw new OutOfHoursException();
		
		return valid;
	}
	
	public boolean validatePlateM(char index1, char index2,  int hr) throws OutOfHoursException {
		int plate=Integer.parseInt(String.valueOf(index1)+String.valueOf(index2));
		boolean valid=false;

		if(plate>=00 && plate<50 && hr<14 && hr>=7) 
			valid=true;
		
		else if(plate>49 && plate<=99 && hr>=14 && hr<22)
			valid=true;
		else
			throw new OutOfHoursException();
		
		return valid;
	}
}
