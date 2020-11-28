package com.gSTAX.Setup;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.testng.ITestNGListener;
import org.testng.TestNG;
import org.testng.annotations.Test;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import com.gSTAX.TestData.ExcelData;

public class CreateXML {

	static int rowCount, executeCol, classNameCol;
	static String className;
	static TestNG myTestNG = new TestNG();
	
	@Test
	public void runTestNGTest() throws IOException
	 {   
		    
		 XmlSuite mySuite = new XmlSuite(); 
		 mySuite.setName("Suite");
		 
		 
		 //mySuite.setParallel(XmlSuite.ParallelMode.TESTS);
	
	     List<XmlTest> myTests = new ArrayList<XmlTest>(); 
	     List<XmlSuite> mySuites = new ArrayList<XmlSuite>();
	     List<Class<? extends ITestNGListener>> listenerClasses = new ArrayList<Class<? extends ITestNGListener>>();
		 
	     ExcelData excel= new ExcelData();
	     rowCount = ExcelData.getNumberofRecords();
	     executeCol = ExcelData.getColumnIndex("Execute");
	     classNameCol = ExcelData.getColumnIndex("Class Name");
	     
	     for(int i=1; i<rowCount; i++)
	     {
	    	 if(ExcelData.getData(i, "Execute").equals("Y"))
	    	 {
	    		 XmlTest myTest = new XmlTest(mySuite);
	    		 List<XmlClass> myClasses = new ArrayList<XmlClass>();
	    		 Map<String, String> testClassParameters = new HashMap<String,String>();
	    		 
	    	     testClassParameters.put("TC_ID", ExcelData.getData(i, "TC_ID"));
	    	     testClassParameters.put("URL", ExcelData.getData(i, "URL"));
	    	     testClassParameters.put("Browser", ExcelData.getData(i, "Browser"));
	    		 
	    		 className = ExcelData.getData(i, "Class Name");
	    		 myTest.setName(ExcelData.getData(i, "TC_ID"));
	    		 myClasses.add(new XmlClass("com.gSTAX.Setup.InitialSetup"));
	    		 myClasses.add(new XmlClass("com.gSTAX.Tests."+className));
	    		 myTest.setParameters(testClassParameters);
	    	     myTest.setXmlClasses(myClasses);  
	    	     myTests.add(myTest);
	    	   
	    	 }
	     }
	     
	     listenerClasses.add(TestListener.class);
	     mySuite.setTests(myTests); 
	     mySuites.add(mySuite);   
	     myTestNG.setXmlSuites(mySuites);
	     mySuite.setFileName("testng.xml"); 
	     myTestNG.setListenerClasses(listenerClasses);
	     //mySuite.setThreadCount(15);
	     myTestNG.run();
	     
	     
	     for(XmlSuite suite : mySuites) 
	     {  
	         createXmlFile(suite); 
	     }   
	     System.out.println("File generated successfully.");
	     
	  
	    }

	    //Create temporary XML file
	    public void createXmlFile(XmlSuite mSuite) 
	    { 
	       FileWriter writer; 
	       try { 
	            writer = new FileWriter(new File("temp.xml")); 
	            writer.write(mSuite.toXml()); 
	            writer.flush(); 
	            writer.close(); 
	            System.out.println(new File("temp.xml").getAbsolutePath());
	           } catch (IOException e)
	            {
	              e.printStackTrace(); 
	            }
	    }
	    
}

