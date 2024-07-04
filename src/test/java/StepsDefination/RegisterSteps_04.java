package StepsDefination;

import org.junit.Assert;

import PageObjects.HomePage;
import PageObjects.RegisterPage_04;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import utiles.BaseClass;

public class RegisterSteps_04 {
	
	HomePage hp;
	RegisterPage_04 rp;

	@Given("user land on register page")
	public void user_land_on_register_page() {
		hp=new HomePage(BaseClass.getDriver());
		hp.clickRegister();
		
	    
	}

	@When("enter all required fields \\(lastname: {string},Password: {string})")
	public void enter_all_required_fields_firstname_lastname_email_password( String ln,  String pass) throws InterruptedException {
		rp=new RegisterPage_04(BaseClass.getDriver());
	    rp.radiobutton();
	    rp.firstname();
	    rp.lastname(ln);
	    rp.email();
	    rp.password(pass);
	    rp.confirmpass(pass);
	    rp.setDOB();
	    
	    
	    
	}

	@When("click on register button")
	public void click_on_register_button() {
		rp=new RegisterPage_04(BaseClass.getDriver());
		rp.clickRegister();
	    
	}

	@Then("confirm the redireted confirmation page")
	public void confirm_the_redireted_confirmation_page() {
		rp=new RegisterPage_04(BaseClass.getDriver());
		Assert.assertEquals(rp.status(), true);
		
	    
	}

}
