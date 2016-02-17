package vhs.advanced.elevens;

import java.util.ArrayList;
import java.util.List;

/**
 * A poker hand containing a 5 card hand. 
 * If the argument for a 
 * and a type (flush, straight, two pair, etc).
 * 
 * This class will automatically find the highest type,
 * as well as the cards involved in that type.
 * 
 * Flush and Straight involves all 5.
 * Pair involves 2, Two pair involves 4,
 * Three of a kind involves 3, etc.
 * 
 * @author Tommy
 *
 */
public class PokerHand {

	private List<Card> hand;
	private List<Card> involvedCards;
	private PokerHandType type;
	
	public PokerHand(PokerHand ph) {
		hand = ph.getHand();
		
	}
	
	public PokerHand(List<Card> hand) {
		checkHandIs5(hand);
		this.hand = hand;
		this.type = findHighestType(hand);
	}

	public List<Card> getHand() {
		return new ArrayList<Card>(hand);
	}
	
	public List<Card> getInvolvedCards() {
		return new ArrayList<Card>(involvedCards);
	}

	public void setHand(List<Card> hand) {
		checkHandIs5(hand);
		this.hand = hand;
	}

	public PokerHandType getType() {
		return type;
	}
	
	/**
	 * Figures the highest type as well as the cards involved
	 * @param hand, 5 cards
	 * @return
	 */
	private PokerHandType findHighestType(List<Card> hand) {
		
	}
	
	private void checkHandIs5(List<Card> hand) {
		if (hand.size() != 5) {
			throw new IllegalArgumentException("A PokerHand's hand must be 5 cards in size.");
		}
	}
}
