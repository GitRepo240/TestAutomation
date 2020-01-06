/**
 * 
 */
package com.qa.testlayer;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
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
public class TestReferenceData extends TestBase {

	public HomePage objHomePage;
	public LoginPage objLoginPage;
	public ReferenceData objReferenceData;
	Boolean strMenuResult;
	ExtentTest extTestCommon;
	ExtentTest extTestReferenceDatamenu;
	ExtentTest extReferenceData;

	@BeforeClass
	public void selectBrowserAndURL() throws InterruptedException {

		// extTestReferenceDatamenu = TestBase.extReport.startTest("ReferenceDataMenu");
		extTestCommon = TestBase.extReport.startTest("OpenBrowser");
		// extTestReferenceDatamenu.appendChild(extTestCommon);

		TestBase.OpenWindow();
		objLoginPage = new LoginPage();
		extTestCommon.log(LogStatus.PASS, "Login page loaded");

	}

	@Test(priority = 1)
	public void LoginToApplication() throws InterruptedException {

		// Or retrieve username & pwd using prop file.
		extTestCommon = TestBase.extReport.startTest("LoginToApplication");
		// extTestReferenceDatamenu.appendChild(extTestCommon);

		objLoginPage.LoginToSite(TestBase.Username, TestBase.Password);
		objHomePage = new HomePage();
		extTestCommon.log(LogStatus.PASS, "Logged in successfully & Home page loaded");

	}

	@Test(priority = 2)
	public void VerifyReferenceData() throws InterruptedException {

		extReferenceData = TestBase.extReport.startTest("Reference Data");
		objHomePage.GotoReferenceData();

		objReferenceData = new ReferenceData();
		extReferenceData.log(LogStatus.INFO, "Reference Data page is loaded");

	}

	@Test(priority = 3)
	public void VerifyAQL() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("AQL List");
		extReferenceData.appendChild(extTestCommon);
		// extTestReferenceDatamenu.appendChild(extReferenceData);

		objReferenceData.GotoAQLList();
		extTestCommon.log(LogStatus.PASS, "AQL page loaded");

	}

	@Test(priority = 4)
	public void VerifyArea() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("Area");
		extReferenceData.appendChild(extTestCommon);
		objReferenceData.GotoAreaList();
		extTestCommon.log(LogStatus.PASS, "Area page loaded");

	}

	@Test(priority = 5)
	public void VerifyBusinessLine() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("BusinessLine");
		extReferenceData.appendChild(extTestCommon);
		objReferenceData.GotoBusinessLine();
		extTestCommon.log(LogStatus.PASS, "Busines Line page loaded");
	}

	@Test(priority = 6)
	public void VerifyCalendar() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("Calendar");
		extReferenceData.appendChild(extTestCommon);
		objReferenceData.GotoCalendar();
		extTestCommon.log(LogStatus.PASS, "Holiday List page loaded");
	}

	@Test(priority = 7)
	public void VerifyChargeItem() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("ChargeItem");
		extReferenceData.appendChild(extTestCommon);
		objReferenceData.GotoChargeItemList();
		extTestCommon.log(LogStatus.PASS, "Charge Item page loaded");
	}

	@Test(priority = 8)
	public void VerifyCheckingItem() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("CheckingItem");
		extReferenceData.appendChild(extTestCommon);
		objReferenceData.GotoCheckingItem();
		extTestCommon.log(LogStatus.PASS, "Checking Item page loaded");
	}

	@Test(priority = 9)
	public void VerifyCheckingList() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("CheckingList");
		extReferenceData.appendChild(extTestCommon);
		objReferenceData.GotoCheckingList();
		extTestCommon.log(LogStatus.PASS, "CheckingList page loaded");
	}

	@Test(priority = 10)
	public void VerifyCoordinator() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("Coordinator");
		extReferenceData.appendChild(extTestCommon);
		objReferenceData.GotoCoordinator();
		extTestCommon.log(LogStatus.PASS, "CheckingList page loaded");
	}

	@Test(priority = 11)
	public void VerifyCountry() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("Country");
		extReferenceData.appendChild(extTestCommon);
		objReferenceData.GotoCountry();
		extTestCommon.log(LogStatus.PASS, "Country page loaded");
	}

	@Test(priority = 12)
	public void VerifyCoustomerGroup() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("CoustomerGroup");
		extReferenceData.appendChild(extTestCommon);
		objReferenceData.GotoCoustomerGroup();
		extTestCommon.log(LogStatus.PASS, "CoustomerGroup page loaded");
	}

	@Test(priority = 13)
	public void VerifyDefect() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("Defect");
		extReferenceData.appendChild(extTestCommon);
		objReferenceData.GotoDefect();
		extTestCommon.log(LogStatus.PASS, "Defect page loaded");
	}

	@Test(priority = 14)
	public void VerifyDictionary() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("Dictionary");
		extReferenceData.appendChild(extTestCommon);
		objReferenceData.GotoDictionary();
		extTestCommon.log(LogStatus.PASS, "Dictionary page loaded");
	}

	@Test(priority = 15)
	public void VerifyExpenseList() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("ExpenseList");
		extReferenceData.appendChild(extTestCommon);
		objReferenceData.GotoExpenseList();
		extTestCommon.log(LogStatus.PASS, "ExpenseList page loaded");
	}

	@Test(priority = 16)
	public void VerifyFormulaList() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("FormulaList");
		extReferenceData.appendChild(extTestCommon);
		objReferenceData.GotoFormulaList();
		extTestCommon.log(LogStatus.PASS, "FormulaList page loaded");
	}

	@Test(priority = 17)
	public void VerifyGeneralInspectionCriteria() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("GeneralInspectionCriteria");
		extReferenceData.appendChild(extTestCommon);
		objReferenceData.GotoGeneralInspectionCriteria();
		extTestCommon.log(LogStatus.PASS, "GeneralInspectionCriteria page loaded");
	}

	@Test(priority = 18)
	public void VerifyGradeErrorCategory() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("GradeErrorCategory");
		extReferenceData.appendChild(extTestCommon);
		objReferenceData.GotoGradeErrorCategory();
		extTestCommon.log(LogStatus.PASS, "GradeErrorCategory page loaded");
	}

	@Test(priority = 19)
	public void VerifyGradeErrorDescription() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("GradeErrorDescription");
		extReferenceData.appendChild(extTestCommon);
		objReferenceData.GotoGradeErrorDescription();
		extTestCommon.log(LogStatus.PASS, "GradeErrorDescription page loaded");
	}

	@Test(priority = 20)
	public void VerifyInspectionLevelList() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("InspectionLevelList");
		extReferenceData.appendChild(extTestCommon);
		objReferenceData.GotoInspectionLevelList();
		extTestCommon.log(LogStatus.PASS, "InspectionLevelList page loaded");
	}

	@Test(priority = 21)
	public void VerifyInspectorList() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("InspectorList");
		extReferenceData.appendChild(extTestCommon);
		objReferenceData.GotoInspectorList();
		extTestCommon.log(LogStatus.PASS, "InspectorList page loaded");
	}

	@Test(priority = 22)
	public void VerifyKeyword() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("Keyword");
		extReferenceData.appendChild(extTestCommon);
		objReferenceData.GotoKeyword();
		extTestCommon.log(LogStatus.PASS, "Keyword page loaded");
	}

	@Test(priority = 23)
	public void VerifyLegalEntity() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("LegalEntity");
		extReferenceData.appendChild(extTestCommon);
		objReferenceData.GotoLegalEntity();
		extTestCommon.log(LogStatus.PASS, "LegalEntity page loaded");
	}

	@Test(priority = 24)
	public void VerifyMailTemplate() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("MailTemplate");
		extReferenceData.appendChild(extTestCommon);
		objReferenceData.GotoMailTemplate();
		extTestCommon.log(LogStatus.PASS, "MailTemplate page loaded");
	}

	@Test(priority = 25)
	public void VerifyMDRate() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("MDRate");
		extReferenceData.appendChild(extTestCommon);
		objReferenceData.GotoMDRate();
		extTestCommon.log(LogStatus.PASS, "MDRate page loaded");
	}

	@Test(priority = 26)
	public void VerifyMiscellaneousTime() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("MiscellaneousTime");
		extReferenceData.appendChild(extTestCommon);
		objReferenceData.GotoMiscellaneousTime();
		extTestCommon.log(LogStatus.PASS, "MiscellaneousTime page loaded");
	}

	@Test(priority = 27)
	public void VerifyMultipleLanguage() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("MultipleLanguage");
		extReferenceData.appendChild(extTestCommon);
		objReferenceData.GotoMultipleLanguage();
		extTestCommon.log(LogStatus.PASS, "MultipleLanguage page loaded");
	}

	@Test(priority = 28)
	public void VerifyProduct() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("Product");
		extReferenceData.appendChild(extTestCommon);
		objReferenceData.GotoProduct();
		extTestCommon.log(LogStatus.PASS, "Product page loaded");
	}

	@Test(priority = 29)
	public void VerifyProductCategory() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("ProductCategory");
		extReferenceData.appendChild(extTestCommon);
		objReferenceData.GotoProductCategory();
		extTestCommon.log(LogStatus.PASS, "ProductCategory page loaded");
	}

	@Test(priority = 30)
	public void VerifyProductType() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("ProductType");
		extReferenceData.appendChild(extTestCommon);
		objReferenceData.GotoProductType();
		extTestCommon.log(LogStatus.PASS, "ProductType page loaded");
	}

	@Test(priority = 31)
	public void VerifyAttentionDegree() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("AttentionDegree");
		extReferenceData.appendChild(extTestCommon);
		objReferenceData.GotoAttentionDegree();
		extTestCommon.log(LogStatus.PASS, "AttentionDegree page loaded");
	}

	@Test(priority = 32)
	public void VerifyRegionList() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("RegionList");
		extReferenceData.appendChild(extTestCommon);
		objReferenceData.GotoRegionList();
		extTestCommon.log(LogStatus.PASS, "RegionList page loaded");
	}

	@Test(priority = 33)
	public void VerifyReportSection() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("ReportSection");
		extReferenceData.appendChild(extTestCommon);
		objReferenceData.GotoReportSection();
		extTestCommon.log(LogStatus.PASS, "ReportSection page loaded");
	}

	@Test(priority = 34)
	public void VerifyServiceType() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("ServiceType");
		extReferenceData.appendChild(extTestCommon);
		objReferenceData.GotoServiceType();
		extTestCommon.log(LogStatus.PASS, "ServiceType page loaded");
	}

	@Test(priority = 35)
	public void VerifySpecialAttentionList() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("SpecialAttentionList");
		extReferenceData.appendChild(extTestCommon);
		objReferenceData.GotoSpecialAttentionList();
		extTestCommon.log(LogStatus.PASS, "SpecialAttentionList page loaded");
	}

	@Test(priority = 36)
	public void VerifySpecialQuotationList() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("SpecialQuotationList");
		extReferenceData.appendChild(extTestCommon);
		objReferenceData.GotoSpecialQuotationList();
		extTestCommon.log(LogStatus.PASS, "SpecialQuotationList page loaded");
	}

	@Test(priority = 37)
	public void VerifySubAreaList() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("RegionList");
		extReferenceData.appendChild(extTestCommon);
		objReferenceData.GotoSubAreaList();
		extTestCommon.log(LogStatus.PASS, "SubAreaList page loaded");
	}

	@Test(priority = 38)
	public void VerifyReportTemplate() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("ReportTemplate");
		extReferenceData.appendChild(extTestCommon);
		objReferenceData.GotoReportTemplate();
		extTestCommon.log(LogStatus.PASS, "ReportTemplate page loaded");
	}

	@Test(priority = 39)
	public void VerifyTermsAndConditions() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("TermsAndConditions");
		extReferenceData.appendChild(extTestCommon);
		objReferenceData.GotoTermsAndConditions();
		extTestCommon.log(LogStatus.PASS, "TermsAndConditions page loaded");
	}

	@Test(priority = 40)
	public void VerifyUnitList() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("UnitList");
		extReferenceData.appendChild(extTestCommon);
		objReferenceData.GotoUnitList();
		extTestCommon.log(LogStatus.PASS, "UnitList page loaded");
	}

	@Test(priority = 41)
	public void VerifyUserAcceptedTerms() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("UserAcceptedTerms");
		extReferenceData.appendChild(extTestCommon);
		objReferenceData.GotoUserAcceptedTerms();
		extTestCommon.log(LogStatus.PASS, "UserAcceptedTerms page loaded");
	}

	@Test(priority = 42)
	public void VerifyWorkingStage() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("WorkingStage");
		extReferenceData.appendChild(extTestCommon);
		objReferenceData.GotoWorkingStage();
		extTestCommon.log(LogStatus.PASS, "WorkingStage page loaded");
	}
	@Test(priority = 43)
	public void VerifyPhotoAttachmentDescription() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("PhotoAttachmentDescription");
		extReferenceData.appendChild(extTestCommon);
		objReferenceData.GotoPhotoAttachmentDescription();
		extTestCommon.log(LogStatus.PASS, "PhotoAttachmentDescription page loaded");
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
		 TestBase.extReport.endTest(extReferenceData);
		// TestBase.extReport.endTest(extTestReferenceDatamenu);

		TestBase.CloseWindow();
	}

}
