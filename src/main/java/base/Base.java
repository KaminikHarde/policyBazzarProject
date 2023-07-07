package base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import utility.*;

public class Base  
{
  
	//driver and browser setup
	static protected WebDriver driver;
	 public void launchBrowser() 
	 {
		 driver=new ChromeDriver();
		 driver.get("https://www.policybazaar.com/");
		 Reporter.log("Launching Browser", true);
	 } 
	 
	 public void launchBrowserUsingPropertyFile() throws IOException 
	 {
		 driver=new ChromeDriver();
		 driver.get(Utility.readDataFromPeopertyFile("url"));
		 
		 Reporter.log("Launching Browser", true);
	 }
		 public void closeBrowser() 
		 {
			Reporter.log("closing Browser", true);
			 driver.quit(); 
			 
		 }
	 }

