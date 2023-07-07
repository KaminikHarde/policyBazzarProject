package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class LoginPage
{

	
	//variable
	@FindBy(xpath ="//a[text()='Sign in']" )private  WebElement SignInButtonHomePage;
	@FindBy(xpath = "(//input[@type='number'])[2]")private WebElement mobileNumberField;
	@FindBy(xpath =" (//span[text()='Sign in with Password'])[2]")private WebElement SignInWithPassword;
	@FindBy(name = "password")private WebElement passwordField;
	@FindBy(xpath = "//span[text()='Sign in']")private WebElement signInButton;
	@FindBy(xpath = "//div[text()='My Account']")private WebElement MyAccountButton;
	@FindBy(xpath = "//span[text()=' My profile ']")private WebElement myProfileButton;
	//constructor
	public LoginPage(WebDriver driver) 
	{
		
		PageFactory.initElements(driver, this);
		
	}
	
	//Methods
	public void ClickOnSignInButtonHomePage() 
	{
		Reporter.log("clicking on home page SignInButton", true);

		SignInButtonHomePage.click();
	}
	
	public void enterMobileNum(String mobNum) 
	{
		Reporter.log("entering mobile number", true);

		mobileNumberField.sendKeys(mobNum);
	}
	
	public void clickOnSignInWithPassword() 
	{
		Reporter.log("clicking on SignInWithPassword", true);

		SignInWithPassword.click();
		
	}
	public void enterPassword(String pwd) 
	
	{
		Reporter.log("entering password", true);

		passwordField.sendKeys(pwd);
	}
	
	public void clickOnSignInButton()
	    {
		Reporter.log("clicking on SignInButton", true);

		signInButton.click();
		}
	
	public void clickOnMyAccountButton() 
	{
		Reporter.log("clicking on myAccount Button", true);

		MyAccountButton.click();
	}
	public void clickOnMyProfileButton()
	
	{
		Reporter.log("clicking on MyProfile Button", true);

		myProfileButton.click();
	}
	}

