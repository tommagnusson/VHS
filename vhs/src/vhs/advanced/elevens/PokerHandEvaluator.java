package vhs.advanced.elevens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Poker hand evaluator based on
 * http://nsayer.blogspot.com/2007/07/algorithm-for-evaluating-poker-hands.html
 * "Nick's Blog"
 * @author Tommy
 *
 */
public class PokerHandEvaluator {
	
	public static List<Player> findWinner(List<Player> players) {
		
		for (Player p: players) {
			p.setBestHand(findBestHand(p.getHand()));
		}
		return null;
	}

	private PokerHandEvaluator() { }
	
	/**
	 * Creates a histogram of each card rank.
	 * Finds how many times a rank occurs in the hand.
	 * 
	 * @param cards
	 * @return
	 * 		A hand type describing a pair, otherwise null
	 */
	private static PokerHandType findPairs(List<Card> cards) {
		List<Card.Rank> distinctRanks = cards.stream().map(Card::getRank).distinct().collect(Collectors.toList());
		List<Integer> histogram = new ArrayList<Integer>(distinctRanks.size());
		int histIndex = 0;
		for (Card.Rank r: distinctRanks) {
			for (Card c: cards) {
				if (c.getRank() == r) {
					int value = histogram.get(histIndex).intValue();
					value++;
					histogram.set(histIndex, value);
				}
			}
			histIndex++;
		}
		Collections.sort(histogram, Collections.reverseOrder());
		int size = histogram.size();
		int firstIndex = histogram.get(0);
		if (size == 2) {
			if ( firstIndex == 4) { // 4, 1
 				return PokerHandType.FOUR_OF_A_KIND;
			} // 3, 2
			return PokerHandType.FULL_HOUSE;
		}
		if (size == 3) {
			if (firstIndex == 3) { // 3, 1, 1
				return PokerHandType.THREE_OF_A_KIND;
			} // 2, 2, 1
			return PokerHandType.TWO_PAIR;
		} 
		if (size == 4) { // 2, 1, 1, 1
			return PokerHandType.ONE_PAIR;
		} // 1, 1, 1, 1, 1 NO_PAIR
		return PokerHandType.NO_PAIR;
	}
	
	private static boolean isFlush(List<Card> cards) {
		List<Card.Suit> distinctSuits = cards.stream().map(Card::getSuit).distinct().collect(Collectors.toList());
		return distinctSuits.size() == 1;
	}
	
	private static boolean isStraight(List<Card> cards) {
		Collections.sort(cards);
		Card.Rank first = cards.get(0).getRank();
		Card.Rank last = cards.get(cards.size() - 1).getRank();
		
		int firstOrdinal = first.ordinal();
		int lastOrdinal = first.ordinal();
		
		boolean classicStraight = false;
		
		// Ace can be high or low in a straight
		if (!(last == Card.Rank.ACE)) {
			classicStraight = (lastOrdinal - firstOrdinal) == 4;
			return classicStraight;
		}
		
		return classicStraight || isAceHighStraight(cards);
	}

	private static boolean isAceHighStraight(List<Card> cards) {
		for (int i = 0; i < cards.size(); i++) {
			Card.Rank[] ranks = Card.Rank.values();
			Card.Rank rank = cards.get(i).getRank();
			if (rank != Card.Rank.ACE && (ranks[i] != rank)) { 
				 return false;
			} else {
				return (i == cards.size() - 1) && rank == Card.Rank.ACE;
			}
		}
		return false;
	}
	
	private static List<Card> findBestHand(List<Card> hand) {
		List<List<Card>> bestHands = new ArrayList<List<Card>>();
		PokerHandType bestHandType = Poker.HandType.HIGH_CARD;
		
		// Find highest type and then find those hands
		for (int lastIndex = hand.size() - 1; lastIndex >= 0; lastIndex--) {
			for (int secondIndex = lastIndex - 1; secondIndex >= 0; secondIndex--) {
				List<Card> handClone = new ArrayList<Card>(hand);
				handClone.remove(lastIndex);
				handClone.remove(secondIndex);
				PokerHandType type = findHighestHandType(handClone);
				if (type.ordinal() > bestHandType.ordinal()) {
					bestHands.clear();
					bestHands.add(handClone);
				} else if (type.ordinal() == bestHandType.ordinal()) {
					bestHands.add(handClone);
				}
			}
		}
		
		// Compare hands of the same highest type to find real winner
		if (PokerHandType.STRAIGHT == bestHandType) {
			Card.Rank highestRank = Card.Rank.TWO;
			List<Card> highestHand = new ArrayList<Card>();
			for (List<Card> currentHand: bestHands) {
				if (isAceHighStraight(currentHand)) {
					return currentHand;
				}
				Card.Rank currentRank = currentHand.get(currentHand.size() - 1).getRank();
				if (currentRank.ordinal() > highestRank.ordinal()) {
					highestRank = currentRank;
					highestHand = currentHand;
				}
			}
		}
		
		if (PokerHandType.FLUSH == bestHandType) {
			Card.Rank highestRank = Card.Rank.TWO;
			List<Card> highestHand = new ArrayList<Card>();
			for (List<Card> currentHand: bestHands) {
				Card.Rank currentRank = currentHand.get(currentHand.size() - 1).getRank();
				if (currentRank.ordinal() > highestRank.ordinal()) {
					highestRank = currentRank;
					highestHand = currentHand;
				}
			}
		}
		switch(bestHandType) {
		case FOUR_OF_A_KIND:
		case FULL_HOUSE:
		case THREE_OF_A_KIND:
		case TWO_PAIR:
		case ONE_PAIR:
			
		}
	}

	private static Poker.HandType findHighestHandType(List<Card> hand) {
		Poker.HandType highestType = findPairs(hand);
		if (highestType == Poker.HandType.NO_PAIR) highestType = Poker.HandType.HIGH_CARD;
		boolean isFlush = isFlush(hand);
		boolean isStraight = isStraight(hand);
		if (isFlush && isStraight) {
			return Poker.HandType.STRAIGHT_FLUSH;
		}
		if (!isStraight && !isFlush) {
			return highestType;
		}
		if (isStraight) {
			return Poker.HandType.STRAIGHT;
		}
		if (isFlush) {
			return Poker.HandType.FLUSH;
		}
		return highestType;
	}
	
}
