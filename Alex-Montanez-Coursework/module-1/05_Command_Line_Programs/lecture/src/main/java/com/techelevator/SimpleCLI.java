package com.techelevator;

import java.sql.SQLOutput;
import java.util.Scanner;

public class SimpleCLI {
    public static void main(String[] args) {
        // 1. get info from user
        // 2. do something with the info
        // 3. output something back to the user

        // Standard Streams (Abstractions over a lot of complexity)
        // - standard in - a stream that represents keyboard (System.in)
        // - standard out - a stream that represents console/screen (System.out)

        Scanner userInput = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = userInput.nextLine();

        String greeting = "Hello " + name;

        System.out.println(greeting);

        System.out.println("How old are you?");
        String age = userInput.nextLine();

        age = "You are: " + age;
        System.out.println(age);
    }
}
