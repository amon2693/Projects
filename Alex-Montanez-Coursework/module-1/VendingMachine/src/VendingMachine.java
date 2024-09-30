import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VendingMachine {
    private Transactions transaction; // Instance of Transaction class

    public VendingMachine() {
        this.transaction = new Transactions(); // Initialize the Transaction instance
    }

    public void startTransaction() {
        transaction.startTransaction(); // Delegate to the Transaction instance
    }
    static Map<String, Integer> productIdAndInventory = new HashMap<String, Integer>();
    static Map<String, String> productIdAndName = new HashMap<String, String>();
    static Map<String, Integer> nameAndInventory = new HashMap<String, Integer>();
    static Map<String, Double> productIdAndPrice = new HashMap<String, Double>();

    public static void main(String[] args) {



        Scanner scanner = new Scanner(System.in);
        VendingMachine vendingMachine = new VendingMachine();
        boolean stillShopping = true;
        //Initial Display
        while (stillShopping) {
            System.out.println("Please select an option:");
            System.out.println("(1) Display Vending Machine Items");
            System.out.println("(2) Purchase");
            System.out.println("(3) Exit");
            int option = scanner.nextInt();
            File inventory = new File("vendingmachine.csv");
            if (inventory.exists() && inventory.isFile()) {
                try (Scanner reader = new Scanner(inventory)) {
                    String lineOfText;
                    if (reader.hasNextLine()) {
                        lineOfText = reader.nextLine();
                    }
                    while (reader.hasNextLine()) {
                        lineOfText = reader.nextLine();
                        String[] allThingsOnFile = lineOfText.split(",");

                        String productId = allThingsOnFile[0];
                        String productName = allThingsOnFile[1];
                        double price = Double.parseDouble(allThingsOnFile[2]);
                        int inventoryCount = Integer.parseInt(allThingsOnFile[4]);

                        // Populate maps
                        productIdAndInventory.put(productId, inventoryCount);
                        productIdAndName.put(productId, productName);
                        nameAndInventory.put(productName, inventoryCount);
                        productIdAndPrice.put(productId, price);
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("Unable to open vendingmachine.csv");
                }
            } else {
                System.out.println("Unable to open vendingmachine.csv");
            }

            if (option == 1) {
                System.out.println("Vending Machine Items:");
                for (Map.Entry<String, String> entry : productIdAndName.entrySet()) {
                    String productId = entry.getKey();
                    String productName = entry.getValue();
                    int inventoryCount = productIdAndInventory.get(productId);
                    double price = productIdAndPrice.get(productId); // Retrieve price using productName
                    System.out.println(productId + "," + productName + " ($" + price + ")" + ": " + inventoryCount);
                }


            } else if (option == 2) {
                System.out.println("Current Money Provided: $0.00");
                System.out.println();
                System.out.println("(1) Feed Money");
                System.out.println(("(2) Select Product"));
                System.out.println("(3) Finish Transaction");

                int transactionChoice = scanner.nextInt();
                if (transactionChoice == 1) {
                    vendingMachine.startTransaction();
                    if(transactionChoice == 5) {
                        vendingMachine.selectProduct();
                    }
                    stillShopping = false;
                } else if(transactionChoice == 2){
                    vendingMachine.selectProduct();
                }

            } else if (option == 3) {
                System.out.println("Thank you for shopping with CuteCo!");
                stillShopping = false;

            }
        }
    }
    public void selectProduct() {
        Scanner productScanner = new Scanner(System.in);
        System.out.println("Please enter the code of the product you want to purchase:");
        String productCode = productScanner.nextLine();

        if (productIdAndInventory.containsKey(productCode)) {
            double price = productIdAndPrice.get(productCode);

            if (transaction.getBalance() >= price) {
                // Sufficient balance, proceed with the transaction
                System.out.println("You have purchased: " + productIdAndName.get(productCode));
                transaction.balance -= price; // Deduct the price from the balance
                productIdAndInventory.put(productCode, productIdAndInventory.get(productCode) - 1); // Decrement inventory count

                System.out.println("Remaining balance: $" + String.format("%.2f", transaction.getBalance()));
            } else {
                System.out.println("Insufficient funds to purchase this item.");
            }
        } else {
            System.out.println("Invalid product code.");
        }

    }
}
