package com.techelevator;

import java.util.Locale;

public class StringFun {
    public static void main(String[] args) {


        String hello = "hello world";
        System.out.println(hello.length());

        //substring
        String words = "one two three four";
        System.out.println(words.substring(4));
        System.out.println(words.substring(4, 7));

        //contains
        System.out.println(words.contains("two"));
        System.out.println(words.contains("TWO"));

        //indexOf & charAt
        System.out.println(words.indexOf("two"));
        char tee = 't';
        System.out.println(words.charAt(4));

        //startsWith & endWith
        System.out.println(words.substring(0, 1).equals("o"));
        System.out.println(words.startsWith("o"));
        System.out.println(words.endsWith("four"));

        //toUpperCase & toLowerCase
        //returns a new string
        System.out.println(words.toLowerCase());
        System.out.println(words.toUpperCase());
        System.out.println(words.equalsIgnoreCase("ONE TWO THREE FOUR"));
        System.out.println(words.toUpperCase().contains("TWO"));

        // replace a string
        //strings are immutable, replace creates a new string
        String newString = words.replace("one", "five");
        System.out.println(newString);
        System.out.println(words);
    }
}
