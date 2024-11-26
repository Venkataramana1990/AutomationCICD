package Steaphenrahul;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Steaphenrrahul.AbstractComponenents.AbstractComponents;

public class Landingpage extends AbstractComponents {
	WebDriver  driver;
	public Landingpage(WebDriver driver){
		super(driver);
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}
	
	//WebElement userEmail = driver.findElement(By.id("userEmail"));
	//WebElement password = driver.findElement(By.id("userPassword"));
	
	//or PageFactory - @FindBy
	
	@FindBy(id = "userEmail")
	WebElement UserEmail;	
	@FindBy(id = "userPassword")
	WebElement Password;
	@FindBy(id = "login")
	WebElement Submit;
	@FindBy(xpath="//div[@id='toast-container']/div/div")
	WebElement errormessage;
	public ProductCataloguePage loginapplication(String Username, String password ) {
		
		UserEmail.sendKeys(Username);
		Password.sendKeys(password);
		Submit.click();
		ProductCataloguePage productCatalogue = new ProductCataloguePage(driver);
		return productCatalogue;
		
	}
	public String getErrorMessage() {
		waitForWebElementtoAppear(errormessage);
		return errormessage.getText();
	}
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}

}
