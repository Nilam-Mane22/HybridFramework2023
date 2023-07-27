package com.learnAutomation.testcases;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.learnautomation.constants.Constants;
import com.learnautomation.dataProvider.CustomDataProvider;
import com.learnautomation.helper.BaseClass;
import com.learnautomation.pages.EnrollPage;
import com.learnautomation.pages.LoginPage;
import com.learnautomation.pages.ManageCategoryPage;
import com.learnautomation.pages.ManageCoursePage;
import com.learnautomation.pages.RegisterPage;

public class E2ETest extends BaseClass

{
	@Test(priority = 2 ,dataProvider = "login",dataProviderClass = CustomDataProvider.class)
	public void loginToApp(String username,String password)
	{
		LoginPage page=new LoginPage(driver);
		
		page.loginToApplication(username, password);		
	}
	
	@Test  (priority =1,dataProvider="SignUpUsers",dataProviderClass=CustomDataProvider.class)
	public void SignUpForApp(String fname,String eid,String pwd,String interest,String gender,String state,String hobby) 
	
	{
	LoginPage login=new LoginPage(driver);
	login.clickOnNewUserLink();
	RegisterPage Rpage=new RegisterPage(driver);
	Rpage.createUser(fname, eid, pwd, interest, gender,state,hobby);
	boolean status=Rpage.captureUserExistingMessage().contains("Email already registered!");
	Assert.assertTrue(status,"Error message displayed as expected ");
	 
	boolean status2=Rpage.signupSuccessMessage().contains("Signup successfully, Please login!");
	Assert.assertTrue(status2,"Error message displayed as expected ");

	//driver.quit();
	
}
	@Test(priority = 3, dataProvider = "courseDeatils", dataProviderClass = CustomDataProvider.class)
	public void CourseDetails(String courseName, String description, String instructor, String price,  String categorySelection) throws InterruptedException 
	{
	ManageCoursePage course = new ManageCoursePage(driver);
	course.CourseDetails(courseName, description, instructor, price, categorySelection);
	}
	

//	@Test(priority = 2, dataProvider = "category", dataProviderClass = CustomDataProvider.class)
//    public void categoryManage(String categoryName) throws InterruptedException
//    {
//		   
//            ManageCategoryPage Mcategory = new ManageCategoryPage(driver);
//            
//            Mcategory.AddCategory(categoryName);         
//            
//    }
	@Test(priority = 4, dataProvider = "courseEnroll", dataProviderClass = CustomDataProvider.class)
	public void enrollCourse(String address, String phoneNumber) throws InterruptedException {

		EnrollPage Cpage = new EnrollPage(driver);
		Cpage.addToCart();
		Cpage.enrollNow2(address, phoneNumber);
		String orderIdMsg = Cpage.captureOrderId().getText();
	    System.out.println(orderIdMsg);
		Assert.assertTrue(orderIdMsg.contains("order"));

	}

	
}
