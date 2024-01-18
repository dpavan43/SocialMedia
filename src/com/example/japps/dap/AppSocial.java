package com.example.japps.dap;

import java.util.Scanner;

public class AppSocial {
	public static void main(String[] args) {
		CreateAccount acc=new CreateAccount();
		
		int choice;
		do {
			System.out.println("*************INSTAGRAM***************");
			System.out.println("1. Login Instagram :");
			System.out.println("2. Create New Account :");
			System.out.println("****************************************");
			Scanner sc = new Scanner (System.in);
			choice=sc.nextInt();
			
			switch(choice) {
			case 1:
				acc.login();
				break;				
			case 2:
				acc.createAccount();
				System.out.println("Your Account is Created.....");
				System.out.println("");
				break;
			}			
		}while(true);
	}

}
