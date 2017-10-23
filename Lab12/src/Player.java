
public class Player {

	public static void main(String[] args) {

		// initialize the dice
		PairOfDice dice = new PairOfDice(21, 21);

		// roll 10 times and print each result
		for (int i = 0; i < 10; i++) {
			System.out.println("You rolled " + dice.roll());
			System.out.println("");
		}
	}

}
