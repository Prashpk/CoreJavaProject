package com.edu;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("Banking System Application: ");
			System.out.println("1. Create Account");
			System.out.println("2. Display All Account details");
			System.out.println("3. Deposit the Amount");
			System.out.println("4. Withdraw the Amount");
			System.out.println("5. Display Details based on id");
			System.out.println("6. Current Balance");
			System.out.println("7. Exit");
			System.out.println("Enter your choice ?");
			int ch = sc.nextInt();
			
			switch(ch) {
			
			case 1:
				BankingOperations.createAccount();
				break;
			case 2:
				BankingOperations.displayAccountdetails();
				break;
			
			case 3: 
				BankingOperations.depositAmount();
				break;
			case 4: 
				BankingOperations.withdrawAmount();
				break;
			case 5: 
				BankingOperations.displayDetailsBasedOnAccountNumber();
				break;
			case 6: 
				BankingOperations.CurrentBalance();
				break;
			case 7:
				BankingOperations.Exit();
				break;
			default :
				System.out.println("Invalid choice");
			}
			
			System.out.println("Do you want to continue yes/no ?\n");
			String choice = sc.next();
			if(choice.equalsIgnoreCase("no")) {
				break;
			}
			}
			System.out.println("Program Terminated!");
		}
	}

