package vhs.petshop;

public class Horse extends AbstrPets {

	private Color color;
	
	public enum Color {
		BLACK, WHITE, BROWN, MIXED;
	}
	
	public Horse(String petName, Gender g, Horse.Color c) {
		super(petName, g);
		color = c;
	}

	@Override
	public String speak() {
		return "neighhh";
	}

	@Override
	public String move() {
		return "gallup";
	}
	
	@Override
	public String toString() {
		return super.toString() + " is a horse. Of course.";
	}
	
	public Horse.Color getColor() {
		return color;
	}

}
