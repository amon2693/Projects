package com.techelevator;

public class Duck extends StuffedAnimal{

    public Duck(String name, Double price) {
    super(name, price, "Quack, Quack, Splash!");

}
static {sound = "Quack, Quack, Splash!";}
    public static String getSound() {
        return sound;
    }
}

