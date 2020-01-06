package com.qa.testlayer;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.base.CaptureFailureScreen;
import com.qa.pagelayer.HomePage;
import com.qa.pagelayer.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestHomeNew extends TestBase {

	public HomePage objHomePage;
	public LoginPage objLoginPage;
	Boolean strMenuResult;
	ExtentTest extTestBooking; 
	ExtentTest extTestAdministration; 
	ExtentTest extTestCommon;
	ExtentTest extReferenceData;
	ExtentTest extTestHomePagemenu;

	@BeforeClass
	public void selectBrowserAndURL() throws InterruptedException {
		
		extTestHomePagemenu = TestBase.extReport.startTest("HomePageMenu");
		extTestCommon = TestBase.extReport.startTest("OpenBrowser");
		extTestHomePagemenu.appendChild(extTestCommon);

		TestBase.OpenWindow();
		objLoginPage = new LoginPage();
		Thread.sleep(3000);
		extTestCommon.log(LogStatus.PASS, "Login page loaded");

	}

	
	
	
	
	
	
	@Test(priority = 1)
	public void LoginToApplication() throws InterruptedException {
		
		// Or retrieve username & pwd using prop file.
		extTestCommon = TestBase.extReport.startTest("LoginToApplication");
		extTestHomePagemenu.appendChild(extTestCommon);
		
		objLoginPage.LoginToSite(TestBase.ObjProp.getProperty("username"), TestBase.ObjProp.getProperty("password"));
		objHomePage = new HomePage();
		extTestCommon.log(LogStatus.PASS, "Logged in successfully & Home page loaded");
	
	}

	
	@Test(priority = 2)
	public void VerifyStartBooking() throws InterruptedException {

		extTestBooking = TestBase.extReport.startTest("Booking");
		extTestBooking.log(LogStatus.INFO, "Booking Menu list started");
		extTestCommon = TestBase.extReport.startTest("Start Booking");
		extTestBooking.appendChild(extTestCommon);
		extTestHomePagemenu.appendChild(extTestBooking);
		
		objHomePage.GotoStartBooking();
		extTestCommon.log(LogStatus.PASS, "Start booking page loaded successfully");
		
	}
	
	@Test(priority = 3)
	public void VerifyBookingList() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("Booking List");
		extTestBooking.appendChild(extTestCommon);
		
		objHomePage.GotoBookingList();
		extTestCommon.log(LogStatus.PASS, "Booking List page loaded successfully");
		
	}
	
	
	@Test(priority = 5,enabled=false)
	public void VerifyManageRolePage() throws InterruptedException {

		extTestAdministration = TestBase.extReport.startTest("Administration");
		extTestCommon = TestBase.extReport.startTest("Menu ManageRole");
		extTestAdministration.appendChild(extTestCommon);
		extTestHomePagemenu.appendChild(extTestAdministration);
		
		objHomePage.GotoManageRolePage();
	}
	
	

	@Test(priority = 6,enabled=false)
	public void VerifyIntegrationLog() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("Menu Integration Log");
		extTestAdministration.appendChild(extTestCommon);
		
		 objHomePage.GotoIntegrationLog();
		

	}

	@Test(priority = 7,enabled=false)
	public void VerifyGotoSystemEventLog() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("System EventLog");
		extTestAdministration.appendChild(extTestCommon);
		
		 objHomePage.GotoSystemEventLog();
		
	}
	

	
	@AfterMethod
	public void teardown(ITestResult result,ITestContext itr) {
		
		//System.out.println("Result: " + result.getName() + " >> " +  result.getStatus());
		
		if (result.getStatus() == ITestResult.SUCCESS) {
			extTestCommon.log(LogStatus.PASS, result.getName(), "Test " + result.getName() + " is passed");
			
		}
		else if (result.getStatus() == ITestResult.FAILURE) {
			String strScreenpath = CaptureFailureScreen.CaptureScreenShot(TestBase.ObjWebDriver, result.getName());
			extTestCommon.log(LogStatus.FAIL, "Test "+ result.getName() +" is failed", strScreenpath +" >> "+ result.getThrowable().getMessage() );
		}
		else if (result.getStatus() == ITestResult.SKIP) {
			extTestCommon.log(LogStatus.PASS, result.getName(), "Test " + result.getName() + " is skipped");
			
		}
	}

	@AfterClass
	public void endSession() {
		
		TestBase.extReport.endTest(extTestCommon);
		TestBase.extReport.endTest(extTestBooking);
		TestBase.extReport.endTest(extTestAdministration);
		TestBase.extReport.endTest(extTestHomePagemenu);
		TestBase.CloseWindow();
	}

}
