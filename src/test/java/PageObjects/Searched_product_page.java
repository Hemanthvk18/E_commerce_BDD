package PageObjects;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utiles.BaseClass;

public class Searched_product_page extends BasePage{
	
	public Searched_product_page(WebDriver driver) {
		super(driver);
	}
	
	Properties p;
	
	@FindBy(xpath="//span[@class='cart-label']") 
	WebElement shoppingCart;
	
	@FindBy(xpath="//input[@id='small-searchterms']") 
	WebElement txtSearchbox;
	
    @FindBy(xpath="//button[normalize-space()='Search']") 
    WebElement btnSearch;
    
//    @FindBy(xpath="//div[@class='details']/h2/a") 
//    List<WebElement> searchProduct;
     
    @FindBy(xpath="//button[@id='add-to-cart-button-18']") 
    WebElement addToCart;
    
    @FindBy(xpath="//input[@id='product_enteredQuantity_18']") 
    WebElement qty;
   // WebElement AddToCart =driver.findElement(By.xpath("//button[@id='add-to-cart-button-18']"));
    
    
    public void ShoppingCart()
	{
		shoppingCart.click();
		System.out.println("ShoppingCart is ok");
	}
	
	public void SearchProduct_01() throws IOException   //For Search Product Test
, InterruptedException
	{
		p=BaseClass.getProperties();
		txtSearchbox.sendKeys(p.getProperty("searchProductName_01"));
		btnSearch.click();
		
		String productName = p.getProperty("productName_01");
		List<WebElement> searchProduct=driver.findElements(By.xpath("//div[@class='details']/h2/a"));
		
		for(WebElement product: searchProduct)
		{				
			if(product.getText().equals(productName))
			{
				try {
				product.click();
				Thread.sleep(3000);
				System.out.println("product is ok");
				}
				catch (StaleElementReferenceException e) 
				{
					WebElement Product= driver.findElement(By.xpath("//div[@class='details']/h2/a"));
					Product.click();
					System.out.println("product is ok after stale element");
				}
			}
			
	   }
	}
	
	  public void Addtocart()
		{
		    addToCart.click();
			System.out.println("cart is ok");
		}
	
	
	public void SearchProduct_02() throws IOException    //For Search Product Test
, InterruptedException

	{
		
		p=BaseClass.getProperties();
		txtSearchbox.sendKeys(p.getProperty("searchProductName_02"));
        btnSearch.click();
        
        String productName = p.getProperty("productName_02");
		List<WebElement> searchProduct=driver.findElements(By.xpath("//div[@class='details']/h2/a"));
		
        for(WebElement product: searchProduct)
		{				
			if(product.getText().equals(productName))
			{
				product.click();
				Thread.sleep(3000);
			}
		}
  
	}
	
	public void setQuantity( )
	{
		try
		{
		qty.clear();
		qty.sendKeys(p.getProperty("set_qty_01"));
		System.out.println("qty is ok...");
	    }
		catch(StaleElementReferenceException e) 
		{
			WebElement Qtantity=driver.findElement(By.xpath("//input[@id='product_enteredQuantity_18']"));
			Qtantity.sendKeys(p.getProperty("set_qty_01"));
			System.out.println("qty is ok after stale element...");
		}
	}
}
//stale element reference: stale element not found
