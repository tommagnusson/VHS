package vhs.petshop;

public class Pitbull extends Dog {
	
	int hungerLevel = 0;

	public Pitbull(String dogName, Gender g, int dogWeight) {
		super(dogName, g, dogWeight);
	}
	
	@Override
	public String speak() {
		if (hungerLevel >= 50) {
			hungerLevel += 10;
			return "grrrrrrrr";
		}
		hungerLevel += 5;
		return super.speak();
	}
	
	@Override
	public String move() {
		hungerLevel += 10;
		return "leaps and bounds";
	}
	
	public void pet() {
		if (hungerLevel >= 100) {
			System.out.println(getName() + " bites your hand!");
			hungerLevel = 0;
		} else {
			System.out.println(getName() + " nuzzles your hand.");
		}
	}
}
