package com.gSTAX.Functions;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.gSTAX.Utilities.Report;

public class ReportImplementor extends Report {
	
	public static ExtentReports extent = new ExtentReports();
	public static ExtentTest test;
	public static ExtentSparkReporter spark = new ExtentSparkReporter("Test Results/TestSuite-"+getDateTime()+".html");
	public String TC_ID, URL, Browser;
	public WebDriver driver;
	public static File sourceFile, destinationFile;
	public static HashMap<String, ExtentTest> testCaseMap = new HashMap<String, ExtentTest>();
	public static HashMap<String, WebDriver> driverMap = new HashMap<String, WebDriver>();
	
	//Sets TC_ID and driver
	public ReportImplementor(String TC_ID, WebDriver driver)
	{
		this.TC_ID = TC_ID;
		this.driver = driver;
		driverMap.put(TC_ID, driver);
	} 
	
	//Start Extent Reporting
	public synchronized void startReporting()
	{
		extent.attachReporter(spark);
		test=extent.createTest(TC_ID);
		testCaseMap.put(TC_ID, test);
		
	}
	
	//Ends Extent Reporting
	public void endReporting()
	{
		extent.flush();
	}
	
	//Log event
	public synchronized static void logEvent(String TC_ID, String logMessage) 
	{
		test = testCaseMap.get(TC_ID);
		test.info(logMessage);
	}
		
	//Take screenshot-INFO only
	public synchronized static void takeScreenshot(String TC_ID) throws IOException
	{
		saveScreenshot(TC_ID);
		test = testCaseMap.get(TC_ID);
		test.info("", MediaEntityBuilder.createScreenCaptureFromPath(destinationFile.getAbsolutePath()).build());
	}
	
	//Take screenshot and add a log message - INFO only
	public synchronized static void takeScreenshot(String TC_ID, String logMessage) throws IOException
	{
		saveScreenshot(TC_ID, logMessage);
		test = testCaseMap.get(TC_ID);
		test.info(logMessage, MediaEntityBuilder.createScreenCaptureFromPath(destinationFile.getAbsolutePath()).build());
	}
	
	//Pass step with screenshot
	public synchronized static void passWithScreenshot(String TC_ID) throws IOException
	{
		saveScreenshot(TC_ID);
		test = testCaseMap.get(TC_ID);
		test.pass(MediaEntityBuilder.createScreenCaptureFromPath(destinationFile.getAbsolutePath()).build());
	}
	
	//Pass step with screenshot and a log message
	public synchronized static void passWithScreenshot(String TC_ID, String logMessage) throws IOException
	{
		saveScreenshot(TC_ID, logMessage);
		test = testCaseMap.get(TC_ID);
		test.pass(logMessage,MediaEntityBuilder.createScreenCaptureFromPath(destinationFile.getAbsolutePath()).build());
	}
	
	//Pass step with log message
	public synchronized static void pass(String TC_ID, String logMessage) throws IOException
	{
		test = testCaseMap.get(TC_ID);
		test.pass(logMessage);
	}

	//Fail step with screenshot
	public synchronized static void failWithScreenshot(String TC_ID) throws IOException
	{
		test = testCaseMap.get(TC_ID);
		saveScreenshot(TC_ID);
		test.fail(MediaEntityBuilder.createScreenCaptureFromPath(destinationFile.getAbsolutePath()).build());
	}
	
	//Fail step with screenshot and log message
	public synchronized static void failWithScreenshot(String TC_ID, String logMessage) throws IOException 
	{
		test = testCaseMap.get(TC_ID);
		saveScreenshot(TC_ID, logMessage);
		test.fail(logMessage,MediaEntityBuilder.createScreenCaptureFromPath(destinationFile.getAbsolutePath()).build());
	}
	
	//Fail step with log message
	public synchronized static void fail(String TC_ID, String logMessage) throws IOException
	{
		test = testCaseMap.get(TC_ID);
		test.fail(logMessage);
	}
	
	
	//Common method to take screenshot and save in local with log message
	public synchronized static void saveScreenshot(String TC_ID, String logMessage) throws IOException
	{
		WebDriver driver = driverMap.get(TC_ID);
		TakesScreenshot screenshot = ((TakesScreenshot)driver);
		sourceFile=screenshot.getScreenshotAs(OutputType.FILE);
		destinationFile = new File("Test Results//Snapshots//"+logMessage+"_"+getDateTime()+".png");
		FileUtils.copyFile(sourceFile, destinationFile);
		driver = null;
	}
	
	//Common method to take screenshot and save in local
	public synchronized static void saveScreenshot(String TC_ID) throws IOException
	{
		WebDriver driver = driverMap.get(TC_ID);
		TakesScreenshot screenshot = ((TakesScreenshot)driver);
		
		sourceFile=screenshot.getScreenshotAs(OutputType.FILE);
		destinationFile = new File("Test Results//Snapshots//"+getDateTime()+".png");
		FileUtils.copyFile(sourceFile, destinationFile);
		driver = null;
	}
	
	//Returns Datetime in the format dd-MM-yyyy hh-mm-ss
	public static String getDateTime()
	{
		Calendar calendar = Calendar.getInstance();
		Format format = new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
		String datetime = format.format(new Date(calendar.getTimeInMillis()));
		return datetime; 
	}

}
