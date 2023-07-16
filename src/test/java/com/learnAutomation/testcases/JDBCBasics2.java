package com.learnAutomation.testcases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.Test;



public class JDBCBasics2 {
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
				
				boolean status=false;
				
				while(result.next())
				{
					
//					String email=result.getString("Email");
//					if(email.contains("foysal@gmail.com"))
					
					String city=result.getString("City");
						if(city.contains("Pune"))
					{
						System.out.println("\nRecord Found");
						status=true;
						
					}
				}
				
				Assert.assertTrue(status);				
				
			} 
			catch(SQLException e)
			{
				System.out.println("\n Could not connect to DB "+e.getMessage());
			}
			
			catch (ClassNotFoundException e) {
				System.out.println("Could not load the driver");
			}
			
			
		}

	}
