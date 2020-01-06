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

import com.qa.base.TestBase;
import com.qa.pagelayer.HomePage;
import com.qa.pagelayer.LoginPage;
import com.qa.pagelayer.ManageAppVersion;
import com.qa.pagelayer.ManageCheckingItem;
import com.qa.pagelayer.ReferenceData;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * @author Manohar.Khot
 *
 */
public class TestManageAppVersion extends TestBase {

	public HomePage objHomePage;
	public LoginPage objLoginPage;
	public ReferenceData objReferenceData;
	public ManageCheckingItem objManageCheckingItem;
	public ManageAppVersion objManageAppVersion;

	String strMajor;
	String strMinor;
	String strBuild;
	String strPatch;
	String strRemark;

	Boolean strMenuResult;
	ExtentTest extTestCommon;
	ExtentTest extTestReferenceDatamenu;
	ExtentTest extReferenceData;

	@BeforeClass
	public void SelectBrowser() throws InterruptedException {

		System.out.println("Loaded");

	}

	@Test(priority = 1, enabled = true)
	public void LoginToApplication() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("LoginToApplication");
		TestBase.OpenWindow();
		objLoginPage = new LoginPage();
		objLoginPage.LoginToSite(TestBase.Username, TestBase.Password);
		objHomePage = new HomePage();

	}

	@Test(priority = 2, enabled = true)
	public void AddNewAppVersion() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("AddNewAppVersion");
		objHomePage.GotoAppVersion();
		objManageAppVersion = new ManageAppVersion();

		strMajor = "111";
		strMinor = "222";
		strBuild = "333";
		strPatch = "444";
		strRemark = "New version added 444";
		objManageAppVersion.addAppVersion(strMajor, strMinor, strBuild, strPatch, strRemark);

	}

	@AfterMethod
	public void teardown(ITestResult result, ITestContext itr) {

		// System.out.println("Result: " + result.getName() + " >> " +
		// result.getStatus());

		if (result.getStatus() == ITestResult.SUCCESS) {
			extTestCommon.log(LogStatus.PASS, result.getName(), "Test " + result.getName() + " is passed");

		} else if (result.getStatus() == ITestResult.FAILURE) {
			String strScreenpath = "";
			// String strScreenpath =
			// CaptureFailureScreen.CaptureScreenShot(TestBase.ObjWebDriver,
			// result.getName());
			extTestCommon.log(LogStatus.FAIL, "Test " + result.getName() + " is failed",
					strScreenpath + " >> " + result.getThrowable().getMessage());
			if (result.getName().equalsIgnoreCase("LoginToApplication")) {
				endSession();
			}
		} else if (result.getStatus() == ITestResult.SKIP) {
			extTestCommon.log(LogStatus.PASS, result.getName(), "Test " + result.getName() + " is skipped");

		}
	}

	@AfterClass
	public void endSession() {

		// TestBase.extReport.endTest(extTestCommon);
		// TestBase.extReport.endTest(extReferenceData);
		TestBase.CloseWindow();
	}
}
