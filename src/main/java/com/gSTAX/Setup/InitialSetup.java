package com.gSTAX.Setup;

import java.sql.Date;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InitialSetup {
	
	public static ExtentReports extent = new ExtentReports();
	public static ExtentTest Report;
	public static ExtentSparkReporter spark = new ExtentSparkReporter("Test Results/TestSuite-"+getDateTime()+".html");
	public static String TC_ID;
	public static WebDriver driver;

	public static String getDateTime()
	{
		Calendar calendar = Calendar.getInstance();
		Format format = new SimpleDateFormat("dd-mm-yyyy hh-ss");
		String datetime = format.format(new Date(calendar.getTimeInMillis()));
		return datetime; 
	}

	@Parameters({ "TC_ID" })
	@BeforeTest
	public static void InitialSetup(String TestCase_ID)
	{
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
		TC_ID = TestCase_ID;
		extent.attachReporter(spark);
		Report=extent.createTest(TC_ID);
	}
	@Test
	public void extentReportsDemo()
	{

	}

	@AfterTest
	public static void endTest()
	{
		extent.flush();
		driver.quit();
		extent.flush();
	}
} 