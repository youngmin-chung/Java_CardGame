/**
 * Program Name: Deck.java
 * Purpose: is a subclass of CardSet and an aggregate class for GameOf21 class.
 * 				  create, poppulate, shuffle a deck here
 * Coder: Youngminc Chung for Sec 01
 * Date: Mar 12, 2018
 */

import java.util.*;

public class Deck extends CardSet
{
	public static final int SIZE = 52;

	public Deck()
	{
		super(); 
	  populateDeck();
	  shuffle();
	}
	
	/**
	 * Method Name: populateDeck()
	 * Purpose: loads an ArrayList<Card> deck with 52 Card objects made up of 4 suits, 
	 * 					each with 13 ranks, that is, ranks from 1 to 13.
	 * Accepts: 
	 * @returns nothing
	*/	
	public void populateDeck()
	{
		
		for (Suit suit : Suit.values()) 
		{
			for (int rank = 1; rank  <= 13; rank++)
			{
				cards.add(new Card(suit, rank));
      }
    }
	}//end method

	/**
	 * Method Name: shuffle()
	 * Purpose: shuffles the ArrayList<Card> deck in random order
	 * Accepts: 
	 * @returns nothing
	*/		
	public void shuffle()
	{
    Collections.shuffle(cards);
	}//end method

	/**
	 * Method Name: dealCard()
	 * Purpose: returns and removes the "top" Card object from the deck, that is, 
	 * 					the Card at Index 0
	 * Accepts: 
	 * @returns return card value for user and computer
	*/	
	public Card dealCard()
	{
		if(cards.size() >= 0)
		{
			Card c = cards.get(0); // get the first element in ArrayList.
			cards.remove(0); // is equal to remove the first element in ArrayList
			return c;
		}
		return null;	
	}//end method
	
	/**
	 * Method Name: size()
	 * Purpose: returns the size of the deck
	 * Accepts: 
	 * @returns int value of size
	*/	
	public int size()
	{
		return cards.size();	
	}//end method
	
	/**
	 * Method Name: displayCards()
	 * Purpose: shows cards in players hand by inputting the order number
	 * Accepts: 
	 * @returns print out a message of current cards 
	*/
	private void displayCards(int start)
	{
		if(start == 0) // for user side
		{
			for (int i = 0; i < this.cards.size(); i++)
			{
				System.out.println(i+1 + ") " + cards.get(i).toString());
			}
		}
		else if(start == 1) // for computer side
		{
			for (int i = 1; i < this.cards.size(); i++)
			{
				System.out.println(i+1 + ") " + cards.get(i).toString());
			}
		}
	}//end method
	
	@Override
	public void displayAllcards()
	{
		displayCards(0);
	}//end method

	@Override
	public void displayVisiblecards()
	{
		displayCards(1);
	}//end method
}//end class