package com.SeleniumWork.FraworkTest;

import org.testng.annotations.Test;

@Test(groups="MainGroup_Defaul")
public class GroupingTest {
	
	@Test(groups="Group 2",priority=2)
	public void test1()
	{
		System.out.println("This is Test 1");
	}
	
	@Test
	public void test2()
	{
		System.out.println("This is Test 2");
	}
	
	@Test (groups="Group 1")
	public void test3()
	{
		System.out.println("This is Test 3");
	}
	
	@Test
	public void test4()
	{
		System.out.println("This is Test 4");
	}
	
	@Test(priority=4,groups={"Group 3","Group 1"})
	public void test5()
	{
		System.out.println("This is Test 5");
	}
	
	@Test(groups="Group 3")
	public void test6()
	{
		System.out.println("This is Test 6");
	}
}
