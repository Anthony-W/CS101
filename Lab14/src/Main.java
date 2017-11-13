import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean exit = false;
		int numer = 0;
		int denom = 0;
		int quotient = 0;
		
		System.out.println("Enter 2 integers seperated by a space. Enter '0 0' to exit.");
		do
		{
			//get input and parse to integers
			try
			{
				numer = Integer.parseInt(input.next());
				denom = Integer.parseInt(input.next());
			}
			catch (NumberFormatException exception)
			{
				exception.printStackTrace();
				
				//clear scanner's buffer
				input.nextLine();
				
				//skip zero checking and calculation
				continue;
			}
			
			//check for zeroes
			if (denom == 0)
			{
				//numerator and denominator are both 0, exit
				if (numer == 0)
					exit = true;
				//trying to divide something by zero
				else
					System.out.println("You can't divide by 0.");
			}
			//denominator is not 0, normal calculation
			else
			{
				quotient = numer / denom;
				System.out.println("That quotient is " + quotient);
			}
			
			//clear scanner's buffer
			input.nextLine();
			
		} while (!exit);
		
		System.out.println("Goodbye");
		
		input.close();
	}

}
