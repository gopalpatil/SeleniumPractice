package com.SeleniumWork.FraworkTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class DataBaseTest {
	
	@Test
	public void validateInDB() throws SQLException
	{
		
		Connection con = DriverManager.getConnection("jdbc:sqlserver://DRNJ-IPDBTVM01\\QA","sa","ec@pqa");
		Statement st = con.createStatement();
		String sqlStr = "select * from [Ecap_Config].[dbo].[Languages]";
		ResultSet rs = st.executeQuery(sqlStr);
		while (rs.next()) 
		{
			System.out.println(rs.getString("Description"));
		}
		rs.first();
		con.close();
		
		
	}

}
