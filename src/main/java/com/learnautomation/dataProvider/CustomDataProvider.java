package com.learnautomation.dataProvider;

import org.testng.annotations.DataProvider;

public class CustomDataProvider {

	// Access login credentials
	
	@DataProvider(name="users")
	public static Object[][] getUserData()
	{
		Object [][]arr=ExcelReader.getDataFromSheet("Users");
		return arr;
	}
	
	@DataProvider(name="Login")
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
 
 @DataProvider(name ="courseEnroll")
 public static Object[][] getEnrollDataFromExcel() 
 {

 		Object [][]arr=ExcelReader.getDataFromSheet("Enroll");
 		return arr;
 }
}

