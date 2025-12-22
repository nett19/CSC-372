package bankAccount;

public class TestAccount {
	public static void main(String[] args) {
		System.out.println("Testing BankAccount Superclass");
		BankAccount genericAccount = new BankAccount();
		
		//setters
		genericAccount.setFirstName("John");
        genericAccount.setLastName("Doe");
        genericAccount.setAccountID(99999999);
        
        genericAccount.deposit(698705.00);
        genericAccount.accountSummary();

        genericAccount.withdrawal(45890.00);
        genericAccount.accountSummary();
        System.out.printf("Current Balance via getBalance(): $%.2f\n", genericAccount.getBalance());

        // Test standard insufficient funds
        System.out.println("\nAttempting $500 Withdrawal:");
        genericAccount.withdrawal(987654321.00); // Should fail
        genericAccount.accountSummary();
        
        System.out.println("\n============================================\n");


        System.out.println("--- Part 2: Testing CheckingAccount Subclass ---");
     // Remove quotes from 2002 to make it an int
        CheckingAccount checking = new CheckingAccount(2002, 200.00, 0.015);        // Use inherited Setters
        checking.setFirstName("Bob");
        checking.setLastName("Johnson");
        checking.setAccountID(22222);
        
        // Deposit using inherited method
        checking.deposit(99999.00);

        // Test displayAccount() which includes interest rate
        checking.displayAccount(); 

        // 1. Test standard withdrawal 
        System.out.println("Attempting standard withdrawal:");
        checking.withdrawal(10000.00); 
        checking.displayAccount();

        // 2. Test Overdraft withdrawal (should trigger fee)
        System.out.println("Attempting Overdraft withdrawal (calling inherited withdrawal method):");

        checking.withdrawal(999999999.00); 
        checking.displayAccount();

        // Test calling the processWithdrawal method directly
        System.out.println("Attempting another Overdraft withdrawal (calling processWithdrawal directly):");

        checking.processWithdrawal(10.00);
        checking.displayAccount();
        
        
    }
}