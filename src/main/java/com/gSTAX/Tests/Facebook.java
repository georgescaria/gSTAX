package com.gSTAX.Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Hello world!
 *
 */
public class Facebook 
{
	
	public static WebDriver driver;
    
    
	
	@Test       
    public  void test( )
    {
        System.out.println( "Hello World!" );
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://facebook.com");
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
