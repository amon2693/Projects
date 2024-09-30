package com.techelevator;

public abstract class StuffedAnimal {

    protected String name;
    protected static String sound;
    protected double price;

    public StuffedAnimal(String name, double price, String sound) {
        this.name = name;
        this.price = price;
        this.sound = sound;
    }

    public String getName() {
        return name;
    }


}
