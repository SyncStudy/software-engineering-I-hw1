
import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;
import java.util.HashSet;

/*
 * COMP201 2019-20
 * Assignment 1
 * Clerk.java *V2*
 * NAME:
 * STUDENT ID:
 * COMPUTER USERNAME:
 */
 
 public class Clerk extends Person{
	private CreditUnion union;
	 
	 public Clerk()
	 {
		 super(); 
	  }
	 
	 public Clerk(CreditUnion theUnion)
	 {
		 super();
		 union = theUnion;
	 }
	 
	 public Clerk(String theName)
	 {
			super(theName);
	 }
	 
	 public void setUnion(CreditUnion theUnion)
	 {
			union = theUnion;
	 }
	 
	 
	 public void addAccount(Account theAccount)
	{

		union.accounts.add(theAccount);
		
	}
	
	public void rmAccount(Account theAccount) throws AccountException
	{
        //TODO: Complete this method as opposite of addAccount(Account, Person)
            if(theAccount==null)
            {
                System.out.println("The amount is not created yet.");
            }
            else
            {
                theAccount.close();
                union.accounts.remove(theAccount);
            }
	}
	
	public void addCustomer(Customer c)
	{
		union.people.add(c);
		System.out.println("Customer " + c.name + " is registered with the Credit Union");
	}
	
	public void rmCustomer(Customer c)
	{
		union.people.remove(c);
                System.out.println("Customer"+ c.name + " is removed from the Credit Union");
	}
	 
	 public boolean openSavings(Customer theCustomer, double openAmount)
	 {
		 //Check the Customer is registered with the union
		 if(!(union.people.contains(theCustomer)))
		 {
			 addCustomer(theCustomer);
		 }
		 
			 //Check we are opening the account with a valid amount
			 if(openAmount >=0.0)
			 {
				 try
				 {
					//Create a Saving account for the customer with the openAmount
					Account theAccount = new Savings(openAmount, theCustomer); 
					addAccount(theAccount);
					return true;
				 }catch(AccountException e)
				 {
						System.out.println("Account Exception caught whilst opening a savings account");
				 }
				
			 }
		 
		 return false;
	 }
	 
	 public boolean openLoan(Customer theCustomer, double theAmount) throws Exception
	 {
            //TODO: Complete this method - use the Process Loan method to help
             if(!(union.people.contains(theCustomer)))
		 {
			 addCustomer(theCustomer);
		 }
		 
			 //Check we are opening the account with a valid amount
			 if(union.processLoanApplication(Clerk.this,-theAmount))
			 {
				 try
				 {
					//Create a Saving account for the customer with the openAmount
					Account theAccount = new Loan(theAmount); 
                                        theAccount.setHolder(theCustomer);
                                        theCustomer.setAccount(theAccount);
					addAccount(theAccount);
                                        System.out.println("Loan account opened for " + theCustomer.name + " with balance of " + theAmount);
					return true;
				 }catch(AccountException e)
				 {
						System.out.println("Account Exception caught whilst opening a savings account");
				 }
				
			 }
		 
		 return false;  
	 }
	 
	 
	 public boolean applyInterest()
	{	//TODO: Complete this method
            for(int i=0; i<union.accounts.size(); i++)
            {
                if (union.accounts.get(i).getBalance()<0) 
                {
                    double Temp = 1.0001*union.accounts.get(i).getBalance();
                    union.accounts.get(i).setBalance(Temp);
                }
                
            }
		return true;
	}
};
