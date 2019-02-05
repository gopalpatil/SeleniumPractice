package com.SeleniumWork.MavenTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadWriteExcelTest {
	
	
	public ArrayList<String> getData(String testCaseName) throws IOException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\TestData\\TestData.xlsx");		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);		
		XSSFSheet sheet = workbook.getSheet("LoginDetails"); //EnterSheet Name		
		Iterator<Row> rows = sheet.iterator(); //to iterate all the rows		
		Iterator<Cell> cells;  //to iterate all the cells
		
		int totalRows = 0;
		int totalColumn = 0;
		int columnNumber1 = 0;
		int rowNumber1 = 0;
		
		ArrayList<String> testData = new ArrayList<String>(); //to save fetched data in ArrayList
		
		/*** Get Total Row count and Column count ****/
		while(rows.hasNext())
		{
			Row row = rows.next();
			totalRows = totalRows + 1;
			cells = row.iterator();
			if(totalRows==1)
			{
				while(cells.hasNext())
				{
					cells.next();
					totalColumn = totalColumn + 1;
				}
			}
		}
		/***************************************/
		
		boolean flag = false;
		break_a:
		for(int i=0;i<totalRows;i++) //traverse all the rows
		{
			if(!flag)
			{
				break_b:
				for(int j=0;j<totalColumn;j++) //get the column# having header 'TestCases'
				{
					if(sheet.getRow(i).getCell(j).getStringCellValue().equalsIgnoreCase("TestCases"))
					{
						columnNumber1 = j;
						flag = true;
						break break_b;
					}
				}
			}
			if(flag) //once get the column#, get the row# for desired Test Case
			{
				if(sheet.getRow(i).getCell(columnNumber1).getStringCellValue().equalsIgnoreCase(testCaseName))
				{
					rowNumber1 = i;
					break break_a;
				}				
			}
		}
		
		/**** now u have column# & row#. Get all the test data from the row **/
		for(int i=columnNumber1+1;i<totalColumn;i++)
		{
			testData.add(sheet.getRow(rowNumber1).getCell(i).getStringCellValue());
		}
		return testData;
	}
}
