package com.electricityBill.Bill;
import java.util.Random;

public class random2 {
	

	
	    public static void main(String[] args) {
	        // Create a Random object
	        Random random = new Random();

	        // Generate a random integer
	        int randomNumber = random.nextInt(); // Generates a random integer within the full range of integers
	        System.out.println("Random Number: " + randomNumber);

	        // Generate a random integer within a specific range (e.g., between 0 and 100)
	        int randomInRange = random.nextInt(101); // Generates a random integer between 0 (inclusive) and 101 (exclusive)
	        System.out.println("Random Number in Range: " + randomInRange);

	        // Generate a random double
	        double randomDouble = random.nextDouble(); // Generates a random double between 0.0 (inclusive) and 1.0 (exclusive)
	        System.out.println("Random Double: " + randomDouble);
	    }
	
}
