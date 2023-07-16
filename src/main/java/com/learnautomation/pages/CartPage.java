package com.learnautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.learnautomation.helper.Utility;

public class CartPage {
	protected WebDriver driver;

	public CartPage(WebDriver driver) {
		this.driver = driver;
	}

	private By cartBtn = By.className("cartBtn");
	private By shopNow = By.xpath("//button[text()='Shop Now']");
	private By coursePrice = By
			.xpath("//h2[text()='Nilam-Testcourse']//parent::div//following-sibling::span[@id='cardChip']/b");
	// parent alternative
	// -//h2[text()='Nilam-Testcourse']/../following-sibling::button   button[text()='Add to Cart']
	private By addToCart = By.xpath("//h2[text()='Nilam-Testcourse']//parent::div//following-sibling::button[text()='Add to Cart']");
	private By cartCount = By.xpath("//button[@class='cartBtn']//span[@class='count']");
	private By enrollNow = By.xpath("//button[text()='Enroll Now']");
	private By address = By.xpath("//textarea[@id='thumbnail']");
	private By phoneNumber = By.xpath("//input[@id='name']");
	private By totalPrice = By.xpath("//h3[@style='text-align: right;']/b");
	private By confirmEnrollNow = By.xpath("//div[@class='modal-footer']//button[text()='Enroll Now']");
	private By orderId = By.xpath("//div[@class='modal-body']//h4[@class='uniqueId']//b");
	private By cancelBtn = By.xpath("//button[text()='Cancel']");

	public void addToCart() {
		
		Utility.waitForWebElement(driver, cartBtn).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;

			js.executeScript("window.scrollBy(0,-350)", "");

			Utility.waitForWebElement(driver, cartBtn).click();

			Utility.waitForWebElement(driver, shopNow).click();

			String price1 = Utility.waitForWebElement(driver, coursePrice).getText();

			System.out.println("The price for the course is:: " + price1);

			Utility.waitForWebElement(driver, addToCart).click();

             if(Utility.waitForWebElement(driver, cartCount).isDisplayed()==true)
             {
                     System.out.println("Course is added into the cart successfully");
                     
                     Utility.waitForWebElement(driver, cartBtn).click();
             }
             
             else
             {
                     System.out.println("Your cart is empty please add the course into the cart");
             }
             
            js.executeScript("window.scrollBy(0, -350)", "");

			Utility.waitForWebElement(driver, enrollNow).click();

			WebElement price2 = Utility.waitForWebElement(driver, totalPrice);

			System.out.println("The price while enroll is::" + price2.getText());

			if (price2.getText().contains(price1) == true) {
				System.out.println("The actual price of the course is same as while enroll!!");
			}

			else {
				System.out.println("Sorry the price is different");
			}
		}
	

	public void enrollNow(String courseAddress, String phoneNo) {
		Utility.waitForWebElement(driver, address).sendKeys(courseAddress);

		Utility.waitForWebElement(driver, phoneNumber).sendKeys(phoneNo);

		Utility.waitForWebElement(driver, confirmEnrollNow).click();

	}

	public WebElement captureOrderId() {
		WebElement orderIdStatus = Utility.waitForElement(driver, orderId);

		System.out.println("Your order id is: " + orderIdStatus.getText());

		Utility.waitForWebElement(driver, cancelBtn).click();

		return orderIdStatus;

	}

}
