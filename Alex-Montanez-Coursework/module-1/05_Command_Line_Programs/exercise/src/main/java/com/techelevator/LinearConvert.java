package com.techelevator;

import java.util.Arrays;
import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {
		Scanner scanner = new Scanner (System.in);

		// prompt user to input length
		System.out.print("Please enter the length: ");
		double length = scanner.nextDouble();

		// prompt user for length scale input

		System.out.print("Is the measurement in (m)eters, or (f)eet? ");
		scanner.nextLine();
		String scale = scanner.nextLine();

		//convert length based on scale
		double convertedLength;
		final double METERS_CONVERSION = 0.3048;
		final double FEET_CONVERSION = 3.2808399;
		if(scale.equalsIgnoreCase("m")) {
			convertedLength = length * FEET_CONVERSION;
			System.out.printf("%.0fm is %.0ff.\n", length, Math.floor(convertedLength));
		} else if(scale.equalsIgnoreCase("f")) {
			convertedLength = (length * METERS_CONVERSION);
			System.out.printf("%.0ff is %.0fm.\n", length, Math.floor(convertedLength));
		} else {
			System.out.println("Invalid input. Please enter 'm' or 'f'.");
		}


	}

}
