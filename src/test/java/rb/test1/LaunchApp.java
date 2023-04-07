package rb.test1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import rb.app.DriverSetUp;
import rb.app.extent.ExtentReportManager;
import rb.app.pom.HomeScreen;
import rb.app.pom.SignInElements;

public class LaunchApp {
	WebDriver driver = null;
	final String username = "rbsd37rbs@gmail.com";
	final String password = "#Dana0952";

	private ExtentReports extent;
	private ExtentTest test;

	@BeforeSuite
	public void setup() {
		extent = ExtentReportManager.getInstance();
		test = extent.createTest("Example Test");
	}

	@Test(priority = 1)
	public void launchChromeDriver() {
		// DriverSetUp set = new DriverSetUp();
		// driver = set.getDriver(driver);
		test.log(Status.INFO, "Test started");
		driver = DriverSetUp.getDriver();

		driver.navigate().to("https://magento.softwaretestingboard.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		System.out.println("**** Website Launched ****");
		test.log(Status.PASS, "Test passed");
	}

	@Test(priority = 2)
	public void website() throws InterruptedException {
		test.log(Status.INFO, "Test started");
		String expected = "Default welcome msg!";

		Thread.sleep(2000);
		HomeScreen homeObj = new HomeScreen(driver);
		String actual = homeObj.getDefaultMsg();
		Assert.assertEquals(actual, expected);
		test.log(Status.PASS, "Test passed");
	}

	@Test(priority = 3)
	public void doSignIn() throws InterruptedException {
		test.log(Status.INFO, "Test started");
		HomeScreen homeObj = new HomeScreen(driver);
		homeObj.clickSignIn();
		Thread.sleep(1000);
		SignInElements signObj = new SignInElements(driver);
		signObj.enterCredentials(username, password);

		Thread.sleep(3000);

		String expected = "Welcome, rb rajolla!";
		String actual = driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[1]/span")).getText();
		System.out.println("ACTUAl TEXT " + actual);
		Assert.assertEquals(actual, expected);
		test.log(Status.PASS, "Test passed");
	}

	@Test(priority = 4)
	public void doSignOut() throws InterruptedException {
		test.log(Status.INFO, "Test started");
		SignInElements signObj = new SignInElements(driver);
		signObj.performSignOut();
		Thread.sleep(3000);

		String expected = "Default welcome msg!";
		HomeScreen homeObj = new HomeScreen(driver);
		String actual = homeObj.getDefaultMsg();
		Assert.assertEquals(actual, expected);
		test.log(Status.PASS, "Test passed");
		}
	 @AfterSuite
	    public void teardown() {
	        ExtentReportManager.close();
	    }

}
