package com.gSTAX.Functions;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.gSTAX.Setup.InitialSetup;
import com.gSTAX.Utilities.Report;

public class ReportImplementor extends InitialSetup implements Report {

	public void takeScreenshot() throws Exception
	{
		TakesScreenshot screenshot =((TakesScreenshot)driver);
		File sourceFile=screenshot.getScreenshotAs(OutputType.FILE);
		File destinationFile=new File("Test Results//Snapshots//"+getDateTime()+".png");
		FileUtils.copyFile(sourceFile, destinationFile);
		test.info("", MediaEntityBuilder.createScreenCaptureFromPath(destinationFile.getAbsolutePath()).build());
	}
	
	public  void takeScreenshot(String logMessage) throws Exception
	{
		TakesScreenshot screenshot = ((TakesScreenshot)driver);
		File sourceFile=screenshot.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File("Test Results//Snapshots//"+logMessage+"_"+getDateTime()+".png");
		FileUtils.copyFile(sourceFile, destinationFile);
		
		test.pass(MediaEntityBuilder.createScreenCaptureFromPath(destinationFile.getAbsolutePath()).build());
		test.info(logMessage, MediaEntityBuilder.createScreenCaptureFromPath(destinationFile.getAbsolutePath()).build());
	}
	
	
	public  void passWithScreenshot() throws Exception
	{
		TakesScreenshot screenshot = ((TakesScreenshot)driver);
		File sourceFile=screenshot.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File("Test Results//Snapshots//"+getDateTime()+".png");
		FileUtils.copyFile(sourceFile, destinationFile);
		
		test.pass(MediaEntityBuilder.createScreenCaptureFromPath(destinationFile.getAbsolutePath()).build());
	}
	
	public  void passWithScreenshot(String logMessage) throws Exception
	{
		TakesScreenshot screenshot = ((TakesScreenshot)driver);
		File sourceFile=screenshot.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File("Test Results//Snapshots//"+logMessage+"_"+getDateTime()+".png");
		FileUtils.copyFile(sourceFile, destinationFile);
		
		test.pass(logMessage,MediaEntityBuilder.createScreenCaptureFromPath(destinationFile.getAbsolutePath()).build());
	}
	
	public  void pass(String logMessage) throws Exception
	{
		TakesScreenshot screenshot = ((TakesScreenshot)driver);
		File sourceFile=screenshot.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File("Test Results//Snapshots//"+logMessage+"_"+getDateTime()+".png");
		FileUtils.copyFile(sourceFile, destinationFile);
		
		test.pass(logMessage);
	}

	public  void failWithScreenshot() throws Exception
	{
		TakesScreenshot screenshot = ((TakesScreenshot)driver);
		File sourceFile=screenshot.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File("Test Results//Snapshots//"+getDateTime()+".png");
		FileUtils.copyFile(sourceFile, destinationFile);
		
		test.fail(MediaEntityBuilder.createScreenCaptureFromPath(destinationFile.getAbsolutePath()).build());
	}
	
	public  void failWithScreenshot(String logMessage) throws Exception
	{
		TakesScreenshot screenshot = ((TakesScreenshot)driver);
		File sourceFile=screenshot.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File("Test Results//Snapshots//"+logMessage+"_"+getDateTime()+".png");
		FileUtils.copyFile(sourceFile, destinationFile);
		
		test.fail(logMessage,MediaEntityBuilder.createScreenCaptureFromPath(destinationFile.getAbsolutePath()).build());
	}
	
	public void fail(String logMessage) throws Exception
	{
		TakesScreenshot screenshot = ((TakesScreenshot)driver);
		File sourceFile=screenshot.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File("Test Results//Snapshots//"+logMessage+"_"+getDateTime()+".png");
		FileUtils.copyFile(sourceFile, destinationFile);
		
		test.fail(logMessage);
	}
	
	

}
