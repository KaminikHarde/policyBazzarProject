package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class Utility
{
	


	//commonly used method
	//screenshot
	//scrolling
	//data reading
	//wait
	
	//screenshot
	
	public static void takeScreenShot(WebDriver driver,String fileName ) throws IOException 
	{
		
		 
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
		    File dest=new File("C:\\Users\\si\\eclipse-workspace\\PolicyBazzarProject\\screenshot"+fileName+".png");

		    FileHandler.copy(src, dest);
		    
		    Reporter.log("takingscreenShor",true);
}
	//scrollIntoview
	
	public static void scrollIntoView(WebDriver driver,WebElement element)
	{ 
		JavascriptExecutor js = ( JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		Reporter.log("scrollingIntoView",true);
	}
	
	//fetch data from excell
	public static String readDataFromExcell(int row,int cell) throws EncryptedDocumentException, IOException 
	{
		FileInputStream myFile=new FileInputStream("D:\\18thFebVelo.xlsx ");
		Reporter.log("reading data from excell row num is " +row+" cell num is"+cell, true);
		String value = WorkbookFactory.create(myFile).getSheet("Sheet2").getRow(row). getCell(cell).getStringCellValue();
		return value;
		 
	}
	
	public static void wait(int waitTime) throws InterruptedException 
	
	{
		Reporter.log("waiting for "+waitTime+ " mili sec", true);
		Thread.sleep(waitTime);
	}

  public static String readDataFromPeopertyFile(String key) throws IOException 
  {
	  Properties prop=new Properties();
	  FileInputStream myFile=new FileInputStream("C:\\Users\\si\\eclipse-workspace\\Feb18_Batch_selenium\\myproperty.properties");
	  prop.load(myFile);
	 String value = prop.getProperty(key);
	 Reporter.log("reading data"+ key+ " from propertyFile", true);
	 return value;
  }

 
}
