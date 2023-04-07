package rb.test1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


import rb.app.DriverSetUp;
import rb.app.pom.HomeScreen;
import rb.app.pom.SignInElements;

public class LaunchApp {
	WebDriver driver = null;
	final String username = "rbsd37rbs@gmail.com";
	final String password = "#Dana0952";

	@Test(priority = 1)
	public void launchChromeDriver() {
		//DriverSetUp set = new DriverSetUp();
		//driver = set.getDriver(driver);
		
		driver = DriverSetUp.getDriver();
		
		driver.navigate().to("https://magento.softwaretestingboard.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		System.out.println("**** Website Launched ****");
	}

	@Test(priority = 2)
	public void website() throws InterruptedException {
		String expected="Default welcome msg!";
		
		Thread.sleep(2000);
		HomeScreen homeObj = new HomeScreen(driver);		
		String actual = homeObj.getDefaultMsg();
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 3)
	public void doSignIn() throws InterruptedException {
		
		HomeScreen homeObj = new HomeScreen(driver);
		homeObj.clickSignIn();
		Thread.sleep(1000);
		SignInElements signObj = new SignInElements(driver);
		signObj.enterCredentials(username, password);
		
		Thread.sleep(3000);
		
		String expected = "Welcome, rb rajolla!";
		String actual = driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[1]/span")).getText();
		System.out.println("ACTUAl TEXT "+actual);
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority =4)
	public void doSignOut() throws InterruptedException {
		SignInElements signObj = new SignInElements(driver);
		signObj.performSignOut();
		Thread.sleep(3000);
		
		String expected="Default welcome msg!";		
		HomeScreen homeObj = new HomeScreen(driver);		
		String actual = homeObj.getDefaultMsg();
		Assert.assertEquals(actual, expected);
	}
	

}
