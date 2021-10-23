package com.gSTAX.Setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.gSTAX.Functions.ReportImplementor;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InitialSetup {
	
	
	public String TC_ID, URL, Browser;
	public WebDriver driver;
	public static ReportImplementor reportFunctions;


	@Parameters({ "TC_ID", "URL", "Browser" }) 
	@BeforeTest
	public void Setup(String TestCase_ID, String URL, String Browser)
	{
		this.TC_ID = TestCase_ID;
		this.URL = URL;
		this.Browser = Browser;
		openBrowser();
		reportFunctions = new ReportImplementor(TC_ID,driver);
		reportFunctions.startReporting();
	}


	@AfterTest
	public void endTest()
	{
		driver.quit();
		reportFunctions.endReporting();
	}
	
	void openBrowser() 
	{
		switch(Browser)
		{
			case "Chrome":
				WebDriverManager.chromedriver().setup();
			    driver = new ChromeDriver();
			    break;
			    
			case "Edge":
				WebDriverManager.edgedriver().setup();
			    driver = new EdgeDriver();
			    break;
			    
			case "Firefox":
				WebDriverManager.firefoxdriver().setup();
			    driver = new ChromeDriver();
			    break;
			    
			case "Opera":
				WebDriverManager.operadriver().setup();
			    driver = new OperaDriver();
			    break;
		}
		
		driver.manage().window().maximize();
	    driver.get(URL);
	    
	}
} 