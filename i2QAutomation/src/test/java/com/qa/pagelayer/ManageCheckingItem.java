/**
 * 
 */
package com.qa.pagelayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.qa.base.TestBase;

/**
 * @author manohar.khot
 *
 */
public class ManageCheckingItem {

	
	@FindBy(linkText = "Administration")
	private WebElement eAdministration;

	@FindBy(linkText = "Booking")
	private WebElement eBooking;
	
	@FindBy(id = "CompanyCode")
	private WebElement eCompanyCode;
	
	@FindBy(id = "CheckingItemType")
	private WebElement eCheckingItemType;
	
	@FindBy(id = "imgSelectKeyword")
	private WebElement eSelectKeyword;
	
	@FindBy(id = "CheckingItemName")
	private WebElement eCheckingItemName;
	@FindBy(id = "ActualFindingType")
	private WebElement eActualFindingType;
	@FindBy(id = "WorkingStage")
	private WebElement eWorkingStage;
	@FindBy(id = "ddlSampleSizeID")
	private WebElement eSamplingLevel;
	@FindBy(id = "ApplicationScopeTypeID")
	private WebElement eApplicationScopeTypeID;
	@FindBy(id = "SamplingUnitID")
	private WebElement eSamplingUnitID;
	@FindBy(id = "SamplingRangeID")
	private WebElement eSamplingRangeID;
	@FindBy(id = "Requirement")
	private WebElement eRequirement;
	@FindBy(id = "Condition")
	private WebElement eCondition;
	@FindBy(id = "ActiveStatus")
	private WebElement eActiveStatus;
	@FindBy(className = "btn btn-blue")
	private WebElement eBtnSelect;
	@FindBy(partialLinkText = "Create")
	private WebElement eBtnCreate;
	
	//@FindBy(id = "imgSelectKeyword")
	//private WebElement eSelectKeyword;
	//@FindBy(id = "imgSelectKeyword")
	//private WebElement eSelectKeyword;
	
	
	//Select Keyword
	//INSPGIM0051
	
	
	WebDriverWait objWait = new WebDriverWait(TestBase.ObjWebDriver, 20);
	Actions objAction = new Actions(TestBase.ObjWebDriver);
	String strExpectedTitle; 
	
	public ManageCheckingItem()
	{
		PageFactory.initElements(TestBase.ObjWebDriver, this);
	}
	
	
	
	public void GotoCheckingItemScreen()
	{
		objWait.until(ExpectedConditions.elementToBeClickable(eBtnCreate)).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);
		
		strExpectedTitle = "Create Checking Item";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		objWait.until(ExpectedConditions.elementToBeClickable(TestBase.ObjWebDriver.findElement(By.name("submit.Save"))));
		Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
	}
	
	public void CreateCheckingItemInReferenceData()
	{
		
		Select CheckingItemType = new Select(eCheckingItemType);
		CheckingItemType.selectByVisibleText("Product Related");
		//Service Type Related, Special Check
		
		strExpectedTitle = "Select Keyword";
		String mainWindow= TestBase.ObjWebDriver.getWindowHandle();
		objWait.until(ExpectedConditions.elementToBeClickable(eSelectKeyword)).click();
		TestBase.waitForLoad(TestBase.ObjWebDriver);
		
		String ActualTitle = TestBase.ObjWebDriver.findElement(By.xpath("//div[@id='TB_ajaxWindowTitle']")).getText().trim();
		Assert.assertEquals(ActualTitle, strExpectedTitle);
		
		String strKeywordCode= "INSPGIM0052";
		WebElement rdKeywordCode = TestBase.ObjWebDriver.findElement(By.id("jqg_tbList_0"));
		rdKeywordCode.click();
		
		TestBase.ObjWebDriver.findElement(By.partialLinkText("Select")).click();;
		TestBase.ObjWebDriver.switchTo().defaultContent();
		
		
	}
	
	
	
	
	
	
	
	
	
}
