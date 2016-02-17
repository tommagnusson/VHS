package vhs.petshop;

public interface Flying {

	public double getFlightSpeed();
	
	public double getAltitude();
	
	public void ascend(double feet);
	
	public void descend(double feet);
	
	public void accelerate(double mph);
	
}
