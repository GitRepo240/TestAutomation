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

public class TestHome extends TestBase {

	public HomePage objHomePage;
	public LoginPage objLoginPage;
	Boolean strMenuResult;
	ExtentTest extTestCommon;

	
	ExtentTest extTestBooking = TestBase.extReport.startTest("Booking");
	ExtentTest extTestInspection = TestBase.extReport.startTest("Inspection");
	ExtentTest extTestReport = TestBase.extReport.startTest("Report");
	ExtentTest extTestCertificate = TestBase.extReport.startTest("Certificate");
	ExtentTest extTestInvoice = TestBase.extReport.startTest("Invoice");
	ExtentTest extTestAnalysisReport = TestBase.extReport.startTest("AnalysisReport");
	ExtentTest extTestEquipment = TestBase.extReport.startTest("Equipment");
	ExtentTest extTestSample = TestBase.extReport.startTest("Sample");
	ExtentTest extTestClient = TestBase.extReport.startTest("Client");
	ExtentTest extTestScheduling = TestBase.extReport.startTest("Scheduling");
	ExtentTest extTestAdministration = TestBase.extReport.startTest("Administration");
	ExtentTest extTestDatalink = TestBase.extReport.startTest("Datalink");
	//ExtentTest extTestReferenceData = TestBase.extReport.startTest("ReferenceData");
	
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
		
		objHomePage = new HomePage();
		extTestCommon.log(LogStatus.PASS, "Logged in successfully & Home page loaded");
	
	}

	@Test(priority = 2)
	public void VerifyStartBooking() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("Start Booking");
		extTestBooking.appendChild(extTestCommon);
		
		objHomePage.GotoStartBooking();
		extTestCommon.log(LogStatus.PASS, "Start Booking page loaded successfully");
		
	}
	
	@Test(priority = 3)
	public void VerifyBookingList() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("Booking List");
		extTestBooking.appendChild(extTestCommon);
		
		objHomePage.GotoBookingList();
		extTestCommon.log(LogStatus.PASS, "Booking List page loaded successfully");
	}
	
	@Test(priority = 4)
	public void VerifyQuotationList() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("Quotation List");
		extTestBooking.appendChild(extTestCommon);
		
		objHomePage.GotoQuotationList();
		extTestCommon.log(LogStatus.PASS, "Quotation List page loaded successfully");
	}
		
	@Test(priority = 5)
	public void VerifyPaymentList() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("Payment List");
		extTestBooking.appendChild(extTestCommon);
		
		objHomePage.GotoPaymentList();
		extTestCommon.log(LogStatus.PASS, "Payment List page loaded successfully");
	}

	@Test(priority = 6)
	public void VerifyLateCancelRequestList() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("Late Cancel Request List");
		extTestBooking.appendChild(extTestCommon);
		
		objHomePage.GotoLateCancelRequestList();
		extTestCommon.log(LogStatus.PASS, "Late Cancel Request List page loaded successfully");
	}
	
	@Test(priority = 7)
	public void VerifyETReviewBooking() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("ET Review Booking");
		extTestBooking.appendChild(extTestCommon);
		
		objHomePage.GotoETReviewBooking();
		extTestCommon.log(LogStatus.PASS, "ET Review page loaded successfully");
	}
		
	
	@Test(priority = 8)
	public void VerifyEquipmentTobePrepared() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("Equipment to be Prepared");
		extTestBooking.appendChild(extTestCommon);
		
		objHomePage.GotoEquipmenttobePrepared();
		extTestCommon.log(LogStatus.PASS, "Equipment to be prepared screen loaded successfully");
	}
	
	@Test(priority = 9)
	public void VerifyEquipmentTobeDelivered() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("Equipment to be Delivered");
		extTestBooking.appendChild(extTestCommon);
		
		objHomePage.GotoEquipmenttobeDelivered();
		extTestCommon.log(LogStatus.PASS, "Equipment to be delivered screen loaded successfully");
	}
	
	@Test(priority = 10)
	public void VerifyRemainManPower() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("Remain Man Power");
		extTestBooking.appendChild(extTestCommon);
		
		objHomePage.GotoRemainManPower();
		extTestCommon.log(LogStatus.PASS, "Remain Man Power screen loaded successfully");
	}
	
	@Test(priority = 21)
	public void VerifyInspectionList() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("Inspection List");
		extTestInspection.appendChild(extTestCommon);
		
		objHomePage.GotoInspectionList();
		extTestCommon.log(LogStatus.PASS, "Remain Man Power screen loaded successfully");
	}
	@Test(priority = 22)
	public void VerifyAbortiveList() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("Abortive List");
		extTestInspection.appendChild(extTestCommon);
		
		objHomePage.GotoAbortiveList();
		extTestCommon.log(LogStatus.PASS, "Remain Man Power screen loaded successfully");
	}
	
	
	@Test(priority = 31)
	public void VerifyReportList() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("Report List");
		extTestReport.appendChild(extTestCommon);
		
		objHomePage.GotoReportList();
		extTestCommon.log(LogStatus.PASS, "Remain Man Power screen loaded successfully");
	}
	@Test(priority = 41)
	public void VerifyICReadyList() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("ICReadyList");
		extTestCertificate.appendChild(extTestCommon);
		
		objHomePage.GotoICReadyList();
		//extTestCommon.log(LogStatus.PASS, "Remain Man Power screen loaded successfully");
	}

	@Test(priority = 42)
	public void VerifyCertificateRequestList() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("CertificateRequestList");
		extTestCertificate.appendChild(extTestCommon);
		objHomePage.GotoCertificateRequestList();
	}
	
	@Test(priority = 43)
	public void VerifyCertificateList() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("CertificateList");
		extTestCertificate.appendChild(extTestCommon);
		objHomePage.GotoCertificateList();
	}
		
	@Test(priority = 44)
	public void VerifyShipmentReleaseNoteList() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("ShipmentReleaseNoteList");
		extTestCertificate.appendChild(extTestCommon);
		objHomePage.GotoShipmentReleaseNoteList();
	}
	@Test(priority = 45)
	public void VerifyReportReadyForIRN() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("ReportReadyForIRN");
		extTestCertificate.appendChild(extTestCommon);
		objHomePage.GotoReportReadyForIRN();
	}
	
	@Test(priority = 51)
	public void VerifyInvoiceList() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("InvoiceList");
		extTestInvoice.appendChild(extTestCommon);
		objHomePage.GotoInvoiceList();
	}
	@Test(priority = 52)
	public void VerifyCreditNoteList() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("CreditNoteList");
		extTestInvoice.appendChild(extTestCommon);
		objHomePage.GotoCreditNoteList();
	}
	@Test(priority = 53)
	public void VerifyCreditNoteRequestList() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("CreditNoteRequestList");
		extTestInvoice.appendChild(extTestCommon);
		objHomePage.GotoCreditNoteRequestList();
	}
	@Test(priority = 54)
	public void VerifyCreateInvoice() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("CreateInvoice");
		extTestInvoice.appendChild(extTestCommon);
		objHomePage.GotoCreateInvoice();
	}
	
	@Test(priority = 61)
	public void VerifyViewReport() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("ViewReport");
		extTestAnalysisReport.appendChild(extTestCommon);
		objHomePage.GotoViewReport();
	}
	
	@Test(priority = 71)
	public void VerifyEquipmentList() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("EquipmentList");
		extTestEquipment.appendChild(extTestCommon);
		objHomePage.GotoEquipmentList();
	}
	@Test(priority = 72)
	public void VerifyEquipmentTypeList() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("EquipmentTypeList");
		extTestEquipment.appendChild(extTestCommon);
		objHomePage.GotoEquipmentTypeList();
	}
	@Test(priority = 73)
	public void VerifyQueryJobLog() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("QueryJobLog");
		extTestEquipment.appendChild(extTestCommon);
		objHomePage.GotoQueryJobLog();
	}
	
	
	@Test(priority = 81)
	public void VerifyReferenceSampleList() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("ReferenceSampleList");
		extTestSample.appendChild(extTestCommon);
		objHomePage.GotoReferenceSampleList();
	}
	@Test(priority = 82)
	public void VerifyProductSampleList() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("ProductSampleList");
		extTestSample.appendChild(extTestCommon);
		objHomePage.GotoProductSampleList();
	}
	@Test(priority = 83)
	public void VerifyReferenceSampletobeDelivered() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("ReferenceSampletobeDelivered");
		extTestSample.appendChild(extTestCommon);
		objHomePage.GotoReferenceSampletobeDelivered();
	}
	
	@Test(priority = 91)
	public void VerifyClientList() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("ClientList");
		extTestClient.appendChild(extTestCommon);
		objHomePage.GotoCustomerList();
	}
	@Test(priority = 92)
	public void VerifyManageCreditLimit() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("ManageCreditLimit");
		extTestClient.appendChild(extTestCommon);
		objHomePage.GotoManageCreditLimit();
	}
	@Test(priority = 93)
	public void VerifyClientToBeVerified() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("ClientToBeVerified");
		extTestClient.appendChild(extTestCommon);
		objHomePage.GotoClientToBeVerified();
	}
	@Test(priority = 94)
	public void VerifyCustomerRelationshipRequestList() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("CustomerRelationshipRequestList");
		extTestClient.appendChild(extTestCommon);
		objHomePage.GotoCustomerRelationshipRequestList();
	}
	
	@Test(priority = 101)
	public void VerifyPlannerHome() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("PlannerHome");
		extTestScheduling.appendChild(extTestCommon);
		objHomePage.GotoPlannerHome();
	}
	@Test(priority = 102)
	public void VerifyManageScheduling() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("ManageScheduling");
		extTestScheduling.appendChild(extTestCommon);
		objHomePage.GotoSchedulingBookingList();
	}
	@Test(priority = 103)
	public void VerifyConfirmScheduling() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("ConfirmScheduling");
		extTestScheduling.appendChild(extTestCommon);
		objHomePage.GotoConfirmScheduling();
	}
	@Test(priority = 104)
	public void VerifySendNotification() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("SendNotification");
		extTestScheduling.appendChild(extTestCommon);
		objHomePage.GotoSendNotification();
	}
	@Test(priority = 105)
	public void VerifyViewNotification() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("ViewNotification");
		extTestScheduling.appendChild(extTestCommon);
		objHomePage.GotoViewNotification();
	}
	@Test(priority = 106)
	public void VerifyViewEventLog() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("ViewEventLog");
		extTestScheduling.appendChild(extTestCommon);
		objHomePage.GotoViewEventLog();
	}
	@Test(priority = 107)
	public void VerifySupervisorDashboard() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("SupervisorDashboard");
		extTestScheduling.appendChild(extTestCommon);
		objHomePage.GotoSupervisorDashboard();
	}
	
	@Test(priority = 111)
	public void VerifyManageInternalUser() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("ManageInternalUser");
		extTestAdministration.appendChild(extTestCommon);
		objHomePage.GotoManageInternalUser();
	}
	@Test(priority = 112)
	public void VerifyManageExternalUser() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("ManageExternalUser");
		extTestAdministration.appendChild(extTestCommon);
		objHomePage.GotoManageExternalUser();
	}
	
	@Test(priority = 113)
	public void VerifySchedulingPlanner() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("SchedulingPlanner");
		extTestAdministration.appendChild(extTestCommon);
		objHomePage.GotoSchedulingPlanner();
	}
	
	@Test(priority = 114)
	public void VerifyManageRolePage() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("ManageRole");
		extTestAdministration.appendChild(extTestCommon);
		objHomePage.GotoManageRolePage();
		//extTestCommon.log(LogStatus.PASS, "Manage Role page loaded successfully");
	}
	
	@Test(priority = 115)
	public void VerifyManageSummaryReport() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("ManageSummaryReport");
		extTestAdministration.appendChild(extTestCommon);
		objHomePage.GotoManageSummaryReport();
	}
	@Test(priority = 116)
	public void VerifyIntegrationLog() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("Integration Log");
		extTestAdministration.appendChild(extTestCommon);
		objHomePage.GotoIntegrationLog();
		//extTestCommon.log(LogStatus.PASS, "Integration log page loaded successfully");
	}

	@Test(priority = 117)
	public void VerifyGotoSystemEventLog() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("SystemEventLog");
		extTestAdministration.appendChild(extTestCommon);
		objHomePage.GotoSystemEventLog();
		//extTestCommon.log(LogStatus.PASS, "System event log page loaded successfully");
		
	}
	
	@Test(priority = 118)
	public void VerifyUploadedJobsLog() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("UploadedJobsLog");
		extTestAdministration.appendChild(extTestCommon);
		objHomePage.GotoUploadedJobsLog();
	}
	@Test(priority = 119)
	public void VerifyAppVersion() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("AppVersion");
		extTestAdministration.appendChild(extTestCommon);
		objHomePage.GotoAppVersion();
	}
	
	
	
	@Test(priority = 121)
	public void VerifyFieldMappingSetList() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("FieldMappingSetList");
		extTestDatalink.appendChild(extTestCommon);
		objHomePage.GotoFieldMappingSetList();
	}

	@Test(priority = 122)
	public void VerifyValueMappingSetList() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("ValueMappingSetList");
		extTestDatalink.appendChild(extTestCommon);
		objHomePage.GotoValueMappingSetList();
	}
	@Test(priority = 123)
	public void VerifyNotification() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("Notification");
		extTestDatalink.appendChild(extTestCommon);
		objHomePage.GotoNotification();
	}
	@Test(priority = 124)
	public void VerifyReportStatus() throws InterruptedException {

		extTestCommon = TestBase.extReport.startTest("ReportStatus");
		extTestDatalink.appendChild(extTestCommon);
		objHomePage.GotoReportStatus();
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
		
		
		TestBase.extReport.endTest(extTestCommon);
		TestBase.extReport.endTest(extTestBooking);
		TestBase.extReport.endTest(extTestInspection);
		TestBase.extReport.endTest(extTestReport);
		TestBase.extReport.endTest(extTestCertificate);
		TestBase.extReport.endTest(extTestInvoice);
		TestBase.extReport.endTest(extTestAnalysisReport);
		TestBase.extReport.endTest(extTestEquipment);
		TestBase.extReport.endTest(extTestSample);
		TestBase.extReport.endTest(extTestClient);
		TestBase.extReport.endTest(extTestScheduling);
		TestBase.extReport.endTest(extTestAdministration);
		TestBase.extReport.endTest(extTestDatalink);
		//TestBase.extReport.endTest(extTestReferenceData);
		
		
		TestBase.CloseWindow();
	}

}
