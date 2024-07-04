package PageObjects;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import utiles.BaseClass;

public class CartPage extends BasePage {
	
	public CartPage(WebDriver driver) {
		super(driver);
	}
	
	HomePage hp;
	Properties p;
	
	
	@FindBy(xpath="//input[@id='itemquantity11227']") 
	WebElement qty;
	
	@FindBy(xpath="//tr[1]/td[@class='product']/a") 
	WebElement p1;
	@FindBy(xpath="//tr[2]/td[@class='product']/a") 
	WebElement p2;

	@FindBy(xpath="//input[@id='termsofservice']") 
	WebElement checkbox;
	@FindBy(xpath="//button[@id='checkout']") 
	WebElement checkout;
	

	@FindBy(xpath="//input[@id='BillingNewAddress_FirstName']")
	WebElement firstName;
	@FindBy(xpath="//input[@id='BillingNewAddress_LastName']") 
	WebElement lastName;
	@FindBy(xpath="//input[@id='BillingNewAddress_Email']") 
	WebElement email;
	@FindBy(xpath="//select[@id='BillingNewAddress_CountryId']") 
	WebElement country;
	@FindBy(xpath="//input[@id='BillingNewAddress_City']")
	WebElement city;
	@FindBy(xpath="//input[@id='BillingNewAddress_Address1']") 
	WebElement address1;
	@FindBy(xpath="//input[@id='BillingNewAddress_ZipPostalCode']") 
	WebElement PostalCode;
	@FindBy(xpath="//input[@id='BillingNewAddress_PhoneNumber']") 
	WebElement phoneNumber;
	@FindBy(xpath="//button[@onclick='if (!window.__cfRLUnblockHandlers) return false; Billing.save()']") 
	WebElement continu1;
	@FindBy(xpath="//button[@class='button-1 shipping-method-next-step-button']")
	WebElement continu2;
	@FindBy(xpath="//button[@class='button-1 payment-method-next-step-button']")
	WebElement continu3;
	@FindBy(xpath="//button[@class='button-1 payment-info-next-step-button']")
	WebElement continu4;
	@FindBy(xpath="//button[normalize-space()='Confirm']")  
	WebElement confirm;
	
	@FindBy(xpath="//strong[normalize-space()='Your order has been successfully processed!']") 
	WebElement OrderSuccessful;
	
	@FindBy(xpath="//div[@class='order-number']") 
	WebElement orderNumber;
	

	
	public void verify_product() throws IOException
	{
		
		
		String p1_name_incart = p1.getText();
	    String p2_name_incart = p2.getText();
	    
	    System.out.println("Product_01 name_incart : "+p1_name_incart);
	    System.out.println("Product_02 name_incart : "+p2_name_incart);
	    
	   
	   p=BaseClass.getProperties();
	   assertEquals(p1_name_incart, p.getProperty("productName_01"));
	   assertEquals(p2_name_incart,  p.getProperty("productName_02"));
	}
	
	
	public void checkout()
	{
		checkbox.click();
		checkout.click();
	}
	
	public void fn()
	{
		firstName.clear();
		firstName.sendKeys(BaseClass.randomeString());
	}
	public void ln()
	{
		lastName.clear();
		lastName.sendKeys(BaseClass.randomeString());
	}
	public void email() throws InterruptedException
	{
		
		email.sendKeys(BaseClass.randomAlphaNumeric()+"@gmail.com");
	Thread.sleep(3000);
	}
	
	public void country() throws InterruptedException
	{
		WebElement dropdown = country;
		Select abc=new Select(dropdown);
		abc.selectByVisibleText("India");
		Thread.sleep(3000);
		
	}
	
	public void city()
	{
		
		city.sendKeys(BaseClass.randomeString());
	
	}
	public void addr()
	{
		
		address1.sendKeys(BaseClass.randomeString());
	
	}
	public void zip()
	{
		
		PostalCode.sendKeys(BaseClass.randomeNumber());
	
	}
	public void ph()
	{
		
		phoneNumber.sendKeys(BaseClass.randomeNumber());
	
	}
	public void contine1()
	{
		
		continu1.click();
	}
	
	public void contine2()
		{
			
			continu2.click();
		
		}
	public void contine3()
	{
		
		continu3.click();
	}
	public void contine4()
	{
		
		continu4.click();
	}
	public void confirm()
	{
		
		confirm.click();
	}
	
	public void successMessage()
	{
		
		String successMessage= OrderSuccessful.getText();
		assertEquals(successMessage, "Your order has been successfully processed!");
		System.out.println("Status of the Order : "+successMessage);
	}
	public void ordernum()
	{
		
		String ordernum= orderNumber.getText();
		System.out.println(ordernum);
	}
	

}
