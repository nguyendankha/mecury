package com.newtours.utilities;

import com.newtours.base.TestBase;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestUtility extends TestBase
{
	//These 2 variable we used in TestBase Class for Page Load and Implicit Wait.
	public static long Page_Load_TimeOut = 20;
	public static long Implicit_Wait = 30;

	//Screenshot Utility.
	public static void takeScreenshotAtEndOfTest() throws IOException
	{
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/src/test/java/screenshots/testScreenshots/" + System.currentTimeMillis() + ".png"));
	}

	//Explicit Wait for Click on any Element.
	public static void clickOn(WebDriver driver, WebElement element, int timeout)
	{
		new WebDriverWait(driver, timeout).
		until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

	//Explicit Wait for Sending Data to any Element.
	public static void sendKeys(WebDriver driver, WebElement element, int timeout, String value)
	{
		new WebDriverWait(driver, timeout).
		until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
	}

	//Element Display or Not.
	public static void displayElement(WebElement element)
	{
		boolean elementDisplayed = element.isDisplayed();
		if(elementDisplayed)
		{
			System.out.println("Element is Displayed");
		}
		else
		{
			System.out.println("Element is not Displayed");
		}
	}

	//Element is Enable or Not.
	public static void enableElement(WebElement element)
	{
		boolean elementEnabled = element.isEnabled();
		if(elementEnabled)
		{
			System.out.println("Element is Enabled in Page");
		}
		else
		{
			System.out.println("Element is not Enabled in Page");
		}
	}

	//Extent Report - 1.
	public static String getSystemDate()
	{
		DateFormat dateFormat = new SimpleDateFormat("_ddMMyyyy_HHmmss");
		Date date = new Date();
		return dateFormat.format(date);
	}

	//Extent Report - 2.
	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException
	{
		//We have generated Date now.
		String dateName = new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);

		String destination = System.getProperty("user.dir") + "\\src\\test\\java\\screenshots\\testScreenshots\\" + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

	//Set Date For Log4J.
	public static void setDateForLog4j() 
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("_ddMMyyy_hhmmss");
		System.setProperty("current_date", dateFormat.format(new Date()));
		PropertyConfigurator.configure("./src/main/resources/log4j.properties");
	}
}

	