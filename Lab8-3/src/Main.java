import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int length = input.nextInt();
		if (length < 0) length *= -1;
		
		for (int i = 1; i <= length; i++)
		{
			for (int ii = 1; ii <= i; ii++)
			{
				System.out.print("*");
			}
			System.out.print(" ");
		}
		
		
		input.close();
	}

}
