package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Game {

    // Properties
    List<Dice> gameDice = new ArrayList<>();

    // Constructors

    public Game(int[] diceSizes) {
        int i;
        for (i = 0; i < diceSizes.length; i++) {
            Dice myDice = new Dice(diceSizes[i]);
            myDice.rollDice();
            gameDice.add(myDice);
        }
    }



    // Methods

    public void run() {
        System.out.println("** Welcome to our amazing dice game **");
        System.out.println("Roll the dice and get " + rollAllDice());
        printGameDice();
    }
    public void printGameDice() {
        for (Dice myDice : gameDice) {
            System.out.println("Dice with " + "" + myDice.getNumberOfSides() + " sides is currently a " + myDice.getCurrentFace());
        }
    }

    public int rollAllDice() {
        int sumOfAllDice = 0;

        for (Dice myDice : gameDice) {
            sumOfAllDice += myDice.rollDice();
        }
        return sumOfAllDice;
    }
}
