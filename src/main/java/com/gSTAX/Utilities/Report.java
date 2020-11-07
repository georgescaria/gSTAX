package com.gSTAX.Utilities;

import com.gSTAX.Functions.ReportImplementor;

public abstract class Report{

	
	//Take screenshot-INFO only
	public static void takeScreenshot() throws Exception {
		ReportImplementor.takeScreenshot();
	}
	
	//Take screenshot and add a log message - INFO only
	public static void takeScreenshot(String logMessage) throws Exception {
		ReportImplementor.takeScreenshot(logMessage);
	}
	
	//Pass step with log message
	public static void pass(String logMessage) throws Exception {
		ReportImplementor.pass(logMessage);
	}
	
	//Pass step with screenshot
	public static void passWithScreenshot() throws Exception {
		ReportImplementor.passWithScreenshot();
	}
	
	//Pass step with screenshot and a log message
	public static void passWithScreenshot(String logMessage) throws Exception {
		ReportImplementor.passWithScreenshot(logMessage);
	}
	
	//Fail step with log message
	public static void fail(String logMessage) throws Exception {
		ReportImplementor.fail(logMessage);
	}
	
	//Fail step with screenshot
	public static void failWithScreenshot() throws Exception {
		ReportImplementor.failWithScreenshot();
	}
	
	//Fail step with screenshot and log message
	public static void failWithScreenshot(String logMessage) throws Exception {
		failWithScreenshot(logMessage);
	}
	
	
}
