package rb.test1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import rb.app.DriverSetUp;

public class Men {
	WebDriver driver = null;
	@Test(priority = 4)
	public void clickMen() throws InterruptedException {
		Thread.sleep(6000);
		
		driver = DriverSetUp.getDriver();      
		driver.findElement(By.linkText("Men")).click();
	}
}
