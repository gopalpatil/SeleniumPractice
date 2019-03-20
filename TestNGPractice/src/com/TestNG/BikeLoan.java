package com.TestNG;

import org.testng.annotations.Test;

public class BikeLoan {
	
	@Test
	public void bikeLoanLogin1Web()
	{				
		System.out.println("Bike Loan Login --- Web");		
	}
	
	@Test
	public void bikeLoanLoginAPI()
	{
		System.out.println("Bike Loan Login --- API");
		int i = 5/0;
	}
	
	@Test
	public void bikeLoanLoginMobile()
	{
		System.out.println("Bike Loan Login --- Mobile");	
	}

	//@Test(dependsOnMethods = {"bikeLoanLogin1Web"})
}
