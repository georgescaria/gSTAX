package com.gSTAX.Setup;

public class SetupObjects {

	public static String TC_ID, url, browser;
	
	public SetupObjects(String TC_ID, String url, String browser)
	{
		this.TC_ID = TC_ID;
		this.url = url;
		this.browser = browser;
	}

	public static String getTC_ID() {
		return TC_ID;
	}

	public static void setTC_ID(String tC_ID) {
		TC_ID = tC_ID;
	}

	public static String getUrl() {
		return url;
	}

	public static void setUrl(String url) {
		SetupObjects.url = url;
	}

	public static String getBrowser() {
		return browser;
	}

	public static void setBrowser(String browser) {
		SetupObjects.browser = browser;
	}
	
	
}
