package com.techelevator;

import java.util.Arrays;

public class StringFun {
    public static void main(String[] args) {
        String hello = "hello";
        String world = " world";
        String full = hello + " " + world;
        String expected = "hello world";
        System.out.println(full);


        String oneAsAString = "1";
        System.out.println(oneAsAString + 5);
        int one = Integer.parseInt(oneAsAString) + 5;
        System.out.println(one);
        Long.parseLong("1");
        Double.parseDouble("42.0");
        Boolean.parseBoolean("true");

        int theAnswer = 42;
        System.out.println("the answer is: " + theAnswer);

        String formatString = "X=%s Y=%s Z=%s";
        System.out.println(String.format(formatString, 8, 13, 22));
        System.out.println(String.format(formatString, 100, 243, 4));

        System.out.print("a");
        System.out.print("b");
        System.out.print("c");
        System.out.print("d");
        System.out.println("e");
        System.out.print("f");
        System.out.println("");
        System.out.printf("<%d>\n", 52);
        System.out.printf("<%d>\n", 52);

        // %s = general
        // %d = integer data types
        // %f = floating point data types


    }

}
