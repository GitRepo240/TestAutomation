/**
 * 
 */
package com.qa.base;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

/**
 * @author manohar.khot
 *
 */
public class TestListener extends TestListenerAdapter {

	
	@Override
	public void onTestStart(ITestResult tstResult)
	{
		System.out.println("Test Started " + tstResult.getName());
	}
	
	@Override
	public void onTestSuccess(ITestResult tstResult)
	{
		System.out.println("Test Success " + tstResult.getName() +">>"+ tstResult.SUCCESS  );
		
	}
	
	@Override
	public void onTestFailure(ITestResult tstResult)
	{
		System.out.println("Test Failure" + tstResult.getName() +">>"+ tstResult.FAILURE);
		
	}
	
	@Override
	public void onTestSkipped(ITestResult tstResult)
	{
		System.out.println("Test Skip" + tstResult.getName() +">>" + tstResult.SKIP);
		
	}
	
}
