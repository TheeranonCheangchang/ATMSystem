import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ATM {
    private List<Account> accounts;
    private Scanner scanner;

    public ATM() {
        accounts = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public Account login(String loginId, String password) {
        for (Account acc : accounts) {
            if (acc.getLoginId().equals(loginId) && acc.checkPassword(password)) {
                return acc;
            }
        }
        return null;
    }

    public Account findAccountByLoginId(String loginId) {
        for (Account acc : accounts) {
            if (acc.getLoginId().equals(loginId)) {
                return acc;
            }
        }
        return null;
    }

    public void atmMenu(Account user) {
        while (true) {
            System.out.println("\n========================================");
            System.out.println("      ATM ComputerThanyaburi Bank");
            System.out.println("      Account: " + user.getFullName());
            System.out.println("========================================");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Exit");
            System.out.print("Choose menu [1-5]: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    user.checkBalance();
                    break;
                case "2":
                    System.out.print("Enter amount to withdraw: ");
                    double w = Double.parseDouble(scanner.nextLine());
                    user.withdraw(w);
                    break;
                case "3":
                    System.out.print("Enter amount to deposit: ");
                    double d = Double.parseDouble(scanner.nextLine());
                    user.deposit(d);
                    break;
                case "4":
                    System.out.print("Enter receiver Login ID: ");
                    String targetId = scanner.nextLine();
                    Account target = findAccountByLoginId(targetId);
                    if (target == null) {
                        System.out.println("Receiver account not found.");
                        break;
                    }
                    System.out.print("Enter amount to transfer: ");
                    double t = Double.parseDouble(scanner.nextLine());
                    user.transfer(target, t);
                    break;
                case "5":
                    System.out.println("Thank you. Logging out");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
