package com.learnautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.learnautomation.helper.Utility;

public class ManageCoursePage {
	
		protected WebDriver driver;
	    
		public ManageCoursePage(WebDriver driver)
			{
			this.driver=driver;		
			}
		private By manageMenu=By.xpath("//span[text()='Manage']");
		private By manageCourseClick =By.xpath("//div[@class='nav-menu-item-hover-div']//child::a[1]");
		private By addCourseBtn =By.xpath("//div[@class='manage-btns']/child::button[3]");
		private By addNewCourse=By.id("thumbnail");
		private By courseName=By.xpath("//div[@class='modal-body']//following::input[2]");
		private By description=By.xpath("//div[@class='modal-body']//following::textarea");
        private By instrauctorName=By.xpath("//div[@class='combine-child']//following-sibling::input[@id='instructorNameId']");
        private By price =By.xpath("//div[@class='combine-child']//following-sibling::input[@id='price']");
        private By startDate=By.xpath("//div[@class='react-datepicker__input-container']//input[@type='text']");
        private By endDate=By.xpath("//div[@class='react-datepicker__input-container']//following::input");		
        private By categorySelection=By.xpath("//button[@class='menu-btn']//child::div");
        
        
        public void ManageCourseMenu()
		{
		
			
		}

}
		
////Add new course 
//		//1 choose file -THUMBNAIL
//		 driver.findElement(By.id("thumbnail")).sendKeys("F:\\test.png");	
//		Thread.sleep(1000);
////COURSE NAME
//		driver.findElement(By.xpath("//div[@class='modal-body']//following::input[2]")).sendKeys("Nilam-Testcourse");
//		
////DESCRIPTION
//		driver.findElement(By.xpath("//div[@class='modal-body']//following::textarea")).sendKeys("Created Test Course ");
////instructor 
//		driver.findElement(By.xpath("//div[@class='combine-child']//following-sibling::input[@id='instructorNameId']")).sendKeys("Mukesh Otwani");
////Price
//		driver.findElement(By.xpath("//div[@class='combine-child']//following-sibling::input[@id='price']")).sendKeys("2000");
//		
////start from 
//		driver.findElement(By.xpath("//div[@class='react-datepicker__input-container']//input[@type='text']")).click();
//	
////Enddate 
//		driver.findElement(By.xpath("//div[@class='react-datepicker__input-container']//following::input")).click();
//		Thread.sleep(1000);
//		
////Category mouse action 
//		new Actions(driver).moveToElement(driver.findElement(By.xpath("//button[@class='menu-btn']//child::div"))).perform();
//		driver.findElement(By.xpath("//button[@class='menu-btn']//child::div")).click();
//		
//			
////Automation Testing/Performance Testing 
//		new Actions(driver).moveToElement(driver.findElement(By.xpath("//button[@class='menu-btn']//following::button[text()='Automation Testing']"))).perform();
//		driver.findElement(By.xpath("//button[@class='menu-btn']//following::button[text()='Automation Testing']")).click();
////Performance Testing 
////		new Actions(driver).moveToElement(driver.findElement(By.xpath("//button[@class='menu-btn']//following::button[text()='Performance Testing']"))).perform();
////		driver.findElement(By.xpath("//button[@class='menu-btn']//following::button[text()='Performance Testing']")).click();
//		
//		
////save
////driver.findElement(By.xpath("//div[@class='modal-footer']//following::button")).click();
//		
//	} 
//	


