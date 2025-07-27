public class Account extends Person implements ATMAction {
    private String loginId;
    private String password;
    private double balance;

    public Account(String nationalId, String fullName, String gender, String loginId, String password, double balance) {
        super(nationalId, fullName, gender);
        this.loginId = loginId;
        this.password = password;
        this.balance = balance;
    }

    public String getLoginId() {
        return loginId;
    }

    public boolean checkPassword(String input) {
        return password.equals(input);
    }

    public void checkBalance() {
        System.out.println("Current balance: " + balance + " THB");
    }

    public void withdraw(double amount) {
        if (amount <= balance && amount > 0) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + " THB");
        } else {
            System.out.println("invalid amount.");
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount + " THB");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public boolean transfer(Account target, double amount) {
        if (amount <= balance && amount > 0) {
            balance -= amount;
            target.balance += amount;
            System.out.println("Transferred: " + amount + " THB to " + target.getFullName());
            return true;
        } else {
            System.out.println("Transfer failed.");
            return false;
        }
    }
}
