import java.util.Random;

public class Die {

	private final int MAX_SIDES = 20; // maximum number of side for the die
	private int numSides; // number of sides on this die
	private int currentFace = 1; // current face value of this die
	Random random = new Random(); // random number generator

	// default constructor
	public Die() {
		numSides = 6;
	}

	// overloaded constructor to set number of sides on this die
	public Die(int sides) {
		if (sides < MAX_SIDES)
			numSides = sides;
		else 
			numSides = 6;
	}

	// generate a new face value
	public void roll() {
		currentFace = random.nextInt(numSides) + 1;
	}

	// return the current face value of this die
	public int currentFace() {
		return currentFace;
	}

	// return the string representation of the face value
	@Override
	public String toString() {
		return Integer.toString(currentFace);
	}

}
