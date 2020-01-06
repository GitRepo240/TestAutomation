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
import com.qa.pagelayer.ManageRolePage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestManageRole extends TestBase {

	public HomePage objHomePage;
	public LoginPage objLoginPage;
	public ManageRolePage objManageRole;
	Boolean strMenuResult;
	ExtentTest extTestCommon;

	@BeforeClass
	public void selectBrowserAndURL() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("OpenBrowser");
		TestBase.OpenWindow();
		objLoginPage = new LoginPage();
		extTestCommon.log(LogStatus.PASS, "Login page loaded");

	}

	@Test(priority = 1)
	public void LoginToApplication() throws InterruptedException {

		// Or retrieve username & pwd using prop file.
		extTestCommon = TestBase.extReport.startTest("LoginToApplication");
		objLoginPage.LoginToSite(TestBase.Username, TestBase.Password);
		extTestCommon.log(LogStatus.PASS, "Logged in successfully & Home page loaded");

	}

	@Test(priority = 2)
	public void LoadManageRole() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("Load Manage Role Screen");
		objHomePage = new HomePage();
		objHomePage.GotoManageRolePage();
		objManageRole = new ManageRolePage();
		extTestCommon.log(LogStatus.PASS, "Start ManageRole Screen loaded successfully");

	}

	@Test(priority = 3)
	public void ManageNewRole() throws InterruptedException {
	
		extTestCommon = TestBase.extReport.startTest("Open New Role screen");
		objManageRole.AddNewRoleData("Test334","Test334", "Yes", "New role added Test334");
		extTestCommon.log(LogStatus.PASS, "New Role added successfully");
	}
	
	
	@Test(priority = 3)
	public void ManageExistingRole() throws InterruptedException {
	
		objManageRole.EditRoleData("Test334","Test334", "Yes", "New role added Test334");
		
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

		TestBase.extReport.endTest(extTestCommon);
		TestBase.CloseWindow();
	}
}
