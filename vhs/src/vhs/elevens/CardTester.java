package vhs.elevens;

/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		Card c = new Card("two", "Diamonds", 2);
		Card c2 = new Card("Two", "diamonds", 2);
		System.out.println("Does " + c + " match " + c2 + "?");
		System.out.println(c.matches(c2));
		
		Card c3 = new Card("ten", "spades", 10);
		System.out.println("Does " + c + " match " + c3 + "?");
		System.out.println(c.matches(c3));
		
	}
}
