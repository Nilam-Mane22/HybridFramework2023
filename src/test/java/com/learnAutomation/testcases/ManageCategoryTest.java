package com.learnAutomation.testcases;
import org.testng.annotations.Test;


import com.learnautomation.dataProvider.CustomDataProvider;
import com.learnautomation.helper.BaseClass;
import com.learnautomation.pages.LoginPage;
import com.learnautomation.pages.ManageCategoryPage;

public class ManageCategoryTest extends BaseClass
{
	@Test(priority = 1 ,dataProvider = "login",dataProviderClass = CustomDataProvider.class)
	public void loginToApp(String username,String password)
	{
		LoginPage page=new LoginPage(driver);	
		page.loginToApplication(username, password);
	}
	
	
	  @Test(priority = 2, dataProvider = "category", dataProviderClass = CustomDataProvider.class)
      public void categoryManage(String categoryName) throws InterruptedException
      {		   
              ManageCategoryPage Mcategory = new ManageCategoryPage(driver);             
              Mcategory.AddCategory(categoryName);            
      }     
}
