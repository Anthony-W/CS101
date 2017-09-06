import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please enter your first name");
		String firstName = input.nextLine();
		char firstLetter = firstName.toLowerCase().charAt(0);
		
		System.out.println("Please enter your last name");
		String lastName = input.nextLine();
		String firstFive = lastName.toLowerCase().substring(0, 5);
		
		Random r = new Random();
		int firstNumber = r.nextInt(10);
		int secondNumber = r.nextInt(10);
		
		String result = firstLetter + firstFive + firstNumber + secondNumber;
		System.out.println(result);
		
		input.close();
	}

}
