/**
 * Program Name: GameOf21.java
 * Purpose: a class which uses a Deck object and Hand object
 * Coder: Youngminc Chung for Sec 01
 * Date: Mar 12, 2018
 */
import java.util.*;

public class GameOf21
{
	//data members
	private Deck deck;
	private Hand user;
	private Hand computer;
	private static Scanner in = new Scanner(System.in);
	
	public GameOf21 (String player)
	{
		this.user = new Hand(player);
		this.deck = new Deck();
		this.computer = new Hand("Computer"); // computer is delaer
	}
	
	//getters and setters for fields
	/**
	 * @return the deck
	 */
	public Deck getDeck()
	{
		return deck;
	}//end method

	/**
	 * @param deck the deck to set
	 */
	public void setDeck(Deck deck)
	{
		this.deck = deck;
	}//end method

	/**
	 * @return the user
	 */
	public Hand getUser()
	{
		return user;
	}//end method

	/**
	 * @param user the user to set
	 */
	public void setUser(Hand user)
	{
		this.user = user;
	}//end method

	/**
	 * @return the computer
	 */
	public Hand getComputer()
	{
		return computer;
	}//end method
	
	/**
	 * @param computer the computer to set
	 */
	public void setComputer(Hand computer)
	{
		this.computer = computer;
	}//end method
	

	/**
	 * Method Name: startGame()
	 * Purpose: will begin the card game by calling the printTitle(), printinstructions(), and 
	 * 					playGame() mehtods.
	 * Accepts: 
	 * @returns nothing
	*/	
	public void startGame()
	{
		this.printTitle();
		this.printInstructions();
		this.playGame();
	}//end method

	/**
	 * Method Name: printTitle()
	 * Purpose: prints the title fo the Game of 21.
	 * Accepts: 
	 * @returns nothing
	*/	
	private void printTitle()
	{
		System.out.println("\n------------------------------------------");
		System.out.println("Welcome to the Game of 21!");
		System.out.println("------------------------------------------");
	}//end method
	
	/**
	 * Method Name: printInstructions()
	 * Purpose: prints the instructions for the Game of 21.
	 * Accepts: 
	 * @returns nothing
	*/	
	private void printInstructions()
	{
		System.out.println("HOW TO PLAY:");
		System.out.println("--------------------------------------------------------------------------------------");
		System.out.println("The objective of the game is get the closest to 21 without going over. The player "
				+ "\nand the computer are dealt 2 cards. The player’s cards are both face up, but the computer’s"
				+ "\ncards are one up and one down. The player is allowed to draw additional cards to improve his"
				+ "\nhand, without going over 21. The computer can then choose to draw cards; though the computer "
				+ "\nwill not draw if the player has busted. Face cards have a value of 10. Aces can be high or " 
				+ "\nlow (that is, 11 points or 1 point) depending on which is the best value which achieves"
				+ "\n the closest score to 21 without going over. After cards have been drawn by the player and "
				+ "\nthe computer, the score is totaled and a winner is declared.");
		System.out.println("--------------------------------------------------------------------------------------");
	}//end method
	
	/**
	 * Method Name: playGame()
	 * Purpose: displays the deck’s size.  
	 * 					Then, playGame() deals two cards to each player	(by having each player get cards 
	 * 					from the deck by calling its draw() method).  
	 * 					Call displayAllCards() on the user’s hand, and call displayVisibleCards() on 
	 * 					the computer’s hand.  
	 * 					Then, playGame() displays each player’s hand, 
	 * 					calls	userDraws() and computerDraws(), followed by calls to the printWinner() 
	 * 					and the playAgain() methods.
	 * Accepts: 
	 * @returns nothing
	*/	
	private void playGame()
	{
		// using two boolean two times, we figure out that user and computer goes or stands.  
		boolean loopFlag1 = true;
		boolean loopFlag2 = true;
		
		System.out.println("\nThe deck has " + deck.size() + " cards.");
		user.hit(deck.dealCard());
		user.hit(deck.dealCard());
		computer.hit(deck.dealCard());
		computer.hit(deck.dealCard());
		System.out.println("\n" + user.getPlayerName() + " has " + user.cards.size() + " cards:");
		user.displayAllcards();
		System.out.println("\nComputer has " + computer.cards.size() + " cards:");
		computer.displayVisiblecards();
		System.out.println("");
		
		while(loopFlag1 == true)
		{
			System.out.print("Do you want another card (Y/N)? ");
			char userInput = in.next().charAt(0);
			System.out.println("");
			if(userInput == 'y')
			{
				userDraws();
				System.out.println(user.getPlayerName() + " has " + user.cards.size() + " cards:");
				user.displayAllcards();
				if(user.totalHand() > 21)
				{
					System.out.println("\n" + user.getPlayerName() + " busts.");
					loopFlag1 = false;
				}
				else
				{
					break;
				}
			}
			while (loopFlag2 == true)
				if(loopFlag2 == true)
				{
					if(computer.totalHand() > 21)
					{
						System.out.println("\nComputer busts.");
						loopFlag2 = false;
					}
					else if (user.totalHand() > 21 || computer.totalHand() > user.totalHand())
					{
						System.out.println("Computer stands.");
						System.out.println("\nComputer has " + computer.cards.size() + " cards:");
						computer.displayAllcards();
						System.out.println("");
						loopFlag2 = false;
					}
					else
					{
						computerDraws();
						System.out.println("Computer has " + computer.cards.size() + " cards:");
						computer.displayAllcards();
						System.out.println("");
					}
				}
			this.printWinner();
			this.playAgain();
		  }
	}//end method
	
	/**
	 * Method Name: userDraws()
	 * Purpose: repeatedly asks the user if he wants to draw another card and, 
	 * 					if he does, draws another card; otherwise the user stands.
	 * Accepts: 
	 * @returns nothing
	*/	
	private void userDraws()
	{
		user.hit(deck.dealCard());
	}//end method

	/**
	 * Method Name: computerDraws()
	 * Purpose: The computer can then choose to draw cards. the computer will not draw 
	 * 					if the player has busted; in this case, the computer stands. 
	 * Accepts: 
	 * @returns nothing
	*/	
	private void computerDraws()
	{
		computer.hit(deck.dealCard());
	}//end method
	
	/**
	 * Method Name: printWinner()
	 * Purpose: checks the total prints of each winner. The player with the points closest to 21
	 * 					without going over is the winner. A draw occurs if the points are equal.
	 * Accepts: 
	 * @returns nothing
	*/	
	private void printWinner()
	{
		System.out.println("--------------------------------");
		System.out.println("Game of 21 - Final Score");
		System.out.println("--------------------------------");
		System.out.println(user.getPlayerName() + " points:\t" + user.totalHand());
		System.out.println(computer.getPlayerName() + " points:\t" + computer.totalHand());
		System.out.println("--------------------------------");
		if (user.totalHand() == computer.totalHand())
			System.out.println("Game is a draw.");
		else if (user.totalHand() > 21 && computer.totalHand() <= 21)
			System.out.println("Computer wins!");
		else if (user.totalHand() <= 21 && computer.totalHand() > 21)
			System.out.println(user.getPlayerName() + " wins!");
		else if (user.totalHand() < computer.totalHand())
			System.out.println("Computer wins!");
		else
			System.out.println(user.getPlayerName() + " wins!");
		System.out.println("--------------------------------");
	}//end method
	
	/**
	 * Method Name: playAgain()
	 * Purpose: prompts the user to play again, gets the user's resonse to play again and, if 
	 * 					yes AND the deck still has enough cards to deal again, empies the Players
	 * 					hands and plays the game again; otherwise prints an exit message.
	 * Accepts: 
	 * @returns nothing
	*/	
	private void playAgain()
	{
		System.out.print("\nPlay another game (Y/N)? ");
		char userInput = in.next().charAt(0);
		System.out.println("");
		if(userInput == 'y')
		{
			if(deck.size() > 6)
			{
				user.cards.removeAll(user.cards);
				computer.cards.removeAll(computer.cards);
				this.playGame();
			}
			else
			{
				System.out.println("Deck has only " + deck.size() +" cards left.");
				System.out.println("Thanks for playing! Bye!");
			}
		}
		else if (userInput == 'n')
		{
			System.out.println("Thanks for playing! Bye!");
		}
	}//end method
}//end class