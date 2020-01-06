/**
 * 
 */



/**
 * 
 */
package com.qa.testlayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
 * @author manohar.khot
 *
 */
public class TestRndThree extends TestBase{

	
	public HomePage objHomePage;
	public LoginPage objLoginPage;
	public ReferenceData objReferenceData;
	public ManageCheckingItem objManageCheckingItem;
	public ManageAppVersion objManageAppVersion;
	
	Boolean strMenuResult;
	ExtentTest extTestCommon;
	ExtentTest extTestReferenceDatamenu;
	ExtentTest extReferenceData;
	
	
	@BeforeClass
	public void SelectBrowser() throws InterruptedException {
		
		System.out.println("Loaded");
	}
	
	@Test(priority = 1,enabled=true)
	public void LoginToApplication() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("LoginToApplication");
		TestBase.OpenWindow();
		objLoginPage = new LoginPage();
		objLoginPage.LoginToSite(TestBase.Username, TestBase.Password);
		objHomePage = new HomePage();
		
		
	}
	
	
	@Test(priority = 2,enabled=true)
	public void LoadReferenceData() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("Reference Data");
		objHomePage.GotoReferenceData();
		objReferenceData = new ReferenceData();
		extTestCommon.log(LogStatus.INFO, "Reference Data page is loaded");
		
		
	}
	
	
	@Test(priority = 3,enabled=false)
	public void LoadManageCheckingItem() throws InterruptedException {
		
		extTestCommon = TestBase.extReport.startTest("CheckingItem");
		objReferenceData.GotoCheckingItem();
		
		
		
		/*for(int i=0;i<=5;i++)
		{
			String ItemCode = TestBase.ObjWebDriver.findElement(By.xpath("//td[@aria-describedby='tbList_CheckingItemCode'][@title='ITSSPM00023']")).getText();
			System.out.println("ItemCode>>" + ItemCode);
			if(ItemCode.equalsIgnoreCase("ITSSPM00023"))
			{
				System.out.println("match code>>" + ItemCode);
				//TestBase.ObjWebDriver.findElement(By.xpath("//input[@type='checkbox'][@id='jqg_tbList_0']")).click();
				////a[contains(text(),'9646 part 2 edit11188')]/parent::td[@role='gridcell']/preceding-sibling::td[@role='gridcell']/input[@id='jqg_tbList_0']
				//TestBase.ObjWebDriver.findElement(By.xpath("td[contains(text(),'ITSSPM00023')]/preceding-sibling::td[@role='gridcell']/input[@id='jqg_tbList_0']")).click();
				
			}
		} */
		
	}
	
	
	@Test(priority = 3,enabled=false)
	public void GotoCreateCheckingItemScreen() throws InterruptedException {
		
		extTestCommon = TestBase.extReport.startTest("CreateCheckingItem");
		objManageCheckingItem = new ManageCheckingItem();
		
		//objManageCheckingItem.GotoCheckingItemScreen();
		
		
		//System error
		//login overtime 
		
	}
	@Test(priority = 4,enabled=false)
	public void CreateCheckingItem() throws InterruptedException {
		
		///objManageCheckingItem.CreateCheckingItemInReferenceData();
		//objHomePage.GotoBookingList();
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
			if(result.getName().equalsIgnoreCase("LoginToApplication"))
			{
				endSession();
			}
		}
		else if (result.getStatus() == ITestResult.SKIP) {
			extTestCommon.log(LogStatus.PASS, result.getName(), "Test " + result.getName() + " is skipped");
			
		}
	}

	
	
	@AfterClass
	public void endSession() {
		
		//TestBase.extReport.endTest(extTestCommon);
		//TestBase.extReport.endTest(extReferenceData);
		TestBase.CloseWindow();
	}
	
}
