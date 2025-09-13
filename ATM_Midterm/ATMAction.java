public interface ATMAction {
    void checkBalance();
    void withdraw(double amount);
    void deposit(double amount);
    boolean transfer(Account target, double amount);
}
