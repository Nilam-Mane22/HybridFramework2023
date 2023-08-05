package com.learnautomation.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
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
	private By subMenuCategory = By.xpath("//a[@href='/category/manage']");	
	private By addNewCategory = By.xpath("//div[@class='manage-btns']");
	
	//private By addCategory = By.cssSelector("div[class='manage-btns'] button");
	
	
	public void AddCategory(String categoryName) throws InterruptedException 	
	{
		Utility.waitForWebElement(driver, manageMenu); 
		
        new Actions(driver).moveToElement(driver.findElement(manageMenu)).perform(); 
       
        Utility.waitForWebElement(driver, subMenuCategory).click();
        Thread.sleep(3000);  
        
        String parent = driver.getWindowHandle();
        //System.out.println("Current window handle is:"+parent);    
        Set<String> allWindows= driver.getWindowHandles();      
        //System.out.println("All Windows handle is::"+allWindows);       
        Iterator<String> switchWindows = allWindows.iterator();   
        
        while(switchWindows.hasNext())
        {
                String child = switchWindows.next();
                if(!child.equals(parent))
                {
                        driver.switchTo().window(child);                  
                        Utility.waitForWebElement(driver, addNewCategory).click();                       
                        Alert alt = driver.switchTo().alert();                       
                        Utility.waitForAlert(driver, 10);                        
                        alt.sendKeys(categoryName);                      
                        System.out.println(categoryName+" category is added successfully");                       
                        alt.accept();                     
                }                
                      driver.switchTo().window(parent);
        }
 }
}