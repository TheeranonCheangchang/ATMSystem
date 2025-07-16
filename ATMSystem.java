import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class BankAccount {
    private String accountId;
    private String name;
    private String password;
    private float balance;
    
    public BankAccount(String accountId, String name, String password, float balance) {
        this.accountId = accountId;
        this.name = name;
        this.password = password;
        this.balance = balance;
    }
    public String getAccountId() {
        return this.accountId;
    }
    public String getName() {
        return this.name;
    }
    public boolean checkPassword(String passwordAttempt) {
        return this.password.equals(passwordAttempt);
    }
    public float getBalance() {
        return this.balance;
    }
}

public class ATMSystem {
    private static Scanner scanner = new Scanner(System.in);
    private static List<BankAccount> bankAccounts = new ArrayList<>();
    public static void ATM_Menu(BankAccount account) {
        while (true) {
            System.out.println("\n========================================");
            System.out.println("      ATM ComputerThanyaburi Bank");
            System.out.println("      Account ID : " + account.getAccountId());
            System.out.println("========================================");
            System.out.println("  Menu Service");
            System.out.println("  1. Account Balance");
            System.out.println("  2. Withdrawal");
            System.out.println("  3. Exit");
            System.out.println("----------------------------------------");
            System.out.print("  Choose: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.println("Account Balance: " + account.getBalance());
                    break;
                
                case "2":
                    System.out.print("Enter Withdrawal Amount: ");
                    break;

                case "3":
                    return;
                
                default:
                    break;
            }
            
        }
    }
    public static void main(String[] args) {
        int numAccounts = 0;

        while (true) {
             System.out.print("Step 1. Enter amount of all account = ");
                numAccounts = Integer.parseInt(scanner.nextLine());
                
                if (numAccounts >= 1 && numAccounts <= 5) {
                    break;
                }
        }
        System.out.println("\nStep 2. Enter Detail of each account.");
        for (int i = 0; i < numAccounts; i++) {
            System.out.println("No." + (i + 1));

            String accID;
            while (true) {
                System.out.print("Account ID: ");
                accID = scanner.nextLine().trim();

                if(accID.length() == 13) {
                    break;
                }
            }
            String accName;
            while (true) {
                System.out.print("Account Name: ");
                accName = scanner.nextLine().trim();
                
                if (accName.length() > 0 && accName.length() <= 50) {
                    break;
                }
            }
            String accPass;
            while (true) {
                System.out.print("Password (4 หลัก): ");
                accPass = scanner.nextLine().trim();
                
                if (accPass.length() == 4) {
                    break;
                }
            }
            double accBalance;
            while (true) {
                    System.out.print("Balance (ไม่เกิน 1,000,000): ");
                    accBalance = Double.parseDouble(scanner.nextLine());
                    
                if (accBalance >= 0 && accBalance <= 1000000) {
                    break;
                }
            }
            BankAccount newAccount = new BankAccount(accID, accName, accPass, (float) accBalance);
            bankAccounts.add(newAccount);
        }
        System.out.println("\n\n########################################");
        System.out.println("##   WELCOME TO ATM SERVICE           ##");
        System.out.println("########################################");

        while (true) { 
            System.out.println("\n      ATM ComputerThanyaburi Bank");
            System.out.println("----------------------------------------");
            
            System.out.print("Account ID : ");
            String inputId = scanner.nextLine();
            
            System.out.print("Account Password : ");
            String inputPass = scanner.nextLine();

            BankAccount loggedInAccount = null;
            for (BankAccount account : bankAccounts) {
                if (account.getAccountId().equals(inputId) && account.checkPassword(inputPass)) {
                    loggedInAccount = account;
                    break;
                }
            }
            if (loggedInAccount != null) {
                ATM_Menu(loggedInAccount);
            }
        }
    }
}