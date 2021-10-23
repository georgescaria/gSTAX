package com.gSTAX.Utilities;

import java.io.IOException;

import com.gSTAX.Functions.ReportImplementor;

public abstract class Report{

	//Log event - INFO only
	public static void logEvent(String TC_ID, String logMessage)
	{
		ReportImplementor.logEvent(TC_ID, logMessage);
	}
	//Take screenshot-INFO only
	public static void takeScreenshot(String TC_ID) throws IOException {
		ReportImplementor.takeScreenshot(TC_ID);
	}
	
	//Take screenshot and add a log message - INFO only
	public static void takeScreenshot(String TC_ID, String logMessage) throws IOException {
		ReportImplementor.takeScreenshot(TC_ID, logMessage);
	}
	
	//Pass step with log message
	public static void pass(String TC_ID, String logMessage) throws IOException {
		ReportImplementor.pass(TC_ID, logMessage);
	}
	
	//Pass step with screenshot
	public static void passWithScreenshot(String TC_ID) throws IOException {
		ReportImplementor.passWithScreenshot(TC_ID);
	}
	
	//Pass step with screenshot and a log message
	public static void passWithScreenshot(String TC_ID, String logMessage) throws IOException {
		ReportImplementor.passWithScreenshot(TC_ID, logMessage);
	}
	
	//Fail step with log message
	public static void fail(String TC_ID, String logMessage) throws IOException {
		ReportImplementor.fail(TC_ID, logMessage);
	}
	
	//Fail step with screenshot
	public static void failWithScreenshot(String TC_ID) throws IOException {
		ReportImplementor.failWithScreenshot(TC_ID);
	}
	
	//Fail step with screenshot and log message
	public static void failWithScreenshot(String TC_ID, String logMessage) throws IOException {
		ReportImplementor.failWithScreenshot(TC_ID, logMessage);
	}
	
	
}
