import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println(Utilities.absoluteValue(input.nextInt()));
		System.out.println(Utilities.ceiling(input.nextDouble()));
		System.out.println(Utilities.factorial(input.nextInt()));
		System.out.println(Utilities.getPatternOfLength(input.nextInt()));
		
		input.close();
	}

}
