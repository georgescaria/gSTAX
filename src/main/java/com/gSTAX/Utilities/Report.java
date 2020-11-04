package com.gSTAX.Utilities;

import com.gSTAX.Functions.ReportImplementor;

public abstract class Report{

	
	
	public static void takeScreenshot() throws Exception {
		ReportImplementor.takeScreenshot();
	}
	
	
	public static void takeScreenshot(String logMessage) throws Exception {
		ReportImplementor.takeScreenshot(logMessage);
	}
	
	
	public static void pass(String logMessage) throws Exception {
		ReportImplementor.pass(logMessage);
	}
	
	
	public static void passWithScreenshot() throws Exception {
		ReportImplementor.passWithScreenshot();
	}
	
	
	public static void passWithScreenshot(String logMessage) throws Exception {
		ReportImplementor.passWithScreenshot(logMessage);
	}
	
	
	public static void fail(String logMessage) throws Exception {
		ReportImplementor.fail(logMessage);
	}
	
	
	public static void failWithScreenshot() throws Exception {
		ReportImplementor.failWithScreenshot();
	}
	
	
	public static void failWithScreenshot(String logMessage) throws Exception {
		failWithScreenshot(logMessage);
	}
	
	
}
