package com.vcentry.testcase;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vcentry.base.BaseClass;
import com.vcentry.projname.pages.LoginPage;
import com.vcentry.utils.Function;

public class LoginTest extends BaseClass {
	LoginPage login;
	@BeforeClass
	
	public void launchurl() {
		driver.get(Function.getProp("loginUrl"));
		login=new LoginPage( );
	}
	
	@Test(dataProvider="ValidLogin")
		public void loginWithValidCredentials(String uName, String pwd, String expectedResult) {
		login.enterUsername(uName);
		login.enterPassword(pwd);
		login.clickLoginBtn();
		login.verifyHomePage(expectedResult);
	}
	
	
	@Test(dataProvider="InValidLogin")
	public void loginWithInValidCredentials(String uName, String pwd, String expectedResult) {
	login.enterUsername(uName);
	login.enterPassword(pwd);
	login.clickLoginBtn();
	login.verifyError(expectedResult);
}
	
	@DataProvider(name="ValidLogin")
	public String[][] validLogin(){
		return Function.getTestData("login", "ValidCredentials");
	}
	
	@DataProvider(name="InValidLogin")
	public String[][] invalidLogin(){
		return Function.getTestData("login", "InvalidCredentials");
	}

}
