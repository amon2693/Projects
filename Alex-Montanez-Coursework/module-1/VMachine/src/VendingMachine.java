import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class VendingMachine {
    HashMap<String, Product> products;

    public VendingMachine() {
        products = new HashMap<>();
    }

    public void loadProducts(String filename) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Product product = new Product(data[0], data[1], Double.parseDouble(data[2]), data[3], Integer.parseInt(data[4]));
                products.put(product.slotLocation, product);
            }
        }
    }

    public void displayItems() {
        for (Product product : products.values()) {
            String status = product.isSoldOut() ? "SOLD OUT" : "$" + String.format("%.2f", product.price) + ", " + product.quantity + " left";
            System.out.println(product.slotLocation + ": " + product.name + ", " + status);
        }
    }

    public void purchase(String slotLocation) {
        Product product = products.get(slotLocation);
        if (product != null) {
            System.out.println(product.dispense());
            logTransaction("PURCHASE", product.price);
        } else {
            System.out.println("Invalid selection!");
        }
    }

    public void logTransaction(String action, double amount) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("Log.txt", true))) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
            String timestamp = dateFormat.format(new Date());
            writer.println(timestamp + " " + action + ": $" + String.format("%.2f", amount));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
