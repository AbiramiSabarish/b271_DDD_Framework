package com.vcentry.testcase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vcentry.base.BaseClass;
import com.vcentry.projname.pages.LoginPage;
import com.vcentry.utils.Function;

public class LoginTest extends BaseClass {
	LoginPage login;
//	@BeforeClass
//	
//	public void launchurl() {
//		driver.get(Function.getProp("loginUrl"));
//		login=new LoginPage( );
//	}
//	
	@BeforeMethod
	public void launchurl() {
		driver.get(Function.getProp("loginUrl"));
		login=new LoginPage();
	}
	
	@Test(dataProvider="ValidLogin",priority=1)
		public void loginWithValidCredentials(String uName, String pwd, String expectedResult) {
		login.enterUsername(uName);
		login.enterPassword(pwd);
		login.clickLoginBtn();
		login.verifyHomePage(expectedResult);
	}
	
	
	@Test(dataProvider="inValidLogin",priority=2)
	public void loginWithInValidCredentials(String uName, String pwd, String expectedResult) {
	login.enterUsername(uName);
	login.enterPassword(pwd);
	login.clickLoginBtn();
	login.verifyError(expectedResult);
}
	
	@DataProvider(name="ValidLogin")
	public String[][] validLogin(){
		return Function.getTestData("Login", "ValidCredentials");
	}
	
	@DataProvider(name="inValidLogin")
	public String[][] invalidLogin(){
		return Function.getTestData("Login", "InvalidCredentials");
	}

}
