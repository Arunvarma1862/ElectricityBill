package com.electricityBill.Bill;

public class random {
	
	    public static void main(String[] args) {
	        // Generate a random double between 0.0 (inclusive) and 1.0 (exclusive)
	        double randomDouble = Math.random();
	        System.out.println("Random Double: " + randomDouble);

	        // Generate a random double within a specific range (e.g., between 0 and 100)
	        double randomDoubleInRange = Math.random() * 100; // Generates a random double between 0 (inclusive) and 100 (exclusive)
	        System.out.println("Random Double in Range: " + randomDoubleInRange);
	    }
	


}
