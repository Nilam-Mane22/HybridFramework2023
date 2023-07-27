package com.learnautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.learnautomation.helper.Utility;

public class ManageCoursePage 
{

	protected WebDriver driver;

	public ManageCoursePage(WebDriver driver) 
	{
		this.driver = driver;
	}

	private By manageMenu = By.xpath("//span[text()='Manage']");
	private By manageCourseSubMenu = By.xpath("//a[@href='/course/manage']");
	private By addNewCourseBtn = By.xpath("//button[text()='Add New Course ']");
	private By addImage = By.id("thumbnail");
	private By courseName = By.xpath("//input[@id='name']");
	private By description = By.xpath("//textarea[@id='description']");
	private By instrauctorName = By.xpath("//input[@id='instructorNameId']");
	private By price = By.xpath("//input[@id='price']");
	private By startDate = By.xpath("//input[@name='startDate']");
	private By endDate = By.xpath("//input[@name='endDate']");
	private By categorySelection = By.xpath("//div[text()='Select Category']");
	private By category = By.xpath("//button[text()='Automation Testing']");
	
	private By saveBtn = By.xpath("//button[@class='action-btn'][text()='Save']");

	public void CourseDetails(String cname, String cdescription, String cintrsuctor, String cprice 
			,String categoryNm) throws InterruptedException
	{

		Utility.waitForWebElement(driver, manageMenu); 
        new Actions(driver).moveToElement(driver.findElement(manageMenu)).perform(); 
        Thread.sleep(2000);
        
        Utility.waitForWebElement(driver, manageCourseSubMenu).click();
        Utility.waitForWebElement(driver, addNewCourseBtn).click(); 
         
        driver.findElement(addImage).sendKeys(System.getProperty("user.dir")+"/Images/TESTPIC.jpg");
        
		Utility.waitForWebElement(driver, courseName).sendKeys(cname);
		Utility.waitForWebElement(driver, description).sendKeys(cdescription);
		Utility.waitForWebElement(driver, instrauctorName).sendKeys(cintrsuctor);
		Utility.waitForWebElement(driver, price).sendKeys(cprice+"");// Covert to string
//		Utility.waitForWebElement(driver, startDate).sendKeys(cstratDate);
//		Utility.waitForWebElement(driver, endDate).sendKeys(cEndDate);
		Utility.waitForWebElement(driver, categorySelection).click();
	    Thread.sleep(1000);	    
		Utility.waitForElement(driver, category).click();		
		Utility.waitForWebElement(driver, saveBtn).click();
	}
}
