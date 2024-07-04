package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import utiles.BaseClass;

public class RegisterPage_04 extends BasePage {
	
	public RegisterPage_04(WebDriver driver) {
		super(driver);
		
	}
	//public WebDriver driver;
	
	

@FindBy(xpath="//input[@id='gender-male']") 
WebElement male;
@FindBy(xpath="//input[@id='FirstName']") 
WebElement firstName;
@FindBy(xpath="//input[@id='LastName']") 
WebElement lastName;
@FindBy(xpath="//input[@id='Email']") 
WebElement email;
@FindBy(xpath="//input[@id='Password']") 
WebElement password;
@FindBy(xpath="//input[@id='ConfirmPassword']")
WebElement confirmPassword;

@FindBy(xpath="//div[@class='buttons']") 
WebElement register;

@FindBy(xpath="//div[@class='result']")
WebElement yourRegistrationCompleted;

@FindBy(xpath="//select[@name='DateOfBirthMonth']")  
WebElement month;

@FindBy(xpath="//select[@name='DateOfBirthDay']")  
WebElement day;

@FindBy(xpath="//select[@name='DateOfBirthYear']")  
WebElement year;

public void radiobutton() 
{
	male.click();
}
public void firstname() 
{
	//BaseClass bc=new BaseClass();
	firstName.sendKeys(BaseClass.randomeString());
    System.out.println(BaseClass.randomeString());
	
}
public void lastname(String ln)
{
	lastName.sendKeys(ln);
}
public void email( ) throws InterruptedException
{
	String randomEmail = BaseClass.randomAlphaNumeric();
	email.sendKeys(randomEmail+"@gmail.com");
	System.out.println(randomEmail+"@gmail.com");
	Thread.sleep(3000);
}
public void password(String pass)
{
	password.sendKeys(pass);
}
public void confirmpass(String pass)
{
	confirmPassword.sendKeys(pass);
}

public void clickRegister()
{
	register.click();
}

public void setDOB()
{
	WebElement dropdown_m =month;
	WebElement dropdown_d =day;
	WebElement dropdown_y =year;
	
	Select m=new Select(dropdown_m);
	Select d=new Select(dropdown_d);
	Select y=new Select(dropdown_y);
	
	m.selectByVisibleText("April");
	d.selectByValue("27");
	y.selectByVisibleText("1999");
	
}

public boolean status()
{
	boolean value=yourRegistrationCompleted.isDisplayed();
	return(value);
}
}
