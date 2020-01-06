/**
 * 
 */
package com.qa.testlayer;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
/**
 * @author manohar.khot
 *
 */
public class TestContactPage {

	
	
	@BeforeTest
	public void BeforeTest()
	{
		System.out.println("Before Test Contact ");
		
	}
	
	
	@BeforeClass
	public void BeforeClass()
	{
		System.out.println("Before class Contact ");
		
	}
	
	
	@Test(priority=1)
	public void VerifyContact()
	{
		System.out.println("Contact VerifyContact");
		
	}
	@Test(priority=2)
	public void VerifyContactNew()
	{
		System.out.println("Contact VerifyContact New");
		
	}
	
	@AfterClass
	public void AfterClass()
	{
		System.out.println("After class Contact ");
		
	}
	
	
	@AfterTest
	public void AfterTest()
	{
		System.out.println("After Test Contact ");
		
		
	}
	
	
}
