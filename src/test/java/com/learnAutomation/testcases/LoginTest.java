package com.learnAutomation.testcases;
import org.testng.Assert;

import org.testng.annotations.Test;

import com.learnautomation.constants.Constants;
import com.learnautomation.dataProvider.CustomDataProvider;
import com.learnautomation.helper.BaseClass;
import com.learnautomation.pages.HomePage;
import com.learnautomation.pages.LoginPage;



public class LoginTest extends BaseClass
{
	@Test(priority = 2 ,dataProvider = "login",dataProviderClass = CustomDataProvider.class)
	public void loginToApp(String username,String password)
	{
		LoginPage page=new LoginPage(driver);
		
		page.loginToApplication(username, password);
	
//		boolean status=page.captureErrorMessage().contains(Constants.userDoesNotExist);
//		
//		Assert.assertTrue(status,"Error messages is displayed as expected");
//		
		//com.learnautomation.helper.Utility.captureScreenshot(driver);	
		//driver.quit();
	}
	
	
//	@Test(priority = 3)
//	
//	public void landingOnhome()
//	{
//		HomePage Hpage=new HomePage(driver);
//		String status=Hpage.capturedisplayMessage();
//		Assert.assertEquals(status, "Something wents wrong" );
//		
//	}
	
	
}