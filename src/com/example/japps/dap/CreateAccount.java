package com.example.japps.dap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.example.japps.model.Create;
import com.example.util.AccountUtil;

public class CreateAccount {
	AccountUtil accountutil=new AccountUtil();
	
	public void createAccount() {
		Create create=new Create();
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the MobileNumber :");
		create.setMobile(sc.nextLine());
		
		System.out.println("Enter the FullName :");
		create.setName(sc.nextLine());
		
		System.out.println("Enter the UserName :");
		create.setUsername(sc.nextLine());
		
		System.out.println("Enter the Password :");
		create .setPassword(sc.nextLine());
		

		Connection con=accountutil.getDbConnection();
		if (con!=null) {
			String query = "INSERT INTO employee_db.social_media (mobile_number,full_name,username,password) VALUES (?,?,?,?)";
			try {
				PreparedStatement ps=con.prepareStatement(query);
				ps.setString(1, create.getMobile());
				ps.setString(2, create.getName());
				ps.setString(3, create.getUsername());
				ps.setString(4, create.getPassword());
				Boolean temp= ps.execute();
				if(temp) {
					System.out.println("Data inserted.....");
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}			
		}			
	}
	public void login() {
		
		Scanner scanner=new Scanner(System.in);
			System.out.println("Enter username:");
			String username = scanner.nextLine();

	        System.out.println("Enter password:");
	        String password = scanner.nextLine();

	        Connection con=accountutil.getDbConnection();
	        if (con!=null) {
	        	String query = "SELECT * FROM social_media WHERE username = ? AND password = ?";
	        	try {
	        		PreparedStatement ps = con.prepareStatement(query);
	                ps.setString(1, username);
	                ps.setString(2, password);
	                
	                ResultSet rs = ps.executeQuery();

	                if (rs.next()) {
	                    System.out.println("Login successful........ ");
	                    System.out.println("*****WELCOME*****"+username);
	                    System.out.println(" ");
	                } else {
	                    System.out.println("Invalid username or password...... Please try again.");
	                }
				} catch (Exception e) {
					e.printStackTrace();
			} 	        	 
		}	      
	}
	public boolean login1(String username, String password) {
		return false;
	}
}
