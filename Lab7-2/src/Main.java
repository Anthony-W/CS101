import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//create scanner and strings
		Scanner input = new Scanner(System.in);
		String string = "";
		String next;
		
		//print instructions
		System.out.println("Type 1 letter at a time. type a '.' when you are finished.");
		
		//concatenate each input to string 
		do {
			next = input.next();
			string += next;
		} while(!next.equals("."));
		
		//print full string
		System.out.println(string);
		
		input.close();
	}

}
