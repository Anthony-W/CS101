import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String[] circles = {"yellow", "red", "blue", "black", "white"};
		
		//input the total radius
		System.out.println("What is the radius in cm of the entire target?");
		double radius = input.nextDouble();
		double radiusIncrement = radius/5;
		
		//calculate total area
		double totalArea = Math.PI * radius * radius;
		totalArea = Math.round(totalArea * 10000.0) / 10000.0;
		
		//calculate area for each ring
		double lastWholeArea = 0;
		for (int i = 1; i <= 5; i++) {
			
			//calculate the area and round
			double thisRadius = radiusIncrement*i;
			double thisWholeArea = Math.PI * thisRadius * thisRadius;
			double thisArea = thisWholeArea - lastWholeArea;
			thisArea = Math.round(thisArea * 10000.0) / 10000.0;
			
			//set lastArea for next pass
			lastWholeArea = thisWholeArea;
			
			//calculate percentage of total area
			double percentArea = thisArea/totalArea;
			
			//format percentage
			DecimalFormat df = new DecimalFormat("0%");
			String percentAreaOutput = df.format(percentArea);
			
			//print the area and percentage for each ring
			System.out.println("The color " + circles[i-1] + " has area " + thisArea 
							 + " cm^2 with " + percentAreaOutput + " of the total area.");
		}
		
		//print the total area
		System.out.println("The total area of the target is " + totalArea + "cm^2");
		
		input.close();
	}

}
