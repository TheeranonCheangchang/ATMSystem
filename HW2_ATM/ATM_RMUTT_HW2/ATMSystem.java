import java.util.Scanner;

public class ATMSystem {
    private static Scanner scanner = new Scanner(System.in);
    private static Manager manager = null;

    public static void main(String[] args) {
        System.out.println("=== Manager System ===");
        System.out.println("No system manager found. Please register one.");
        System.out.print("National ID: ");
        String mid = scanner.nextLine();
        System.out.print("Full Name: ");
        String mname = scanner.nextLine();
        System.out.print("Gender: ");
        String mgender = scanner.nextLine();
        System.out.print("Manager Login ID: ");
        String mlogin = scanner.nextLine();
        System.out.print("Manager Password: ");
        String mpass = scanner.nextLine();

        manager = new Manager(mid, mname, mgender, mlogin, mpass);

        System.out.println("\n=== Manager Login ===");
        boolean success = false;
        while (!success) {
            System.out.print("Login ID: ");
            String login = scanner.nextLine();
            System.out.print("Password: ");
            String pass = scanner.nextLine();

            if (manager.getLoginId().equals(login) && manager.checkPassword(pass)) {
                success = true;
                System.out.println("Login success. Welcome " + manager.getFullName());
            } else {
                System.out.println("Try again.");
            }
        }

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
            System.out.print("National ID: ");
            String nid = scanner.nextLine();
            System.out.print("Full Name: ");
            String name = scanner.nextLine();
            System.out.print("Gender: ");
            String gender = scanner.nextLine();
            System.out.print("Login ID: ");
            String loginId = scanner.nextLine();
            System.out.print("Password: ");
            String pass = scanner.nextLine();
            System.out.print("Initial Balance: ");
            double balance = Double.parseDouble(scanner.nextLine());

            Account acc = new Account(nid, name, gender, loginId, pass, balance);
            atm.addAccount(acc);
        }

        while (true) {
        System.out.println("\nStep 3. User Login");
        Account loggedIn = null;
        while (loggedIn == null) {
            System.out.print("Login ID: ");
            String uid = scanner.nextLine();
            System.out.print("Password: ");
            String upass = scanner.nextLine();
            loggedIn = atm.login(uid, upass);
            if (loggedIn == null) {
                System.out.println("Login failed. Try again.");
                }
            }
        atm.atmMenu(loggedIn);
        }
    }
}
