package com.learnAutomation.testcases;

import java.net.MalformedURLException;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumGrid2 {

        public static void main(String[] args) {
                
                DesiredCapabilities cap = new DesiredCapabilities();
                
               cap.setBrowserName("chrome");
                //cap.setBrowserName("firefox");
               // cap.setBrowserName("edge");
                
              cap.setBrowserName(Browser.CHROME.browserName());
              
                
//{"browserName":"firefox","browserVersion":"114.0","platformName":"linux","se:noVncPort":7900,"se:vncEnabled":true}   
                
                
                try {
                	    //Instance 1
                        URL gridURL = new URL("http://ec2-35-154-8-97.ap-south-1.compute.amazonaws.com:4444/wd/hub");
                        
                        //Instance 2 
                        //URL gridURL = new URL("http://ec2-65-2-156-68.ap-south-1.compute.amazonaws.com:4444/wd/hub");
                     
                 
                        WebDriver driver = new RemoteWebDriver(gridURL, cap);
                        
                        System.out.println(driver);
                        driver.manage().window().maximize();
                        
                        driver.get("https://freelance-learn-automation.vercel.app/login");
                        
                        System.out.println("The title of the page is "+driver.getTitle());
                        
                        Thread.sleep(5000);
                        
                        driver.quit();
                        
                } catch (MalformedURLException e) {
                        System.out.println("Not able to connect to grid "+e.getMessage());
                }
                catch (InterruptedException e)
                {
                        e.getMessage();
                }
                
                

        }

}