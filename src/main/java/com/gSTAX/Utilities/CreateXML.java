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

	static int rowCount,executeCol, classNameCol;
	static String className;
	
	@Test
	public void runTestNGTest() throws IOException
	 {   
	    
		 TestNG myTestNG = new TestNG();   

		 XmlSuite mySuite = new XmlSuite(); 
		 mySuite.setName("Suite"); 
	
	     List<XmlTest> myTests = new ArrayList<XmlTest>(); 
	     List<XmlSuite> mySuites = new ArrayList<XmlSuite>();
		 
	     rowCount = Excel_Data.getNumberofRecords();
	     executeCol = Excel_Data.getColumnIndex("Execute");
	     classNameCol = Excel_Data.getColumnIndex("Class Name");
	     
	     for(int i=1; i<rowCount-1; i++)
	     {
	    	 if(Excel_Data.getData(i, "Execute").equals("Y"))
	    	 {
	    		 XmlTest myTest = new XmlTest(mySuite);
	    		 List<XmlClass> myClasses = new ArrayList<XmlClass>();
	    		 
	    		 className = Excel_Data.getData(i, "Class Name");
	    		 myTest.setName(Excel_Data.getData(i, "TC_ID"));
	    		 myClasses.add(new XmlClass("com.gSTAX.Tests."+className));
	    	     myTest.setXmlClasses(myClasses);   
	    	     myTests.add(myTest);
	    	   
	    	 }
	     }
	     
	     
	     mySuite.setTests(myTests); 
	      
	     mySuites.add(mySuite);   
	     
	     myTestNG.setXmlSuites(mySuites);
	     mySuite.setFileName("testng.xml"); 
	     
	     for(XmlSuite suite : mySuites) 
	     {  
	         createXmlFile(suite); 
	     }   
	     System.out.println("File generated successfully.");
	     myTestNG.run();

	        
	 
	  
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

