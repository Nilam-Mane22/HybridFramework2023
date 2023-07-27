package com.learnautomation.dataProvider;

import org.testng.annotations.DataProvider;

public class CustomDataProvider {


	// Access login credentials
	@DataProvider(name="login")
	public static Object[][] getLoginData()
	{
		Object [][]arr=ExcelReader.getDataFromSheet("Login");
		return arr;
	}
	
	
	//Access SignUpDeatils from excel
 @DataProvider(name ="SignUpUsers")
public static Object[][] getSignupDataFromExcel() 
{

		Object [][]arr=ExcelReader.getDataFromSheet("SignUpUserDetails");
		return arr;
}
 //Mange course details
 @DataProvider(name ="courseDetails")
 public static Object[][] getcourseDeatils() 
 {

 		Object [][]arr=ExcelReader.getDataFromSheet("CourseDetails");
 		return arr;
 }
 //manage category details
 @DataProvider(name ="category")
 public static Object[][] categoryDataFromExcel() 
 {

 		Object[][]arr=ExcelReader.getDataFromSheet("Category");
 		return arr;
 }
//Add to cart -Enroll 
 @DataProvider(name ="courseEnroll")
 public static Object[][] getEnrollDataFromExcel() 
 {

 		Object[][]arr=ExcelReader.getDataFromSheet("CourseEnroll");
 		return arr;
 }
}
 

