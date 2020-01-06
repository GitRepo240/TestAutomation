package com.qa.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectBrowser {

	public static WebDriver objDriver;
	public static String baseUrl = "https://gis-train1.intertek.com/"; 
		
	public static void main(String[] args)
	{
	
		String BrowserType; 
		BrowserType= "Chrome";
		
		
		if (BrowserType.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver","F:\\ManoharK\\ProjectWork\\Seleniumworkspace\\Browserdriverfiles\\chromedriver.exe");
			objDriver = new ChromeDriver();
			String ExpectedTitle="Intertek User Login";
			String ActualTitle;
			objDriver.get(baseUrl);
			ActualTitle = objDriver.getTitle();
			
			if (ExpectedTitle.equals(ActualTitle))
			{
				System.out.println("Login page is loaded successfully");
			}
			else 
			{
				System.out.println("Login page is not loaded");
			}
				
		}
		else if (BrowserType.equalsIgnoreCase("IE"))
		{
			
		}
		else if (BrowserType.equalsIgnoreCase("MZ"))
		{
			
			
		}
		
	}
		
	
	
}
