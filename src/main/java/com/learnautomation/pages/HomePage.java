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
	private By username =By.id("email1");
	private By password =By.id("password1");
	private By loginButton =By.className("submit-btn");

	public void GoToHomepage(String uname,String pwd)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		 wait.until(ExpectedConditions.titleContains("Learn Automation Courses"));
		//String display_msg=driver.findElement(messsagedisplay).getText();
		Utility.waitForWebElement(driver,username).sendKeys(uname);
		Utility.waitForWebElement(driver,password).sendKeys(pwd);
		Utility.waitForWebElement(driver,loginButton).click();
	}
	 public String capturedisplayMessage()
	 {
       WebElement element=Utility.waitForWebElement(driver, messsagedisplay); 
		 WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		 wait.until(ExpectedConditions.titleContains("Learn Automation Courses"));
		String display_msg=Utility.highlightWebElement(driver, messsagedisplay).getText();
		return display_msg;
	}

}