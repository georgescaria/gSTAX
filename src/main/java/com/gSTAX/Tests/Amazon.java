package com.gSTAX.Tests;

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
public class Amazon 
{
	
	public static WebDriver driver;
    
    
	
	@Test       
    public  void test( ) throws Exception
    {
        System.out.println( "Hello World!" );
        int rowCount=Excel_Data.getNumberofRecords();
        System.out.println(rowCount);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://amazon.in");
        String title = driver.getTitle();
        System.out.println(title);      
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
