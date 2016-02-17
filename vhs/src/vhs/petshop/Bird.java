package vhs.petshop;

public class Bird extends AbstrPets implements Flying {
	
	private double currentFlightSpeed;
	
	private double altitude;
	
	private boolean isCurrentlyFlying;
	
	public Bird(String petName, Gender gender) {
		super(petName, gender);
		currentFlightSpeed = 0;
		altitude = 0;
		isCurrentlyFlying = false;
	}

	@Override
	public String speak() {
		return "Caw";
	}

	@Override
	public String move() {
		return getName() + " hops around";
	}

	@Override
	public String toString() {
		return super.toString() + " is a bird";
	}

	@Override
	public double getFlightSpeed() {
		return currentFlightSpeed;
	}

	@Override
	public void ascend(double feet) {
		isCurrentlyFlying = true;
		altitude += feet;
	}

	@Override
	public void descend(double feet) {
		if (altitude - feet >= 0) {
			altitude -= feet;
		} else {
			altitude = 0;
			isCurrentlyFlying = false;
		}
	}

	@Override
	public void accelerate(double mph) {
		currentFlightSpeed += mph;
	}
	
	@Override
	public double getAltitude() {
		return altitude;
	}
	
	public boolean isCurrentlyFlying() {
		return isCurrentlyFlying;
	}

}
