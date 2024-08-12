import java.util.Scanner;

public class ATM {

    private static final int PIN = 1234; // Example PIN for the ATM
    private static double balance = 1000.00; // Example initial balance

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean authenticated = false;

        // Authentication
        System.out.println("Welcome to the ATM.");
        while (!authenticated) {
            System.out.print("Enter your PIN: ");
            int enteredPin = scanner.nextInt();

            if (enteredPin == PIN) {
                authenticated = true;
                System.out.println("Authentication successful.");
                showMenu(scanner);
            } else {
                System.out.println("Invalid PIN. Please try again.");
            }
        }

        scanner.close();
    }
    private static void showMenu(Scanner scanner) {
        boolean running = true;
        while (running) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");

            System.out.print("Select an option (1-4): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit(scanner);
                    break;
                case 3:
                    withdraw(scanner);
                    break;
                case 4:
                    running = false;
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please select a number between 1 and 4.");
                    break;
            }
        }
    }

    private static void checkBalance() {
        System.out.printf("Your current balance is: $%.2f%n", balance);
    }

    private static void deposit(Scanner scanner) {
        System.out.print("Enter the amount to deposit: $");
        double amount = scanner.nextDouble();

        if (amount > 0) {
            balance += amount;
            System.out.printf("You have deposited $%.2f. Your new balance is $%.2f.%n", amount, balance);
        } else {
            System.out.println("Deposit amount must be greater than zero.");
        }
    }

    private static void withdraw(Scanner scanner) {
        System.out.print("Enter the amount to withdraw: $");
        double amount = scanner.nextDouble();

        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                System.out.printf("You have withdrawn $%.2f. Your new balance is $%.2f.%n", amount, balance);
            } else {
                System.out.println("Insufficient funds.");
            }
        } else {
            System.out.println("Withdrawal amount must be greater than zero.");
        }
    }
}
