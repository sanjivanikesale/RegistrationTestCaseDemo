package webAutomation.RegistrationTest.Register;

//import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
 
public class Demo extends TestUtilities
{	    
	WebElement alertname;
	
	 @Test
	 @Parameters({ "fnameString", "lnameString", "emailString", "passwordString", "repasswordString", "phonestring", "expectedURL", "expectedTitle", "xpathvalue"})
	 public void validRegistrationTest(String fnameString, String lnameString, String emailString, String passwordString, String repasswordString, String phoneString, String expectedURL, String expectedTitle, @Optional String xpathvalue)
	 { 
			
		 first_name.sendKeys(fnameString);
		 
		 last_name.sendKeys(lnameString);
		 
		 email.sendKeys(emailString);
		 
		 password.sendKeys(passwordString);
		 
		 re_password.sendKeys(repasswordString);
		 
		 phone.sendKeys(phoneString);
		 
		 checkbox.click();
		 
		 continueButton.click();
		 
		 takeScreenshot("file1");
		 
		 String actualURL = driver.getCurrentUrl();	 
		 
		 if(xpathvalue.equals(""))
		 {       
	        
	     Assert.assertEquals(actualURL, expectedURL);
	    
	     String actualTitle = driver.getTitle();
	     
	     Assert.assertEquals(actualTitle, expectedTitle);
	     log.info("Test case executed");
	    
		 }
		 else
		 {
			 alertname = driver.findElement(By.xpath(xpathvalue));
			 String alerttext = alertname.getText();
			 Assert.assertEquals(alerttext, expectedTitle);	
			 log.info("Test case executed");
			 
		 }
		
	 }	  
}