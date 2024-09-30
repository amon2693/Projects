import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Product {
    String slotLocation;
    String name;
    double price;
    String type;
    int startingQty;
    int quantity;

    public Product(String slotLocation, String name, double price, String type, int startingQty) {
        this.slotLocation = slotLocation;
        this.name = name;
        this.price = price;
        this.type = type;
        this.startingQty = startingQty;
        this.quantity = startingQty;
    }

    public boolean isSoldOut() {
        return quantity == 0;
    }

    public String dispense() {
        if (!isSoldOut()) {
            quantity--;
            return getSound() + " " + name + ", $" + String.format("%.2f", price);
        } else {
            return "SOLD OUT";
        }
    }

    public String getSound() {
        switch (type) {
            case "Duck":
                return "Quack, Quack, Splash!";
            case "Penguin":
                return "Squawk, Squawk, Whee!";
            case "Cat":
                return "Purr, Purr, Meow!";
            case "Pony":
                return "Neigh, Neigh, Yay!";
            default:
                return "";
        }
    }
}
