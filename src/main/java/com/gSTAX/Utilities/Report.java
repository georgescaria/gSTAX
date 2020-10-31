package com.gSTAX.Utilities;

import java.io.File;
import java.sql.Date;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.gSTAX.Setup.InitialSetup;


public class Report extends InitialSetup{

	public static void takeScreenshot() throws Exception
	{

		TakesScreenshot screenshot =((TakesScreenshot)driver);
		//Call getScreenshotAs method to create image file
		File sourceFile=screenshot.getScreenshotAs(OutputType.FILE);
		//Move image file to new destination
		File destinationFile=new File("Test Results//Snapshots//"+getDateTime()+".png");
		//Copy file at destination
		FileUtils.copyFile(sourceFile, destinationFile);
		test.pass(MediaEntityBuilder.createScreenCaptureFromPath(destinationFile.getAbsolutePath()).build());
		test.info("Mains Page", MediaEntityBuilder.createScreenCaptureFromPath(destinationFile.getAbsolutePath()).build());
		
		}
	


	public static String getDateTime()
	{
		Calendar calendar = Calendar.getInstance();
		Format format = new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
		String datetime = format.format(new Date(calendar.getTimeInMillis()));
		return datetime; 
	}

}
