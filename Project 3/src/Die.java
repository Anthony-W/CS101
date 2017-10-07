/*
* @author Anthony Wessel
* <p> Die
* <p> Project 3
* <p> simulates a single die, generates a random value for each roll and stores the face value
* 
*/

import java.util.Random;

//
// class to manage the value of a single simulated die
//
public class Die
{
	private int _pips = 1;
	private final int _MAX_PIPS = 6;
	private Random _randNum;
	
	// constructor that will create a Random class and generate a random start value.
	public Die()
	{
		_randNum = new Random();
		roll();
	}

	//
	// constructor that will create a Random class, set the seed of the RNG,
	// and generate a random start value.
	//
	public Die(int seed)
	{
		_randNum = new Random(seed);
		roll();
	}
	
	//
	// accessor to return the current value of the die.
	//
	public int faceValue()
	{
		return _pips;
	}

	//
	// mutator to randomly change the value of the die.
	//
	public int roll()
	{
		_pips = _randNum.nextInt(_MAX_PIPS) + 1;
		return _pips;
	}
}
