package webAutomation.RegistrationTest.Register;

import java.lang.reflect.Method;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseSetUP 
{

	protected Logger log;
	protected WebDriver driver;
	protected WebElement last_name;
	protected WebElement first_name;
	protected WebElement email;
	protected WebElement password;
	protected WebElement re_password;
	protected WebElement phone;
	protected WebElement continueButton;
	protected WebElement checkbox;
	protected String testSuiteName;
	protected String testName;
	protected String testMethodName;
		
	 @BeforeMethod(alwaysRun = true)
	    public void openBrowser(Method method, ITestContext context)
	    {
		 	String testname = context.getCurrentXmlTest().getName();
			String log4jConfPath ="src/main/resources/log4j.properties";
			PropertyConfigurator.configure(log4jConfPath);
			log = LogManager.getLogger(testname);
	        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			driver = new ChromeDriver();
		    driver.manage().window().maximize();
		    driver.get("http://tutorialsninja.com/demo/index.php?route=account/register");

		    this.testSuiteName = context.getSuite().getName();
			this.testName = testname;
			this.testMethodName = method.getName();
		    
		   log.info("Website opened");
		    
		    first_name =  driver.findElement(By.xpath("//*[@id=\"input-firstname\"]"));
		    
		    last_name =  driver.findElement(By.xpath("//*[@id=\"input-lastname\"]"));
		    
		    email =  driver.findElement(By.xpath("//*[@id=\"input-email\"]"));
		    
		    phone =  driver.findElement(By.xpath("//*[@id=\"input-telephone\"]"));
		    
		    password =  driver.findElement(By.xpath("//*[@id=\"input-password\"]"));
		    
		    re_password =  driver.findElement(By.xpath("//*[@id=\"input-confirm\"]")); 
		    
		    checkbox = driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]"));
		    
		    continueButton = driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]"));
		   
	    }
	 
	    // Closing the browser session after completing each test case
	    @AfterMethod(alwaysRun = true)
	    public void tearDown() throws Exception
	    {
	    	  driver.quit();  
	    	  log.info("Website closed");
	    }
	    
	   
}
