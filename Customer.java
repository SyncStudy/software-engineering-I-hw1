/*
 * COMP201 2019-20
 * Assignment 1
 * Customer.java
 * NAME:
 * STUDENT ID:
 * COMPUTER USERNAME:
 */
 
 public class Customer extends Person{
	 public Account myAccount; //The customers account
	 
	 public Customer()
	 {
			super();
	 }
	 
	 public Customer(String theName)
	 {
			super(theName);
	 }
	 
	 public String getName()
	 {
			return name;
	 }
	 
	 public void setName(String newName)
	 {
			name = newName;
	 }
	 
	 public void setAccount(Account theAccount)
	 {
			myAccount = theAccount;
	 }
	 
	 public void makeWithdrawal(double amount) 
	 {
		 try
		 {
			 	 //TODO: Make sure this only happens for a Savings Account
                                if(myAccount instanceof Savings)
                                {
                                    myAccount.withdraw(amount);
                                }
                                else
                                {
                                    throw new AccountException("The withdrawal can only be valid for saving account");
                                }
				
				
		  } catch (AccountException e)
		  {
			  //TODO:: Handle gracefully
                      System.out.println(e);
                  }
	 }
	 
	 public double makePayment(double amount)
	 {
			myAccount.payment(amount);
			return myAccount.getBalance();
	 }
};
