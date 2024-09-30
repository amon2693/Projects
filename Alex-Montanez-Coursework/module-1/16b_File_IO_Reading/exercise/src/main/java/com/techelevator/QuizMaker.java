package com.techelevator;

import java.io.File;
import java.util.Scanner;

public class QuizMaker {

	// Use this scanner for all user input. Don't create additional Scanners with System.in
	private final Scanner userInput = new Scanner(System.in);

	public static void main(String[] args) {
		QuizMaker quizMaker = new QuizMaker();
		quizMaker.run();
	}

	public void run() {
		/* Your code goes here */
		Scanner scanner = new Scanner(System.in);


		System.out.println("Enter the fully qualified name of the file to read in for quiz questions");
		String file = scanner.nextLine();

		System.out.println("What color is the sky?");
		System.out.println("1. Yellow");
		System.out.println("2. Blue");
		System.out.println("3. Green");
		System.out.println("4. Red");
		int answer1 = scanner.nextInt();



	}

}
