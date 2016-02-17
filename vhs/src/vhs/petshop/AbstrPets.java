package vhs.petshop;

//abstract classes may have concrete methods as well as abstract methods or
//they may be comprised of all abstract methods.

//abstract methods appearing in an abstract class must be defined by
//any class extending this abstract class

public abstract class AbstrPets {
	private String name;
	
	private Gender gender;

	public AbstrPets(String petName, Gender g) {
		name = petName;
		gender = g;
	}

	public final String getName() {
		return name;
	}
	
	public final String getGender() {
		return gender.toString();
	}

	public String toString() {
		return getGender() + " pet " + name;
	}

	abstract public String speak();

	abstract public String move();
}
