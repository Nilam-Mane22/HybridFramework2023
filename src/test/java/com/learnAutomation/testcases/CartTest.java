package com.learnAutomation.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.learnautomation.dataProvider.CustomDataProvider;
import com.learnautomation.helper.BaseClass;
import com.learnautomation.pages.CartPage;
import com.learnautomation.pages.LoginPage;

public class CartTest extends BaseClass

{
@Test(priority = 1, dataProvider = "Login", dataProviderClass = CustomDataProvider.class)
public void loginAppTest(String username, String password)
{
        LoginPage Lpage = new LoginPage(driver);
        
        Lpage.loginToApplication(username, password);
        
        System.out.println("You have logged in successfully");
        
}

@Test(priority = 3, dataProvider = "courseEnroll", dataProviderClass = CustomDataProvider.class)
        public void enrollCourse(String courseAddress, String phoneNumber)
      
        {
	           CartPage Cpage = new CartPage(driver);
                
                Cpage.addToCart();
                
                Cpage.enrollNow(courseAddress, phoneNumber);
                
                Boolean orderIdIsEmpty = Cpage.captureOrderId().getText().isEmpty();
                
                Assert.assertTrue(orderIdIsEmpty, "Sorry the order id is blank");
                
        }
}