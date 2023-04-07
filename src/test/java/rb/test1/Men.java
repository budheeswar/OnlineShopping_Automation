package rb.test1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import rb.app.DriverSetUp;
import rb.app.extent.ExtentReportManager;

public class Men {
	WebDriver driver = null;
	
	private ExtentReports extent;
	private ExtentTest test;

	@BeforeSuite
	public void setup() {
		extent = ExtentReportManager.getInstance();
		test = extent.createTest("Example Test");
	}
	@Test(priority = 4)
	public void clickMen() throws InterruptedException {
		Thread.sleep(6000);
		
		driver = DriverSetUp.getDriver();      
		driver.findElement(By.linkText("Men")).click();
	}
	
	 @AfterSuite
	    public void teardown() {
	        ExtentReportManager.close();
	    }
}
