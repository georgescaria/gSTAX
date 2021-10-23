package com.gSTAX.Setup;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;		

public class TestListener implements ITestListener						
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
    System.out.println("Testcase failed due to\n:"+Result.getThrowable());
    }		

		
    @Override		
    public void onTestSkipped(ITestResult Result)					
    {		
    System.out.println("Testcase Skipped is :'"+Result.getName()+"' due to "+ Result.getSkipCausedBy());					
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

