/**
 * 
 */
package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * @author Manohar
 *
 */
public class TestBase {

	//Global Variables.
	public static WebDriver ObjWebDriver;
	public static Properties ObjProp;
	public static ExtentReports extReport;
	public static ExtentTest extTest;
	public static String WebSiteURL;
	public static String Username;
	public static String Password;
	
	
	
	public TestBase() 
	{
		
		//System.out.println("Test base constructor");
		try {
			ExtentReportStart();
			LoadPropertiesData();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void LoadPropertiesData() throws IOException
	{
		//System.out.println("Load Prop");
		ObjProp = new Properties();
		try {
			String filepath = System.getProperty("user.dir")
					+ "\\src\\test\\java\\com\\qa\\util\\config.properties";
			
			FileInputStream ObjFile = new FileInputStream(filepath);
			ObjProp.load(ObjFile);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void ExtentReportStart() {

		//System.out.println("Report Started");
		
		String filepath = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\Reports\\TestResult.html";
		//System.out.println("file path: " + filepath);
		extReport = new ExtentReports(filepath);

	}
	
	
	
	public static void OpenWindow()
	{
		//System.out.println("open Browser");
		String browser = ObjProp.getProperty("browser");
		
		if (browser.equalsIgnoreCase("Firefox"))
		{
		 	ObjWebDriver = new FirefoxDriver();
			System.out.println("Before Test Firefox : " + Thread.currentThread().getId());	 
		}
		else if (browser.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Manohar.Khot\\workspace\\Browserdriverfiles\\chromedriver.exe");
			
			//System.setProperty("webdriver.chrome.driver","F:\\ManoharK\\ProjectWork\\Seleniumworkspace\\Browserdriverfiles\\chromedriver.exe");
			
			ChromeOptions ChromeOpt = new ChromeOptions();
			//ChromeOpt.setHeadless(true);
			ChromeOpt.setExperimentalOption("useAutomationExtension", false);
			ChromeOpt.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));
			//ChromeOpt.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");  
			//ChromeOpt.setBinary("F:\\ManoharK\\ProjectWork\\Seleniumworkspace\\Browserdriverfiles\\chromedriver.exe");  NW
			ObjWebDriver = new ChromeDriver(ChromeOpt);
			//ObjWebDriver = new ChromeDriver();
			
			
			//System.out.println("OPen Chrome BRW GC ThreadID: " + Thread.currentThread().getId());
			
		}
		
		ObjWebDriver.manage().window().maximize();
		
		ObjWebDriver.manage().deleteAllCookies();
		ObjWebDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//ObjRepository = new RepositoryParser("object.properties");
		
		
		
		if(ObjProp.getProperty("checktestsite").equalsIgnoreCase("yes"))
		{
			ObjWebDriver.get(ObjProp.getProperty("testurl"));
			WebSiteURL = "test";
			//Username = "admin";
			Username = "manohar";
			Password ="123456";
			//System.out.println(Password);
		}
		else if(ObjProp.getProperty("checkstagesite").equalsIgnoreCase("yes"))
		{
			ObjWebDriver.get(ObjProp.getProperty("stageurl"));
			WebSiteURL = "stage";
			Username = "admin";
			Password ="654321";
			//System.out.println(Password);
		}
		else if(ObjProp.getProperty("checkprodsite").equalsIgnoreCase("yes"))
		{
			ObjWebDriver.get(ObjProp.getProperty("produrl"));
			WebSiteURL = "prod";
			Username = "prathmesh.dalvi";
			Password ="1234567";
			//System.out.println(Password);
		}
		//JavascriptExecutor jse = (JavascriptExecutor)ObjWebDriver;
		//jse.executeScript("document.body.style.zoom = '90%';");
	
		//Thread.sleep(5);
		waitForLoad(ObjWebDriver); 
	}
	
	
	
	/* Check if page is completely loaded  */
	public static void waitForLoad(WebDriver driver) 
	{
        		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() 
        		{
                    public Boolean apply(WebDriver driver) 
                    {
                    	return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
                
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(pageLoadCondition);
    }
	
	public static void CloseWindow()
	{
		EndExtentResult();
		
		/*
		if (ObjWebDriver!=null)
		{
			ObjWebDriver.close();
			ObjWebDriver.quit();
		}
		*/
	 }

	public static void EndExtentResult() {

		extReport.flush();
		String filepath = System.getProperty("user.dir") + "\\src\\test\\resources\\Reports\\TestResult.html";
		
		System.out.println("filepath>>"+filepath);
		//ObjWebDriver.get(filepath);
	}
	
}
