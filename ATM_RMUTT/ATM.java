import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ATM {
    private List<BankAccount> bankAccounts;
    private Scanner scanner;
    
    public ATM() {
        bankAccounts = new ArrayList<>();
        scanner = new Scanner(System.in);
    }
    
    public void addAccount(BankAccount account) {
        bankAccounts.add(account);
    }
    
    public BankAccount login(String inputId, String inputPass) {
        for (BankAccount account : bankAccounts) {
            if (account.getAccountId().equals(inputId) && account.checkPassword(inputPass)) {
                return account;
            }
        }
        return null;
    }
    
    public void atmMenu(BankAccount account) {
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
                    break;
                
                case "2":
                    break;

                case "3":
                    return;
                
                default:
                    System.out.println("Please help click the new option.");
                    break;
            }
        }
    }
    
    public void startATMService() {
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

            BankAccount loggedInAccount = login(inputId, inputPass);
            
            if (loggedInAccount != null) {
                atmMenu(loggedInAccount);
            } else {
                System.out.println("Account ID or Password is incorrect.");
            }
        }
    }
}