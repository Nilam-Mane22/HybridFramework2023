package com.learnAutomation.testcases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class JDBCBasics 
{

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
			
			ResultSet result= smt.executeQuery("select * from employee");
			
			while(result.next())
			{
				String fName=result.getString("FirstName");	
				String lName=result.getString("LastName");
				String city=result.getString("City");
				//String empid=result.getString("EmployeeID");
				System.out.println("   " +fName + " "+lName+" from " +city);
			}		
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
