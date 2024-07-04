package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//a[@class='ico-account']") 
	WebElement msgHeading;
	
	@FindBy(xpath="//h2[normalize-space()='Welcome to our store']") 
	WebElement welcomeToOurStore;
	
	@FindBy(xpath="//a[normalize-space()='Log out']") 
	WebElement lnkLogout;

	public boolean isMyAccountPageExists()   // MyAccount Page heading display status
	{
		try {
			return (msgHeading.isDisplayed());
		} catch (Exception e) {
			return (false);
		}
	}

	public void clickLogout() {
		lnkLogout.click();

	}
	
	public void welcomeStatus()
	{
		
		String welcomestatus=	welcomeToOurStore.getText();
		Assert.assertEquals(welcomestatus , "Welcome to our store");	
		System.out.println("Login Status : "+welcomestatus);
		
	}
	
}
