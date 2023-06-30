package com.learnAutomation.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemo {
	
	ExtentReports extent;
	
	@BeforeTest
	public void config()
	{
		ExtentSparkReporter reporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/Reports/EXReport.html");
		reporter.config().setReportName("WebAutomation Results");	
		reporter.config().setDocumentTitle("TestResult");
		
	     extent=new ExtentReports();

		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Nilam");
	
	}
	
	@Test
	public void initialdemo()
	{
		
		ExtentTest t1=extent.createTest("initialdemo");
		ExtentTest t2=t1.createNode("Node1");
		ExtentTest t3=t1.createNode("Node2");
		
		ExtentTest tc1=extent.createTest("TestDemo");
		ExtentTest tc2=tc1.createNode("TCNode1");
		ExtentTest tc3=tc1.createNode("TCNode2");
		
		
		

//		WebDriver driver=new ChromeDriver();
//	    driver.get("https://freelance-learn-automation.vercel.app/login");
	   // System.out.println(driver.getTitle());
	    extent.flush();
	}
}
