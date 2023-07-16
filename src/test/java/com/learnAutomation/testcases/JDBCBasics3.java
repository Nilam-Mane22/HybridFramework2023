package com.learnAutomation.testcases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.Test;

public class JDBCBasics3 {
		
	// orderID - 8978
	
	@Test
	public void verifyDBRecords()
	{
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			System.out.println("1- Driver Loaded");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Jesus@2201");
			
			System.out.println("2 - Connected to DB");
			
			Statement smt=con.createStatement();
			
			System.out.println("3 - Statement Created");
			
			int rowsInserted=smt.executeUpdate("insert into employee(EmployeeID,firstname,lastname,email,AddressLine,city) values (20,'Nilam','Mane','nilam@gmail.com','VimanNagar','pune')");
			
			System.out.println("\nNumber of rows affected "+rowsInserted);
			
			Assert.assertTrue(rowsInserted>0);
				
			
		} 
		catch(SQLException e)
		{
			System.out.println("Could not connect to DB "+e.getMessage());
		}
		
		catch (ClassNotFoundException e) {
			System.out.println("Could not load the driver");
		}
		
		
	}

}



