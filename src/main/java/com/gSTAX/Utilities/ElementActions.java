package com.gSTAX.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gSTAX.Functions.ReportImplementor;


public class ElementActions {
	
	public void click(String TC_ID, String xpath, String elementName)
	{
		WebDriver driver = ReportImplementor.driverMap.get(TC_ID);
		WebElement element = driver.findElement(By.xpath(xpath));

		try {
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", element);
				executor = null;
				Report.takeScreenshot(TC_ID, elementName+" clicked");
			}
		catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		driver = null;
		element = null;
	}
	
	public void waitUntilDisplayed(String TC_ID, String xpath)
	{
		WebDriver driver = ReportImplementor.driverMap.get(TC_ID);
		WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        driver = null;
        wait = null;
	}
	
	
}
