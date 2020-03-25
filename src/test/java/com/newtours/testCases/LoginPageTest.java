package com.newtours.testCases;

import com.newtours.base.TestBase;
import com.newtours.pages.HomePage;
import com.newtours.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class LoginPageTest extends TestBase
{	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest()
	{
		super();
	}
	
	@Parameters("Browser")
	@BeforeMethod
	public void setUp(String Browser)
	{
		initialization(Browser);
		Log.info("Login page launched successfully");
		loginPage = new LoginPage();
	}
	
	@Test(priority=1, enabled=true)
	public void loginTest(Method method)
	{
		extentTest = extent.startTest(method.getName());
		homePage = loginPage.login(property.getProperty("userName") ,property.getProperty("password"));
		Log.info("Successfully Logged in");
	}
}
