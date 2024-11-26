package Steaphenrahul;



import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Steaphenrrahul.AbstractComponenents.AbstractComponents;


public class cartpage extends AbstractComponents {


	public cartpage(WebDriver driver){
		super(driver);
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".cartSection h3")
	private List <WebElement> producTitles;
	
	@FindBy(css = "li[class='totalRow'] button[type='button']")
	WebElement checkoutelement;
	
	public Boolean VerifyProductDisplay(String Productname) {
		
		Boolean match = producTitles.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(Productname));
		return match;
	}
	
	//driver.findElement(By.cssSelector("li[class='totalRow'] button[type='button']")).click();
	public PaymentPage goToCheckOutPage() {
		checkoutelement.click();
		return new PaymentPage(driver);
	}
	
	
}
