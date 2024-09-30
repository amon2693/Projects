import java.util.Scanner;
public class Transactions extends VendingMachine {
    double balance;


    public void startTransaction() {
        Scanner scanner = new Scanner(System.in);
        boolean continueTransaction = true;

        while (continueTransaction) {
            System.out.println("Current Money Provided: $" + String.format("%.2f", balance));
            System.out.println();
            System.out.println("(1) Feed $1");
            System.out.println("(2) Feed $5");
            System.out.println("(3) Feed $10");
            System.out.println("(4) Feed $20");
            System.out.println("(5) Select Product");
            System.out.println("(6) Finish Transaction");

            int transactionChoice = scanner.nextInt();

            if (transactionChoice == 1) {
                feedMoney(1);
            } else if (transactionChoice == 2) {
                feedMoney(5);
            } else if (transactionChoice == 3) {
                feedMoney(10);
            } else if (transactionChoice == 4) {
                feedMoney(20);
            } else if (transactionChoice == 5) {
                selectProduct();
            } else if (transactionChoice == 6) {
                finishTransaction();
                continueTransaction = false;
                System.out.println("Thank you for shopping with CuteCo!");
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }

    private void feedMoney(double amount) {
        balance += amount;
        System.out.println("Money Added: $" + amount);
    }

    public double getBalance() {
        return balance;
    }



    private void finishTransaction() {
        // Implement transaction finishing logic
        System.out.println("Finishing transaction...");
        double change = balance;
        // Reset balance
        balance = 0;

        System.out.println("Transaction completed.");
        if (change > 0) {
            System.out.println("Change returned: $" + String.format("%.2f", change));
        }
    }
}
