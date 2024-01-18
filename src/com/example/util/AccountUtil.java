package com.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AccountUtil {
	 	private String url="jdbc:mysql://localhost:3309/employee_db?useSSL=false";
	    private String username="root";
	    private String password="sql123";

	    public Connection getDbConnection(){
	        Connection con = null;
	        try {
	            con = DriverManager.getConnection(url,username,password);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return con;
	    }

}
