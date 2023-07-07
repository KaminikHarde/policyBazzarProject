package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.Base;
import pom.LoginPage;
import pom.MyAccountPage;
import utility.Utility;
//@Listeners(testPolicyBazzar.Listner.class)
public class PB_TC_1020_ValidatePolicyUserName2 extends Base 
{

	LoginPage login;
	MyAccountPage myacc;
	String TCID="PB_TC_1234";
	
	@BeforeClass
	
	public void launchPolicyBazzar() throws InterruptedException, IOException 
	{
		Utility.wait(1000);
		launchBrowserUsingPropertyFile();
		login=new LoginPage(driver);
		myacc=new MyAccountPage(driver);
	}
	
	@BeforeMethod
	public void signInToPolicyBazzar() throws InterruptedException, EncryptedDocumentException, IOException
	{
		Utility.wait(500);
		login.ClickOnSignInButtonHomePage();
		Utility.wait(500);
		login.enterMobileNum(Utility.readDataFromPeopertyFile("mobNum"));
		Utility.wait(500);
		login.clickOnSignInWithPassword();
		Utility.wait(500);
		login.enterPassword(Utility.readDataFromPeopertyFile("pwd"));
		Utility.wait(500);
		login.clickOnSignInButton();
		Utility.wait(500);
        login.clickOnMyAccountButton();
		Utility.wait(200);
        login.clickOnMyProfileButton();
 		Utility.wait(500);
         Set<String> allpageID = driver.getWindowHandles();
          List<String>l=new ArrayList<>(allpageID);
        String mainpageID = l.get(0);
        String childpageID = l.get(1);
        driver.switchTo().window(childpageID);
        Reporter.log("switching to child page", true);
		Utility.wait(200);
		

      
	}
	
	
  @Test
  public void ValidateUserName() throws EncryptedDocumentException, IOException
  {
	String actualUN = myacc.getActualUserName();
	String expUN = Utility.readDataFromPeopertyFile("UN");
	   
	  Assert.assertEquals(actualUN,expUN,"TC is failed actual and expected are not matching");
	//  Utility.takeScreenShot(driver, actualUN);
  }
  @AfterMethod
  public void logoutFromPolicyBazzar() 
  {
	  myacc.clickOnLogOutButton();
  }
  @AfterClass
  public void closePolicyBazzar() throws InterruptedException 
  {
		Utility.wait(1000);

	  closeBrowser();
  }
  
}
