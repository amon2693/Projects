package com.techelevator;

import java.util.Scanner;

public class Guess {
    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        int secret = (int)(Math.random() * 100) + 1;


        // prompt the user
        boolean keepAsking = true;
        while(keepAsking) {
            System.out.println("Pick a number between 1 and 100");
            String input = userInput.nextLine();
            int guess = Integer.parseInt(input);

            if (guess < secret) {
                System.out.println("Guess higher");
            } else if (guess > secret) {
                System.out.println("Guess lower");
            } else {
                System.out.println("You are correct!");
                keepAsking = false;
            }

        }
    }
}
