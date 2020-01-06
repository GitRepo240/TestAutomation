/**
 * 
 */
package com.qa.testlayer;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pagelayer.HomePage;
import com.qa.pagelayer.LoginPage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * @author manohar.khot
 *
 */
public class TestLogin extends TestBase{

	
	public HomePage objGISHomePage;
	public LoginPage objGISLoginPage;
	
	ExtentTest logger;

	@BeforeTest
	public void selectBrowserAndURL() throws InterruptedException
	{
		System.out.println("start test selectBrowserAndURL");
		TestBase.OpenWindow();
		logger = TestBase.extReport.startTest("StartLoginScenario");
		objGISLoginPage  = new LoginPage();
		Thread.sleep(3000);
		logger.log(LogStatus.INFO, "Login page loaded");
		
	}
	
	
	@Test(priority=0)
	public void LoginToApplication() throws InterruptedException 
	{
		
		System.out.println("start test LoginToApplication");
		
		
		
		//Or retrieve username & pwd using prop file.
		objGISLoginPage.LoginToSite(TestBase.ObjProp.getProperty("username"), TestBase.ObjProp.getProperty("password"));
		logger.log(LogStatus.INFO, "Credentials entered");
		objGISHomePage = new HomePage();
		boolean strflag = objGISHomePage.ValidateHomePageTitle();
		logger.log(LogStatus.INFO, "Logged in successfully & Home page loaded");
		
		
	}
	
	@AfterTest
	public void endSession()
	{
		logger.log(LogStatus.INFO, "EndLoginScenario");
		TestBase.extReport.endTest(logger);
		TestBase.CloseWindow();
	}
	
	
}
