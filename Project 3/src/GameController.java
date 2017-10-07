/*
 * @author Anthony Wessel
 * <p> GameController
 * <p> Project 3
 * <p> general game structure, contains each player and controls the game flow
 */
 
//
// The rules to the dice game Pig
//
// Number of Players: 2 + 
// Game Duration: 30 mins
// Players Aged: 6 +
//
// You will need: 2 dice and paper to score on.
//
// To Play: The players take turns to roll both dice, 
// they can roll as many times as they want in one turn.
//
// A player scores the sum of the two dice thrown and 
// gradually reaches a higher score as they continue to roll.
//
// If a single number 1 is thrown on either die, the score 
// for that whole turn is lost. However a double 1 counts as 25.
// The first player to 100 wins unless a player scores more 
// subsequently in the same round. This means that everyone in 
// the game must have the same number of turns.
//

import java.util.Scanner;

public class GameController
{
	// central method to start and manage game play
	public void play()
	{
		//set up scanner and players
		Scanner scanner = new Scanner(System.in);
		PigDice player1 = new PigDice();
		PigDice player2 = new PigDice();
		
		//get the max score
		int maxScore = getInitialMax(scanner);
		
		//gameplay loop
		while (player1.currentTotal() < maxScore && player2.currentTotal() < maxScore) {
			//player 1's turn
			System.out.println("\nPLAYER 1");
			takeTurn(scanner, player1);
			
			//player 2's turn
			System.out.println("\nPLAYER 2");
			takeTurn(scanner, player2);
			
			//print out current total scores
			System.out.println("\nPlayer 1: " + player1.currentTotal() + " -- Player 2: " + player2.currentTotal());
		}
		
		//print out the winner
		if (player1.currentTotal() > player2.currentTotal())
			System.out.println("\nPlayer 1 wins!");
		else if (player1.currentTotal() < player2.currentTotal())
			System.out.println("\nPlayer 2 wins");
		else
			System.out.println("\nThe result is a tie.");
		
		//new game?
		System.out.println("would you like to play again? Respond (Y/N) only.");
		if (scanner.nextLine().substring(0,1).toUpperCase().equals("Y"))
			play();
		else
			System.out.println("Goodbye");
	}

	//
	// Returns the initial max score (loops until a value between 1 <= score <= 100 is entered) 
	//
	private int getInitialMax(Scanner kb)
	{
		int max;
		do {
	        System.out.println("What score would you like to play to? (100 max)");
			max = kb.nextInt();
			kb.nextLine(); //prevents error in yesResponse method
		} while (max < 1 || max > 100);
		
		return max;
	}
	
	//
	// method for managing a single session of rolling dice
	//
	private void takeTurn(Scanner kb, PigDice pd)
	{
		String response;
		boolean keepRolling = true;

		do
		{
			// Roll the dice
			pd.rollDice();

			// Report the result
			System.out.println(pd.lastRoll() + " scored " + pd.evaluate() + " points.");
			
			// Did the player pig out?
			if (pd.piggedOut())
			{	
				System.out.println("You pigged out this turn.");
			}
			else
			{
				//
				// Roll again; see if the user wants to roll again to add to total or pass and keep current points
				//
				System.out.println("Your current roll is " + pd.currentRound() + " points. Keep rolling? Respond (Y/N) only.");
				if (!yesResponse(kb))
				{
					keepRolling = false;
					int roundScore = pd.save();
					System.out.printf("Your total for the round was %d and your total score is %d.\r\n", roundScore, pd.currentTotal());
				}
			} 

		} while (!pd.piggedOut() && keepRolling);
	}
	
	//
	// Returns true if the user enters a 'y' or 'Y'
	//
	final String _YES = "Y";
	public boolean yesResponse(Scanner kb)
	{
		String answer = kb.nextLine();
		return answer.substring(0, 1).toUpperCase().equals(_YES); //TODO: This code is causing an exception
	}
}
