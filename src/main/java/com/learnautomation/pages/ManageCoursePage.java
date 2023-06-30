package com.learnautomation.pages;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
        
        
        public void AddNewCourse(String cname,String cdescription,String cintrsuctor,String stratDate,String  EndDate,String state,String hobby )
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Sign Up']")));
			
			Utility.waitForWebElement(driver,courseName).sendKeys(cname);
			Utility.waitForWebElement(driver,description).sendKeys(cdescription);
			Utility.waitForWebElement(driver,instrauctorName).sendKeys(cintrsuctor);
			Utility.waitForWebElement(driver,instrauctorName).sendKeys(cintrsuctor);
			Utility.waitForWebElement(driver,price).sendKeys(cintrsuctor);
			Utility.waitForWebElement(driver,startDate).sendKeys(cintrsuctor);
			Utility.waitForWebElement(driver,endDate).sendKeys(cintrsuctor);
			Utility.waitForWebElement(driver,categorySelection).click();
}
}
		
