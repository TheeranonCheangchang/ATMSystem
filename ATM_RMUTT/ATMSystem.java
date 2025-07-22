import java.util.Scanner;

public class ATMSystem {
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        ATM atm = new ATM();
        int numAccounts = 0;

        while (true) {
            try {
                System.out.print("Step 1. Enter amount of all account = ");
                numAccounts = Integer.parseInt(scanner.nextLine());
                
                if (numAccounts >= 1 && numAccounts <= 5) {
                    break;
                } else {
                    System.out.println("Please enter number between 1-5.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
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
                } else {
                    System.out.println("Account ID must be 13 digits.");
                }
            }
            
            String accName;
            while (true) {
                System.out.print("Account Name: ");
                accName = scanner.nextLine().trim();
                
                if (accName.length() > 0 && accName.length() <= 50) {
                    break;
                } else {
                    System.out.println("Account Name must not be empty and not exceed 50 characters.");
                }
            }
            
            String accPass;
            while (true) {
                System.out.print("Password : ");
                accPass = scanner.nextLine().trim();
                
                if (accPass.length() == 4) {
                    break;
                } else {
                    System.out.println("Password must be 4 digits.");
                }
            }
            
            float accBalance;
            while (true) {
                try {
                    System.out.print("Balance : ");
                    accBalance = Float.parseFloat(scanner.nextLine());
                    
                    if (accBalance >= 0 && accBalance <= 1000000) {
                        break;
                    } else {
                        System.out.println("Balance must be between 0 and 1,000,000.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Incorrect balance.");
                }
            }
            
            BankAccount newAccount = new BankAccount(accID, accName, accPass, accBalance);
            atm.addAccount(newAccount);
        }
        atm.startATMService();
    }
}