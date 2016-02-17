package vhs.petshop;

public class Lion extends Cat {
	
	boolean cannotWaitToBeKing = false;
	
	public Lion(String name, Gender g) {
		super(name, g);
		if (name.equals("Simba")) {
			cannotWaitToBeKing = true;
		}
	}
	
	@Override
	public String speak() {
		return "roar";
	}

	@Override
	public String move() {
		return "sprint";
	}
	
	public boolean cannotWaitToBeKing() {
		return cannotWaitToBeKing;
	}
}
