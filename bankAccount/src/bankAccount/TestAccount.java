package bankAccount;

public class TestAccount {
    public static void main(String[] args) {
        // --- TEST 1: BANKACCOUNT (SUPERCLASS) ---
        System.out.println(">>> TESTING BANKACCOUNT SUPERCLASS <<<");
        BankAccount genericAccount = new BankAccount();
        
        genericAccount.setFirstName("John");
        genericAccount.setLastName("Doe");
        genericAccount.setAccountID(999999);
        
        System.out.println("Action: Initial Deposit $698,705.00");
        genericAccount.deposit(698705.00);
        
        System.out.println("Action: Standard Withdrawal $45,890.00");
        genericAccount.withdrawal(45890.00);
        
        genericAccount.accountSummary();
        System.out.printf("Verified Balance (via getter): $%.2f\n", genericAccount.getBalance());

        System.out.println("\nAction: Attempting Insufficient Funds Withdrawal ($987,654,321.00)");
        genericAccount.withdrawal(987654321.00); 
        
        System.out.println("\n" + "=".repeat(45) + "\n");

        // --- TEST 2: CHECKINGACCOUNT (SUBCLASS) ---
        System.out.println(">>> TESTING CHECKINGACCOUNT SUBCLASS <<<");
        
        // Using the full constructor
        CheckingAccount checking = new CheckingAccount(2002, 200.00, 0.015);
        checking.setFirstName("Bob");
        checking.setLastName("Johnson");

        System.out.println("Action: Large Deposit $99,999.00");
        checking.deposit(99999.00); // Inherited from BankAccount
        checking.displayAccount(); 

        System.out.println("\nAction: Testing Interest Application + $500 Deposit");
        checking.applyInterestAndDeposit(500.00);
        checking.displayAccount();

        System.out.println("\nAction: Standard Withdrawal $10,000.00");
        checking.withdrawal(10000.00); // Calls Overridden method
        
        System.out.println("\nAction: Triggering Overdraft (Withdrawal exceeds balance)");
        // This will trigger the $30.00 fee
        checking.withdrawal(checking.getBalance() + 100.00); 
        
        checking.displayAccount();
        
        System.out.println("\n>>> TEST SUITE COMPLETE <<<");
    }
}