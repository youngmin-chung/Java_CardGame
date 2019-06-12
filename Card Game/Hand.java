/**
 * Program Name: Hand.java
 * Purpose: is a subclass of CardSet and an aggregate class for GameOf21 class.
 * Coder: Youngminc Chung for Sec 01
 * Date: Mar 12, 2018
 */

public class Hand extends CardSet
{
	private String playerName;
	
	public Hand (String name)
	{
		super();
		this.playerName = name;
	}
	
	//getters and setters
	public String getPlayerName()
	{
		return playerName;
	}//end method

	public void setPlayerName(String playerName)
	{
		this.playerName = playerName;
	}//end method
	
	/**
	 * Method Name: hit(Card c)
	 * Purpose: adds a Card object to a Player's hand, which is dealt from the CardGame class deck.
	 * Accepts: 
	 * @returns nothing
	*/		
	public void hit (Card c)
	{
		// if (c != null) In theorically, a dealer can deal a card to user unless a card deck is empty.
		cards.add(c);   //In this program, we don't consider. The game is end if deck size is less than 6. 
	}//end method
	
	/**
	 * Method Name: discard(int)
	 * Purpose: removes a Card object from a Player's hand given the Card's index.
	 * Accepts: 
	 * @returns nothing
	*/
	public void discard (int index)
	{
		cards.remove(index);
	}//end method
	
	/**
	 * Method Name: discard(int)
	 * Purpose: removes Card objects from a Players's hand given the beginning position (inclusive) 
	 * 					and the end position (exclusive) of the CardSet in the Hand
	 * Accepts: 
	 * @returns nothing
	*/
	public void discard (int begIndex, int endIndex)
	{
		 for(int i = begIndex; i < endIndex ; i++)
		 {
		   cards.remove(i);
		 }
	}//end method
	
	/**
	 * Method Name: totalHand()
	 * Purpose: finds the total value of a Player's hand based on the CardSet's values. 
	 * 					This method also checks if a Card is an Ace and if it is, calls the 
	 * 					findAceValue() helper method.
	 * Accepts: 
	 * @returns sum of rank value in hand of user and computer
	*/
	public int totalHand()
	{
		int total = 0;
		for (int i = 0; i < this.cards.size(); i++)
		{
			if(cards.get(i).findFaceValue() == "Ace")
			{
				total += this.findAceValue(total);
			}
			else
			{
				total += cards.get(i).findCardValue();
			}
		}
		return total;
	}//end method
		
	/**
	 * Method Name: totalVisibleHand()
	 * Purpose: finds the total hand that is visible, and ignores the first card that is faced down.
	 * 					This method also checks if a Card is an Ace and,
	 * 					if it is, calls the findAceValue() helper method.
	 * Accepts: 
	 * @returns sum of rank value in visible
	*/
	public int totalVisibleHand()
	{
		int total = 0;
		for(int i = 1; i <= cards.size(); i++)
		{
			if(i % 2 == 0) 
			{
				if(cards.get(i-1).findFaceValue() == "Ace")
				{
					total += this.findAceValue(total);
				}
				else
				{
					total += cards.get(i-1).findCardValue();
				}
			}
		}
		return total;
	}//end method
		
	
	/**
	 * Method Name: findAceValue(int total)
	 * Purpose: is a helper method which checks if the Players' current hand total plus 11 goes 
	 * 					over 21, then returns ace as 1, otherwise returns ace as 11.
	 * Accepts: 
	 * @returns int value
	*/
	private int findAceValue (int total)
	{
		if (total + 11 > 21)
		{
			return 1;
		}
		else
		{
			return 11;
		}
	}//end method
	
	/**
	 * Method Name: emptyHand()
	 * Purpose:
	 * Accepts: 
	 * @returns nothing
	*/
	public void emptyHand()
	{
		for(int i = this.cards.size() -1 ; i >=0 ; i--)
		{
			this.cards.remove(0);
		}
	}//end method
	
	/**
	 * Method Name: displayCards()
	 * Purpose: shows cards in players hand by inputting the order number
	 * Accepts: 
	 * @returns nothing
	*/
	private void displayCards(int start)
	{
		if(start == 0)
		{
			for (int i = 0; i < this.cards.size(); i++)
			{
				System.out.println(i+1 + ") " + cards.get(i).toString());
			}
		}
		else if(start == 1)
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
