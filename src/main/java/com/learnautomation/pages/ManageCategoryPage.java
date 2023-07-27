package com.learnautomation.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.learnautomation.helper.Utility;

public class ManageCategoryPage {

	protected WebDriver driver;
	public ManageCategoryPage(WebDriver driver)
	{
		this.driver = driver;
	}

	private By manageMenu = By.xpath("//div[@class='nav-menu-item-manage']");	
	private By subMenuCateory = By.xpath("//a[@href='/category/manage']");	
	private By addCategory = By.cssSelector("div[class='manage-btns'] button");
	private By Nil = By.xpath("//div[@class='container-child']");
	private By dip = By.className("manage-category");
	public void AddCategory(String categoryName) throws InterruptedException 	
	{
		Utility.waitForWebElement(driver, manageMenu); 
        new Actions(driver).moveToElement(driver.findElement(manageMenu)).perform(); 
        Thread.sleep(2000);
        Utility.waitForWebElement(driver, subMenuCateory).click();
        Thread.sleep(1000);  
        
        String web = Utility.waitForWebElement(driver, Nil).getAttribute("class");
        System.out.println(web);
        
        
        String web2 = driver.findElement(dip).getAttribute("class");
        System.out.println(web2);
        
        
        try
        {
        	//driver.switchTo().frame(0); 
        	Utility.waitForWebElement(driver, addCategory).click();
        	//new Actions(driver).moveToElement(driver.findElement(addCategory)).perform(); 
        	//driver.switchTo().defaultContent();      	
        }
        catch(Exception e)
        {
        	WebElement ele=driver.findElement(addCategory);
        	JavascriptExecutor js=(JavascriptExecutor)driver;
        	js.executeScript("arguments[0].click()",ele);           	
        }
        		
		Alert alt = driver.switchTo().alert();
		Utility.waitForAlert(driver, 10);
		alt.sendKeys(categoryName);
		System.out.println(categoryName + " is added successfully");
		alt.accept();
		driver.switchTo().alert().dismiss();
	}
}