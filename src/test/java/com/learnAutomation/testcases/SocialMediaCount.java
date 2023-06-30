package com.learnAutomation.testcases;


import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.learnautomation.helper.BaseClass;



public class SocialMediaCount extends BaseClass
{
@Test
	
	public void socialMediaCount()
	{
   List<WebElement> social =driver.findElements(By.xpath("//div[@class='social']//div[@class='social-btns']/a"));
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
	  System.out.println("\n\n The Media count and list displayed: "+social.size());
	
}

}



