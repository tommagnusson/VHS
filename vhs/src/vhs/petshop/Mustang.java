package vhs.petshop;

import vhs.petshop.Horse;

public class Mustang extends Horse {
	
	private boolean isRaceHorse;
	
	public Mustang(String petName, Gender g, Color c, boolean isRaceHorse) {
		super(petName, g, c);
		this.isRaceHorse = isRaceHorse;
	}

	public boolean isRaceHorse() {
		return isRaceHorse;
	}
	
}
