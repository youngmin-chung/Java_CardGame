/**
 * Program Name: Card.java
 * Purpose: CREATE Card 
 * Coder: Youngminc Chung for Sec 01
 * Date: Mar 12, 2018
 */

public class Card
{
	
	private Suit suit;
	private int rank;
	
	public Card()
	{
		this.suit = Suit.CLUBS;
		this.rank = 1;
	}
	public Card(Suit suit)
	{
		this.rank = 1;
		this.suit = suit;
	}
	public Card(Suit suit, int rank)
	{
		this.suit = suit;
		this.rank = rank;
	}
	
	//getters and setters
	/**
	 * @return the suit
	 */
	public Suit getSuit()
	{
		return suit;
	}
	/**
	 * @param suit the suit to set
	 */
	public void setSuit(Suit suit)
	{
		this.suit = suit;
	}
	/**
	 * @return the rank
	 */
	public int getRank()
	{
		return rank;
	}
	/**
	 * @param rank the rank to set
	 */
	public void setRank(int rank)
	{
		this.rank = rank;
	}
	
	
	/**
	 * Method Name: isSameSuit()
	 * Purpose: compares the suits of this card to the parameter and returns true if the suis are the same
	 * Accepts: 
	 * @returns true if the suits are the same.
	*/
	public boolean isSameSuit(Card c)
	{
		if (c.suit == this.suit)
		{
			return true;
		}
		return false;

	}//end method
	
	/**
	 * Method Name: findFaceValue()
	 * Purpose: checks the rank of this card, and returns one of the following face values
	 * Accepts: 
	 * @returns return sRank value
	*/
	public String findFaceValue()
	{
		String sRank = "";
		switch (rank)
    {
        case 1: sRank = "Ace"; break;
        case 2: sRank = "Two"; break;
        case 3: sRank = "Three"; break;
        case 4: sRank = "Four"; break;
        case 5: sRank ="Five"; break;
        case 6: sRank = "Six"; break;
        case 7: sRank = "Seven"; break;
        case 8: sRank = "Eight"; break;
        case 9: sRank = "Nine"; break;
        case 10: sRank = "Ten"; break;
        case 11: sRank = "Jack"; break;
        case 12: sRank = "Queen"; break;
        case 13: sRank = "King"; break;
    }
		return sRank;
	}//end method
	
	/**
	 * Method Name: findCardValue()
	 * Purpose: checks the rank of thsi card, and returns its card value based on the 
	 * 					following face values
	 * Accepts: 
	 * @returns return int value of result
	*/
	public int findCardValue()
	{
		int result = 0;
		switch (rank)
    {
        case 1:
        	result = 1; break;
        case 2:
        	result = 2; break;
        case 3:
        	result = 3; break;
        case 4:
        	result = 4; break;
        case 5:
        	result = 5; break;
        case 6:
        	result = 6; break;
        case 7:
        	result = 7; break;
        case 8:
        	result = 8; break;
        case 9:
        	result = 9; break;
        case 10:
        	result = 10; break;
        case 11:
        case 12:
        case 13:
            result = 10; break;
    }
		return result;
	}//end method
	
	/**
	 * Method Name: isGreaterThan()
	 * Purpose: compares the rank of this card to the parameter and reutrns true if this 
	 * 					card's rank is greater tahn the parameter card's rank.
	 * Accepts: 
	 * @returns true if the parameter's rank is less than rank of this card.
	*/
	public boolean isGreaterThan(Card c)
	{
		if(c.getRank() <= this.getRank())
		{
			return true;
		}
		return false;
	}//end method
	
	/**
	 * Method Name: equals()
	 * Purpose: compares the rank of this card to the parameter and returns true if this 
	 * 					card's rank is equal to the parameter card's rank
	 * Accepts: 
	 * @returns true if the ranks are the same.
	*/
	public boolean equals (Card c)
	{
		if(c.getRank() == this.getRank())
		{
			return true;
		}
		return false;
	}//end method
	
	/**
	 * Method Name: toString()
	 * Purpose: returns a String that represents the current state of a Card object, 
	 * 					using the card's face value and its suit.
	 * Accepts: 
	 * @returns String
	*/
	public String toString()
	{
		return findFaceValue() + " - " + this.getSuit();
	}//end method
	
}//end class