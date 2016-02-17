package vhs.petshop;

public class Pigeon extends Bird {

	private String city;
	
	public Pigeon(String petName, Gender gender, String city) {
		super(petName, gender);
		this.city = city;
	}

	public String getCity() {
		return city;
	}
}
