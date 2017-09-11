import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("0%");
		
		//input the total radius
		System.out.println("What is the radius in cm of the entire target?");
		double radius = input.nextDouble();
		
		//calculate total area
		double totalArea = Math.PI * radius * radius;
		totalArea = Math.round(totalArea * 10000.0) / 10000.0;
			
		//calculate yellow circle
		double yellowRadius = radius/5;
		double yellowArea = Math.PI*Math.pow(yellowRadius, 2);
		yellowArea = Math.round(yellowArea * 10000.0) / 10000.0;
		double yellowPercent = yellowArea / totalArea;
		System.out.println("The color yellow has area " + yellowArea + " cm^2 with " 
							+ df.format(yellowPercent) + " of the total area.");
		
		//calculate red circle
		double redRadius = radius/5 * 2;
		double redArea = Math.PI*Math.pow(redRadius, 2) - yellowArea;
		redArea = Math.round(redArea * 10000.0) / 10000.0;
		double redPercent = redArea / totalArea;
		System.out.println("The color red has area " + redArea + " cm^2 with "
							+ df.format(redPercent) + " of the total area.");
		
		//calculate blue circle
		double blueRadius = radius/5 * 3;
		double blueArea = Math.PI*Math.pow(blueRadius, 2) - yellowArea - redArea;
		blueArea = Math.round(blueArea * 10000.0) / 10000.0;
		double bluePercent = blueArea / totalArea;
		System.out.println("The color blue has area " + blueArea + " cm^2 with " 
							+ df.format(bluePercent) + " of the total area.");
		
		//calculate black circle
		double blackRadius = radius/5 * 4;
		double blackArea = Math.PI*Math.pow(blackRadius, 2) - yellowArea - redArea - blueArea;
		blackArea = Math.round(blackArea * 10000.0) / 10000.0;
		double blackPercent = blackArea / totalArea;
		System.out.println("The color black has area " + blackArea + " cm^2 with " 
							+ df.format(blackPercent) + " of the total area.");
		
		//calculate white circle
		double whiteRadius = radius;
		double whiteArea = Math.PI*Math.pow(whiteRadius, 2) - yellowArea - redArea - blueArea - blackArea;
		whiteArea = Math.round(whiteArea * 10000.0) / 10000.0;
		double whitePercent = whiteArea / totalArea;
		System.out.println("The color white has area " + whiteArea + " cm^2 with " 
							+ df.format(whitePercent) + " of the total area.");
		
		
		//print the total area
		System.out.println("The total area of the target is " + totalArea + "cm^2");
		
		input.close();
	}

}
