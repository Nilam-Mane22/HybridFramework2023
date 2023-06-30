package com.learnautomation.pages;

import org.openqa.selenium.By;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.learnautomation.helper.Utility;

//import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	protected WebDriver driver;

	public LoginPage(WebDriver driver) 
	{
		this.driver = driver;
	}

	private By newUserLink = By.linkText("New user? Signup");
	private By errormessage = By.className("errorMessage");
	private By username = By.id("email1");
	private By password = By.id("password1");
	private By loginButton = By.className("submit-btn");
	private By messsagedisplay = (By.xpath("//h4"));

	public RegisterPage clickOnNewUserLink() {
		Utility.waitForWebElement(driver, newUserLink).click();
		RegisterPage page = new RegisterPage(driver);
		return page;
	}

//	public HomePage LandingOnHome() {
//		Utility.waitForWebElement(driver, messsagedisplay).getText();
//		HomePage page = new HomePage(driver);
//		return page;
//	}

	public void loginToApplication(String uname, String pwd) {
		Utility.waitForWebElement(driver, username).sendKeys(uname);
		Utility.waitForWebElement(driver, password).sendKeys(pwd);
		Utility.waitForWebElement(driver, loginButton).click();

	}

	public String captureErrorMessage() {
		WebElement element = Utility.waitForWebElement(driver, errormessage);

		String error_msg = Utility.highlightWebElement(driver, element).getText();

		return error_msg;
	}

}
