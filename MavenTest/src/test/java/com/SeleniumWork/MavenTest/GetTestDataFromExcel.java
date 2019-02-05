package com.SeleniumWork.MavenTest;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.Test;

public class GetTestDataFromExcel {
	@Test
	public void getTestCaseData() throws IOException
	{
		ReadWriteExcelTest a = new ReadWriteExcelTest();
		ArrayList testData = a.getData("WebLogin");		//Get all the test data form 'WebLogin' test case

		int arraySize = testData.size();
		for(int i=0;i<arraySize;i++)
		{
			System.out.println(testData.get(i)); //Print the fetched test data
		}			
	}
}
