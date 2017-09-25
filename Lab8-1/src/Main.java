import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num;
		
		//read in number until it is between -13 and 13
		do
		{
			num = input.nextInt();
		}
		while (num < -13 || num > 13);
		
		System.out.println("Done.");
		
		input.close();
	}

}