package com.techelevator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;

public class Transactions {

    static double balance;

    public void startTransaction() {
        Scanner scanner = new Scanner(System.in);
        boolean continueTransaction = true;

        while (continueTransaction) {
            System.out.println("Current Money Provided: $" + String.format("%.2f", getBalance()));
            System.out.println();
            System.out.println("(1) Feed $1");
            System.out.println("(2) Feed $5");
            System.out.println("(3) Feed $10");
            System.out.println("(4) Feed $20");
            System.out.println("(5) Main Menu");
//            System.out.println("(6) Finish Transaction");

            String transactionChoice = scanner.nextLine();

            if (transactionChoice.equals("1")) {
                feedMoney(1);
            } else if (transactionChoice.equals("2")) {
                feedMoney(5);
            } else if (transactionChoice.equals("3")) {
                feedMoney(10);
            } else if (transactionChoice.equals("4")) {
                feedMoney(20);
            } else if (transactionChoice.equals("5")) {
                continueTransaction = false;
//            } else if (transactionChoice.equals("6")) {
//                finishTransaction();
//                continueTransaction = false;
//                System.out.println("Thank you for shopping with CuteCo!");
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }

    private void feedMoney(double amount) {
        balance += amount;
        System.out.println("Money Added: $" + amount);
        String newAmount = Double.toString(amount);
        transactionLog("Feed", newAmount);
    }

    public static double getBalance() {
        return balance;
    }
    public double setBalance(double newBalance){
        balance = newBalance;
        return balance;
    }
    public void giveChange(double change) {
        int quarters = (int) (change / 0.25);
        change %= 0.25;

        int dimes = (int) (change / 0.10);
        change %= 0.10;

        int nickels = (int) (change / 0.05);
        change %= 0.05;

        System.out.println("Change given: ");
        System.out.println(quarters + " quarters");
        System.out.println(dimes + " dimes");
        System.out.println(nickels + " nickels");
        System.out.println();
    }




    private void finishTransaction() {
        // Implement transaction finishing logic
        System.out.println("Finishing transaction...");
        double change = balance;
        String stringChange = Double.toString(change);

        // Reset balance
        balance = 0;
        transactionLog("GIVE CHANGE", stringChange);

        System.out.println("Transaction completed.");
        if (change > 0) {
            System.out.println("Change returned: $" + String.format("%.2f", change));
        }


    }

    public static void transactionLog(String action, String amount) {
        Date date = new Date();
        File f = new File("log.txt");
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        String formattedDate = formatter.format(date);
        try (FileWriter writer = new FileWriter("log.txt", true)) {
            writer.write(formattedDate + " " + action + " " + amount +  " " + getBalance()+ "\n" );
        }
        catch (IOException e) {
                e.printStackTrace();
        }

    }
}
