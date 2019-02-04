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
	
	@Test
	public ArrayList<String> getData(String testCaseName) throws IOException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\TestData\\TestData.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = workbook.getSheet("LoginDetails"); //EnterSheet Name
		
		Iterator<Row> rows = sheet.iterator();
		
		Iterator<Cell> cells;
		
		int totalRows = 0;
		int totalColumn = 0;
		int columnNumber1 = 0;
		int rowNumber1 = 0;
		
		ArrayList<String> testData = new ArrayList<String>();
		
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
		boolean flag = false;
		break_a:
		for(int i=0;i<totalRows;i++)
		{
			if(!flag)
			{
				break_b:
				for(int j=0;j<totalColumn;j++)
				{
					if(sheet.getRow(i).getCell(j).getStringCellValue().equalsIgnoreCase("TestCases"))
					{
						columnNumber1 = j;
						flag = true;
						break break_b;
					}
				}
			}
			if(flag)
			{
				if(sheet.getRow(i).getCell(columnNumber1).getStringCellValue().equalsIgnoreCase(testCaseName))
				{
					rowNumber1 = i;
					break break_a;
				}
				
			}
		}
		
		for(int i=columnNumber1+1;i<totalColumn;i++)
		{
			testData.add(sheet.getRow(rowNumber1).getCell(i).getStringCellValue());
		}
		return testData;
	}

}
