package com.learnautomation.pages;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.learnautomation.helper.Utility;

public class HomePage {
protected WebDriver driver;
    
	public HomePage(WebDriver driver)
		{
		this.driver=driver;
		}

	private By messsagedisplay= (By.xpath("//h4[normalize-space()='Welcome Admin Manager to Learn Automation Courses']"));//h4[normalize-space()='Welcome Admin Manager to Learn Automation Courses']
	
	 public String capturedisplayMessage()
	 {
        Utility.waitForElement(driver, messsagedisplay); 
		String display_msg=Utility.highlightWebElement(driver, messsagedisplay).getText();
		return display_msg;
	}
	
}