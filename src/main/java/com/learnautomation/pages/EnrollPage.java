package com.learnautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.learnautomation.helper.Utility;

public class EnrollPage {
	protected WebDriver driver;

	public EnrollPage(WebDriver driver) {
		this.driver = driver;
	}

	private By cartBtn = By.className("cartBtn"); 
	private By shopNow = By.xpath("//button[text()='Shop Now']");
	private By coursePrice = By
			.xpath("//span[normalize-space()='Nilam']//parent::div //following-sibling::span[@id='cardChip']/b");
	// parent alternative
	// -//h2[text()='Nilam-Testcourse']/../following-sibling::button   button[text()='Add to Cart']
	private By courseSelect=By.xpath("//span[normalize-space()='Nilam']");
	private By addToCart = By.xpath("//span[text()='Nilam']//following::button[text()='Add to Cart']");
	private By cartCount = By.xpath("//button[@class='cartBtn']//span[@class='count']");
	private By enrollNow = By.xpath("//button[text()='Enroll Now']"); 
	private By address = By.xpath("//textarea[@id='thumbnail']");
	private By phoneNumber = By.xpath("//input[@id='name']");
	private By totalPrice = By.xpath("//h3[@style='text-align: right;']/b");
	private By FinalEnrollNow = By.xpath("//div[@class='modal-footer']//button[text()='Enroll Now']");
	private By orderId = By.xpath("//h4[@class='uniqueId']//b");
	private By cancelBtn = By.xpath("//button[text()='Cancel']");

	public void addToCart() throws InterruptedException {
		
		Utility.waitForWebElement(driver, cartBtn);
		//new Actions(driver).moveToElement(driver.findElement(cartBtn)).perform();
	
			Utility.waitForWebElement(driver, cartBtn).click();
			Utility.waitForWebElement(driver, shopNow).click();

			String price1 = Utility.waitForWebElement(driver, coursePrice).getText();
			System.out.println("The price for the course is:: " + price1);			
            Thread.sleep(5000);
            try
            {
            	Utility.waitForWebElement(driver, addToCart).click();          	
            }
            catch(ElementClickInterceptedException e)
            {
            	WebElement ele=driver.findElement(addToCart);
            	JavascriptExecutor js=(JavascriptExecutor)driver;
            	js.executeScript("arguments[0].click()",ele);
                	
            }
			
             if(Utility.waitForWebElement(driver, cartCount).isDisplayed()==true)
             {
                     System.out.println("Course is added into the cart");
                     
                     Utility.waitForWebElement(driver, cartBtn).click();
             }
             
             else
             {
                     System.out.println("Your cart is empty please add the course");
             }
             
             
             Thread.sleep(3000);
             try
             {
              Utility.waitForWebElement(driver, enrollNow).click();
             	
             }
             catch(ElementClickInterceptedException e)
             {
             	WebElement ele=driver.findElement(enrollNow);
             	JavascriptExecutor js=(JavascriptExecutor)driver;
             	js.executeScript("arguments[0].click()",ele);                	
             }

		

			WebElement price2 = Utility.waitForWebElement(driver, totalPrice);
			System.out.println("The price while enroll is::" + price2.getText());

			if (price2.getText().contains(price1) == true) {
				System.out.println("The actual price of the course is same as while enroll!!");
			}

			else 
			{
				System.out.println("Sorry the price is different");
			}
		}
	

	public void enrollNow2(String courseAddress, String phoneNo) 
	{
		Utility.waitForWebElement(driver, address).sendKeys(courseAddress);
        System.out.println(phoneNo);
		Utility.waitForWebElement(driver, phoneNumber).sendKeys(phoneNo);    
		Utility.waitForWebElement(driver, FinalEnrollNow).click();
	}

	public WebElement captureOrderId() 
	{
		WebElement orderIdStatus = Utility.waitForElement(driver, orderId);
		System.out.println("Your order id is: " + orderIdStatus.getText());
		Utility.waitForWebElement(driver, cancelBtn).click();
		return orderIdStatus;
	}

}
