package Steaphenrrahul.AbstractComponenents;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage extends AbstractComponents {
		public OrderPage(WebDriver driver){
		super(driver);
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}
	

	@FindBy(css = ".tr td:nth-child(3)")
	private List <WebElement> ProductNames;

		

		public boolean VerifyOrderDisplay(String Productname) {
			Boolean match = ProductNames.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(Productname));
			return match;
		}
}
