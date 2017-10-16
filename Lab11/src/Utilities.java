public class Utilities {
	
	//returns that absolute value of the given number
	public static int absoluteValue(int num) {
		
		if (num < 0) return -num; //num is negative, make it positive
		
		else return num; //num is already positive
	}
	
	//returns the ceiling of the given number
	public static int ceiling(double num) {
		
		if (num == (int)num) return (int)num; //number is an integer
		
		else if (num < 0) return (int)num; //number is not an integer, and is negative
		
		else return (int)num + 1; //number is not an integer, and is positive
	}
	
	//returns the factorial of the given number
	public static long factorial(int num) {
		
		//create the result variable to return
		long product = 1;
		
		//compute the factorial
		for (int i = num; i > 0; i--) {
			product *= i;
		}
		
		return product;
	}
	
	//returns a string containing a pattern of the given length
	public static String getPatternOfLength(int length) {
		
		//interpret negative numbers as positive
		length = absoluteValue(length);
		
		//create result variable to return
		String result = "";
		
		//fill the result variable based on length variable
		for (int i = 1; i <= length; i++) {
			for (int j = 0; j < i; j++) {
				result += "x";
			}
			result += " ";
		}
		
		return result;
	}
}
