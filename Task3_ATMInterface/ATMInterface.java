import java.util.Scanner;

class Account {
    double balance = 5000;
    StringBuilder history = new StringBuilder();

    void deposit(double amount) {
        balance += amount;
        history.append("Deposited: ₹").append(amount).append("\n");
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            history.append("Withdrawn: ₹").append(amount).append("\n");
        } else {
            System.out.println("Insufficient funds!");
        }
    }

    void transfer(double amount) {
        if (amount <= balance) {
            balance -= amount;
            history.append("Transferred: ₹").append(amount).append("\n");
        } else {
            System.out.println("Insufficient funds!");
        }
    }

    void showHistory() {
        System.out.println("Transaction History:\n" + history.toString());
    }

    void showBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account acc = new Account();

        System.out.print("Enter User ID: ");
        String id = sc.next();
        System.out.print("Enter PIN: ");
        int pin = sc.nextInt();

        if (id.equals("user") && pin == 1234) {
            while (true) {
                System.out.println("\nATM Menu");
                System.out.println("1. Check Balance\n2. Deposit\n3. Withdraw\n4. Transfer\n5. History\n6. Quit");
                System.out.print("Choose: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1 -> acc.showBalance();
                    case 2 -> {
                        System.out.print("Amount to deposit: ");
                        acc.deposit(sc.nextDouble());
                    }
                    case 3 -> {
                        System.out.print("Amount to withdraw: ");
                        acc.withdraw(sc.nextDouble());
                    }
                    case 4 -> {
                        System.out.print("Amount to transfer: ");
                        acc.transfer(sc.nextDouble());
                    }
                    case 5 -> acc.showHistory();
                    case 6 -> {
                        System.out.println("Thank you!");
                        return;
                    }
                    default -> System.out.println("Invalid option.");
                }
            }
        } else {
            System.out.println("Login failed.");
        }
        sc.close();
    }
}