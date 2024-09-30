package com.techelevator;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VendingMachine {

    private static Transactions transaction; // Instance of Transaction class

    public VendingMachine() {
        this.transaction = new Transactions(); // Initialize the Transaction instance
    }

    public void startTransaction() {
        transaction.startTransaction(); // Delegate to the Transaction instance
    }
    static Map<String, Integer> productIdAndInventory = new HashMap<String, Integer>();
    static Map<String, String> productIdAndName = new HashMap<String, String>();
    static Map<String, Integer> nameAndInventory = new HashMap<String, Integer>();
    static Map<String, String> productIdAndPrice = new HashMap<String, String>();
    static Map<String, String> productIdAndProductType = new HashMap<String, String>();

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
            String option = scanner.nextLine();
            File inventory = new File("vendingmachine.csv");
            if (inventory.exists() && inventory.isFile()) {
                try (Scanner reader = new Scanner(inventory)) {
                    String lineOfText;

                    while (reader.hasNextLine()) {
                        lineOfText = reader.nextLine();
                        String[] allThingsOnFile = lineOfText.split(",");
                        String productId = allThingsOnFile[0];
                        String productName = allThingsOnFile[1];
                        String price = allThingsOnFile[2];
                        int inventoryCount = Integer.parseInt(allThingsOnFile[4]);
                        String productType = allThingsOnFile[3];

                        // Populate maps
                        productIdAndInventory.put(productId, inventoryCount);
                        productIdAndName.put(productId, productName);
                        nameAndInventory.put(productName, inventoryCount);
                        productIdAndPrice.put(productId, price);
                        productIdAndProductType.put(productId, productType);
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("Unable to open vendingmachine.csv");
                }
            } else {
                System.out.println("Unable to open vendingmachine.csv");
            }

            if (option.equals("1")) {
                System.out.println("Vending Machine Items:");
                for (Map.Entry<String, String> entry : productIdAndName.entrySet()) {
                    String productId = entry.getKey();
                    String productName = entry.getValue();
                    int inventoryCount = productIdAndInventory.get(productId);
                    String price = productIdAndPrice.get(productId); // Retrieve price using productName
                    System.out.println(productId + "," + productName + " ($" + price + ")" + ": " + inventoryCount);
                    System.out.println();
                }


            } else if (option.equals("2")) {
                System.out.println("Current Money Provided: " + transaction.getBalance());
                System.out.println();
                System.out.println("(1) Feed Money");
                System.out.println(("(2) Select Product"));
                System.out.println("(3) Finish Transaction");

                String choiceStr = scanner.nextLine();

                if (choiceStr.equals("1")){
                    vendingMachine.startTransaction();
                } else if(choiceStr.equals("2")){
                    vendingMachine.selectProduct();
                }

            } else if (option.equals("3")) {
                System.out.println("Thank you for shopping with CuteCo!");
                double change = transaction.getBalance();
                System.out.printf("Your change is: $%.2f%n", change);
                System.out.println();
                System.out.println();

                transaction.giveChange(change);
                transaction.setBalance(0.00);
                stillShopping = false;
            }
        }
    }
    private void selectProduct() {
        boolean keepGoing = true;
        Scanner product = new Scanner(System.in);
        while (keepGoing) {
            System.out.println("Please select your new best friend!");
            String code = product.nextLine();
            String usableCode = code.toUpperCase();
            String animalName = productIdAndName.get(usableCode);
            String price = productIdAndPrice.get(usableCode);
            String animalType = productIdAndProductType.get(usableCode);
            System.out.println("You have chosen a " + animalName + "!");
            System.out.println("Good choice!  She was getting lonely.");
            System.out.println();
            if (transaction.getBalance() >= Double.parseDouble(price)) {
                double currentBalance = transaction.getBalance();
                double newBalance = currentBalance - Double.parseDouble(price);
                String amountLeft = Double.toString(newBalance);
                transaction.setBalance(newBalance);
                if (animalType.equals("Pony")) {
                    System.out.println(Pony.getSound());
                }
                if (animalType.equals("Penguin")) {
                    System.out.println(Penguin.getSound());
                }
                if (animalType.equals("Duck")) {
                    System.out.println(Duck.getSound());
                }
                if (animalType.equals("Cat")) {
                    System.out.println(Cat.getSound());
                }
                Transactions.transactionLog(animalName + " " + code, price);
                System.out.println();
                System.out.println("You have $" + String.format("%.2f", Double.parseDouble(amountLeft)) + " left.");
                System.out.println("Would you like to make another selection?");
                System.out.println();
                System.out.println("If yes, press 1.  If no, press 2");
                String yesOrNo = product.nextLine();
                boolean loop = true;
                while(loop){
                if (yesOrNo.equals("2")) {
                    keepGoing = false;
                    loop = false;
                }
                else if (yesOrNo.equals("1")){
                    keepGoing = true;
                    loop = false;
                }
                else {
                    System.out.println("Not a valid input");
                    System.out.println("Please select 1 or 2");
                    loop = false;
                }

            }
            if(transaction.getBalance() < Double.parseDouble(price)){
                System.out.println("I'm sorry, you don't have enough money to purchase that friend today.");
                keepGoing = false;
            }
        }


    }

}
}
