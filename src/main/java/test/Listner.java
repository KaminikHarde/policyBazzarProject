package test;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import base.Base;
import utility.Utility;

public class Listner extends Base implements ITestListener
{

	
	@Override
	public void onTestFailure(ITestResult result)
	{
		
		try {
			Utility.takeScreenShot(driver, result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	@Override
	public void onTestSuccess(ITestResult result) 
	{
		Reporter.log("TC "+result.getName()+"passed successfully", true);
	}
	
	@Override
	public void onTestStart(ITestResult result)
	{
		Reporter.log("TC excusition started for TC "+result.getName(), true);
	}
}
