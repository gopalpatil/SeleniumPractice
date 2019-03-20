package com.TestNG;

import org.testng.annotations.Test;

public class ACarLoan {
	
	@Test(groups={"SmokeTest"})
	public void carLoanLoginWeb()
	{
		System.out.println("Car Loan Login --- Web");
	}
	
	@Test
	public void carLoanLoginMobile()
	{
		System.out.println("Car Loan Login --- Mobile");
	}
	
	@Test
	public void carLoanLoginAPI()
	{
		System.out.println("Car Loan Login --- API");
	}

}
