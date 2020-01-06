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
public class ManageAppVersion {

	WebDriverWait objWait = new WebDriverWait(TestBase.ObjWebDriver, 20);
	Actions objAction = new Actions(TestBase.ObjWebDriver);
	String strExpectedTitle; 
	
	@FindBy(linkText = "Administration")
	private WebElement eAdministration;
	
	@FindBy(linkText = "App Version")
	private WebElement eAppVersion;
	
	@FindBy(id = "AppType")
	private WebElement eAppType;
	
	@FindBy(id = "Major")
	private WebElement eMajor;
	
	@FindBy(id = "Minor")
	private WebElement eMinor;
	
	@FindBy(id = "Build")
	private WebElement eBuild;
	
	@FindBy(id = "Patch")
	private WebElement ePatch;
	
	@FindBy(id = "ToleranceDays")
	private WebElement eToleranceDays;
	
	@FindBy(id = "Remark")
	private WebElement eRemark;
	
	
	
	@FindBy(xpath = "input//[@type='submit'][@value='Save']")
	private WebElement ebtnSave;
	
	
	
	public ManageAppVersion()
	{
		PageFactory.initElements(TestBase.ObjWebDriver, this);
	}
	
	
	
	public void addAppVersion(String strMajor,String strMinor,String strBuild,String strPatch,String strRemark)
	{
		TestBase.waitForLoad(TestBase.ObjWebDriver);
		objWait.until(ExpectedConditions.elementToBeClickable(eAppType));
		
		Select selectAppType = new Select(eAppType);
		selectAppType.selectByVisibleText("Laptop");
		
		eMajor.clear();
		eMajor.sendKeys(strMajor);
		eMinor.clear();
		eMinor.sendKeys(strMinor);
		eBuild.clear();
		eBuild.sendKeys(strBuild);
		ePatch.clear();
		ePatch.sendKeys(strPatch);
		
		eRemark.sendKeys(strRemark);
		//driver.executeScript("document.getElementById('Major').setAttribute('value', 11)");
		//ebtnSave.click();
		
	}
	
	
	
	
	
	
}
