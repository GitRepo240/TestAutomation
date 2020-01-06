/**
 * 
 */
package com.qa.testlayer;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * @author manohar.khot
 *
 */
public class TestRemoteGrid {
	
	
	public void CallToRemoteGrid() throws MalformedURLException
	{
		
		DesiredCapabilities Caps = new DesiredCapabilities();
		Caps.setBrowserName("chrome");
		Caps.setVersion("75.0.3770.100");
		Caps.setPlatform(Platform.WINDOWS);
		
		ChromeOptions Options = new ChromeOptions();
		Options.merge(Caps);
		
		String strHubURL = "http://172.24.146.131:4444/wd/hub";
		WebDriver driver = new RemoteWebDriver(new URL(strHubURL),Caps);
		
		driver.get("www.google.com");
		System.out.println(driver.getTitle());
		
		
	}
	
	
	
	
	

}
