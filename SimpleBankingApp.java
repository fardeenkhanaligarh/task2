import java.util.Scanner;

public class SimpleBankingApp {
    private double balance;

    public SimpleBankingApp() {
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("Deposited: $%.2f%n", amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.printf("Withdrew: $%.2f%n", amount);
        } else if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }

    public void checkBalance() {
        System.out.printf("Current balance: $%.2f%n", balance);
    }

    public static void main(String[] args) {
        SimpleBankingApp bankingApp = new SimpleBankingApp();
        Scanner scanner = new Scanner(System.in);
        String choice;

        System.out.println("Welcome to the Simple Banking Application!");

        do {
            System.out.println("\nPlease choose an option:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine();  // Clear the buffer
                    bankingApp.deposit(depositAmount);
                    break;
                case "2":
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    scanner.nextLine();  // Clear the buffer
                    bankingApp.withdraw(withdrawAmount);
                    break;
                case "3":
                    bankingApp.checkBalance();
                    break;
                case "4":
                    System.out.println("Exiting the application. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select between 1 and 4.");
                    break;
            }
        } while (!choice.equals("4"));

        scanner.close();
    }
}
