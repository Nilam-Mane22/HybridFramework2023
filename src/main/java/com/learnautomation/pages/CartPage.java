package com.learnautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage 
{
	protected WebDriver driver;

	public CartPage(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	private By cartBtn = By.className("cartBtn");
    private By shopNow = By.xpath("//button[text()='Shop Now']");
    private By Addtocart=By.xpath("//h2[text()='Nilam-Testcourse']//parent::div//following-sibling::button");
    // parent alternative -//h2[text()='Nilam-Testcourse']/../following-sibling::button
}

