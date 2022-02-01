package model;

public class Driver {
	
	private String plate;
	private String id ;
	private String vehicule;
	
	public Driver(String plate, String id, String vehicule) {
		this.plate=plate;
		this.id=id;
		this.vehicule=vehicule;
	}

	public String getPlate() {
		return plate;
	}

	public String getId() {
		return id;
	}

	public String getVehicule() {
		return vehicule;
	}
	
}
