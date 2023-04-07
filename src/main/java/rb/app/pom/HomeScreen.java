package rb.app.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomeScreen {
	WebDriver driver;

	public HomeScreen(WebDriver d) {
		this.driver=d;
		PageFactory.initElements(d, this);
	}
	
	@FindBy(how=How.LINK_TEXT, using = "Sign In")
	WebElement signInElement;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/header/div[1]/div/ul/li[1]/span")
	WebElement defaultMSg;
	
	public void clickSignIn() {
		signInElement.click();
	}
	public String getDefaultMsg() {
		return defaultMSg.getText();
	}
}
