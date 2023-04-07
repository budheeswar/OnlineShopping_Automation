package rb.app;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

public class LaunchShopping {
	WebDriver driver = null;
	public Static final String website = "https://magento.softwaretestingboard.com/";
  
  @BeforeMethod
  public void beforeMethod() {
	  // Initialize WebDriver
	  DriverSetUp setUp = new DriverSetUp(driver);
	  driver = setUp.initialize(driver);
	  driver.manage().window().maximize();
	  driver.navigate().to(website);
	  
  }
  @Test
  public void website() {
	  //
  }

}
