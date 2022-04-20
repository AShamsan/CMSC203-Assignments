public class SavingsAccount extends BankAccount {
	
	//Define variables
	private final double  RATE= 0.025;
	private int savingsNumber = 0;
	private String accountNumber;


/*A constructor that takes a name and an initial balance as parameters
 *  and calls the constructor for the superclass
 */
	public SavingsAccount(String name, double iniBalance) {

		super(name, iniBalance);
		this.accountNumber = super.getAccountNumber();
	
	}

	
	/*This method will calculate one month's worth of interest on the balance
	 *  and deposit it into the account.
	 */
	public void postInterest() {

	deposit(((RATE * this.getBalance())/12));
		
	}

	
	
	//A method that overrides the getAccountNumber method in the superclass
	@Override
	public String getAccountNumber()
	{
		return this.accountNumber + "-" + savingsNumber;
	}
	
	
	
	//a copy constructor that creates another savings account for the same person
	public SavingsAccount(SavingsAccount account, double iniBalance) {
		// Initialize BankAccount
		super(account, iniBalance);
		this.savingsNumber = account.savingsNumber + 1;
		this.accountNumber = super.getAccountNumber();
	}
		

}