/**
 * 
 */
package com.qa.testlayer;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author manohar.khot
 *
 */
public class TestSearchPage {

	
	@BeforeTest
	public void BeforeTest()
	{
		System.out.println("Before Test Search ");
		
	}
	
	@BeforeClass
	public void BeforeClass()
	{
		System.out.println("Before class search ");
		
	}
	
	@Test(priority=1)
	public void VerifySearch()
	{
		System.out.println("Search VerifySearch");
		
	}
	
	@Test(priority=2)
	public void VerifySearchNew()
	{
		System.out.println("Search VerifySearch New");
		
	}
	
	@AfterClass
	public void AfterClass()
	{
		System.out.println("After class search ");
		
	}
	
	
	
	@AfterTest
	public void AfterTest()
	{
		System.out.println("After Test Search ");
		
		
	}
	
	
	
}
