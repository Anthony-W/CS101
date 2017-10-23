public class PairOfDice {

	Die die1, die2; // Instance of each dice
	private int currentSum; // current sum of face value on both dice

	// default constructor
	public PairOfDice() {
		die1 = new Die(6);
		die2 = new Die(6);
	}

	// overloaded constructor to set number of sides for each die
	public PairOfDice(int sidesOnDie1, int sidesOnDie2) {
		die1 = new Die(sidesOnDie1);
		die2 = new Die(sidesOnDie2);
	}

	// roll both die and return the sum
	public int roll() {

		// generate new numbers
		die1.roll();
		die2.roll();

		// print each face value
		System.out.println("First Die: " + die1.toString());
		System.out.println("Second Die: " + die2.toString());

		// add the two die together
		currentSum = die1.currentFace() + die2.currentFace();

		return currentSum;
	}

	// return the current sum of the face values
	public int currentSum() {
		return currentSum;
	}
}
