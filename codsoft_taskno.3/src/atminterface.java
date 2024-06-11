import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}

class ATM {
    private BankAccount account;

    public ATM(BankAccount bankAccount) {
        account = bankAccount;
    }

    public void displayMenu() {
        System.out.println("WELCOME to the ATM! How can we help you?:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Amount");
        System.out.println("3. Withdraw Amount");
        System.out.println("4. Exit");
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            System.out.print("Please select an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Your balance is: Rs. " + account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter amount to be deposited: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    System.out.println("Deposit successful. Your balance is: Rs. " + account.getBalance());
                    break;
                case 3:
                    System.out.print("Enter amount to be withdrawn: ");
                    double withdrawAmount = scanner.nextDouble();
                    if (account.withdraw(withdrawAmount)) {
                        System.out.println("Withdrawal successful. Your balance is: Rs. " + account.getBalance());
                    } else {
                        System.out.println("Sorry! Insufficient Balance.");
                    }
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Have a nice day!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please select a valid option.");
            }
        }
    }
}

public class atminterface {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000); // Initial balance
        ATM atm = new ATM(userAccount);
        atm.run();
    }
}