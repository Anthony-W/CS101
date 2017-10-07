/*
 * @author Anthony Wessel
 * <p> PigDice
 * <p> Project 3
 * <p> simulates one players set of dice, contains and rolls two Die and keeps track of total score and round score
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

// this class manages the state of the dice and the scoring
public class PigDice
{
	// keep track of total and round scores as well as the two dice.
	private int _totalScore = 0;
	private int _roundScore = 0;
	private Die _die1;
	private Die _die2;

	public PigDice()
	{
		_die1 = new Die(5);
		_die2 = new Die(10);
	}

	// accessor for total score
	public int currentTotal()
	{
		return _totalScore;
	}

	// accessor for this round score
	public int currentRound()
	{
		return _roundScore;
	}

	// accessor to see if the user has rolled a single "1" and loses turn
	public boolean piggedOut()
	{
		return singleOneRolled();
	}

	// mutator that simulates rolling two dice and evaluating the resulting score
	public void rollDice()
	{
		// Roll the die
		_die1.roll();
		_die2.roll();
	}

	// accessor for a formatted string of what the last roll looked like
	public String lastRoll()
	{
		return "D1 (" + _die1.faceValue() + "), D2 (" + _die2.faceValue() + ")";
	}

	public int evaluate()
	{
		int thisRollScore = 0;
		
		if (doubleOnesRolled()) //if you rolled 2 ones
			thisRollScore = 25;
		else if (piggedOut()) //if you rolled a single one (not 2)
			_roundScore = 0;
		else
			thisRollScore = _die1.faceValue() + _die2.faceValue(); //any other combination
		
		_roundScore += thisRollScore; //add the roll to the round score
		
		return thisRollScore;
	}

	private boolean singleOneRolled()
	{
		boolean firstDieOne = _die1.faceValue() == 1;
		boolean secondDieOne = _die2.faceValue() == 1;
		return !doubleOnesRolled() && (firstDieOne || secondDieOne);
	}

	private boolean doubleOnesRolled()
	{
		return _die1.faceValue() == 1 && _die2.faceValue() == 1;
	}

	//
	// mutator to end a round and keep the add this round to the total
	// also returns the total value of the round and resets the round total for next time
	//
	public int save()
	{
		_totalScore += _roundScore; //add round score to total score
		int result = _roundScore; //store round score so that _roundScore variable can be reset
		_roundScore = 0; //reset round score
		return result;
	}
}
