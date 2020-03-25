package com.newtours.pages;

import com.newtours.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase
{
	@FindBy(xpath = "//a[contains(text(), 'SIGN-OFF')]")
	WebElement logoutLink;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() {
		System.out.println(driver.getTitle());
		return driver.getTitle();
	}

	public boolean verifySignOffLinkDisplayed(){
		return logoutLink.isDisplayed();
	}
}
