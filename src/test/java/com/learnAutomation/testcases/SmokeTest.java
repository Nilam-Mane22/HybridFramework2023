package com.learnAutomation.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.learnautomation.helper.BaseClass;

public class SmokeTest extends BaseClass
{

	@Test
	public void verifyURL()
	{
		System.out.println("Test Started");
		
		Assert.assertTrue(driver.getCurrentUrl().contains("login"),"URL does not contain login");
		
		System.out.println("Test Ended");

		System.out.println("Nilam Mane ");
		
	
	}
	
	

}