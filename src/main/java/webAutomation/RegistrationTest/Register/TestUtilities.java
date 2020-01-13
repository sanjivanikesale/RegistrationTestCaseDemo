package webAutomation.RegistrationTest.Register;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class TestUtilities extends BaseSetUP
{

	 protected void takeScreenshot(String fileName)
		{
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String path = System.getProperty("user.dir") 
					+ File.separator + "test-output" 
					+ File.separator + "screenshots"
					+ File.separator + getTodaysDate() 
					+ File.separator + testSuiteName 
					+ File.separator + testName
					+ File.separator + testMethodName 
					+ File.separator + getSystemTime() 
					+ " " + fileName + ".png";
				try
				{
					FileUtils.copyFile(scrFile, new File(path));
				}
				catch (IOException e) 
				{
					e.printStackTrace();
				}
		}
		/** Todays date in yyyyMMdd format */
		private static String getTodaysDate() 
		{
			return (new SimpleDateFormat("yyyyMMdd").format(new Date()));
		}
		/** Current time in HHmmssSSS */
		private String getSystemTime() 
		{
			return (new SimpleDateFormat("HHmmssSSS").format(new Date()));
		}	
}
