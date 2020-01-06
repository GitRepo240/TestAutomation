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
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.TestBase;

/**
 * @author Manohar
 *
 */
public class ManageRolePage {

	@FindBy(linkText = "New Role")
	private WebElement eNewRole;

	@FindBy(linkText = "Edit Role")
	private WebElement eEditRole;

	@FindBy(id = "RoleCode")
	private WebElement eRoleCode;

	@FindBy(id="AccessToAllClients")
	private WebElement AccessToAllClients;
	
	@FindBy(id = "RoleName")
	private WebElement eRoleName;

	@FindBy(id = "Description")
	private WebElement eRoleDescription;

	@FindBy(xpath = ".//input[@value='Create ']")
	private WebElement eCreateBtn;

	@FindBy(linkText = "View Role")
	private WebElement eViewRole;

	@FindBy(linkText = "Delete")
	private WebElement eDelete;

	@FindBy(linkText = "Administration")
	private WebElement eAdministration;

	WebDriverWait objWait = new WebDriverWait(TestBase.ObjWebDriver, 60);
	Actions objAction = new Actions(TestBase.ObjWebDriver);
	
	
	public ManageRolePage() {
		System.out.println("Manage Role page constructor");
		// driver.get(PAGE_URL);
		// Initialize Elements
		PageFactory.initElements(TestBase.ObjWebDriver, this);
	}

	public void setRoleCode(String strRoleCode) {
		eRoleCode.clear();
		eRoleCode.sendKeys(strRoleCode);
	}

	public void setRoleName(String strRoleName) {
		eRoleName.clear();
		eRoleName.sendKeys(strRoleName);
	}

	public void setDescription(String strDescription) {
		eRoleDescription.clear();
		eRoleDescription.sendKeys(strDescription);
	}

	public void ClickCreateButton() throws InterruptedException {
		eCreateBtn.click();
		Thread.sleep(2000);
		TestBase.ObjWebDriver.switchTo().alert().accept(); // Switch to alert
															// from pop up
															// window.
		TestBase.ObjWebDriver.switchTo().defaultContent(); /// back to main
															/// window
		Thread.sleep(2000);
	}

	
	public boolean isTestPass(WebDriver objdriver, String strExpectedTitle) {
		// System.out.println("mainpage " +this.driver.getTitle());
		// System.out.println("innserpage " +objdriver.getTitle());
		return objdriver.getTitle().toString().contains(strExpectedTitle);
	}

	public void OpenCreateNewRoleWindow() throws InterruptedException {
		// String parentWindowHandler = GISOpenBrowser.driver.getWindowHandle();
		// // Store your parent window
		// String subWindowHandler = null;
		eNewRole.click();
		Thread.sleep(5000);
		TestBase.ObjWebDriver.switchTo().frame("TB_iframeContent");
	}


	public void AddNewRoleData(String strRoleCode, String strRoleName, String strAccessToClient, String strDescriptions)
			throws InterruptedException {

		eNewRole.click();
		Thread.sleep(5000);
		TestBase.ObjWebDriver.switchTo().frame("TB_iframeContent");
		
		this.setRoleCode(strRoleCode);
		this.setRoleName(strRoleName);
		this.setDescription(strDescriptions);
		eCreateBtn.click();
		Thread.sleep(3000);
		TestBase.ObjWebDriver.switchTo().alert().accept();
		TestBase.ObjWebDriver.switchTo().defaultContent();
		
	}

	public void EditRoleData(String strRoleCode, String strRoleName, String strAccessToClient, String strDescriptions)
			throws InterruptedException {
		
		
		
		

	}

	public boolean isTestPass(String strExpectedTitle) {
		// System.out.println("mainpage " +this.driver.getTitle());
		// System.out.println("innserpage " +objdriver.getTitle());
		return TestBase.ObjWebDriver.getTitle().toString().contains(strExpectedTitle);
	}

	public void ValidateManageRolePageTitle() throws InterruptedException {

		String strExpectedTitle = "Role List";

		if (this.isTestPass(strExpectedTitle)) {
			System.out.println("User is on Manage Role Page");
			// objGISLoginPage.ClickOnSignOff();
			Thread.sleep(9000);
		} else {
			System.out.println("Manage Role is not loaded.");
		}

	}

}
