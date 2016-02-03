package vhs.advanced.elevens;

import vhs.advanced.elevens.Card.Suit.Color;

public class Card implements Comparable<Card> {

	// Instance variables
	// "Instance fields should never be public" (Item 14)
	
	private Rank rank;
	private Suit suit;
	private int value;
	
	// enums are better than String, because the values are unambiguous
	
	public enum Rank {
		ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;
		
		@Override
		public String toString() {
			return super.toString().toLowerCase();
		}
	}
	
	/**
	 * Represents a suit associated with a playing card.
	 * Orders the suits in the following way (for comparisons):
	 * <ol>
	 * 		<li>Clubs</li>
	 * 		<li>Diamonds</li>
	 * 		<li>Hearts</li>
	 * 		<li>Spades</li>
	 * </ol>
	 * @author Tommy
	 *
	 */
	public enum Suit {
		CLUBS, DIAMONDS, HEARTS, SPADES;
		
		private Color color;
		
		/**
		 * Represents a color associated with a suit in a playing card.
		 * Either {@code Black} or {@code Red}.
		 * @author Tommy
		 *
		 */
		public enum Color {
			BLACK, RED;
		} 
		
		/**
		 * A Color is automatically associated with each suit.
		 */
		static {
			CLUBS.color = Color.BLACK;
			SPADES.color = Color.BLACK;
			
			DIAMONDS.color = Color.RED;
			HEARTS.color = Color.RED;
		}
		
		// Accesses the Color for a given suit.
		public Color getColor() {
			return color;
		}
		
		// It is implicit that a particular suit has
		// a certain color, therefore is not inlcuded
		// on this enum's toString()
		@Override
		public String toString() {
			return super.toString().toLowerCase();
		}
	}
	
	// Constants
	
	public static final int NUM_UNIQUE_CARDS = Rank.values().length * Suit.values().length;
	
	// Constructor

	public Card(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
		
		// Each card has a unique value, 0 - 51
		value = (suit.ordinal() * Rank.values().length) + rank.ordinal();
	}
	
	public Card(int pointsValue) {
		// Awkward way of getting around weird compiler error, call to constructor must be first statement
		this(Rank.values()[pointsValue % Rank.values().length], Suit.values()[pointsValue / Rank.values().length]);
	}
	
	// Accessors

	public Rank getRank() {
		return rank;
	}

	public Suit getSuit() {
		return suit;
	}
	
	public Color getColor() {
		return suit.getColor();
	}

	// Equality, useful for comparing cards, often used for card games with bidding/high cards
	
	public int compareRankTo(Card c) {
		return getRank().ordinal() - c.getRank().ordinal();
	}
	
	public int compareSuitTo(Card c) {
		return getSuit().ordinal() - c.getSuit().ordinal();
	}
	
	@Override
	public int compareTo(Card c) {
		return value - c.value;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		return equals(other);
	}
	
	// Convenience equality
	
	public boolean equals(Card c) {
		if (value != c.value)
			return false;
		if (rank != c.rank)
			return false;
		if (suit != c.suit)
			return false;
		return true;
	}
	
	public boolean rankEquals(Card c) {
		return getRank() == c.getRank();
	}
	
	public boolean suitEquals(Card c) {
		return getSuit() == c.getSuit();
	}
	
	// String
	
	@Override
	public String toString() {
		return getRank() + " of " + getSuit();
	}
	
}
