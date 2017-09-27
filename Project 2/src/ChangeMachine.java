/*
 * @author Anthony Wessel
 * <p> ChangeMachine.java
 * <p> Project 2
 * <p> Gets and stores the price of an item and the amount payed, and computes tax
 */ 

import java.text.DecimalFormat;
import java.util.Scanner;

public class ChangeMachine {

	static final float TAX_RATE = 0.05f;
	static final float MAX_PRICE = 500;
	
	public static void main(String[] args) {
		DecimalFormat outputFormat = new DecimalFormat("$0.00");
		Scanner input = new Scanner(System.in);
		float price, tax, payment, change;
		int hundreds, fifties, twenties, tens, fives, ones, quarters, dimes, nickels, pennies;
		
		while(true) {
			
			//cost of transaction
			do {
				System.out.print("Cost of transaction (enter 0 or negative to exit; max is $500.00): ");
				price = input.nextFloat();
			} while(price > 500);	
			if (price <= 0) break;
			
			//tax
			tax = price * TAX_RATE;
			price += tax;
			System.out.println("Amount due (with 5.00% tax): " + outputFormat.format(price));
			
			//payment amount
			System.out.print("Please enter payment amount: ");
			payment = input.nextFloat();
			while (payment < price) {
				System.out.println("That is not enough to pay for the object, please enter a correct payment");
				payment = input.nextFloat();
			}

			//change
			change = payment - price;
			if (change > 0) {
				System.out.println("Change back " + outputFormat.format(change));
				
				//how many hundreds
				hundreds = (int)(change / 100);
				change %= 100;
				System.out.print("$100: " + hundreds + "    ");
				
				//how many fifties
				fifties = (int)(change / 50);
				change %= 50;
				System.out.print("$50: " + fifties + "    ");
				
				//how many twenties
				twenties = (int)(change / 20);
				change %= 20;
				System.out.print("$20: " + twenties + "    ");
				
				//how many tens
				tens = (int)(change / 10);
				change %= 10;
				System.out.print("$10: " + tens + "    ");
				
				//how many fives
				fives = (int)(change / 5);
				change %= 5;
				System.out.print("$5: " + fives + "    ");
				
				//how many ones
				ones = (int)(change / 1);
				change %= 1;
				System.out.print("$1: " + ones + "    ");
				
				//how many quarters
				quarters = (int)(change / 0.25);
				change %= 0.25;
				System.out.print("$0.25: " + quarters + "    ");
				
				//how many dimes
				dimes = (int)(change / 0.1);
				change %= 0.1;
				System.out.print("$0.1: " + dimes + "    ");
				
				//how many nickels
				nickels = (int)(change / 0.05);
				change %= 0.05;
				System.out.print("$0.05: " + nickels + "    ");
				
				//how many pennies
				pennies = (int)(change / 0.01);
				change %= 0.01;
				System.out.print("$0.01: " + pennies + "    ");
				
				//start new line before restarting loop
				System.out.print("\n\n");
			} else {
				//payment = price+tax
				System.out.println("Exact Change! Amazing!\n");
			}
		}
		
		input.close();
		System.out.println("\nDone.");
	}

}