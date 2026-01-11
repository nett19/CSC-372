package bankAccount;

public class CheckingAccount extends BankAccount {

    private double interestRate; 
    private static final double OVERDRAFT_FEE = 30.0;

    
    public CheckingAccount(double interestRate) {
        super(); 
        this.interestRate = interestRate;
    }

    public CheckingAccount(int accountID, double initialBalance, double interestRate) {
        super();
        this.setAccountID(accountID);
        this.setBalance(initialBalance);
        this.interestRate = interestRate;
    }


    @Override
    public void withdrawal(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return;
        }

        if (getBalance() >= amount) {
            // Standard withdrawal logic
            setBalance(getBalance() - amount);
            System.out.printf("Standard withdrawal successful. $%.2f subtracted.\n", amount);
        } else {
            // Overdraft logic
            setBalance(getBalance() - amount - OVERDRAFT_FEE);
            System.out.println("!!! Overdraft Detected !!!");
            System.out.printf("Withdrawal: $%.2f | Fee: $%.2f\n", amount, OVERDRAFT_FEE);
            System.out.printf("New Balance: $%.2f\n", getBalance());
        }
    }

    public void applyInterestAndDeposit(double depositAmount) {
        double interestEarned = getBalance() * this.interestRate;
        double totalToDeposit = depositAmount + interestEarned;
        
        setBalance(getBalance() + totalToDeposit);
        
        System.out.printf("Interest applied (%.2f%%): $%.2f\n", (this.interestRate * 100), interestEarned);
        System.out.printf("Deposit of $%.2f added.\n", depositAmount);
    }

    public void displayAccount() {
        accountSummary(); // Inherited from BankAccount
        System.out.printf("Interest Rate:   %.2f%%\n", (this.interestRate * 100));
        System.out.println("-----------------------");
    }

    // --- GETTERS & SETTERS ---

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
}