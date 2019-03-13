package com.SeleniumWork.FraworkTest;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import resources.Base;

public class MyClassListners implements ITestListener{	
	Base baseClassObject = new Base();	
	@Override
	public void onTestSuccess(ITestResult result) {
		try 
		{
			baseClassObject.getScreenShot(result.getName());			
		} catch (IOException e) 
		{
			e.printStackTrace();
		}	
		System.out.println("## Test Passed ## "+result.getName());
	}	
	@Override
	public void onFinish(ITestContext arg0) {		
		System.out.println("## Test Finished ## "+arg0.getName());
	}
	@Override
	public void onStart(ITestContext arg0) {
		System.out.println("## Test Started ## "+arg0.getName());		
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {		
	}
	@Override
	public void onTestFailure(ITestResult arg0) {
		System.out.println("## Test Failed ## "+arg0.getName());		
	}
	@Override
	public void onTestSkipped(ITestResult arg0) {
		System.out.println("## Test skipped ## "+arg0.getName());		
	}
	@Override
	public void onTestStart(ITestResult arg0) {
		System.out.println("## Test Cases Started ## "+arg0.getName());		
	}

}
