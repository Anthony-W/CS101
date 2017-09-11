import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please enter a decimal number");
		Integer num = input.nextInt();
		
		System.out.println("This is your number in binary: " + Integer.toBinaryString(num));
		System.out.println("This is your number in octal: " + Integer.toOctalString(num));
		System.out.println("This is your number in hexadecimal: " + Integer.toHexString(num));
		
		input.close();
	}

}
