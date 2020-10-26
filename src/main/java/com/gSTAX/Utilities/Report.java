package com.gSTAX.Utilities;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.*;



public class Report {

static ExtentReports extent = new ExtentReports();


	@BeforeTest
	public static void startTest()
	{
	ExtentSparkReporter spark = new ExtentSparkReporter("Test Results/Spark.html");
	extent.attachReporter(spark);
	extent.createTest("MyFirstTest").pass("Pass");
	extent.createTest("My2nd").pass("Pass");
	
	
	}
	@Test
	public void extentReportsDemo()
	{
	
	}
	@AfterTest
	public static void endTest()
	{
	extent.flush();
	}
}
