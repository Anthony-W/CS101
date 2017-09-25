import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//get the int from the user for the length of one side of the triangle
		System.out.print("Enter the size of the equal sides in an isosceles triangle: ");
		int length = input.nextInt();
		
		System.out.println("*"); //top of the triangle
		
		//loop through the rows
		for(int i = 0; i < length-1; i++)
		{
			System.out.print("*");
			
			//loop through each * or " " in a specific row
			for(int ii = 0; ii < i; ii++)
			{
				//determine whether this is the bottom line of the triangle
				if (i < length - 2)
					System.out.print(" ");
				else
					System.out.print("*");
			}
			System.out.println("*");
		}
		
		input.close();
	}

}
