import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		long num, factorial = 1;
		
		//read in number until it is between 0 and 13
		num = input.nextInt();
		while (num < 0 || num > 13) {
			System.out.println("The number must be between 0 and 13 inclusive.");
			num = input.nextInt();
		}
		
		//calculate the factorial
		for (long i = num; i > 0; i--)
		{
			factorial *= i;
		}
		
		System.out.println(num + "! = " + factorial);
		
		input.close();
	}

}
