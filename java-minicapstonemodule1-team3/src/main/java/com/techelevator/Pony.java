package com.techelevator;

public class Pony extends StuffedAnimal {

    public Pony(String name, double price) {
        super(name, price, "Neigh, Neigh, Yay!");

    }
    static {sound = "Neigh, Neigh, Yay!";}
    public static String getSound() {
        return sound;
    }



}
