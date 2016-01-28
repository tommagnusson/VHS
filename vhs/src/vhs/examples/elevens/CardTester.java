package vhs.examples.elevens;

import vhs.examples.elevens.Card.Rank;
import vhs.examples.elevens.Card.Suit;

public class CardTester {

	public static void main(String[] args) {
		
		Card aceOfSpades = new Card(Rank.ACE, Suit.SPADES);
		Card anotherAceOfSpades = new Card(Rank.ACE, Suit.SPADES);
		Card sevenOfClubs = new Card(Rank.SEVEN, Suit.CLUBS);
		
		System.out.println(aceOfSpades.compareTo(anotherAceOfSpades));
		System.out.println(aceOfSpades.equals(anotherAceOfSpades));
		System.out.println(sevenOfClubs.compareTo(aceOfSpades));
		System.out.println(sevenOfClubs.equals(anotherAceOfSpades));
		System.out.println(sevenOfClubs);
		System.out.println(new Card(0));
		
	}
	
}
