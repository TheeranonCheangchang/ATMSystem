public class BankAccount {
    private String accountId;
    private String name;
    private String password;
    private double balance;
    
    public BankAccount(String accountId, String name, String password, double balance) {
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
    
    public double getBalance() {
        return this.balance;
    }
    
}