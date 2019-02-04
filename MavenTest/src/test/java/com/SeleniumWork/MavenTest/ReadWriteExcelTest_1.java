package com.SeleniumWork.MavenTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadWriteExcelTest_1 {
	
	@Test
	public void ReadExcel() throws IOException,FileNotFoundException
	{
		int rowNumber1=0, rowNumber2=0;
		int columnNumber1 = 0, columnNumber2=0;
		int totalRows = 0, 	totalColumns = 0;
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\TestData\\TestData.xlsx"); //Open the connection to the file
		XSSFWorkbook workbook = new XSSFWorkbook(fis); //Workbook
		int sheetCount = workbook.getNumberOfSheets(); //get number of sheets
		
		XSSFSheet sheet;
		
		b:
		for(int i=0;i<sheetCount;i++)
		{
			sheet = workbook.getSheetAt(i); //sheet
			if(sheet.getSheetName().equalsIgnoreCase("LoginDetails")) //Go into the sheet viz. 'LoginDetails'
			{
			
				
				Iterator<Row> rows = sheet.iterator(); //To Iterate all the rows in sheet	
				
				/****** Get total # of Rows and Columns in Excel *******/
				while(rows.hasNext()) //loop it till last row 
				{
					Row nextRow = rows.next();
					totalRows = totalRows + 1;
					if(totalRows ==1)
					{
						Iterator<Cell> cells = nextRow.cellIterator(); 
						while(cells.hasNext())
						{
							cells.next();
							totalColumns = totalColumns + 1;
						}
					}
				}
				/*******************************************************/
				Iterator<Row> rows1 = sheet.iterator(); //To Iterate all the rows in sheet	
				while(rows1.hasNext())
				{
					Row row = rows1.next();
					
					Iterator<Cell> cells = row.cellIterator();
					Cell cell = null;
					while(cells.hasNext())
					{
						cell = cells.next();
						
						if(cell.getStringCellValue().equalsIgnoreCase("TestCases"))
						{
							rowNumber1 = cell.getRowIndex();
							columnNumber1 = cell.getColumnIndex();
							
							for(int j=(columnNumber1); j<totalColumns; j++)
							{
								if(sheet.getRow(rowNumber1).getCell(j).getStringCellValue().equalsIgnoreCase("Data1"))
								{
									columnNumber2 = j;
									
								}
							}
						}
					}
					
					a:
					for(int k=rowNumber1;k < totalRows;k++)
					{
						if(cell.getRow().getCell(columnNumber1).getStringCellValue().equalsIgnoreCase("MobileLogin"))
						{
							rowNumber2 = cell.getRowIndex();
							System.out.println(sheet.getRow(rowNumber2).getCell(columnNumber2).getStringCellValue());
							break a;
						}
					}			

				}

			}
			break b;
		}

	}

}
