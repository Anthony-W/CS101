import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//input growth rate
		System.out.println("Please enter the annual growth rate percentage");
		float growthRate = input.nextFloat();
		
		//input inflation
		System.out.println("Please enter the current inflation percentage");
		float inflation = input.nextFloat();
		
		//determine output
		if (growthRate < 1) {
			if (inflation < 3) {
				System.out.println("Increase welfare spending, reduce personal taxes, and decrease discount rate.");
			} else {
				System.out.println("Reduce business taxes.");
			}
		} else if (growthRate > 4) {
			if (inflation < 1) {
				System.out.println("Increase personal and business taxes, and decrease discount rate.");
			} else if (inflation > 3) {
				System.out.println("Increase discount rate");
			} else {
				System.out.println("No change in economic policy");
			}
		} else {
			System.out.println("No change in economic policy");
		}
		
		
		input.close();
	}

}
