import java.util.Scanner;

public class Main
{

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int consonants = 0;
		int vowels = 0;
		int punctuation = 0;
		int whitespace = 0;
		
		
		char[] text = input.nextLine().toCharArray();
		
		for (int i = 0; i < text.length; i++)
		{
			switch (text[i])
			{
				//vowels
				case 'a':
				case 'e':
				case 'i':
				case 'o':
				case 'u':
					vowels++;
					break;
				//consonants
				case 'b':
				case 'c':
				case 'd':
				case 'f':
				case 'g':
				case 'h':
				case 'j':
				case 'k':
				case 'l':
				case 'm':
				case 'n':
				case 'p':
				case 'q':
				case 'r':
				case 's':
				case 't':
				case 'v':
				case 'w':
				case 'x':
				case 'y':
				case 'z':
					consonants++;
					break;
					
				//punctuation
				case '.':
				case ',':
				case ';':
				case '!':
				case '?':
					punctuation++;
					break;
					
				//whitespace
				case '\\':
					i++;
				case ' ':
					whitespace++;
					break;
			}
		}

		System.out.println("Vowels: " + vowels);
		System.out.println("Consonants: " + consonants);
		System.out.println("Punctuation: " + punctuation);
		System.out.println("Whitespace: " + whitespace);
		
		input.close();
	}

}
