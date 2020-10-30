package com.gSTAX.Tests;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.gSTAX.Setup.InitialSetup;
import com.gSTAX.Setup.InitialSetup.*;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.gSTAX.TestData.Excel_Data;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Hello world!
 *
 */
public class Facebook extends InitialSetup 
{
	
	
	@Test       
    public  void test( ) throws Throwable
    {
        System.out.println( "Hello World!" );
        
        driver.get("https://facebook.com");
        Report.log(Status.PASS, "Text details");
        Report.fail(MediaEntityBuilder.createScreenCaptureFromPath("img.png").build());
        String title = driver.getTitle();
        Report.log(Status.PASS, title) ;    
        driver.quit(); 
    }
	
	@BeforeTest  
	public void beforeTest() {    
	System.out.println("before test");  
	}     
	@AfterTest  
	public void afterTest() {  
	driver.quit();  
	System.out.println("after test");  
	}   
    
    
    
    
 
}
