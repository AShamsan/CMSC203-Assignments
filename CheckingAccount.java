public class CheckingAccount extends BankAccount {

	// declare variables
	private static final double FEE = 0.15;

	
	/*a constructor that takes a name and an initial amount as parameters
	 and calls the constructor for the superclass
	 */
	public CheckingAccount(String name, double amount) {
		super(name, amount);
		this.setAccountNumber(this.getAccountNumber().concat("-10"));
	}

//A method that overrides the withdraw method in the superclass.
	public boolean withdraw(double amount) {
		
		return super.withdraw(amount + FEE);
	}
}