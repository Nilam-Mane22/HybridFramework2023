package com.learnAutomation.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.learnautomation.dataProvider.CustomDataProvider;
import com.learnautomation.helper.BaseClass;
import com.learnautomation.pages.HomePage;


//import com.learnautomation.base.BaseClass;
//import com.learnautomation.dataProvider.CustomDataProvider;


public class HomeTest extends BaseClass
{
	@Test(dataProvider = "users",dataProviderClass = CustomDataProvider.class)
	public void WelcomeHome(String username,String password)
	{
  
		HomePage page=new HomePage(driver);
		page.GoToHomepage(username,password);
		boolean status=page.capturedisplayMessage().contains("Welcome Admin Manager to Learn Automation Courses");		
		Assert.assertTrue(status,"Not login with Admin User.This is another user");
		
	   
	}
}
