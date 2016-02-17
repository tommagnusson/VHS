package vhs.advanced.elevens;

import java.util.Iterator;

public interface Deck {

	public int getSize();
	
	public Card[] toArray();
	
	public Card draw();
	
	public boolean isEmpty();
	
	public Iterator<Card> iterator();
	
}
