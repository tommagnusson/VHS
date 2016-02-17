package vhs.petshop;

public class Parrot extends Bird {
	
	private boolean hasCracker = false;

	public Parrot(String petName, Gender gender) {
		super(petName, gender);
	}
	
	public void giveCacker() {
		hasCracker = true;
	}

	@Override
	public String speak() {
		if (!hasCracker) {
			return "Polly want a cracker";
		}
		return "squawk";
	}
	
}
