package com.gSTAX.Utilities;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.testng.TestNG;
import org.testng.annotations.Test;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import com.gSTAX.TestData.Excel_Data;

public class CreateXML {

	@Test
	public void runTestNGTest() throws IOException
	 {   
	     TestNG myTestNG = new TestNG();   

		  XmlSuite mySuite = new XmlSuite(); 
		  mySuite.setName("Suite"); 
		  //mySuite.setParallel(XmlSuite.ParallelMode.METHODS);   
		
		
		  
		 //Create an instance of XmlTest and assign a name for it.  
		 XmlTest myTest = new XmlTest(mySuite); 
		 myTest.setName("Test");   
		  
	     
	   
	     //Create a list which can contain the classes that you want to run.
	     List<XmlClass> myClasses = new ArrayList<XmlClass>();
	     myClasses.add(new XmlClass("com.gSTAX.Tests.Facebook"));   

	     //Assign that to the XmlTest Object created earlier. 
	     myTest.setXmlClasses(myClasses);   

	     //Create a list of XmlTests and add the Xmltest you created earlier to it.
	     List<XmlTest> myTests = new ArrayList<XmlTest>(); 
	     myTests.add(myTest);   

	     //add the list of tests to your Suite. 
	     mySuite.setTests(myTests);   

	     //Add the suite to the list of suites. 
	     List<XmlSuite> mySuites = new ArrayList<XmlSuite>(); 
	     mySuites.add(mySuite);   
	     
	     //Set the list of Suites to the testNG object you created earlier. 
	     myTestNG.setXmlSuites(mySuites);
	     mySuite.setFileName("testng.xml"); 
	     mySuite.setThreadCount(3);   
	     myTestNG.run();

	     //Create physical XML file based on the virtual XML content 
	     for(XmlSuite suite : mySuites) 
	     {  
	         createXmlFile(suite); 
	     }   
	     System.out.println("File generated successfully.");   
	 
	     //Print the parameter values 
	     Map<String,String> params = myTest.getAllParameters(); 
	     for(Map.Entry<String, String> entry : params.entrySet()) 
	     { 
	       System.out.println(entry.getKey() + " => " + entry.getValue()); 
	     }
	    }

	    //This method will create an Xml file based on the XmlSuite data 
	    public void createXmlFile(XmlSuite mSuite) 
	    { 
	       FileWriter writer; 
	       try { 
	            writer = new FileWriter(new File("myTemp.xml")); 
	            writer.write(mSuite.toXml()); 
	            writer.flush(); 
	            writer.close(); 
	            System.out.println(new File("myTemp.xml").getAbsolutePath());
	           } catch (IOException e)
	            {
	              e.printStackTrace(); 
	            }
	    }

}

