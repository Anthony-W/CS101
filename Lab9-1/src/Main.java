import java.util.Scanner;

public class Main
{

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int zeros = 0;
		int odds = 0;
		int evens = 0;
		
		
		String number = input.nextLine();
		char[] digits = number.toCharArray();
		
		for (int i = 0; i < digits.length; i++)
		{
			switch(digits[i])
			{
				//zerp
				case '0':
					zeros++;
					break;
				
				//odds
				case '1':
				case '3':
				case '5':
				case '7':
				case '9':
					odds++;
					break;
					
				//evens
				case '2':
				case '4':
				case '6':
				case '8':
					evens++;
					break;
			}
		}
		
		System.out.println("Zeros: " + zeros);
		System.out.println("Odds: " + odds);
		System.out.println("Evens: " + evens);
		
		input.close();
	}

}
