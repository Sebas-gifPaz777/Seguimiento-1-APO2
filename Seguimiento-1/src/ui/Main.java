package ui;
import java.io.IOException;
import java.util.Scanner;

import Exceptions.CannotEnterException;
import Exceptions.NoMorePlacesException;
import Exceptions.OutOfHoursException;
import model.Parking;

public class Main {
	public static Scanner sc= new Scanner(System.in);
	public static Parking pk= new Parking();
	public static void main(String[]args) throws IOException {
		
		boolean finish= true;
		String vehicule="";
		
		while(finish) {
			
			System.out.println("1:Registrar vehiculo\n2:Salir");
			int option=sc.nextInt();
			sc.nextLine();
			
			switch(option) {
				case 1:
					System.out.println("Digita el numero de la placa");
					String plate=sc.nextLine();
					
					if(Character.isLetter(plate.charAt(plate.length()-1))) {
						vehicule="Moto";
					}
					else
						vehicule="Automovil";
		
					System.out.println("Digita el numero de identificacion");
					String id=sc.nextLine();
					
				String message;
				try {
					message = pk.registVehicule(plate,vehicule,id);
					System.out.println(message);
				} catch (NumberFormatException|OutOfHoursException|CannotEnterException|NoMorePlacesException e) {
					System.err.println(e.getMessage());
				} 
				break;
				
				case 2:
					System.out.println("Programa finalizado");
					finish=false;
				break;
				
				default:
					System.out.println("Esta opcion no es valida");
			
			}
			
		}
	}
	
}
