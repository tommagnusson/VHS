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
		Card aceOfSpades = new Card("ace", "spades", 1);
		Card sevenOfHearts = new Card("seven", "hearts", 7);
		Card aceOfSpades2 = new Card("Ace", "Spades", 1);
		
		System.out.println("Matches? " + aceOfSpades.matches(aceOfSpades2)); // false, uh oh...
		// This is why we use enums instead of String.
		// enum is a defined type, and there a constant amount of ranks, and suits.
		// It's the perfect piece of data to display the power of enums
		
		System.out.println(sevenOfHearts.toString());
		
	}
}
