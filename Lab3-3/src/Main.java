import java.util.Scanner;

/*
 * Anthony Wessel
 * Main.java
 * Lab3-3
 * Misc mathematical commands to practice date types
 */
public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter initial value of x: ");
		String x = input.nextLine();
		System.out.println("Enter initial value of y: ");
		String y = input.nextLine();
		String temp = x;
		x = y;
		y = temp;
		System.out.println("x = " + x);
		System.out.println("y = " + y);
		
		input.close();
	}

}
