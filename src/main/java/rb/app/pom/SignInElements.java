package rb.app.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SignInElements {

	WebDriver driver;

	public SignInElements(WebDriver d) {
		this.driver=d;
		PageFactory.initElements(d, this);
	}
	
	@FindBy(how = How.ID, using = "email")
	WebElement emailTextBox;
	
	@FindBy(how = How.ID, using = "pass")
	WebElement passwordTextBox;
	
	@FindBy(how = How.ID, using = "send2")
	WebElement submit;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/header/div[1]/div/ul/li[2]/span/button")
	WebElement topDropdown;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/header/div[1]/div/ul/li[2]/div/ul/li[3]/a")
	WebElement signOut;
	
	public void enterEmail(String emai) {
		emailTextBox.sendKeys(emai);
	}
	public void enterPassword(String pass) {
		passwordTextBox.sendKeys(pass);
	}
	public void enterCredentials(String e, String p) {
		this.enterEmail(e);
		this.enterPassword(p);
		submit.click();
	}
	public void performSignOut() throws InterruptedException {
		Thread.sleep(1000);
		topDropdown.click();
		Thread.sleep(1000);
		signOut.click();
	}
	

}
