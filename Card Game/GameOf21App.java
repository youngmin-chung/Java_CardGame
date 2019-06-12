/**
 * Program Name: GameOf21App.java
 * Purpose: a tester class which allows a user to play the Game of 21
 * 1.	Print a message to the screen, and get the user’s name. 
 * 2.	Then create a GameOf21 object.  
 * 3.	Begin the card game, by calling startGame().
 * Coder: Youngminc Chung for Sec 01
 * Date: Mar 12, 2018
 */
import java.util.*;

public class GameOf21App
{

	public static void main(String[] args)
	{
		Scanner in = new Scanner (System.in);
		System.out.println("------------------------------------------");
		System.out.println("This application allows a player to play");
		System.out.println("------------------------------------------");
		System.out.print("Enter your name: " );
		String player = in.next();
		System.out.println("\n" + player + " , good luck! ");
		
		GameOf21 BlackJack = new GameOf21(player);
		BlackJack.startGame();
		in.close();
	}//end main

}//end class
