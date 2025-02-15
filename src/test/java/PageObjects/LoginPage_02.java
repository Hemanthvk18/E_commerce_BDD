package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage_02 extends BasePage {

	public LoginPage_02(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//input[@id='Email']") 
	WebElement txtEmailAddress;

	@FindBy(xpath="//input[@id='Password']") 
	WebElement txtPassword;
	
	@FindBy(xpath="//button[normalize-space()='Log in']") 
	WebElement btnLogin;
	
	public void setEmail(String email) {
		txtEmailAddress.sendKeys(email);
	}

	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}

	public void clickLogin() {
		btnLogin.click();
	}

	

}
