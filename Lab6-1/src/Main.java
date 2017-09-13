import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//input letter grade
		System.out.println("Please enter a letter grade.");
		String letter = input.nextLine().toUpperCase();
		
		//A
		if (letter.equals("A")) {
			System.out.println("Letter grade: A");
			System.out.println("Comment: Superior");
		//B
		} else if (letter.equals("B")) {
			System.out.println("Letter grade: B");
			System.out.println("Comment: Good");
		//C
		} else if (letter.equals("C")) {
			System.out.println("Letter grade: C");
			System.out.println("Comment: Average");
		//D
		} else if (letter.equals("D")) {
			System.out.println("Letter grade: D");
			System.out.println("Comment: Just Passing");
		//F
		} else if (letter.equals("F")) {
			System.out.println("Letter grade: F");
			System.out.println("Comment: Failure");
		//any other letter
		} else {
			System.out.println("Letter grade: " + letter);
			System.out.println("Comment: ERROR- Invalid letter grade");
		}

		input.close();
	}

}
