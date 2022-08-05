package com;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnection {
	static Connection con=null;
	public static Connection getMyConnection() {
		try{  
		
			Class.forName("com.mysql.cj.jdbc.Driver");  	 
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/retrivingproduct","root","parani");  
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
		return con;
		
		}

}