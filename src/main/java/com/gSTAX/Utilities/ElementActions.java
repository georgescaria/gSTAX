package com.gSTAX.Utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gSTAX.Functions.ReportImplementor;


public class ElementActions {
	
	public WebDriver getDriver(String TC_ID)
	{
		WebDriver driver = ReportImplementor.driverMap.get(TC_ID);
		return driver;
	}
	
	public void click(String TC_ID, String xpath, String elementName)
	{
		WebDriver driver = ReportImplementor.driverMap.get(TC_ID);
	 	WebElement element = driver.findElement(By.xpath(xpath));

		try {
				JavascriptExecutor executor = (JavascriptExecutor)driver; 
				executor.executeScript("arguments[0].click();", element);
				executor = null;
				Report.logEvent(TC_ID, elementName+" clicked");
			}
		catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		driver = null;
		element = null;
	}
	
	public void scrollToElement(String TC_ID, String xpath, String elementName)
	{
		WebDriver driver = ReportImplementor.driverMap.get(TC_ID);
	 	WebElement element = driver.findElement(By.xpath(xpath));

		try {
				JavascriptExecutor executor = (JavascriptExecutor)driver; 
				executor.executeScript("arguments[0].scrollIntoView(true);", element);
				executor = null;
				Report.logEvent(TC_ID, "Scrolled to "+ elementName);
			}
		catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		driver = null;
		element = null;
	}
	
	public void inputText(String TC_ID, String xpath, String inputText, String elementName) throws Exception
	{
		WebDriver driver = ReportImplementor.driverMap.get(TC_ID);
	 	WebElement element = driver.findElement(By.xpath(xpath));

	 	element.sendKeys(inputText);
		Report.logEvent(TC_ID, "'"+ inputText +"' entered in "+elementName);
		
		driver = null;
		element = null;
	}
	
	public void clearAndInputText(String TC_ID, String xpath, String inputText, String elementName) throws Exception
	{
		WebDriver driver = ReportImplementor.driverMap.get(TC_ID);
	 	WebElement element = driver.findElement(By.xpath(xpath));
	 	
	 	element.clear();
	 	element.sendKeys(inputText);
		Report.logEvent(TC_ID, "'"+ inputText +"' entered in "+elementName);
		
		driver = null;
		element = null;
	}
	
	public void enterKey(String TC_ID) throws Exception
	{
		WebDriver driver = ReportImplementor.driverMap.get(TC_ID);
	 	WebElement element = driver.findElement(By.xpath("//input"));

	 	element.sendKeys(Keys.ENTER);
		
		driver = null;
		element = null;
	}
	
	public void selectDropDownByVisibleText(String TC_ID, String xpath, String visibleText) throws Exception
	{
		WebDriver driver = ReportImplementor.driverMap.get(TC_ID);
		WebElement element = driver.findElement(By.xpath(xpath));

		Select sel = new Select(element);
		sel.selectByVisibleText(visibleText);
		
		Report.logEvent(TC_ID, visibleText+" selected");
		
		driver = null;
		element = null;
	}
	
	public void checkDropDownValues(String TC_ID, String xpath, String expectedValue) throws Exception
	{
		 WebDriver driver = ReportImplementor.driverMap.get(TC_ID);

		 String[] arr = expectedValue.split(",");
	   	 WebElement dropdown = driver.findElement(By.xpath(xpath));  
	   	 Select select = new Select(dropdown);  
	
	   	 List<WebElement> options = select.getOptions();  
	   	 for(WebElement we:options)  
	   	 {  
	       	  boolean match = false;
	       	  for (int i1=0; i1<arr.length; i1++){
	       	      if (we.getText().equals(arr[i1]))
	       	      {
	       	        match = true;
	       	        Report.logEvent(TC_ID, we.getText()+" is displayed");
	       	      }
	       	    }
	       	  if(!match)
	       		  Report.fail(TC_ID, we.getText()+" should not be displayed in the drop down list");
	   	 }  
	   	 
	   	 for(int i1=0; i1<arr.length; i1++)  
	   	 {  
	       	  boolean match = false;
	       	  for (WebElement we:options){
	       	      if (arr[i1].equals(we.getText()))
	       	      {
	       	        match = true;
	       	      }
	       	    }
	       	  if(!match)
	       		  Report.fail(TC_ID, arr[i1]+" is not displayed in the drop down list");
	       } 
			
			driver = null;
			options = null;
			arr = null;
			select = null;
			dropdown = null;
	}
	
	public void waitUntilDisplayed(String TC_ID, String xpath)
	{
		WebDriver driver = ReportImplementor.driverMap.get(TC_ID);
		WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        driver = null;
        wait = null;
	}
	
	public void waitUntilClickable(String TC_ID, String xpath)
	{
		WebDriver driver = ReportImplementor.driverMap.get(TC_ID);
		WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        driver = null;
        wait = null;
	}
	
	
}
