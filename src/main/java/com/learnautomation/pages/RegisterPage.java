package com.learnautomation.pages;

import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.learnautomation.helper.Utility;

public class RegisterPage {

protected WebDriver driver;
    
	public RegisterPage(WebDriver driver)
		{
		this.driver=driver;
		}
	
	private By firstname =By.id("name");
    private By emailid =By.name("email");
    private By password =(By.xpath("//input[@type='password']"));
   //private By interestCB =(By.xpath("//label[text()='"+interest+"']"));
   //private By genderRB=(By.xpath("//input[@value='"+gender+"']"));
   //private By state=(By.xpath("//select[@id='state']//following::option[@value='"+state+"]"));
   //private By hobbies=(By.xpath("//select[@id='hobbies']//following::option[@value='"+hobbies+"']"));
    
    private By signupclick=(By.xpath("//button[@type='submit']"));
    private By userExistingmsg=(By.xpath("//h2[@class='errorMessage false']"));
    private By signupSuccessMsg=(By.xpath("//div[contains(text(),'Signup successfully, Please login!')]"));
 
  

	
		public void createUser(String fname,String eid,String pwd,String interest,String  gender,String state,String hobby )
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Sign Up']")));
			
			Utility.waitForWebElement(driver,firstname).sendKeys(fname);
			Utility.waitForWebElement(driver,emailid).sendKeys(eid);
			Utility.waitForWebElement(driver,password).sendKeys(pwd);
		
		    WebElement interestCB= driver.findElement(By.xpath("//label[text()='"+interest+"']"));
		    Utility.highlightWebElement(driver, interestCB).click();
		    
		    WebElement genderRB=driver.findElement(By.xpath("//input[@value='"+gender+"']"));
		    Utility.highlightWebElement(driver, genderRB).click();
		    
//		    WebElement stateCB=driver.findElement(By.xpath("//select[@id='state']//following::option[@value='"+state+"]"));
//		    Utility.highlightWebElement(driver, stateCB).click();
		    
           // WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement stateDD =wait.until(ExpectedConditions.elementToBeClickable(By.id("state")));
		    WebElement State=driver.findElement(By.id("state"));
		    Select StateDD=new Select(State);
		    StateDD.selectByValue(state);
		    
		    Utility.highlightWebElement(driver, stateDD);
		    
		    WebElement hobbies= driver.findElement(By.xpath("//select[@id='hobbies']//following::option[@value='"+hobby+"']"));
		    Utility.highlightWebElement(driver, hobbies).click();
		    
		    Utility.waitForWebElement(driver,signupclick).click();
		    
	}
		public String captureUserExistingMessage()
		 {
			   WebElement element=Utility.waitForWebElement(driver, userExistingmsg);
				
				String existing_msg=Utility.highlightWebElement(driver, element).getText();
				
				return existing_msg;
			}
			
		public String signupSuccessMessage()
		 {
			   WebElement element=Utility.waitForWebElement(driver, signupSuccessMsg);
				
				String success_msg=Utility.highlightWebElement(driver, element).getText();
			
				return success_msg;
		}
}
		
		