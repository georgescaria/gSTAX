package com.gSTAX.Functions;

import java.io.File;
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
import com.gSTAX.Setup.InitialSetup;
import com.gSTAX.Utilities.Report;

public class ReportImplementor extends Report {
	
	public static ExtentReports extent = new ExtentReports();
	public static ExtentTest test;
	public static ExtentSparkReporter spark = new ExtentSparkReporter("Test Results/TestSuite-"+getDateTime()+".html");
	public static String TC_ID, URL, Browser;
	public static WebDriver driver;
	
	public ReportImplementor(String TC_ID, WebDriver driver)
	{
		ReportImplementor.TC_ID = TC_ID;
		ReportImplementor.driver = driver;
	}
	
	public void startReporting()
	{
		extent.attachReporter(spark);
		test=extent.createTest(TC_ID);
	}
	
	public void endReporting()
	{
		extent.flush();
	}

	public static void takeScreenshot() throws Exception
	{
		TakesScreenshot screenshot =((TakesScreenshot)driver);
		File sourceFile=screenshot.getScreenshotAs(OutputType.FILE);
		File destinationFile=new File("Test Results//Snapshots//"+getDateTime()+".png");
		FileUtils.copyFile(sourceFile, destinationFile);
		test.info("", MediaEntityBuilder.createScreenCaptureFromPath(destinationFile.getAbsolutePath()).build());
	}
	
	public static void takeScreenshot(String logMessage) throws Exception
	{
		TakesScreenshot screenshot = ((TakesScreenshot)driver);
		File sourceFile=screenshot.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File("Test Results//Snapshots//"+logMessage+"_"+getDateTime()+".png");
		FileUtils.copyFile(sourceFile, destinationFile);
		
		test.pass(MediaEntityBuilder.createScreenCaptureFromPath(destinationFile.getAbsolutePath()).build());
		test.info(logMessage, MediaEntityBuilder.createScreenCaptureFromPath(destinationFile.getAbsolutePath()).build());
	}
	
	
	public static void passWithScreenshot() throws Exception
	{
		TakesScreenshot screenshot = ((TakesScreenshot)driver);
		File sourceFile=screenshot.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File("Test Results//Snapshots//"+getDateTime()+".png");
		FileUtils.copyFile(sourceFile, destinationFile);
		
		test.pass(MediaEntityBuilder.createScreenCaptureFromPath(destinationFile.getAbsolutePath()).build());
	}
	
	public static void passWithScreenshot(String logMessage) throws Exception
	{
		TakesScreenshot screenshot = ((TakesScreenshot)driver);
		File sourceFile=screenshot.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File("Test Results//Snapshots//"+logMessage+"_"+getDateTime()+".png");
		FileUtils.copyFile(sourceFile, destinationFile);
		
		test.pass(logMessage,MediaEntityBuilder.createScreenCaptureFromPath(destinationFile.getAbsolutePath()).build());
	}
	
	public static void pass(String logMessage) throws Exception
	{
		TakesScreenshot screenshot = ((TakesScreenshot)driver);
		File sourceFile=screenshot.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File("Test Results//Snapshots//"+logMessage+"_"+getDateTime()+".png");
		FileUtils.copyFile(sourceFile, destinationFile);
		
		test.pass(logMessage);
	}

	public static void failWithScreenshot() throws Exception
	{
		TakesScreenshot screenshot = ((TakesScreenshot)driver);
		File sourceFile=screenshot.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File("Test Results//Snapshots//"+getDateTime()+".png");
		FileUtils.copyFile(sourceFile, destinationFile);
		
		test.fail(MediaEntityBuilder.createScreenCaptureFromPath(destinationFile.getAbsolutePath()).build());
	}
	
	public static void failWithScreenshot(String logMessage) throws Exception
	{
		TakesScreenshot screenshot = ((TakesScreenshot)driver);
		File sourceFile=screenshot.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File("Test Results//Snapshots//"+logMessage+"_"+getDateTime()+".png");
		FileUtils.copyFile(sourceFile, destinationFile);
		
		test.fail(logMessage,MediaEntityBuilder.createScreenCaptureFromPath(destinationFile.getAbsolutePath()).build());
	}
	
	public static void fail(String logMessage) throws Exception
	{
		TakesScreenshot screenshot = ((TakesScreenshot)driver);
		File sourceFile=screenshot.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File("Test Results//Snapshots//"+logMessage+"_"+getDateTime()+".png");
		FileUtils.copyFile(sourceFile, destinationFile);
		
		test.fail(logMessage);
	}
	
	public static String getDateTime()
	{
		Calendar calendar = Calendar.getInstance();
		Format format = new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
		String datetime = format.format(new Date(calendar.getTimeInMillis()));
		return datetime; 
	}

}
