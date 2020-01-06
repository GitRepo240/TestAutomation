/**
 * 
 */
package com.qa.testlayer;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.base.CaptureFailureScreen;
import com.qa.base.TestBase;
import com.qa.pagelayer.HomePage;
import com.qa.pagelayer.LoginPage;
import com.qa.pagelayer.ReferenceData;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * @author manohar.khot
 *
 */
public class TestRndOne extends TestBase{

	public HomePage objHomePage;
	public LoginPage objLoginPage;
	public ReferenceData objReferenceData;
	Boolean strMenuResult;
	ExtentTest extTestCommon;
	ExtentTest extTestReferenceDatamenu;
	ExtentTest extReferenceData ;
	
   
	
	@BeforeClass
	public void selectBrowserAndURL() throws InterruptedException {
		
		extTestReferenceDatamenu = TestBase.extReport.startTest("ReferenceDataMenu");
		//extTestCommon = TestBase.extReport.startTest("OpenBrowser");
		//extTestReferenceDatamenu.appendChild(extTestCommon);
		
		////TestBase.OpenWindow();
		////objLoginPage = new LoginPage();
		
	}

	
	
	@Test(priority = 1)
	public void LoginToApplication() throws InterruptedException {
		
		// Or retrieve username & pwd using prop file.
		extTestCommon = TestBase.extReport.startTest("LoginToApplication1");
		extTestReferenceDatamenu.appendChild(extTestCommon);
		
		////objLoginPage.LoginToSite(TestBase.ObjProp.getProperty("username"), TestBase.ObjProp.getProperty("password"));
		////objHomePage = new HomePage();
		extTestCommon.log(LogStatus.PASS, "Logged in successfully & Home page loaded");
		 extReferenceData = TestBase.extReport.startTest("Reference Data1");	
	}
	
	
	
	@Test(priority = 2,enabled=false)
	public void VerifyReferenceData() throws InterruptedException {

		objHomePage.GotoReferenceData();
		
		objReferenceData = new ReferenceData();
		extReferenceData.log(LogStatus.PASS, "Reference Data page is loaded");
		
	}
	@Test(priority = 3,enabled=false)
	public void VerifyAQL() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("AQL List");
		extReferenceData.appendChild(extTestCommon);
		//extTestReferenceDatamenu.appendChild(extReferenceData);
		//jqgh_tbAQLList_AQLLevelCode , ui-jqgrid-sortable
		
		//miscell, attentiondegree, inspection criteria
		objReferenceData.GotoAQLList();
		extTestCommon.log(LogStatus.PASS, "AQL page loaded");
	}
	
	@Test(priority = 4,enabled=false)
	public void VerifyArea() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("Area");
		extReferenceData.appendChild(extTestCommon);
		objReferenceData.GotoAreaList();
		//extTestCommon.log(LogStatus.PASS, "Area page loaded");
	}
	
	@Test(priority = 103)
	public void VerifyConfirmScheduling() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("ConfirmScheduling");
		extReferenceData.appendChild(extTestCommon);
		//extTestScheduling.appendChild(extTestCommon);
		////objHomePage.GotoConfirmScheduling();
	}
	
	
	@AfterMethod
	public void teardown(ITestResult result,ITestContext itr) {
		
		//System.out.println("Result: " + result.getName() + " >> " +  result.getStatus());
		
		if (result.getStatus() == ITestResult.SUCCESS) {
			extTestCommon.log(LogStatus.PASS, result.getName(), "Test " + result.getName() + " is passed");
			
		}
		else if (result.getStatus() == ITestResult.FAILURE) {
			String strScreenpath = "";
			//String strScreenpath = CaptureFailureScreen.CaptureScreenShot(TestBase.ObjWebDriver, result.getName());
			extTestCommon.log(LogStatus.FAIL, "Test "+ result.getName() +" is failed", strScreenpath +" >> "+ result.getThrowable().getMessage() );
		}
		else if (result.getStatus() == ITestResult.SKIP) {
			extTestCommon.log(LogStatus.PASS, result.getName(), "Test " + result.getName() + " is skipped");
			
		}
	}
	
	@AfterClass
	public void endSession() {
		TestBase.extReport.endTest(extReferenceData);
		TestBase.extReport.endTest(extTestCommon);
		
		TestBase.extReport.endTest(extTestReferenceDatamenu);
		
		TestBase.CloseWindow();
	}
	
	
}
