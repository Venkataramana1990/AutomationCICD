package Steaphenrahul.stepDefintions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;

import Steaphenrahul.Landingpage;
import Steaphenrahul.PaymentPage;
import Steaphenrahul.ProductCataloguePage;
import Steaphenrahul.cartpage;
import Steaphenrahul.confirmationPage;
import Steaphenrahul.TestComponents.baseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class StepDefinitions extends baseTest{
	
	public Landingpage landingpage;
	public ProductCataloguePage  productCatalogue;
	public confirmationPage ConfirmationPage;
	@Given("I landed on the Ecommerce Page")
	public void I_landed_on_the_Ecommerce_Page(	) throws IOException {
		
		landingpage = launchApplication();
		
	}
	
	@Given ("^Logged in with Username (.+) and password (.+)$")
	public void Logged_in_Username_and_Password(String Username, String password) {
		ProductCataloguePage productCatalogue =landingPage.loginapplication(Username, password);
		
	}
	
	//When I add the <productname> to Cart
	@When("^I add the (.+) to Cart$")
	public void Add_Product_to_Cart(String productname ) throws InterruptedException {
		List<WebElement>Products = productCatalogue.getProductlist();
		productCatalogue.addProductToCart(productname);
		
	}
	
    //And Checkout <productname> and submit the Order
	@When ("^Checkout (.+) and submit the Order$")
	public void Checkout_and_Submit(String productName) throws InterruptedException {
		cartpage CartPage = productCatalogue.goToCartPage();
		Boolean match = CartPage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
		PaymentPage paymentpage = CartPage.goToCheckOutPage();
		paymentpage.selectCountry("India");
		ConfirmationPage = paymentpage.submitButton();
		
	}
	
	//Then "THANKYOU FOR THE ORDER." message is displayed in the Confirmation page
	@Then("{string} message is displayed in the Confirmation page")
		public void message_displayed_confirmationPage(String string) throws InterruptedException {
		String confirmMessage= ConfirmationPage.getConfirmMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));	
		
	}
	
	@Then ("^\"([^\"]*)\"message is displayed")
	public void  Incorrect_Username_Password_message_Is_Displayed(String strg21){
		AssertJUnit.assertEquals(strg21,landingPage.getErrorMessage());
		driver.close();
		}
}
