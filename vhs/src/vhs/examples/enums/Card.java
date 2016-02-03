package vhs.examples.enums;

public class Card {

	private Rank rank;
	private Suit suit;
	
	public Card(Rank r, Suit s) {
		rank = r;
		suit = s;
	}
	
	// Enumerations:
	
	public enum Rank {
		ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(10), QUEEN(10), KING(10);
		
		// Instance variable (Rank is a class!)
		private int points;
		
		// Constructor
		private Rank(int value) {
			this.points = value;
		}
		
		public int getPoints() {
			return points;
		}
	}
	
	public enum Suit {
		CLUBS, DIAMONDS, HEARTS, SPADES;
	}

	// Accessors:
	
	public Rank getRank() {
		return rank;
	}

	public Suit getSuit() {
		return suit;
	}
	
	@Override
	public String toString() {
		return rank.toString().toLowerCase() + " of " + suit.toString().toLowerCase();
	}
	
}
