/**
 * 
 */
package com.qa.pagelayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.qa.base.TestBase;

/**
 * @author manohar.khot
 *
 */
public class ReferenceData {

	@FindBy(linkText = "AQL")
	private WebElement eAQL;

	@FindBy(linkText = "Area")
	private WebElement eArea;

	@FindBy(linkText = "Business Line")
	private WebElement eBusinessLine;

	@FindBy(linkText = "Calendar")
	private WebElement eCalendar;

	@FindBy(linkText = "Charge Item")
	private WebElement eChargeItem;

	@FindBy(linkText = "Checking Item")
	private WebElement eCheckingItem;

	@FindBy(linkText = "Checking List")
	private WebElement eCheckingList;

	@FindBy(linkText = "Coordinator")
	private WebElement eCoordinator;

	@FindBy(linkText = "Country")
	private WebElement eCountryList;

	@FindBy(partialLinkText = "Customer Group")
	private WebElement eCustomerGroup;

	@FindBy(linkText = "Defect")
	private WebElement eDefect;

	@FindBy(linkText = "Dictionary")
	private WebElement eDictionary;

	@FindBy(linkText = "Expense")
	private WebElement eExpense;

	@FindBy(linkText = "Formula")
	private WebElement eFormula;

	@FindBy(linkText = "General Inspection Criteria")
	private WebElement eGeneralInspectionCriteria;

	@FindBy(linkText = "Grade Error Category")
	private WebElement eGradeErrorCategory;

	@FindBy(linkText = "Grade Error Description")
	private WebElement eGradeErrorDescription;

	@FindBy(linkText = "Inspection Level")
	private WebElement eInspectionLevel;

	@FindBy(linkText = "Inspector")
	private WebElement eInspector;

	@FindBy(linkText = "Keyword")
	private WebElement eKeyword;

	@FindBy(linkText = "Legal Entity")
	private WebElement eLegalEntity;

	@FindBy(partialLinkText = "Mail Template")
	private WebElement eMailTemplate;

	@FindBy(linkText = "MD Rate")
	private WebElement eMDRate;

	@FindBy(linkText = "Miscellaneous Time")
	private WebElement eMiscellaneousTime;

	@FindBy(linkText = "Multiple Language")
	private WebElement eMultipleLanguage;

	@FindBy(linkText = "Product")
	private WebElement eProduct;

	@FindBy(linkText = "Product Category")
	private WebElement eProductCategory;

	@FindBy(linkText = "Product Type")
	private WebElement eProductType;

	@FindBy(partialLinkText = "Attention Degree")
	private WebElement eAttentionDegree;

	@FindBy(linkText = "Region")
	private WebElement eRegion;

	@FindBy(linkText = "Report Section")
	private WebElement eReportSection;

	@FindBy(linkText = "Special Attention")
	private WebElement eSpecialAttention;

	@FindBy(linkText = "Service Type")
	private WebElement eServiceType;

	@FindBy(partialLinkText = "Special Quotation")
	private WebElement eSpecialQuotation;

	@FindBy(linkText = "SubArea")
	private WebElement eSubArea;

	@FindBy(linkText = "Template")
	private WebElement eTemplate;

	@FindBy(linkText = "Terms And Conditions")
	private WebElement eTermsAndConditions;

	@FindBy(linkText = "Unit")
	private WebElement eUnit;

	@FindBy(partialLinkText = "User Accepted Terms")
	private WebElement eUserAcceptedTerms;

	@FindBy(partialLinkText = "Working Stage")
	private WebElement eWorkingStage;

	@FindBy(partialLinkText = "Photo Attachment")
	private WebElement ePhotoAttachment;

	@FindBy(linkText = "Administration")
	private WebElement eAdministration;

	@FindBy(linkText = "Reference Data")
	private WebElement eReferenceData;

	@FindBy(linkText = "View")
	private WebElement eViewBtn;

	@FindBy(linkText = "Reset")
	private WebElement eResetbtn;

	WebElement eColumnName;
	WebElement eLoading;
	WebDriverWait objWait;
	Actions objAction;

	public ReferenceData() {
		// System.out.println("Login page constructor");
		// Initialize Elements
		PageFactory.initElements(TestBase.ObjWebDriver, this);
		// System.out.println("inside constructor");
		objWait = new WebDriverWait(TestBase.ObjWebDriver, 60);
		objAction = new Actions(TestBase.ObjWebDriver);

	}

	
	public void waitForLoadingTable(WebDriver driver, String divID) {
		eLoading = driver.findElement(By.xpath("//div[@id='" + divID.toString().trim() + "']"));
		objWait.until(ExpectedConditions.attributeContains(eLoading, "style", "display: none;"));
		Assert.assertEquals(eLoading.getAttribute("style").toString().trim(), "display: none;");
	}

	public void GotoAQLList() throws InterruptedException {

		objWait.until(ExpectedConditions.elementToBeClickable(eAQL)).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);

		String strExpectedTitle = "AQL List";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		objWait.until(
				ExpectedConditions.elementToBeClickable(TestBase.ObjWebDriver.findElement(By.linkText("Search"))));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbAQLList");
	}

	public void GotoAreaList() throws InterruptedException {

		objWait.until(ExpectedConditions.elementToBeClickable(eArea)).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);

		String strExpectedTitle = "Area List";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		objWait.until(
				ExpectedConditions.elementToBeClickable(TestBase.ObjWebDriver.findElement(By.linkText("Search"))));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);

		eColumnName = TestBase.ObjWebDriver.findElement(By.xpath("//div[@id='jqgh_tbList_CountryName']"));
		System.out.println("ddddd" + eColumnName.getText().toString());
		Assert.assertEquals(eColumnName.getText().toString(), "Country");
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbList");
	}

	public void GotoBusinessLine() throws InterruptedException {

		objWait.until(ExpectedConditions.elementToBeClickable(eBusinessLine)).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);

		String strExpectedTitle = "Business Line List";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		objWait.until(ExpectedConditions.elementToBeClickable(eResetbtn));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbBusinessLineList");
	}

	public void GotoCalendar() throws InterruptedException {

		objWait.until(ExpectedConditions.elementToBeClickable(eCalendar)).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);

		String strExpectedTitle = "Holiday List";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		objWait.until(ExpectedConditions.elementToBeClickable(eResetbtn));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbHolidayList");
	}

	public void GotoChargeItemList() throws InterruptedException {

		objWait.until(ExpectedConditions.elementToBeClickable(eChargeItem)).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);

		String strExpectedTitle = "Charge Item List";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		objWait.until(ExpectedConditions.elementToBeClickable(eResetbtn));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbChargeItemList");
	}

	public void GotoCheckingItem() throws InterruptedException {

		objWait.until(ExpectedConditions.elementToBeClickable(eCheckingItem)).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);

		String strExpectedTitle = "Checking Item List";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		objWait.until(ExpectedConditions.elementToBeClickable(eResetbtn));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbList");
		
		
		/* Click checkbox based on checkingitem code */
		// Thread.sleep(5000);
		// TestBase.ObjWebDriver.findElement(By.xpath("//td[contains(text(),'ITSSPM00023')]/preceding-sibling::td[@role='gridcell']/input[@type='checkbox']")).click();

	}

	public void GotoCheckingList() throws InterruptedException {

		objWait.until(ExpectedConditions.elementToBeClickable(eCheckingList)).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);

		String strExpectedTitle = "Checking List";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		objWait.until(ExpectedConditions.elementToBeClickable(eResetbtn));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbList");
	}

	public void GotoCoordinator() throws InterruptedException {

		objWait.until(ExpectedConditions.elementToBeClickable(eCoordinator)).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);

		String strExpectedTitle = "Coordinator List";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		objWait.until(ExpectedConditions.elementToBeClickable(eResetbtn));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbList");
	}

	public void GotoCountry() throws InterruptedException {

		objWait.until(ExpectedConditions.elementToBeClickable(eCountryList)).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);

		String strExpectedTitle = "Country List";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		objWait.until(ExpectedConditions.elementToBeClickable(eResetbtn));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbCountryList");
	}

	public void GotoCoustomerGroup() throws InterruptedException {

		objWait.until(ExpectedConditions.elementToBeClickable(eCustomerGroup)).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);

		String strExpectedTitle = "Customer Group";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		objWait.until(ExpectedConditions.elementToBeClickable(eResetbtn));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbCustomerGroupList");
	}

	public void GotoDefect() throws InterruptedException {

		objWait.until(ExpectedConditions.elementToBeClickable(eDefect)).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);

		String strExpectedTitle = "Manage Defect 1st Layer";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbList");
	}

	public void GotoDictionary() throws InterruptedException {

		objWait.until(ExpectedConditions.elementToBeClickable(eDictionary)).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);

		String strExpectedTitle = "Dictionary List";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		objWait.until(ExpectedConditions.elementToBeClickable(eResetbtn));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbList");
	}

	public void GotoExpenseList() throws InterruptedException {

		objWait.until(ExpectedConditions.elementToBeClickable(eExpense)).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);

		String strExpectedTitle = "Expense List";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		objWait.until(ExpectedConditions.elementToBeClickable(eResetbtn));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbExpenseList");
	}

	public void GotoFormulaList() throws InterruptedException {

		objWait.until(ExpectedConditions.elementToBeClickable(eFormula)).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);

		String strExpectedTitle = "Formula List";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		objWait.until(ExpectedConditions.elementToBeClickable(eResetbtn));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbList");
	}

	public void GotoGeneralInspectionCriteria() throws InterruptedException {

		objWait.until(ExpectedConditions.elementToBeClickable(eGeneralInspectionCriteria)).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);

		String strExpectedTitle = "General Inspection Criteria";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);

		eColumnName = TestBase.ObjWebDriver.findElement(By.xpath("//div[@id='jqgh_tbAQLList_AQLProfileName']"));
		/// System.out.println("ddddd" + eColumnName.getText().toString());
		Assert.assertEquals(eColumnName.getText().toString(), "Profile");
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbAQLList");

	}

	public void GotoGradeErrorCategory() throws InterruptedException {

		objWait.until(ExpectedConditions.elementToBeClickable(eGradeErrorCategory)).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);

		String strExpectedTitle = "Grade Error Category List";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		objWait.until(ExpectedConditions.elementToBeClickable(eResetbtn));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbList");
	}

	public void GotoGradeErrorDescription() throws InterruptedException {

		objWait.until(ExpectedConditions.elementToBeClickable(eGradeErrorDescription)).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);

		String strExpectedTitle = "Grade Error Description List";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		objWait.until(ExpectedConditions.elementToBeClickable(eResetbtn));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbList");
	}

	public void GotoInspectionLevelList() throws InterruptedException {

		objWait.until(ExpectedConditions.elementToBeClickable(eInspectionLevel)).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);

		String strExpectedTitle = "Inspection Level List";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		objWait.until(ExpectedConditions.elementToBeClickable(eResetbtn));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbList");
	}

	public void GotoInspectorList() throws InterruptedException {

		objWait.until(ExpectedConditions.elementToBeClickable(eInspector)).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);

		String strExpectedTitle = "Inspector List";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		objWait.until(ExpectedConditions.elementToBeClickable(eResetbtn));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbInspectorList");
	}

	public void GotoKeyword() throws InterruptedException {

		objWait.until(ExpectedConditions.elementToBeClickable(eKeyword)).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);

		String strExpectedTitle = "Keyword List";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		objWait.until(ExpectedConditions.elementToBeClickable(eResetbtn));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbList");
	}

	public void GotoLegalEntity() throws InterruptedException {

		objWait.until(ExpectedConditions.elementToBeClickable(eLegalEntity)).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);

		String strExpectedTitle = "Legal List";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		objWait.until(ExpectedConditions.elementToBeClickable(eResetbtn));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbList");
	}

	public void GotoMailTemplate() throws InterruptedException {

		objWait.until(ExpectedConditions.elementToBeClickable(eMailTemplate)).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);

		String strExpectedTitle = "Mail Template List";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		objWait.until(ExpectedConditions.elementToBeClickable(eResetbtn));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbList");
	}

	public void GotoMDRate() throws InterruptedException {

		objWait.until(ExpectedConditions.elementToBeClickable(eMDRate)).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);

		String strExpectedTitle = "MD Rate List";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		objWait.until(ExpectedConditions.elementToBeClickable(eResetbtn));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbList");
	}

	public void GotoMiscellaneousTime() throws InterruptedException {

		objWait.until(ExpectedConditions.elementToBeClickable(eMiscellaneousTime)).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);

		String strExpectedTitle = "Miscellaneous Time List";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);

		eColumnName = TestBase.ObjWebDriver
				.findElement(By.xpath("//div[@id='jqgh_tbMiscellaneousTimeList_SampleSizeFrom']"));
		// System.out.println("ddddd" + eColumnName.getText().toString());
		Assert.assertEquals(eColumnName.getText().toString(), "Sample Size From");
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbMiscellaneousTimeList");

	}

	public void GotoMultipleLanguage() throws InterruptedException {

		objWait.until(ExpectedConditions.elementToBeClickable(eMultipleLanguage)).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);

		String strExpectedTitle = "Customer Group";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		objWait.until(ExpectedConditions.elementToBeClickable(eResetbtn));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbMultiLanguageList");
	}

	public void GotoProduct() throws InterruptedException {

		objWait.until(ExpectedConditions.elementToBeClickable(eProduct)).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);

		String strExpectedTitle = "Product List";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		objWait.until(ExpectedConditions.elementToBeClickable(eResetbtn));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbList");
	}

	public void GotoProductCategory() throws InterruptedException {

		objWait.until(ExpectedConditions.elementToBeClickable(eProductCategory)).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);

		String strExpectedTitle = "Product Category List";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		objWait.until(ExpectedConditions.elementToBeClickable(eResetbtn));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbProductCategoryList");
	}

	public void GotoProductType() throws InterruptedException {

		objWait.until(ExpectedConditions.elementToBeClickable(eProductType)).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);

		String strExpectedTitle = "Product Type List";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		objWait.until(ExpectedConditions.elementToBeClickable(eResetbtn));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbProductTypeList");
	}

	public void GotoAttentionDegree() throws InterruptedException {

		objWait.until(ExpectedConditions.elementToBeClickable(eAttentionDegree)).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);

		String strExpectedTitle = "Manage Report Order";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		// objWait.until(ExpectedConditions.elementToBeClickable(eResetbtn));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);

		eColumnName = TestBase.ObjWebDriver.findElement(By.xpath("//div[@id='jqgh_tbList_Description']"));
		// System.out.println("ddddd" + eColumnName.getText().toString());
		Assert.assertEquals(eColumnName.getText().toString(), "Description");
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbList");

	}

	public void GotoRegionList() throws InterruptedException {

		objWait.until(ExpectedConditions.elementToBeClickable(eRegion)).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);

		String strExpectedTitle = "Region List";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		objWait.until(ExpectedConditions.elementToBeClickable(eResetbtn));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbList");
	}

	public void GotoReportSection() throws InterruptedException {

		objWait.until(ExpectedConditions.elementToBeClickable(eReportSection)).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);

		String strExpectedTitle = "Manage Report Section";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		objWait.until(ExpectedConditions.elementToBeClickable(eResetbtn));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbList");
	}

	public void GotoServiceType() throws InterruptedException {

		objWait.until(ExpectedConditions.elementToBeClickable(eServiceType)).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);

		String strExpectedTitle = "Service Type List";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		objWait.until(ExpectedConditions.elementToBeClickable(eResetbtn));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbList");
	}

	public void GotoSpecialAttentionList() throws InterruptedException {

		objWait.until(ExpectedConditions.elementToBeClickable(eSpecialAttention)).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);

		String strExpectedTitle = "Manage Special Attention";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		objWait.until(ExpectedConditions.elementToBeClickable(eResetbtn));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbList");
	}

	public void GotoSpecialQuotationList() throws InterruptedException {

		objWait.until(ExpectedConditions.elementToBeClickable(eSpecialQuotation)).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);

		String strExpectedTitle = "Manage Rule";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		objWait.until(ExpectedConditions.elementToBeClickable(eResetbtn));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbList");
	}

	public void GotoSubAreaList() throws InterruptedException {

		objWait.until(ExpectedConditions.elementToBeClickable(eSubArea)).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);

		String strExpectedTitle = "SubArea List";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		objWait.until(ExpectedConditions.elementToBeClickable(eResetbtn));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbList");
	}

	public void GotoReportTemplate() throws InterruptedException {

		objWait.until(ExpectedConditions.elementToBeClickable(eTemplate)).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);

		String strExpectedTitle = "Report Template";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		objWait.until(ExpectedConditions.elementToBeClickable(eResetbtn));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbList");
	}

	public void GotoTermsAndConditions() throws InterruptedException {

		objWait.until(ExpectedConditions.elementToBeClickable(eTermsAndConditions)).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);

		String strExpectedTitle = "Terms And Conditions";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		// objWait.until(ExpectedConditions.elementToBeClickable(eResetbtn));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);

		eColumnName = TestBase.ObjWebDriver.findElement(By.xpath("//div[@id='jqgh_tbStandardTnC_Language']"));
		// System.out.println("ddddd" + eColumnName.getText().toString());
		Assert.assertEquals(eColumnName.getText().toString(), "Language");
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbStandardTnC");

	}

	public void GotoUnitList() throws InterruptedException {

		objWait.until(ExpectedConditions.elementToBeClickable(eUnit)).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);

		String strExpectedTitle = "Unit List";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		objWait.until(ExpectedConditions.elementToBeClickable(eResetbtn));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbUnitList");
	}

	public void GotoUserAcceptedTerms() throws InterruptedException {

		objWait.until(ExpectedConditions.elementToBeClickable(eUserAcceptedTerms)).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);

		String strExpectedTitle = "User Accepted Terms And Conditions";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		objWait.until(ExpectedConditions.elementToBeClickable(eResetbtn));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbTnCAcceptedList");
	}

	public void GotoWorkingStage() throws InterruptedException {

		objWait.until(ExpectedConditions.elementToBeClickable(eWorkingStage)).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);

		String strExpectedTitle = "Manage Working Stage";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		objWait.until(ExpectedConditions.elementToBeClickable(eResetbtn));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbList");
	}
	public void GotoPhotoAttachmentDescription() throws InterruptedException {

		objWait.until(ExpectedConditions.elementToBeClickable(ePhotoAttachment)).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);

		String strExpectedTitle = "Photo Attachment Description";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		objWait.until(ExpectedConditions.elementToBeClickable(eResetbtn));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
		waitForLoadingTable(TestBase.ObjWebDriver, "load_tbPADList");
	}
}
