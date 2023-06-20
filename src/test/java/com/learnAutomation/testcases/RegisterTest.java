package com.learnAutomation.testcases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.learnautomation.base.BaseClass;
//import com.learnAutomation.constants.Constants;
import com.learnautomation.dataProvider.CustomDataProvider;
import com.learnautomation.pages.LoginPage;
import com.learnautomation.pages.RegisterPage;


public class RegisterTest extends BaseClass
{
	@Test  (priority =1,dataProvider="SignUpUsers",dataProviderClass=CustomDataProvider.class)
	public void SignUpForApp(String fname,String eid,String pwd,String interest,String gender,String state,String hobby) 
	
	{
	LoginPage login=new LoginPage(driver);
	login.clickOnNewUserLink();
	RegisterPage Rpage=new RegisterPage(driver);
	Rpage.createUser(fname, eid, pwd, interest, gender,state,hobby);
	boolean status=Rpage.captureUserExistingMessage().contains("Email already registered!");
	Assert.assertTrue(status,"Error message displayed as expected ");
	 
//	boolean status2=Rpage.signupSuccessMessage().contains("Signup successfully, Please login!");
//	Assert.assertTrue(status2,"Error message displayed as expected ");

	driver.quit();
	
}
}