/**
 * 
 */
package com.qa.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author manohar.khot
 *
 */
public class TestFirstpage {
	
	public static void main(String[] args)
	{
		
		System.setProperty("webdriver.chrome.driver","F:\\ManoharK\\ProjectWork\\Seleniumworkspace\\Browserdriverfiles\\chromedriver.exe");
		WebDriver objDriver = new ChromeDriver();
		String baseUrl = "http://demo.guru99.com/test/newtours/";
        String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle = "";
        
        
        objDriver.get(baseUrl);
        actualTitle = objDriver.getTitle();
        
        if (actualTitle.contentEquals(expectedTitle))
        {
            System.out.println("Test Passed!");
        } 
        else 
        {
            System.out.println("Test Failed");
        }
       
        //close Fire fox
        objDriver.close();
        objDriver.quit();
		
	}
	
}
