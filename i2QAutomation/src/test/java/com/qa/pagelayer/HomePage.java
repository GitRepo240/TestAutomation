/**
 * 
 */
package com.qa.pagelayer;


import org.openqa.selenium.By;
//import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.qa.base.TestBase;
//import com.qa.testlayer.Report;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.JavascriptExecutor;
/**
 * @author Manohar
 *
 */
public class HomePage {

	@FindBy(linkText = "Administration")
	private WebElement eAdministration;

	@FindBy(linkText = "Booking")
	private WebElement eBooking;

	@FindBy(linkText = "Inspection")
	private WebElement eInspection;
	
	@FindBy(linkText = "Report")
	private WebElement eReport;
	
	@FindBy(linkText = "Certificate")
	private WebElement eCertificate;
	
	@FindBy(linkText = "Invoice")
	private WebElement eInvoice;
	
	@FindBy(linkText = "Analysis Report")
	private WebElement eAnalysisReport;
	
	@FindBy(linkText = "Equipment")
	private WebElement eEquipment;
	 
	@FindBy(linkText = "Sample")
	private WebElement eSample;
	
	@FindBy(linkText = "Client")
	private WebElement eClient;
	
	@FindBy(linkText = "Scheduling")
	private WebElement eScheduling; 
	
	@FindBy(linkText = "Reference Data")
	private WebElement eReferenceData; 
	
	@FindBy(partialLinkText = "Datalink")
	private WebElement eDatalink; 
	
	@FindBy(id = "btnSaveGeneralInfo")
	private WebElement eStartBookingSave;
	
	@FindBy(linkText = "Search")
	private WebElement eSearch;

	WebDriverWait objWait = new WebDriverWait(TestBase.ObjWebDriver, 60);
	Actions objAction = new Actions(TestBase.ObjWebDriver);
	public WebElement eLoading;
	public WebElement menuWebElement;

	public HomePage() {
		//System.out.println("Home page constructor");
		// driver.get(PAGE_URL);
		// Initialize Elements
		PageFactory.initElements(TestBase.ObjWebDriver, this);
	}

	// @FindBy(linkText = "Manage Role")
	// private WebElement eManageRole;

	public void waitForLoadingTable(WebDriver driver, String divID) {
		eLoading = driver.findElement(By.xpath("//div[@id='" + divID.toString().trim() + "']"));
		objWait.until(ExpectedConditions.attributeContains(eLoading, "style", "display: none;"));
		Assert.assertEquals(eLoading.getAttribute("style").toString().trim(), "display: none;");
	}
	
	public void GotoStartBooking() throws InterruptedException {
		
		objAction.moveToElement(eBooking).build().perform();
		menuWebElement = objWait.until(ExpectedConditions
				.elementToBeClickable(TestBase.ObjWebDriver.findElement(By.linkText("Start Booking"))));
		menuWebElement.click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);

		String strExpectedTitle = "Booking - General Information";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		objWait.until(ExpectedConditions.elementToBeClickable(eStartBookingSave));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);

	}

	public void GotoBookingList() throws InterruptedException {

		objAction.moveToElement(eBooking).build().perform();
		objWait.until(ExpectedConditions.elementToBeClickable(TestBase.ObjWebDriver.findElement(By.linkText("Booking List")))).click();
		//TestBase.ObjWebDriver.findElement(By.linkText("Booking List")).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);
		
		String strExpectedTitle = "All Booking";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		objWait.until(ExpectedConditions.elementToBeClickable(TestBase.ObjWebDriver.findElement(By.linkText("Search"))));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);

		
		WebElement eLoading= TestBase.ObjWebDriver.findElement(By.xpath("//div[@id='load_tbList']"));
		System.out.println("eLoading text >> " + eLoading.getText());
		System.out.println("eLoading style >> " + eLoading.getAttribute("style"));
		eSearch.click();
		System.out.println("eLoading style >> " + eLoading.getAttribute("style"));
		objWait.until(ExpectedConditions.attributeContains(eLoading, "style", "display: none;"));
		System.out.println("eLoading style >> " + eLoading.getAttribute("style"));
		
	}

	/*
	public void waitForLoad(WebDriver driver) 
	{
        		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() 
        		{
                    public Boolean apply(WebDriver driver) 
                    {
                    	return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
                
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(pageLoadCondition);
    }*/
	
	public void GotoQuotationList() throws InterruptedException {
		// Actions objAction = new Actions(TestBase.ObjWebDriver);
		objAction.moveToElement(eBooking).build().perform();
		TestBase.ObjWebDriver.findElement(By.linkText("Quotation List")).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);
		
		String strExpectedTitle = "Quotation List";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		objWait.until(
				ExpectedConditions.elementToBeClickable(TestBase.ObjWebDriver.findElement(By.linkText("Search"))));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbList");
	}

	public void GotoPaymentList() throws InterruptedException {
		// Actions objAction = new Actions(TestBase.ObjWebDriver);
		objAction.moveToElement(eBooking).build().perform();
		TestBase.ObjWebDriver.findElement(By.linkText("Payment List")).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);
		
		String strExpectedTitle = "Payment List";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		objWait.until(
				ExpectedConditions.elementToBeClickable(TestBase.ObjWebDriver.findElement(By.linkText("Search"))));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbList");
	}

	public void GotoLateCancelRequestList() throws InterruptedException {
		// Actions objAction = new Actions(TestBase.ObjWebDriver);
		objAction.moveToElement(eBooking).build().perform();
		TestBase.ObjWebDriver.findElement(By.linkText("Late Cancel Request List")).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);
		
		String strExpectedTitle = "Late Cancel Request List";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		objWait.until(
				ExpectedConditions.elementToBeClickable(TestBase.ObjWebDriver.findElement(By.linkText("Search"))));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbList");
		
	}

	public void GotoETReviewBooking() throws InterruptedException {
		// Actions objAction = new Actions(TestBase.ObjWebDriver);
		objAction.moveToElement(eBooking).build().perform();
		TestBase.ObjWebDriver.findElement(By.linkText("ET Review Booking")).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);
		
		String strExpectedTitle = "ET Review Booking";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		objWait.until(
				ExpectedConditions.elementToBeClickable(TestBase.ObjWebDriver.findElement(By.linkText("Search"))));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbList");
	}

	public void GotoEquipmenttobePrepared() throws InterruptedException {

		objAction.moveToElement(eBooking).build().perform();
		TestBase.ObjWebDriver.findElement(By.linkText("Equipment to be Prepared")).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);
		
		String strExpectedTitle = "Equipment to be Prepared";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		objWait.until(
				ExpectedConditions.elementToBeClickable(TestBase.ObjWebDriver.findElement(By.linkText("Search"))));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbList");
	}

	public void GotoEquipmenttobeDelivered() throws InterruptedException {

		objAction.moveToElement(eBooking).build().perform();
		TestBase.ObjWebDriver.findElement(By.linkText("Equipment to be Delivered")).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);
		
		String strExpectedTitle = "Equipment to be Delivered";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		objWait.until(
				ExpectedConditions.elementToBeClickable(TestBase.ObjWebDriver.findElement(By.linkText("Search"))));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbList");
	}

	public void GotoRemainManPower() throws InterruptedException {

		objAction.moveToElement(eBooking).build().perform();
		TestBase.ObjWebDriver.findElement(By.linkText("Remain Man Power")).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);
		
		String strExpectedTitle = "Remain Man Power";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		objWait.until(
				ExpectedConditions.elementToBeClickable(TestBase.ObjWebDriver.findElement(By.linkText("Search"))));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
	}

	/*Booking menu is completed */
	
	/*Inspection menu is started*/
	public void GotoInspectionList() throws InterruptedException {

		objAction.moveToElement(eInspection).build().perform();
		TestBase.ObjWebDriver.findElement(By.linkText("Inspection List")).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);
		
		String strExpectedTitle = "Inspection List";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		
		objWait.until(ExpectedConditions.elementToBeClickable(TestBase.ObjWebDriver.findElement(By.linkText("Search"))));
		Thread.sleep(5000);
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbList");
	}
	
	public void GotoAbortiveList() throws InterruptedException {

		objAction.moveToElement(eInspection).build().perform();
		TestBase.ObjWebDriver.findElement(By.linkText("Abortive List")).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);
		
		String strExpectedTitle = "Abortive List";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		
		objWait.until(ExpectedConditions.elementToBeClickable(TestBase.ObjWebDriver.findElement(By.linkText("Search"))));
		Thread.sleep(5000);
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbList");
	}
	
	public void GotoReportList() throws InterruptedException {

		objAction.moveToElement(eReport).build().perform();
		TestBase.ObjWebDriver.findElement(By.partialLinkText("Report List")).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);
		
		String strExpectedTitle = "Report List";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		//Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		objWait.until(ExpectedConditions.elementToBeClickable(TestBase.ObjWebDriver.findElement(By.linkText("Search"))));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbList");
	}
	
	/* Certificate menu list */
	public void GotoICReadyList() throws InterruptedException {

		objAction.moveToElement(eCertificate).build().perform();
		TestBase.ObjWebDriver.findElement(By.partialLinkText("IC Ready List")).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);
		
		String strExpectedTitle = "IC Ready List";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		objWait.until(ExpectedConditions.elementToBeClickable(TestBase.ObjWebDriver.findElement(By.linkText("Search"))));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbList");
	}

	public void GotoCertificateRequestList() throws InterruptedException {

		objAction.moveToElement(eCertificate).build().perform();
		TestBase.ObjWebDriver.findElement(By.linkText("Certificate Request List")).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);
		
		String strExpectedTitle = "Certificate Request List";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		//Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		objWait.until(ExpectedConditions.elementToBeClickable(TestBase.ObjWebDriver.findElement(By.linkText("Search"))));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbList");
	}
	
	public void GotoCertificateList() throws InterruptedException {

		objAction.moveToElement(eCertificate).build().perform();
		TestBase.ObjWebDriver.findElement(By.linkText("Certificate List")).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);
		
		String strExpectedTitle = "Certificate List";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		//Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		objWait.until(ExpectedConditions.elementToBeClickable(TestBase.ObjWebDriver.findElement(By.linkText("Search"))));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbList");
	}
	public void GotoShipmentReleaseNoteList() throws InterruptedException {

		objAction.moveToElement(eCertificate).build().perform();
		TestBase.ObjWebDriver.findElement(By.partialLinkText("Shipment Release List")).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);
		
		String strExpectedTitle = "Shipment Release Note List";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		objWait.until(ExpectedConditions.elementToBeClickable(TestBase.ObjWebDriver.findElement(By.linkText("Search"))));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbList");
	}
	
	public void GotoReportReadyForIRN() throws InterruptedException {

		objAction.moveToElement(eCertificate).build().perform();
		TestBase.ObjWebDriver.findElement(By.linkText("Report Ready For IRN")).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);
		
		String strExpectedTitle = "Report Ready For IRN";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		objWait.until(ExpectedConditions.elementToBeClickable(TestBase.ObjWebDriver.findElement(By.linkText("Search"))));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbList");
	}
	
	/*Invoice Menu List*/
	
	public void GotoInvoiceList() throws InterruptedException {

		objAction.moveToElement(eInvoice).build().perform();
		TestBase.ObjWebDriver.findElement(By.linkText("Invoice List")).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);
		
		String strExpectedTitle = "Invoice List";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		objWait.until(ExpectedConditions.elementToBeClickable(TestBase.ObjWebDriver.findElement(By.linkText("Search"))));
		Thread.sleep(5000);
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbList");
	}
	

	public void GotoCreditNoteList() throws InterruptedException {

		objAction.moveToElement(eInvoice).build().perform();
		TestBase.ObjWebDriver.findElement(By.linkText("Credit Note List")).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);
		
		String strExpectedTitle = "Credit Note List";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		objWait.until(ExpectedConditions.elementToBeClickable(TestBase.ObjWebDriver.findElement(By.linkText("Search"))));
		Thread.sleep(5000);
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbList");
	}
	
	public void GotoCreditNoteRequestList() throws InterruptedException {

		objAction.moveToElement(eInvoice).build().perform();
		TestBase.ObjWebDriver.findElement(By.linkText("Credit Note Request List")).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);
		
		String strExpectedTitle = "Credit Note Request List";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		objWait.until(ExpectedConditions.elementToBeClickable(TestBase.ObjWebDriver.findElement(By.linkText("Search"))));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbList");
	}
	
	public void GotoCreateInvoice() throws InterruptedException {

		objAction.moveToElement(eInvoice).build().perform();
		TestBase.ObjWebDriver.findElement(By.linkText("Create Invoice")).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);
		
		String strExpectedTitle = "Create Invoice";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		objWait.until(ExpectedConditions.elementToBeClickable(TestBase.ObjWebDriver.findElement(By.linkText("Search"))));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbList");
	}
	
	
	public void GotoViewReport() throws InterruptedException {

		objAction.moveToElement(eAnalysisReport).build().perform();
		TestBase.ObjWebDriver.findElement(By.linkText("View Report")).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);
		
		String strExpectedTitle = "View Report";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		objWait.until(ExpectedConditions.elementToBeClickable(TestBase.ObjWebDriver.findElement(By.linkText("Search"))));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbList");
	}
	
	
	public void GotoEquipmentList() throws InterruptedException {

		objAction.moveToElement(eEquipment).build().perform();
		TestBase.ObjWebDriver.findElement(By.linkText("Equipment List")).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);
		
		String strExpectedTitle = "Equipment List";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		objWait.until(ExpectedConditions.elementToBeClickable(TestBase.ObjWebDriver.findElement(By.linkText("Search"))));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbList");
	}
	
	
	public void GotoEquipmentTypeList() throws InterruptedException {

		objAction.moveToElement(eEquipment).build().perform();
		TestBase.ObjWebDriver.findElement(By.linkText("Equipment Type List")).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);
		
		String strExpectedTitle = "Equipment Type List";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		objWait.until(ExpectedConditions.elementToBeClickable(TestBase.ObjWebDriver.findElement(By.linkText("Search"))));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbList");
	}
	
	public void GotoQueryJobLog() throws InterruptedException {

		objAction.moveToElement(eEquipment).build().perform();
		TestBase.ObjWebDriver.findElement(By.linkText("Query Job Log")).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);
		
		String strExpectedTitle = "Query Job Log";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		objWait.until(ExpectedConditions.elementToBeClickable(TestBase.ObjWebDriver.findElement(By.linkText("Search"))));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbList");
	}
	
	public void GotoReferenceSampleList() throws InterruptedException {

		objAction.moveToElement(eSample).build().perform();
		TestBase.ObjWebDriver.findElement(By.linkText("Reference Sample")).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);
		
		String strExpectedTitle = "Reference Sample List";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		objWait.until(ExpectedConditions.elementToBeClickable(TestBase.ObjWebDriver.findElement(By.linkText("Search"))));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbList");
	}
	
	public void GotoProductSampleList() throws InterruptedException {

		objAction.moveToElement(eSample).build().perform();
		TestBase.ObjWebDriver.findElement(By.linkText("Product Sample")).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);
		
		String strExpectedTitle = "Product Sample List";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		objWait.until(ExpectedConditions.elementToBeClickable(TestBase.ObjWebDriver.findElement(By.linkText("Search"))));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbList");
	}
	
	public void GotoReferenceSampletobeDelivered() throws InterruptedException {

		objAction.moveToElement(eSample).build().perform();
		TestBase.ObjWebDriver.findElement(By.partialLinkText("Sample to be")).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);
		
		String strExpectedTitle = "Reference Samples to be Delivered";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		objWait.until(ExpectedConditions.elementToBeClickable(TestBase.ObjWebDriver.findElement(By.linkText("Search"))));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbList");
	}
	
	public void GotoCustomerList() throws InterruptedException {

		objAction.moveToElement(eClient).build().perform();
		TestBase.ObjWebDriver.findElement(By.linkText("Client List")).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);
		
		String strExpectedTitle = "Customer List";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		objWait.until(ExpectedConditions.elementToBeClickable(TestBase.ObjWebDriver.findElement(By.linkText("Search"))));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbCustomerList");
	}
	
	public void GotoManageCreditLimit() throws InterruptedException {

		objAction.moveToElement(eClient).build().perform();
		TestBase.ObjWebDriver.findElement(By.linkText("Manage Credit Limit")).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);
		
		String strExpectedTitle = "Application";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		objWait.until(ExpectedConditions.elementToBeClickable(TestBase.ObjWebDriver.findElement(By.linkText("Search"))));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbList");
	}
	public void GotoClientToBeVerified() throws InterruptedException {

		objAction.moveToElement(eClient).build().perform();
		TestBase.ObjWebDriver.findElement(By.linkText("Client To Be Verified")).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);
		
		String strExpectedTitle = "Client To Be Verified";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		objWait.until(ExpectedConditions.elementToBeClickable(TestBase.ObjWebDriver.findElement(By.linkText("Search"))));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbList");
		
		GotoClientFromInterlink();
	}
	
	
	public void GotoClientFromInterlink() throws InterruptedException {

		objWait.until(ExpectedConditions.elementToBeClickable(TestBase.ObjWebDriver.findElement(By.linkText("Client From Interlink"))));
		objWait.until(ExpectedConditions.elementToBeClickable(TestBase.ObjWebDriver.findElement(By.linkText("Client From Interlink")))).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);
		
		String strExpectedTitle = "Client To Be Verified";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		objWait.until(ExpectedConditions.elementToBeClickable(TestBase.ObjWebDriver.findElement(By.linkText("Search"))));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbList");
		
		
	}
	
	
	public void GotoCustomerRelationshipRequestList() throws InterruptedException {

		objAction.moveToElement(eClient).build().perform();
		TestBase.ObjWebDriver.findElement(By.linkText("Customer Relationship Request List")).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);
		
		String strExpectedTitle = "Customer Relationship Request List";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		objWait.until(ExpectedConditions.elementToBeClickable(TestBase.ObjWebDriver.findElement(By.linkText("Search"))));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbList");
	}
	
	/* Scheduling Menu list*/
	public void GotoPlannerHome() throws InterruptedException {

		objAction.moveToElement(eScheduling).build().perform();
		TestBase.ObjWebDriver.findElement(By.linkText("Planner Home")).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);
		
		String strExpectedTitle = "Planner Home";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		objWait.until(ExpectedConditions.elementToBeClickable(TestBase.ObjWebDriver.findElement(By.linkText("Search"))));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
	}
	 
	public void GotoSchedulingBookingList() throws InterruptedException {

		objAction.moveToElement(eScheduling).build().perform();
		TestBase.ObjWebDriver.findElement(By.linkText("Manage Scheduling")).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);
		
		String strExpectedTitle = "Scheduling Booking List";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		objWait.until(ExpectedConditions.elementToBeClickable(TestBase.ObjWebDriver.findElement(By.linkText("Search"))));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbBookingList");
	}
	public void GotoConfirmScheduling() throws InterruptedException {

		objAction.moveToElement(eScheduling).build().perform();
		TestBase.ObjWebDriver.findElement(By.linkText("Confirm Scheduling")).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);
		
		String strExpectedTitle = "Confirm Scheduling";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		//objWait.until(ExpectedConditions.elementToBeClickable(TestBase.ObjWebDriver.findElement(By.linkText("Search"))));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
	}
	public void GotoSendNotification() throws InterruptedException {

		objAction.moveToElement(eScheduling).build().perform();
		TestBase.ObjWebDriver.findElement(By.linkText("Send Notification")).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);
		
		String strExpectedTitle = "Send Notification";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		objWait.until(ExpectedConditions.elementToBeClickable(TestBase.ObjWebDriver.findElement(By.linkText("Search"))));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbInspectorList");
	}
	public void GotoViewNotification() throws InterruptedException {

		objAction.moveToElement(eScheduling).build().perform();
		TestBase.ObjWebDriver.findElement(By.linkText("View Notification")).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);
		
		String strExpectedTitle = "View Notification";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		objWait.until(ExpectedConditions.elementToBeClickable(TestBase.ObjWebDriver.findElement(By.linkText("Search"))));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbInspectorList");
	}
	public void GotoViewEventLog() throws InterruptedException {

		objAction.moveToElement(eScheduling).build().perform();
		TestBase.ObjWebDriver.findElement(By.linkText("View Event Log")).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);
		
		String strExpectedTitle = "View Event Log";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		objWait.until(ExpectedConditions.elementToBeClickable(TestBase.ObjWebDriver.findElement(By.linkText("Search"))));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbList");
	}
	
	public void GotoSupervisorDashboard() throws InterruptedException {

		objAction.moveToElement(eScheduling).build().perform();
		TestBase.ObjWebDriver.findElement(By.linkText("Supervisor’s Dashboard")).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);
		
		String strExpectedTitle = "Supervisor’s Dashboard";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		objWait.until(ExpectedConditions.elementToBeClickable(TestBase.ObjWebDriver.findElement(By.linkText("Search"))));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		
	}
	
	/*Administration Menu List*/
	
	public void GotoManageInternalUser() throws InterruptedException {

		objAction.moveToElement(eAdministration).build().perform();
		TestBase.ObjWebDriver.findElement(By.linkText("Manage Internal User")).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);
		
		String strExpectedTitle = "Internal User List";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		objWait.until(ExpectedConditions.elementToBeClickable(TestBase.ObjWebDriver.findElement(By.linkText("Search"))));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbList");
	}
	
	public void GotoManageExternalUser() throws InterruptedException {

		objAction.moveToElement(eAdministration).build().perform();
		TestBase.ObjWebDriver.findElement(By.linkText("Manage External User")).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);
		
		String strExpectedTitle = "External User List";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		objWait.until(ExpectedConditions.elementToBeClickable(TestBase.ObjWebDriver.findElement(By.linkText("Search"))));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbUserList");
	}
	public void GotoSchedulingPlanner() throws InterruptedException {

		objAction.moveToElement(eAdministration).build().perform();
		TestBase.ObjWebDriver.findElement(By.linkText("Scheduling Planner")).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);
		
		String strExpectedTitle = "Scheduling Planner List";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		objWait.until(ExpectedConditions.elementToBeClickable(TestBase.ObjWebDriver.findElement(By.linkText("Search"))));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_dataTable");
	}
	
	public void GotoManageRolePage() throws InterruptedException {

		objWait.until(ExpectedConditions.elementToBeClickable(eAdministration));
		objAction.moveToElement(eAdministration).build().perform();
		objWait.until(ExpectedConditions.elementToBeClickable(TestBase.ObjWebDriver.findElement(By.partialLinkText("Role")))).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);
		
		String strExpectedTitle = "Role List";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbRoleList");
	}

	

	public void GotoManageSummaryReport() throws InterruptedException {

		objWait.until(ExpectedConditions.elementToBeClickable(eAdministration));
		objAction.moveToElement(eAdministration).build().perform();
		// TestBase.ObjWebDriver.findElement(By.linkText("Integration Log")).click();
		objWait.until(ExpectedConditions.elementToBeClickable(TestBase.ObjWebDriver.findElement(By.linkText("Manage Summary Report")))).click();
		
		TestBase.waitForLoad(TestBase.ObjWebDriver);
		String strExpectedTitle = "Business Report View List";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbList");
		
		GotoReportManageList();
	}
	
	public void GotoReportManageList() throws InterruptedException {

		objWait.until(ExpectedConditions.elementToBeClickable(TestBase.ObjWebDriver.findElement(By.linkText("Report Manage List"))));
		objWait.until(ExpectedConditions.elementToBeClickable(TestBase.ObjWebDriver.findElement(By.linkText("Report Manage List")))).click();
		
		String strExpectedTitle = "Report List";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbList");
	}
	
	
	
	public void GotoIntegrationLog() throws InterruptedException {

		objWait.until(ExpectedConditions.elementToBeClickable(eAdministration));
		objAction.moveToElement(eAdministration).build().perform();
		objWait.until(ExpectedConditions.elementToBeClickable(TestBase.ObjWebDriver.findElement(By.linkText("Integration Log")))).click();
		
		TestBase.waitForLoad(TestBase.ObjWebDriver);
		String strExpectedTitle = "Integration Log";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbList");
	}
	public void GotoSystemEventLog() throws InterruptedException {

		// Thread.sleep(6000);
		//Actions objAction = new Actions(TestBase.ObjWebDriver);
		objWait.until(ExpectedConditions.elementToBeClickable(eAdministration));
		objAction.moveToElement(eAdministration).build().perform();
		// TestBase.ObjWebDriver.findElement(By.linkText("Integration Log")).click();
		objWait.until(ExpectedConditions
				.elementToBeClickable(TestBase.ObjWebDriver.findElement(By.linkText("System Event Log")))).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);
		
		String strExpectedTitle = "System Event Log";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbList");
	}
	public void GotoUploadedJobsLog() throws InterruptedException {

		objWait.until(ExpectedConditions.elementToBeClickable(eAdministration));
		objAction.moveToElement(eAdministration).build().perform();
		objWait.until(ExpectedConditions.elementToBeClickable(TestBase.ObjWebDriver.findElement(By.linkText("Uploaded Jobs Log")))).click();
		
		TestBase.waitForLoad(TestBase.ObjWebDriver);
		String strExpectedTitle = "Uploaded Jobs Log";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbList");
	}
	public void GotoAppVersion() throws InterruptedException {

		objWait.until(ExpectedConditions.elementToBeClickable(eAdministration));
		objAction.moveToElement(eAdministration).build().perform();
		objWait.until(ExpectedConditions.elementToBeClickable(TestBase.ObjWebDriver.findElement(By.linkText("App Version")))).click();
		
		TestBase.waitForLoad(TestBase.ObjWebDriver);
		String strExpectedTitle = "App Version";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		
	}
	
	public void GotoFieldMappingSetList() throws InterruptedException {

		
		objWait.until(ExpectedConditions.elementToBeClickable(eDatalink));
		objAction.moveToElement(eDatalink).build().perform();
		objWait.until(ExpectedConditions.elementToBeClickable(TestBase.ObjWebDriver.findElement(By.partialLinkText("Field Mapping")))).click();
		
		TestBase.waitForLoad(TestBase.ObjWebDriver);
		String strExpectedTitle = "Field Mapping Set List";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbMappingSetConfigureList");
	}
	
	public void GotoValueMappingSetList() throws InterruptedException {

		objWait.until(ExpectedConditions.elementToBeClickable(eDatalink));
		objAction.moveToElement(eDatalink).build().perform();
		objWait.until(ExpectedConditions.elementToBeClickable(TestBase.ObjWebDriver.findElement(By.partialLinkText("Value Mapping")))).click();
		
		TestBase.waitForLoad(TestBase.ObjWebDriver);
		String strExpectedTitle = "Value Mapping Set List";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbMappingSetConfigureList");
	}
	public void GotoNotification() throws InterruptedException {

		objWait.until(ExpectedConditions.elementToBeClickable(eDatalink));
		objAction.moveToElement(eDatalink).build().perform();
		objWait.until(ExpectedConditions.elementToBeClickable(TestBase.ObjWebDriver.findElement(By.linkText("Notification")))).click();
		
		TestBase.waitForLoad(TestBase.ObjWebDriver);
		String strExpectedTitle = "Notification Email Setting";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbList");
	}
	public void GotoReportStatus() throws InterruptedException {

		objWait.until(ExpectedConditions.elementToBeClickable(eDatalink));
		objAction.moveToElement(eDatalink).build().perform();
		objWait.until(ExpectedConditions.elementToBeClickable(TestBase.ObjWebDriver.findElement(By.partialLinkText("Report Status")))).click();
		
		TestBase.waitForLoad(TestBase.ObjWebDriver);
		String strExpectedTitle = "Report Status List";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbReportStatusList");
	}
	
	/*Reference Menu List*/
	
	public void GotoReferenceData() throws InterruptedException {

		objWait.until(ExpectedConditions.elementToBeClickable(eAdministration));
		objAction.moveToElement(eAdministration).build().perform();
		objWait.until(ExpectedConditions.elementToBeClickable(eReferenceData)).click();
		
		TestBase.waitForLoad(TestBase.ObjWebDriver);
		String strExpectedTitle = "AQL List";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		objWait.until(ExpectedConditions.elementToBeClickable(TestBase.ObjWebDriver.findElement(By.linkText("Search"))));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
	}
	
	
	
	
	public boolean isTestPass(String strExpectedTitle) {
		// System.out.println("mainpage " +this.driver.getTitle());
		// System.out.println("innserpage " +objdriver.getTitle());
		return TestBase.ObjWebDriver.getTitle().toString().contains(strExpectedTitle);
	}

	public boolean ValidateHomePageTitle() {

		String strExpectedTitle = "To-do-list";

		if (this.isTestPass(strExpectedTitle)) {
			System.out.println("Logged in successfully & user is on home page");
			// objGISLoginPage.ClickOnSignOff();
			return true;
		} else 
		{
			System.out.println("Log-in is not successfull.");

		}
		return false;
	}

	public void LogOutFromSite() throws InterruptedException {
		// this.ClickOnSignOff();
		Thread.sleep(5000);
		// this.ClickOnHome();
		// Thread.sleep(5000);
	}

}
