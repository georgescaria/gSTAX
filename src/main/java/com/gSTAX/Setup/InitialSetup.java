package com.gSTAX.Setup;

import java.sql.Date;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.gSTAX.Functions.ReportImplementor;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InitialSetup {
	
	
	public static String TC_ID, URL, Browser;
	public static WebDriver driver;
	public static ReportImplementor reportFunctions;


	@Parameters({ "TC_ID", "URL", "Browser" })
	@BeforeTest
	public void InitialSetup(String TestCase_ID, String URL, String Browser)
	{
		InitialSetup.TC_ID = TestCase_ID;
		InitialSetup.URL = URL;
		InitialSetup.Browser = Browser;
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
		switch(Browser.toString())
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