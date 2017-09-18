import java.util.Scanner;

/*
 * @author Anthony Wessel
 * <p> TimeInterpreter.java
 * <p> Project 1
 * <p> Simplify an input time
 */ 

public class TimeInterpreter {

	//constants
	static final int SECONDS_PER_DAY = 86400;
	static final int SECONDS_PER_HOUR = 3600;
	static final int SECONDS_PER_MINUTE = 60;
	
	public static void main(String[] args) {
		
		//create scanner
		Scanner input = new Scanner(System.in).useDelimiter("\\s*:\\s*");
		
		//variables to store individual numbers for output
		long outputDays = 0;
		long outputHours = 0;
		long outputMinutes = 0;
		long outputSeconds = 0;
		
		//conditions for specific formatting of output
		boolean startPrintingAll = false;
		boolean negative = false;
		
		//string to store full output
		String output = "";
		
		//ask for input
		System.out.println("Please input a time in the following format.");
		System.out.println("<hours>:<minutes>:<seconds>:");
		
		//store input
		int inputHours = input.nextInt();
		int inputMinutes = input.nextInt();
		int inputSeconds = input.nextInt();
		
		//convert all input into seconds and store sum in totalInputSeconds
		long totalInputSeconds = inputHours*SECONDS_PER_HOUR + inputMinutes*SECONDS_PER_MINUTE + inputSeconds;
		
		//determine if time is negative
		if (totalInputSeconds < 0) {
			negative = true;
			totalInputSeconds *= -1;
		}
		
		//pull number of days out of total seconds
		if (totalInputSeconds >= SECONDS_PER_DAY) {
			outputDays = totalInputSeconds / SECONDS_PER_DAY;
			totalInputSeconds %= SECONDS_PER_DAY;
		}
		
		//pull number of hours out of total seconds
		if (totalInputSeconds >= SECONDS_PER_HOUR) {
			outputHours = totalInputSeconds / SECONDS_PER_HOUR;
			totalInputSeconds %= SECONDS_PER_HOUR;
		}
		
		//pull number of minutes out of total seconds
		if (totalInputSeconds >= SECONDS_PER_MINUTE) {
			outputMinutes = totalInputSeconds / SECONDS_PER_MINUTE;
			totalInputSeconds %= SECONDS_PER_MINUTE;
		}
		
		outputSeconds = totalInputSeconds;
		
		//if time was negative, add a negative sign at the start of the output string
		if (negative) {
			output += "-";
		}
		
		//if the time is 1 day or greater, concatenate the number of days
		if (outputDays > 0) {
			output += outputDays + ":";
			startPrintingAll = true;
		}
		
		//if the time is 1 hour or greater, concatenate the number of hours
		if (outputHours > 0 || startPrintingAll) {
			output += outputHours + ":";
			startPrintingAll = true;
		}
		
		//if the time is 1 minute or greater, concatenate the number of minutes
		if (outputMinutes > 0 || startPrintingAll) {
			output += outputMinutes + ":";
		}
		
		//concatenate the remaining seconds
		output += outputSeconds + ":";
		
		//print the final output time
		System.out.println(output);
		
		//close the scanner
		input.close();
	}

}
