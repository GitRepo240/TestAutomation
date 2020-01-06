/**
 * 
 */
package com.qa.pagelayer;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.qa.base.ReadWriteExcelFile;
import com.qa.base.TestBase;

/**
 * @author Manohar.Khot
 *
 */
public class ManageArea {
	
	
	@FindBy(id = "CountryCode")
	private WebElement eCountryCode;

	@FindBy(id = "RegionID")
	private WebElement eRegionID;

	@FindBy(id = "AreaCode")
	private WebElement eAreaCode;

	@FindBy(id = "AreaName")
	private WebElement eAreaName;
	
	@FindBy(id = "DatalinkFolder")
	private WebElement eDatalinkFolder;
	
	@FindBy(id = "Description")
	private WebElement eDescription;
	
	@FindBy(linkText = "Create")
	private WebElement eBtnCreate;
	
	@FindBy(xpath = "//input[@type='submit' and @value='Save']")
	private WebElement eBtnSave;
	
	@FindBy(xpath = "//input[@type='button' and @value='Cancel']")
	private WebElement eBtnCancel;
	
	WebDriverWait objWait = new WebDriverWait(TestBase.ObjWebDriver, 20);
	Actions objAction = new Actions(TestBase.ObjWebDriver);
	String strExpectedTitle; 
	List<List<String>> arrOfList;
	WebElement eLoading;
	WebElement ErrorMsgAreaCode;
	WebElement ErrorMsgAreaName;
	
	public ManageArea()
	{
		PageFactory.initElements(TestBase.ObjWebDriver, this);
	}
	
	public void waitForLoadingMessage(WebDriver driver, String divID, String strMessage) {
		eLoading = driver.findElement(By.xpath("//div[@id='" + divID.toString().trim() + "']"));
		objWait.until(ExpectedConditions.attributeContains(eLoading, "style", strMessage));
		Assert.assertEquals(eLoading.getAttribute("style").toString().trim(), "display: none;");
	}
	
	
	public static void changeColor(String strColor, WebElement element)
	{
		JavascriptExecutor jsDriver = ((JavascriptExecutor) TestBase.ObjWebDriver);
		jsDriver.executeScript("arguments[0].click();", element);
		jsDriver.executeScript("arguments[0].style.backgroundColor='"+ strColor +"'", element);
		jsDriver.executeScript("arguments[0].style.border='3px solid red'", element);
		String strTitle = jsDriver.executeScript("return document.title;").toString();
		
		System.out.println("Title>"+ strTitle);
		//jsDriver.executeScript("alert('JS Webdriver');");
	}
	
	
	
	public void AddNewArea(String filePath, String fileName, String sheetName) throws IOException, InterruptedException
	{
		
		arrOfList = ReadWriteExcelFile.ReadExcelFile(filePath, fileName, sheetName);
		
		//Start from i=2nd Row
		//for (int i = 1; i < arrOfList.size(); i++) 
		
		for (int i = 1; i < arrOfList.size(); i++) { 
           
			
			eBtnCreate.click();
            TestBase.waitForLoad(TestBase.ObjWebDriver);
            String strExpectedTitle = "Create Area";
      		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
			
			//for (int j = 0; j < arrOfList.get(i).size(); j++) { 
                String strCountry = arrOfList.get(i).get(1).toString().trim().toUpperCase();
                String strRegion = arrOfList.get(i).get(2).toString().trim();
                String strAreaCode = arrOfList.get(i).get(3).toString().trim();
                String strAreaName = arrOfList.get(i).get(4).toString().trim();
                String strDataLinkFolder = arrOfList.get(i).get(5).toString().trim();
                String strDescriptions = arrOfList.get(i).get(6).toString().trim();
                
                System.out.print(strCountry + ">> ");
                System.out.print(strRegion + ">> ");
                System.out.print(strAreaCode + ">> ");
                System.out.print(strAreaName + ">> ");
                System.out.print(strDataLinkFolder + ">> ");
                System.out.print(strDescriptions + ">> ");
                
                
                Select CountryCode = new Select(eCountryCode);
                CountryCode.selectByVisibleText(strCountry);
                Thread.sleep(3000);
                
                Select RegionID = new Select(eRegionID);
                RegionID.selectByVisibleText(strRegion);
                
                eAreaCode.clear();
                eAreaCode.sendKeys(strAreaCode);
                Thread.sleep(3000);
                
                //ErrorMsgAreaCode  = TestBase.ObjWebDriver.findElement(By.xpath("span//[@class='field-validation-error' and @data-valmsg-for='AreaCode']"));
                //waitForLoadingMessage(TestBase.ObjWebDriver,  "", "");
                //The Area Code already existing  
                //The Area Name already existing
                
                eAreaName.clear();
                eAreaName.sendKeys(strAreaName);
                Thread.sleep(3000);

                eDatalinkFolder.clear();
                //eDatalinkFolder.sendKeys(strDataLinkFolder);
                
                eDescription.clear();
                eDescription.sendKeys(strDescriptions);
                
                changeColor("pink",eDescription);
                
                eBtnSave.isDisplayed();
                Thread.sleep(3000);
                objWait.until(ExpectedConditions.attributeContains(eCountryCode, "class", "valid"));
                objWait.until(ExpectedConditions.attributeContains(eRegionID, "class", "valid"));
                objWait.until(ExpectedConditions.attributeContains(eAreaCode, "class", "valid"));
                objWait.until(ExpectedConditions.attributeContains(eAreaName, "class", "valid"));

                eBtnCancel.click();
                objWait.until(ExpectedConditions.alertIsPresent());
                Alert alertMsg = TestBase.ObjWebDriver.switchTo().alert();
                alertMsg.accept();
                TestBase.waitForLoad(TestBase.ObjWebDriver);
            //} 
            //System.out.println(); 
        } 
		
		
		
		
		
		
		
		
	}
	
	

}
