package bankAccount;

public class CheckingAccount extends BankAccount {

	private double interestRate;
	private static final double OVERDRAFT_FEE = 30.0;
    
   
    // Passes inherited account details to the superclass constructor
	public CheckingAccount(String accountNumber, double initialBalance, double interestRate) {
			super(); 
			
			this.interestRate = interestRate;
	}
	// Getter and Setter for interestRate
    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate *100;
    }
    
    
    public void applyInterestAndDeposit(double depositAmount) {
  	    double interest = getBalance() * this.interestRate;
  	    
       
  	    double newBalance = getBalance() + depositAmount + interest;

        setBalance(newBalance);
        
        System.out.printf("Interest applied (%.2f%%): $%.2f\n", this.interestRate * 100,interest);    }
	
	// 1. withdrawal() - Overrides superclass 
	@Override
	public void withdrawal(double amount) {
	    processWithdrawal(amount);
	}

	// 2. processWithdrawal() -  standard and overdraft withdrawals
	public void processWithdrawal(double amount) {
		if (amount > 0) {
			if (getBalance() >= amount) {
				// Standard withdrawal
				setBalance(getBalance() - amount);
				System.out.printf("Standard withdrawal successful. $%.2f subtracted.\n", amount); 
			} 
			else { 
				// Overdraft scenario
                setBalance(getBalance() - amount - OVERDRAFT_FEE);
                double newBalance = getBalance();

                System.out.printf("!!! Overdraft Detected !!!\n");
                System.out.printf("Withdrawal amount: $%.2f\n", amount);
                System.out.printf("Overdraft Fee Assessed: $%.2f\n", OVERDRAFT_FEE);
                System.out.printf("New Balance (Negative): $%.2f\n", newBalance);
          }
		} else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }
    
	
    // displayAccount()
    public void displayAccount() {
        accountSummary(); 
        System.out.printf("Interest Rate: %.2f%%\n", this.interestRate * 100);
        System.out.println("-----------------------");
        
    }

    
}