/**
 * Program Name: CardSet.java
 * Purpose: it is abstract supper class for Deck and Hand class
 * Coder: Youngminc Chung for Sec 01
 * Date: Mar 12, 2018
 */

import java.util.*;

public abstract class CardSet
{
	protected ArrayList <Card> cards;
	
	public CardSet()
	{
		this.cards = new ArrayList<Card>();
	}
	public CardSet(int numberOfCards)
	{
		this.cards = new ArrayList<Card> (numberOfCards);
	}

	/**
	 * Method Name: displayAllcards()
	 * Purpose: displays all the cards in user's hand
	 * Accepts: 
	 * @returns nothing
	*/
	public abstract void displayAllcards();
	/**
	 * Method Name: displayVisiblecards()
	 * Purpose: displays only the top card of the computer's hand
	 * Accepts: 
	 * @returns nothing
	*/
	public abstract void displayVisiblecards();
	
}//end class
