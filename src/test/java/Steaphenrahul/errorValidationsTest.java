package Steaphenrahul;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import Steaphenrahul.TestComponents.baseTest;
import junit.framework.Assert;

@SuppressWarnings("restriction")
public class errorValidationsTest extends baseTest {
	@SuppressWarnings("unchecked")
	@Test
			public void LoginErrorValidation() throws IOException, InterruptedException {
		
		String Productname = "ZARA COAT 3";
		String countryName = "India";
		landingPage.loginapplication("steaphenrahul3@gmail.com", "Rahul@1997");
		AssertJUnit.assertEquals("Incorrect email or password.",landingPage.getErrorMessage());
		
	}
	@Test
	public void ProducterrorValidationsTest()throws IOException, InterruptedException {
		String Productname = "ZARA COAT 3";
		String countryName = "India";
		ProductCataloguePage productCatalogue =landingPage.loginapplication("swarnarahul96@gmail.com", "Rahul@1996");
		List<WebElement>Products = productCatalogue.getProductlist();
		productCatalogue.addProductToCart(Productname);
		cartpage CartPage = productCatalogue.goToCartPage();
		Boolean match = CartPage.VerifyProductDisplay("ZARA COAT 3");
		Assert.assertTrue(match);
	}

}
