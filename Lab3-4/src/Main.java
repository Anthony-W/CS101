import java.util.Scanner;

/*
 * Anthony Wessel
 * Main.java
 * Lab3-4
 * Misc mathematical commands to practice date types
 */
public class Main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter a radius value: ");
		double radius = input.nextDouble();
		System.out.println("Diameter = " + 2*radius);
		System.out.println("Circumference = " + 2*Math.PI*radius);
		System.out.println("Area = " + Math.PI*(radius*radius));
		
		input.close();
	}

}
