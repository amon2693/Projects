package com.techelevator;

import java.util.Random;

public class Dice {
    // Properties
    private int numberOfSides;
    private int currentFace;

    // Constructors
    public Dice(int numberOfSides) {
        if (numberOfSides < 4) {
            numberOfSides = 4;
        } else if (numberOfSides > 20) {
            numberOfSides = 20;
        }
        this.numberOfSides = numberOfSides;
    }

    //Getters and Setters
    public int getNumberOfSides() {
        return numberOfSides;
    }

    public int getCurrentFace() {
        return currentFace;
    }

    private void setCurrentFace(int currentFace) {
        this.currentFace = currentFace;
        if(currentFace < 1 || currentFace > numberOfSides){
            System.out.println("Invalid face to set. Minimum is 1, maximum is " + numberOfSides);
            return;
        }
    }

    // Other Methods
    public int rollDice() {
        int currentValue = 1;
        Random random = new Random();
        currentValue = random.nextInt(numberOfSides - 1) + 1;
        this.currentFace = currentValue;
        return currentValue;
    }
}
