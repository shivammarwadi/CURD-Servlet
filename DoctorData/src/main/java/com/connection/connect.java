package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class connect 
{
	public static Connection getConnection() throws ClassNotFoundException
	{
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CurdServlet", "root", "Shivam2001@");
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
		return con;
	}
	
		
}
