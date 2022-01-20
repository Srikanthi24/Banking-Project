package Project;


import java.util.HashMap;
import java.util.Scanner;


public class Banking_main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		// for password
		HashMap<Integer, String> account = new HashMap<>();
	    account.put(001,"pas1");
	    account.put(002, "pas2");
	    account.put(003, "pas3");
	    // for balance
	    HashMap<Integer, Double> balance = new HashMap<>();
	    balance.put(001,12000.00);
	    balance.put(002,15000.00);
	    balance.put(003,16000.00);
	    
	
	
	   
		System.out.println("Welcome to Online Banking");
		System.out.println("***********************************");
		System.out.println("Do you have a account in the Bank[Y/N]: ");
		String opt = scan.nextLine();
		System.out.println("***********************************");
		if(opt.startsWith("N")) {
			
			System.out.println("Create a New Account.");
			boolean newaccount = true;
			
			System.out.println("Enter a acount no :");
			int account_new = scan.nextInt();
			while(newaccount) {
			if(account.containsKey(account_new)) {
				System.out.println("Try another number.");
				System.out.println("Enter a acount no :");
				account_new = scan.nextInt();
				newaccount = true;
			}
			else {
				newaccount = false;
			    }
			}
			System.out.println("Enter a Password :");
			scan.nextLine();
			String password_new= scan.nextLine();
			System.out.println("Enter the Deposit Amount:");
			double amount_new = scan.nextDouble();
			account.put(account_new, password_new);
			balance.put(account_new,amount_new );
			System.out.println("New Account Created.");
			System.out.println("***********************************");
		
		}
		
		boolean possible = true;
		boolean authentication =false;
		
	   int account_id;
	   String pass;
	   System.out.println("Enter account ID :");
	   account_id =scan.nextInt();
	   System.out.println("Enter Password :");
	   scan.nextLine();
	   pass =scan.nextLine();
	   while(possible){
			if((account.containsKey(account_id))&&(pass.equals(account.get(account_id))))
			{
			    System.out.println("Authentication Done");
			    System.out.println("***********************************");
			    authentication = true;
			    possible = false;
			    
			}
			else {
				
				System.out.println("Not authenticated Try again");
				
				   System.out.println("Enter account ID :");
				   account_id =scan.nextInt();
				   System.out.println("Enter Password :");
				   scan.nextLine();
				   pass =scan.nextLine();
			
			}
		
		}
		
	   System.out.println("Welcome To Bank");
	   System.out.println("-----------------------------------");
		
		while(authentication) {
			
			
			System.out.println("The Bank operations are : ");
			System.out.println("1. Check Current Balance");
			System.out.println("2. Transfer Ammount ");
			System.out.println("3. Withdrawl Amount ");
			System.out.println("4. Exit and Go to other Bank Account.");
			System.out.println("5. Exit ");
			int choice;
			System.out.println("Enter your choice: ");
			choice =scan.nextInt();
			switch(choice){
				
				case 1:
					System.out.println("Your Cuurent Balance :");
					System.out.println(balance.get(account_id));
					System.out.println("-----------------------------------");
					break;
				case 2:
					
				   {
					 System.out.println("Transfer to account :");
					 int transfer_id =scan.nextInt();
					 System.out.println("Transaction Amount :");
					 double amount = scan.nextDouble();
					 
					 if(!balance.containsKey(transfer_id)) {
						 System.out.println( "Account Number Not Found.");
						 System.out.println("-----------------------------------");
						 break;
					 }
					 
					 if(amount <= balance.get(account_id)) {
					   double current_amount_id = balance.get(account_id) - amount;
					   double transfered_amount_id = balance.get(transfer_id)+ amount;
					   balance.replace(account_id,current_amount_id);
					   balance.replace(transfer_id,transfered_amount_id);
					   System.out.println("Amount Transfered.");
					   System.out.println("-----------------------------------");
					 }
					 else {
						 System.out.println(" No Minimum Balance to Transfer.");
						 System.out.println("-----------------------------------");
					 }
					 
					 break;
				   }
				case 3:	
					 System.out.println("Withdraw amount :");
					 System.out.println("Enter Withdrawl amount :");
					 double withdraw_amount=scan.nextDouble();
					 if(withdraw_amount <=  balance.get(account_id)) {
						 System.out.println(withdraw_amount+" is Withdrawed from your account.");
						 System.out.println("-----------------------------------");
						double after_withdraw=  balance.get(account_id) - withdraw_amount;
					    balance.replace(account_id,after_withdraw);
					 }
					 else {
						 System.out.println(" No Minimum Balance to Withdraw.");
						 System.out.println("-----------------------------------");
					 }
					 
					 break;
				case 4:
				{
					 System.out.println("Next Bank Account.");
					   boolean possible1 = true;
					   System.out.println("Enter account ID :");
					   account_id =scan.nextInt();
					   System.out.println("Enter Password :");
					   scan.nextLine();
					   pass =scan.nextLine();
					   while(possible1){
							if((account.containsKey(account_id))&&(pass.equals(account.get(account_id))))
							{
							    System.out.println("Authentication Done");
							    System.out.println("-----------------------------------");
							    authentication = true;
							    possible1 = false;
			
							}
							else {
								
								   System.out.println("Not authenticated Try again");
								   System.out.println("Enter account ID :");
								   account_id =scan.nextInt();
								   System.out.println("Enter Password :");
								   scan.nextLine();
								   pass =scan.nextLine();
							
							}
						
						}
					 break;  
					   
				}			   
				case 5:
					System.out.println("***********************************");
					System.exit(0);
					
				default:
					System.out.println("Wrong choice");
					
			}
			
			
		}
		
		 scan.close();
	}

}
