package com.newtours.pages;

import com.newtours.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase 
{
	@FindBy(xpath = "//input[@name='userName']")
	WebElement phoneNumberTextbox;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordTextbox;
	
	@FindBy(xpath="//input[@name='login']")
	WebElement loginButton;

	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public HomePage login(String userName, String password)
	{
		phoneNumberTextbox.sendKeys(userName);
		passwordTextbox.sendKeys(password);
		loginButton.click();
				
		return new HomePage();
	}
}

