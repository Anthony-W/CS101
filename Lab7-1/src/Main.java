import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//create scanner
		Scanner input = new Scanner(System.in);
		
		//ask for and store input string as char[]
		System.out.println("Tell me something");
		char[] chars = input.nextLine().toCharArray();
		
		//print each char in chars
		for (int i = 0; i < chars.length; i++) {
			System.out.println(chars[i]);
		}
		
		input.close();
	}

}
