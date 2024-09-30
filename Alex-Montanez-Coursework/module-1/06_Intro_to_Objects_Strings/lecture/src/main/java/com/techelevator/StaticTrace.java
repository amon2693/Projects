package com.techelevator;

public class StaticTrace {
    public static void main(String[] args) {

        methodA();
    }

    private static void methodA() {
        
        methodB();
    }

    private static void methodB() {

        int result = 1/0;
    }
}
