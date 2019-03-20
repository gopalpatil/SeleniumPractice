package com.TestNG;

import org.testng.annotations.Test;

public class HomeLoan {
	
	@Test(groups={"RTest"})
	public void homeLoanLoginWeb()
	{
		System.out.println("Home Loan Login --- Web");
	}
	
	@Test(groups={"RTest"})
	public void homeLoanLoginMobile()
	{
		System.out.println("Home Loan Login --- Mobile");
	}
	
	@Test
	public void homeLoanLoginAPI()
	{
		System.out.println("Home Loan Login --- API");
	}

}
