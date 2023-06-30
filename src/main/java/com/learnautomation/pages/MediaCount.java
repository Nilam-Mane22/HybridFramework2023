package com.learnautomation.pages;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.learnautomation.helper.BaseClass;


public class MediaCount extends BaseClass  {
protected WebDriver driver;

public MediaCount(WebDriver driver)
	{
	this.driver=driver;
	}
	private By mediacount=(By.xpath("//div[@class='social']//div[@class='social-btns']/a"));

	public void socialmediacount()
	{
      List<WebElement> social =driver.findElements(mediacount);
		System.out.println(social.size());
		
		Assert.assertEquals(social.size(), 5);
		
		for (WebElement ele :social)
		{
		
			String name =ele.getAttribute("href");
			System.out.println(name);
			if(name.contains("youtube")|| name.contains("twitter")|| name.contains("reddit")|| name.contains("facebook")|| name.contains("linkedin"))
			{
				
			}
			else
			{
				Assert.assertFalse(true);
			}
			}
		System.out.println("All 5 social media list displayed ");
		
	}
}

	