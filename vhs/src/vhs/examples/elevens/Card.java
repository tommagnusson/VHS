package vhs.examples.elevens;

public class Card implements Comparable<Card> {

	// Instance variables
	
	private Rank rank;
	private Suit suit;
	private Color color;
	private int pointsValue;
	
	// enums are better than String, because the values are unambiguous
	
	public static enum Rank {
		ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;
	}
	
	public static enum Suit {
		CLUBS, DIAMONDS, HEARTS, SPADES;
	}
	
	public static enum Color {
		BLACK, RED;
	}
	
	// Constructor

	public Card(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit; 
		
		switch(suit) {
		case CLUBS:
		case SPADES:
			color = Color.BLACK;
			break;
		default:
			color = Color.RED;
			break;
		}
		
		// Each card has a unique value, 0 - 51
		pointsValue = (suit.ordinal() * Rank.values().length) + rank.ordinal();
	}
	
	public Card(int pointsValue) {
		int rank = pointsValue % Rank.values().length;
		int suit = pointsValue / Rank.values().length;
		this.rank = Rank.values()[rank];
		this.suit = Suit.values()[suit];
	}
	
	// Accessors

	public Rank getRank() {
		return rank;
	}

	public Suit getSuit() {
		return suit;
	}
	
	public Color getColor() {
		return color;
	}

	// Equality, useful for comparing cards, often used for card games with bidding/high cards
	
	@Override
	public int compareTo(Card c) {
		return pointsValue - c.pointsValue;
	}
	
	public boolean equals(Card c) {
		if (pointsValue != c.pointsValue)
			return false;
		if (rank != c.rank)
			return false;
		if (suit != c.suit)
			return false;
		return true;
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
	
	// String
	
	@Override
	public String toString() {
		return rank + " of " + suit;
	}
	
}
