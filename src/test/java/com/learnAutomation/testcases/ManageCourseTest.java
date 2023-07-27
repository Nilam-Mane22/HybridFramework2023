package com.learnAutomation.testcases;

import org.testng.Assert;


import org.testng.annotations.Test;

import com.learnautomation.constants.Constants;
import com.learnautomation.dataProvider.CustomDataProvider;
import com.learnautomation.helper.BaseClass;
import com.learnautomation.pages.LoginPage;
import com.learnautomation.pages.ManageCoursePage;

public class ManageCourseTest extends BaseClass {
	
	
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
		
	}
	
	@Test(priority = 3, dataProvider = "courseDetails", dataProviderClass = CustomDataProvider.class)
	public void ManageCourseDetails(String courseName, String description, String instructor, String price,  String categorySelection) throws InterruptedException 
	{
   
	ManageCoursePage course = new ManageCoursePage(driver);
	course.CourseDetails(courseName, description, instructor, price, categorySelection);
	
	}
}
