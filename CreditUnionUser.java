/*
 * COMP201 2019-20
 * Assignment 1
 * CreditUnionUser.java
 * NAME:
 * STUDENT ID:
 * COMPUTER USERNAME:
 */
 
 
 //TODO: You must go through ALL CODE to ensure it meets requirements!!!
 
 public class CreditUnionUser{

	 public static void main(String[] args)
	 {
			//Create new Clerk
			Clerk clerk = new Clerk("Donald");
			
			//Create some new customers
			Customer customer1 = new Customer("Thomas");
			Customer customer2 = new Customer("Richard");
			Customer customer3 = new Customer("Harry");
			Customer customer4 = new Customer("Sally");
                        try 
                        {
                        //Create the credit union with opening capital
			CreditUnion cu = new CreditUnion(10000000000.00, clerk);
			System.out.println("Credit Union Capital is: " + cu.getTotalCapital(clerk));

			//TODO: Write code that tests the program. Use the code below to prompt your testing
			
			//Create some saving accounts (The Clerk must do this on behalf of the customer)
			clerk.openSavings(customer1, 300.0);
			System.out.println("Credit Union Capital is: " + cu.getTotalCapital(clerk)+" " +customer1.myAccount.getBalance());
			//Withdraw
			customer1.makeWithdrawal(10.0);
			System.out.println("Credit Union Capital is: " + cu.getTotalCapital(clerk)+" " +customer1.myAccount.getBalance());
			
			//Add balances to saving accounts (The customer does this)
			customer1.makePayment(10.0);
                        System.out.println("Credot Union Capital is : " + cu.getTotalCapital(clerk)+" " +customer1.myAccount.getBalance());
			//Make some withdrawals from saving accounts (The customer does this)
			customer1.makeWithdrawal(10.0);
                        System.out.println("Credit Union Capital is : " +cu.getTotalCapital(clerk)+" " +customer1.myAccount.getBalance());
			//Process a loan application (The clerk does this on behalf of the customer)
                        clerk.openLoan(customer2, -10000000);
                        clerk.applyInterest();
                        System.out.println("__");
			System.out.println("Credit Union Capital is : " +cu.getTotalCapital(clerk)+" " +customer2.myAccount.getBalance());
			//Make a payment to loan account (The customer does this)
			customer2.makePayment(10);//??
                        System.out.println("Credit Union Capital is : "+ cu.getTotalCapital(clerk)+" " +customer2.myAccount.getBalance());
                        System.out.println(customer2.myAccount.getBalance());
			//Close loan account (The clerk does this)
			clerk.rmAccount(customer2.myAccount);
                        System.out.println(cu.accounts.contains(customer2.myAccount));
			//Close saving accounts (The clerk does this)
			clerk.rmAccount(customer1.myAccount);
                        System.out.println(cu.accounts.contains(customer1.myAccount));
                       
                        } 
                        
                        catch (Exception e) 
                        {
                            System.out.println(e);
                        }
			
			
	 } 
	 
};
