package com.techelevator;

public class Cat extends StuffedAnimal{

    public Cat(String name, double price) {
        super(name, price, "Purr, Purr, Meow!");
    }
    static {sound = "Purr, Purr, Meow!";}
    public static String getSound() {
        return sound;
    }
}

