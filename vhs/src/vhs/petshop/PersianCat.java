package vhs.petshop;

public class PersianCat extends Cat {
	
	public PersianCat(String name, Gender g) {
		super(name, g);
	}

	@Override
	public String speak() {
		return "purrrrr";
	}
	
}
