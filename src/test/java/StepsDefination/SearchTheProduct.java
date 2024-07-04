package StepsDefination;

import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;

import PageObjects.CartPage;
import PageObjects.HomePage;
import PageObjects.LoginPage_02;
import PageObjects.MyAccountPage;
import PageObjects.Searched_product_page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utiles.BaseClass;

public class SearchTheProduct {
	HomePage hp;
	CartPage cp;
	LoginPage_02 lp;
	Properties p;
	Searched_product_page sp;
	MyAccountPage macc;
	
	
	@Given("Login")
	public void Login() throws IOException {
		hp=new HomePage(BaseClass.getDriver());
		lp=new LoginPage_02(BaseClass.getDriver());
		macc=new MyAccountPage(BaseClass.getDriver());
		p = BaseClass.getProperties();
		hp.clickLogin();
       	lp.setEmail(p.getProperty("email"));
        lp.setPassword(p.getProperty("password"));
        lp.clickLogin();
        
        macc.welcomeStatus();
        
	}

	
	@Given("search and Add_to_cart the product")
	public void search_and_add_to_cart_the_product() throws  IOException, InterruptedException {
		sp=new Searched_product_page(BaseClass.getDriver());
		
		sp.SearchProduct_01();
		sp.setQuantity();
		sp.Addtocart();
		System.out.println("p1 ok");
		
		sp.SearchProduct_02();
		sp.Addtocart();
		System.out.println("p2 ok");
		sp.ShoppingCart();
	}

	@When("verify the Add_to_cart product")
	public void verify_the_add_to_cart_product() throws InterruptedException, IOException {
		
		cp=new CartPage(BaseClass.getDriver());
		cp.verify_product();
		Thread.sleep(3000);

	}

	@When("checkout the product")
		public void checkout_the_product() throws InterruptedException {
			
			cp.checkout();
			Thread.sleep(3000);
		}

	@Then("Fill the address")
		public void fill_the_address1() throws InterruptedException {
			cp.fn();
			cp.ln();
			//cp.email();
			cp.country();
			cp.city();
			cp.addr();
			cp.zip();
			cp.ph();
			cp.contine1();
			cp.contine2();
			cp.contine3();
			cp.contine4();
			cp.confirm();
		}

	@Then("verify the order")
	public void verify_the_order() {
		cp.successMessage();
		cp.ordernum();
	}


	}


