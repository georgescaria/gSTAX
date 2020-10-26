package com.gSTAX.TestData;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Data {
	 
	
		static String filePath=System.getProperty("user.dir")+"\\src\\main\\resources\\TestData";
	    static String fileName;
	    static FileInputStream inputStream;
	    static String returnData="No data available";
	    static Cell cell;
	    static File file;
	    static Workbook workbook = null;
	    static Sheet sheet;
	    
	    Excel_Data() throws IOException
		{
		    try 
		    {
				fileName="Testdata.xls";
				file = new File(filePath + "\\" + fileName);
				inputStream = new FileInputStream(file);
			} catch (Exception e) 
		    {
				fileName="Testdata.xlsx";
				file = new File(filePath + "\\" + fileName);
				inputStream = new FileInputStream(file);
			}
		    
		    String fileExtensionName = fileName.substring(fileName.indexOf("."));
	
		    if(fileExtensionName.equals(".xlsx"))
		    	workbook = new XSSFWorkbook(inputStream);
		    else if(fileExtensionName.equals(".xls"))
		        workbook = new HSSFWorkbook(inputStream);
		    
		    sheet = workbook.getSheetAt(0);
		}
	    
	    public static int getNumberofRecords() throws IOException
	    {
	    	Excel_Data excel= new Excel_Data();
	    	//System.out.print(sheet.getLastRowNum()-sheet.getFirstRowNum());
	    	return (sheet.getPhysicalNumberOfRows());
	    	 
	    }
	    
	    public static int getColumnIndex(String column) throws IOException
	    {
	        Row row = sheet.getRow(0);
	        int i,found = 0;
	        for (i = 0; i < row.getLastCellNum(); i++) 
	        {
	        	String columnName=row.getCell(i).getStringCellValue();       
	        	if(column.equals(columnName))
	        	{
	        		found=1;
	        		break;   	
	        	}
	        }
	        if(found==1)
	        	return i;
	        else
	        	throw new Error("Column not found");
	    }
	    
	    public static String getData(String testCaseID,String column) throws IOException{
	    	 
		    int rowCount = getNumberofRecords();
	        Row row = sheet.getRow(0);
	        int i,j,found=0;
	        
	        for (i = 0; i < row.getLastCellNum(); i++) 
	        {
	        	String columnName = row.getCell(i).getStringCellValue();       
	        	if(column.equals(columnName))
	        	{
	        		found = 1;
	        		break;   	
	        	}
	        }
	
	        if(found == 1)
	        {
		        for (j = 0; j < rowCount+1; j++) 
		        {
		        	row = sheet.getRow(j);
		        	String TC_ID=row.getCell(0).getStringCellValue();       
		        	if(TC_ID.equals(testCaseID))
		        		break;   	
		        }
	        }
	        else
	        	return returnData;
	        
	        
	        cell = row.getCell(i);
	        if(!cell.getCellType().toString().equals("STRING"))
	        {
	        	System.out.println("The cells should be formatted as 'Text'");
	        	return "The cells should be formatted as 'Text'";
	        }
	        
	        return cell.getStringCellValue();
	    }  
	    
	    public static String getData(int index,String column) throws IOException{
	    	 
		    
	        Row row = sheet.getRow(0);
	        int i,j,found=0;
	        
	        for (i = 0; i < row.getLastCellNum(); i++) 
	        {
	        	String columnName=row.getCell(i).getStringCellValue();       
	        	if(column.equals(columnName))
	        	{
	        		found=1;
	        		break;   	
	        	}
	        }
	
	        if(found==1)
	        {
	        	row = sheet.getRow(index);
	        	cell=row.getCell(i);
		        if(!cell.getCellType().toString().equals("STRING"))
		        {
		        	System.out.println("The cells should be formatted as 'Text'");
		        	return "The cells should be formatted as 'Text'";
		        }
		        
		        return cell.getStringCellValue();
	        }
	        else
	        	return returnData;
	    }
}

