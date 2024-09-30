package com.techelevator;

public class Penguin extends StuffedAnimal{
    public Penguin(String name, double price) {
        super(name, price, sound);

    }
    static {sound = "Squawk, Squawk, Whee!";}
    public static String getSound() {
        return sound;
    }
}
