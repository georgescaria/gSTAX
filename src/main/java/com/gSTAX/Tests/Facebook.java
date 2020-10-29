package com.gSTAX.Tests;

import org.testng.annotations.*;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.gSTAX.Setup.InitialSetup;
/**
 * Hello world!
 *
 */
public class Facebook extends InitialSetup 
{
		
	@Test       
    public void test() 
    {
        driver.get("https://facebook.com");
        Report.log(Status.PASS, "Text details");
        Report.fail(MediaEntityBuilder.createScreenCaptureFromPath("img.png").build());
        String title = driver.getTitle();
        Report.log(Status.PASS, title) ;    
    }

}
