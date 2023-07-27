package com.learnAutomation.testcases;

import org.apache.poi.ddf.EscherColorRef.SysIndexSource;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.learnautomation.dataProvider.CustomDataProvider;
import com.learnautomation.helper.BaseClass;
import com.learnautomation.pages.EnrollPage;
import com.learnautomation.pages.LoginPage;

public class CourseEnrollTest extends BaseClass 
{
	
	@Test(priority = 5, dataProvider = "login", dataProviderClass = CustomDataProvider.class)
	public void loginToApp(String username, String password) {
		LoginPage page = new LoginPage(driver);
		page.loginToApplication(username, password);

	}

	@Test(priority = 6, dataProvider = "courseEnroll", dataProviderClass = CustomDataProvider.class)
	public void enrollCourse(String address, String phoneNumber) throws InterruptedException {

		EnrollPage Cpage = new EnrollPage(driver);
		Cpage.addToCart();
		Cpage.enrollNow2(address, phoneNumber);
		String orderIdMsg = Cpage.captureOrderId().getText();
	    System.out.println(orderIdMsg);
		Assert.assertTrue(orderIdMsg.contains("order"));

	}

}
