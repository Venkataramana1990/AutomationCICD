package Steaphenrahul;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Steaphenrrahul.AbstractComponenents.AbstractComponents;

public class confirmationPage extends AbstractComponents {
	
	public confirmationPage(WebDriver driver){
		super(driver);
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}
	
	//String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
	
	@FindBy(css=".hero-primary")
	WebElement confirmationMessage;
	
	public String getConfirmMessage() {
		return confirmationMessage.getText();
	}

}
