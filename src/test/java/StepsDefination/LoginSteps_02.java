package StepsDefination;



import org.junit.Assert;
import org.openqa.selenium.WebDriver;



import PageObjects.LoginPage_02;
import PageObjects.MyAccountPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import PageObjects.HomePage;
import utiles.BaseClass;


public class LoginSteps_02 {
	
WebDriver driver;
HomePage hp;
LoginPage_02 lp;
MyAccountPage macc;


//List<HashMap<String, String>> datamap; //Data driven
	
	@Given("the user is on the nopCommerce login page")
	public void the_user_is_on_the_nop_commerce_login_page() {
		hp=new HomePage(BaseClass.getDriver());
    	hp.clickLogin();
	   
		System.out.println("***** Testing Start *****");
		
	}

	@When("the user enters valid credentials \\(username: {string}, password: {string})")
	public void the_user_enters_valid_credentials_username_password(String email, String pwd) {
	   
		lp=new LoginPage_02(BaseClass.getDriver());
       	lp.setEmail(email);
        lp.setPassword(pwd);
        lp.clickLogin();
	}

	@When("the user clicks on the Login button")
	public void the_user_clicks_on_the_login_button() {
		
		System.out.println("***** Alreay hit the login button *****");
	}

	@Then("the user should be redirected to the My Account page")
	public void the_user_should_be_redirected_to_the_my_account_page() {
		
		macc=new MyAccountPage(BaseClass.getDriver());
		boolean targetpage=macc.isMyAccountPageExists();
				
		Assert.assertEquals(targetpage, true);
		
		
	}

	@Then("the user should see a welcome message")
	public void the_user_should_see_a_welcome_message() {
		macc.welcomeStatus();
		macc.clickLogout();
		
	}
	
	@Given("chrome setup")
	public void chrome_setup() {
		
		System.out.println("***** Into the driver *****");
	}

	@When("Enter the URL")
	public void enter_the_url() {
		System.out.println("***** Into the URL *****");
	}

    @When("Click on Login")
    public void click_on_login() {
  
    	System.out.println("***** Into the login *****");
    }
	
  

}
