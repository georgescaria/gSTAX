package com.gSTAX.Functions;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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
	public static String TC_ID, URL, Browser;
	public static WebDriver driver;
	public static File sourceFile, destinationFile;
	
	//Sets TC_ID and driver
	public ReportImplementor(String TC_ID, WebDriver driver)
	{
		ReportImplementor.TC_ID = TC_ID;
		ReportImplementor.driver = driver;
	}
	
	//Start Extent Reporting
	public void startReporting()
	{
		extent.attachReporter(spark);
		test=extent.createTest(TC_ID);
	}
	
	//Ends Extent Reporting
	public void endReporting()
	{
		extent.flush();
	}
	
	//Log event
	public static void logEvent(String logMessage) throws Exception
	{
		test.info(logMessage);
	}
		
	//Take screenshot-INFO only
	public static void takeScreenshot() throws Exception
	{
		saveScreenshot();
		test.info("", MediaEntityBuilder.createScreenCaptureFromPath(destinationFile.getAbsolutePath()).build());
	}
	
	//Take screenshot and add a log message - INFO only
	public static void takeScreenshot(String logMessage) throws Exception
	{
		saveScreenshot(logMessage);
		test.info(logMessage, MediaEntityBuilder.createScreenCaptureFromPath(destinationFile.getAbsolutePath()).build());
	}
	
	//Pass step with screenshot
	public static void passWithScreenshot() throws Exception
	{
		saveScreenshot();
		test.pass(MediaEntityBuilder.createScreenCaptureFromPath(destinationFile.getAbsolutePath()).build());
	}
	
	//Pass step with screenshot and a log message
	public static void passWithScreenshot(String logMessage) throws Exception
	{
		saveScreenshot(logMessage);
		test.pass(logMessage,MediaEntityBuilder.createScreenCaptureFromPath(destinationFile.getAbsolutePath()).build());
	}
	
	//Pass step with log message
	public static void pass(String logMessage) throws Exception
	{
		test.pass(logMessage);
	}

	//Fail step with screenshot
	public static void failWithScreenshot() throws Exception
	{
		saveScreenshot();
		test.fail(MediaEntityBuilder.createScreenCaptureFromPath(destinationFile.getAbsolutePath()).build());
	}
	
	//Fail step with screenshot and log message
	public static void failWithScreenshot(String logMessage) throws Exception
	{
		saveScreenshot(logMessage);
		test.fail(logMessage,MediaEntityBuilder.createScreenCaptureFromPath(destinationFile.getAbsolutePath()).build());
	}
	
	//Fail step with log message
	public static void fail(String logMessage) throws Exception
	{
		test.fail(logMessage);
	}
	
	
	//Common method to take screenshot and save in local with log message
	public static void saveScreenshot(String logMessage) throws IOException
	{
		TakesScreenshot screenshot = ((TakesScreenshot)driver);
		sourceFile=screenshot.getScreenshotAs(OutputType.FILE);
		destinationFile = new File("Test Results//Snapshots//"+logMessage+"_"+getDateTime()+".png");
		FileUtils.copyFile(sourceFile, destinationFile);
	}
	
	//Common method to take screenshot and save in local
	public static void saveScreenshot() throws IOException
	{
		TakesScreenshot screenshot = ((TakesScreenshot)driver);
		sourceFile=screenshot.getScreenshotAs(OutputType.FILE);
		destinationFile = new File("Test Results//Snapshots//"+getDateTime()+".png");
		FileUtils.copyFile(sourceFile, destinationFile);
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
