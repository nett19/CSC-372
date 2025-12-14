package bankAccount;

public class BankAccount {

	// fields
	public String firstName;
	public String lastName;
	public int accountID;
	public double balance;

	// constructor
	public BankAccount() {
		this.balance = 0.0;
	}

	// deposit() - 
	public void deposit(double amount) {
		if (amount > 0) {
			this.balance += amount;
			System.out.printf("Deposit successful. $%.2f added to the account.\n", amount);
		} else {
			System.out.println("Deposit must be positive.");
		}
	}

	// withdrawal()
	public void withdrawal(double amount) { 
		if (amount > 0) {
			if (this.balance >= amount) {
				this.balance -= amount;
				 
				System.out.printf("Withdrawal successful. $%.2f subtracted.\n", amount);
			} else {
				System.out.println("Insufficient funds for a standard withdrawal.");
			}
		} else {
			System.out.println("Withdrawal amount must be positive.");
		}
	}

	// accountSummary() 
	public void accountSummary() { 
		System.out.println("--- Account Summary ---");
	    System.out.println("Account Holder: " + this.firstName + " " + this.lastName);
	    System.out.println("Account ID: " + this.accountID);
	    System.out.printf("Current Balance: $%.2f\n", this.balance);
        System.out.println("-----------------------");
	}

    // Getters
	public String getFirstName() { return firstName; }
	public String getLastName() { return lastName; }
	public int getAccountID() { return accountID; }
	
	// getBalance()
    public double getBalance() { return balance; }

    // Setters
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setAccountID(int accountID) { this.accountID = accountID; }

    // Setter for balance (for subclass use)
    protected void setBalance(double balance) { this.balance = balance; }
}