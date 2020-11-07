# gSTAX  [![](https://jitpack.io/v/georgescaria/gSTAX.svg)](https://jitpack.io/#georgescaria/gSTAX)

A simplified Data-driven software automation testing framework along with Library architecture implemented using Selenium and TestNG.

### Setting up
1. To use this framework, add the following code to your pom.xml file.

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

For reference, use the sample project - [gSTAX-Example](https://github.com/georgescaria/gSTAX-Example)

2. In your project, create a package named ***com.gSTAX.Tests*** and add your test classes with TestNG annotation. 
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
   
   The Test Cases that have a corresponding Execute column value 'Y' will only be run.
   For the above sample Testdata, only the class Amazon will run in Chrome browser.
