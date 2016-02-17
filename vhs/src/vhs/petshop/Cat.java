package vhs.petshop;

public class Cat extends AbstrPets {
	
	public Cat(String name, Gender g) {
		super(name, g);
	}

	@Override
	public String speak() {
		return "Meow";
	}

	@Override
	public String move() {
		return "saunter";
	}
	
}
