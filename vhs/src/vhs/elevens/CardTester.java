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
		Card c = new Card("Diamonds", "Two", 2); // No compiler error
		System.out.println(c); // "Diamonds of Two"
		
		// All perfectly valid to the compiler
		Card card1 = new Card("Two", "Diamonds", 2);
		Card card2 = new Card("two", "diamonds", 2);
		
		System.out.println("Does " + card1 + " match " + card2 + "?");
		System.out.println(card1.matches(card2));
		
		Card c1 = new Card("Two", "Diamonds", 2);
		Card c2 = new Card("2", "diamonds", 2);
		
		System.out.println("Does " + c1 + " match " + c2 + "?");
		System.out.println(c1.matches(c2)); // false...
		
		Card notACard = new Card("money", "bags", 1738); // No compiler error
		System.out.println(notACard);
		
	}
}
