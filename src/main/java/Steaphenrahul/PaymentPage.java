package Steaphenrahul;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Steaphenrrahul.AbstractComponenents.AbstractComponents;

public class PaymentPage extends AbstractComponents{
	
	public PaymentPage(WebDriver driver){
		super(driver);
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(css= "[placeholder='Select Country']")
	WebElement Country;
	@FindBy(css= ".ta-item:last-of-type")
	WebElement CountrySelection;
	@FindBy(css="a.btnn.action__submit.ng-star-inserted")
	WebElement submit;
	
	
	
	public void selectCountry(String countryName) {
		Actions a = new Actions(driver);
		a.sendKeys(Country, countryName).build().perform();
		CountrySelection.click();
		
	}
	
	public confirmationPage submitButton() {
		WebElement element = submit;
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().perform();
		return new confirmationPage(driver);
	}
	
}
