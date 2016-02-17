package vhs.petshop;

public class Python extends Snake {

	public static final boolean IS_VENOMOUS = false;
	
	public Python(String snakeName, Gender g, int snakeLength) {
		super(snakeName, g, snakeLength);
	}

	@Override
	public String speak() {
		if (getLength() < Integer.MAX_VALUE) {
			return "I am much more concise than Java";
		} else {
			return super.speak();
		}
	}
}
