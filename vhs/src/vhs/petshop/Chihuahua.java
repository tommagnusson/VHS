package vhs.petshop;

public class Chihuahua extends Dog // concrete classes as well as
// abstract classes can be extended by
// another class
{
	private String whereFrom;

	public Chihuahua(String dogName, Gender g, int weight) {
		super(dogName, g, weight);
	}

	public void setPlace(String location) {
		whereFrom = location;
	}

	public String speak() // overwrites speak in Dog
	{
		return "chalupa!!";
	}

	public String move() // overwrites move in Dog
	{
		return "little tiny steps";
	}

	public String cityOfOrigin() {
		return whereFrom;
	}

}
