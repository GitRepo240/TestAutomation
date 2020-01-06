/**
 * 
 */
package com.qa.pagelayer;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.qa.base.TestBase;

/**
 * @author Manohar
 *
 */
public class LoginPage {

	 //private static String PAGE_URL="https://gis-test1.intertek.com/";
	//WebDriver objDriver = GISOpenBrowser.driver;
	
	String strExpectedTitle;
	
	 @FindBy(id = "UserName")
	 private WebElement eUsername;
	   
	 @FindBy(id = "Password")
	 private WebElement ePassword;
	 
	 @FindBy(className = "btn btn-blue btn-lg")
	 private WebElement eLoginButton;
	 
	 @FindBy(tagName = "button")
	 private WebElement eLoginButton2;
	
	 public LoginPage(){
		// System.out.println("Login page constructor");
	       //Initialize Elements
	     PageFactory.initElements(TestBase.ObjWebDriver, this);
		 //System.out.println("inside constructor");
	   }

	 WebDriverWait objWait = new WebDriverWait(TestBase.ObjWebDriver, 20);
	 
	 
	 public void setUsername(String strUsername)
	   {
		 eUsername.clear();
		 eUsername.sendKeys(strUsername);
	   }
	   public void setPassword(String strPassword)
	   {
		   ePassword.clear();
		   ePassword.sendKeys(strPassword);
	   }
	   public void ClickOnLoginIn()
	   {
		   eLoginButton2.click();
	   }
	   public boolean isTestPass(String strExpectedTitle)
	   {
		   //System.out.println("mainpage " +this.driver.getTitle());
		   //System.out.println("innserpage " +objdriver.getTitle());
		   return TestBase.ObjWebDriver.getTitle().toString().contains(strExpectedTitle); 
	   }
	   
	   public void LoginToSite(String strUsername,String strPassword) 
	   {
		   
		   	this.setUsername(strUsername);
	 		this.setPassword(strPassword);
	 		this.ClickOnLoginIn();
	 		
	 		TestBase.waitForLoad(TestBase.ObjWebDriver);
	 		if(TestBase.WebSiteURL.equalsIgnoreCase("test"))
	 		{
	 			strExpectedTitle = "Planner Home";	
	 		}
	 		else if(TestBase.WebSiteURL.equalsIgnoreCase("stage"))
	 		{
	 			strExpectedTitle = "Planner Home";
	 		}
	 		else if(TestBase.WebSiteURL.equalsIgnoreCase("prod"))
	 		{
	 			strExpectedTitle = "To-do-list";	
	 		}
	 		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
			Assert.assertEquals(TestBase.ObjWebDriver.getTitle().toString(), strExpectedTitle);
			
	   }
	 
	   
	   public void LogOutFromSite() throws InterruptedException
	   {
		   //this.ClickOnSignOff();
		   Thread.sleep(5000);
		   //this.ClickOnHome();
		   Thread.sleep(5000);
	   }
	 
}
