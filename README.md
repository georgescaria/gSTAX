# gSTAX  [![](https://jitpack.io/v/georgescaria/gSTAX.svg)](https://jitpack.io/#georgescaria/gSTAX)

A simplified Data-driven software automation testing framework along with Library architecture implemented using Selenium and TestNG.
For reference, use the sample project - [gSTAX-Example](https://github.com/georgescaria/gSTAX-Example)

### Setting up
1. Add the following code to your pom.xml file.

```xml  
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependency>
    <groupId>com.github.georgescaria</groupId>
    <artifactId>gSTAX</artifactId>
    <version>main-SNAPSHOT</version>
</dependency>
```


2. In your project, create a package named ***com.gSTAX.Tests*** and add your test classes. 
   Extend the class ***InitialSetup*** where the driver and Test Case ID (TC_ID) is initialized. 

```java
package com.gSTAX.Tests;

import org.testng.annotations.Test;
import com.gSTAX.Setup.InitialSetup;

public class Website extends InitialSetup 
{
    @Test       
    public void WebsiteTest() throws Exception
    { //Perform actions }
}
```
    
3. In the project root folder, create a folder named Test Data. Create a new excel file ***Testdata.xls/Testdata.xlsx***. Format all the cells to 'Text'
   Structure the excel file in the below format.
   
   | TC_ID | Execute | Class Name | URL | Browser |
   | :---: |  :---:  |  :---: |:---: |:---: |
   | TC_1  | Y     | Amazon    | https://amazon.com |  Chrome  |
   | TC_2  | N     | Google    | https://google.com |  Edge    |
   
   The Test Cases that have a corresponding Execute column value ***'Y'*** will only be run.
   For the above sample Testdata, only the class Amazon will run(create class Amazon.class in your project - com.gSTAX.Tests.Amazon). The website https://amazon.com will open 	  up in Chrome browser. 
   The following browsers are supported: 
   	1. Chrome
	2. Firefox
	3. Edge
	4. Opera
   
4. Right click on the TestNG.xml file in your project and Run as RestNG Suite. And there you go!

   The test run report will be generated and saved in the folder ***Test Results*** in your project root folder.
   
   
### Reporting

To use the Reporting functions, import the below to your Test class file.
```java
import com.gSTAX.Utilities.Report;
```
The below reporting actions can be performed using the ***Report*** keyword.

1. Informational
	1. Log event
	```java 
	Report.logEvent("Log event"); 
	```
	2. Take screenshot
	```java 
	Report.takeScreenshot();
	```
	3. Take screenshot with log message
	```java 
	Report.takeScreenshot("Take screenshot with Log");
	```

2. Passing Test Case/ Test Step
	1. Pass with log message
	```java 
	Report.pass("Pass test with log");
	```
	2. Pass test with screenshot
	```java 
	Report.passWithScreenshot();
	```
	3. Pass test with screenshot and log message
	```java 
	Report.passWithScreenshot("Pass test step with screenshot and log");
	```
2. Fail Test Case/ Test Step
	1. Fail with log message
	```java 
	Report.fail("Fail test with log");
	```
	2. Fail test with screenshot
	```java 
	Report.failWithScreenshot();
	```
	3. Fail test with screenshot and log message
	```java 
	Report.failWithScreenshot("Fail test step with screenshot and log");
	```	

   
