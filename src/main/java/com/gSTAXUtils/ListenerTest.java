package com.gSTAXUtils;

import java.util.Set;

import org.testng.IClass;
import org.testng.ITestContext;		
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;		

public class ListenerTest implements ITestListener						
{	

	@Override		
    public void onFinish(ITestContext Result) 					
    {
		
    }		

    @Override		
    public void onStart(ITestContext Result)					
    {		
        
    }		

    @Override		
    public void onTestFailedButWithinSuccessPercentage(ITestResult Result)					
    {		
    		
    }		

  		
    @Override		
    public void onTestFailure(ITestResult Result) 					
    {		
    System.out.println("Testcase failed is :"+Result.getName());					
    }		

		
    @Override		
    public void onTestSkipped(ITestResult Result)					
    {		
    System.out.println("Testcase Skipped is :"+Result.getName());					
    }		

		
    @Override		
    public void onTestStart(ITestResult Result)					
    {	
    System.out.println(Result.getName()+" test case started");		
    
    }		

 	
    @Override		
    public void onTestSuccess(ITestResult Result)					
    {		
    System.out.println("Testcase passed is :"+Result.getName());					
    }	
    
   
}

