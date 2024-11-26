package Steaphenrahul;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Steaphenrahul.TestComponents.baseTest;
import Steaphenrrahul.AbstractComponenents.OrderPage;


public class SubmitOrdertest extends baseTest {
	//String Productname = "ZARA COAT 3";
	
	@Test(dataProvider = "getData")
	public void submitorder(HashMap<String,String> input) throws IOException, InterruptedException {
		
		
		String countryName = "India";
		ProductCataloguePage productCatalogue =landingPage.loginapplication(input.get("email"), input.get("password"));
		List<WebElement>Products = productCatalogue.getProductlist();
		productCatalogue.addProductToCart(input.get("Productname"));
		cartpage CartPage = productCatalogue.goToCartPage();
		Boolean match = CartPage.VerifyProductDisplay(input.get("Productname"));
		Assert.assertTrue(match);
		PaymentPage paymentpage = CartPage.goToCheckOutPage();
		paymentpage.selectCountry(countryName);
		confirmationPage ConfirmationPage = paymentpage.submitButton();
		String confirmMessage= ConfirmationPage.getConfirmMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
	}
	
	
	/*@Test(dependsOnMethods = {"submitorder"})
	
	public void orderHistoryTest() throws InterruptedException {
		
		ProductCataloguePage productCatalogue =landingPage.loginapplication("steaphenrahul3@gmail.com", "Rahul@1996");
		OrderPage orderPage =productCatalogue.goToOrdersPage();
		Assert.assertFalse(orderPage.VerifyOrderDisplay(Productname));
	}*/
@DataProvider
public Object[][] getData() throws IOException {
	/*HashMap<String, String> map = new HashMap<String, String>();
	map.put("email", "steaphenrahul3@gmail.com");
	map.put("password", "Rahul@1996");
	map.put("Productname", "ZARA COAT 3");
	
	HashMap<String, String> map1 = new HashMap<String, String>();
	map1.put("email", "swarnarahul96@gmail.com");
	map1.put("password", "Rahul@1996");
	map1.put("Productname", "ADIDAS ORIGINAL");*/
	
	List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//Steaphenrahul//data//purchaseOrder.json");
	
	return new Object[][] {{data.get(0)},{data.get(1)}};
}
}
