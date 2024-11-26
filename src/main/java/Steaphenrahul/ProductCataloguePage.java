package Steaphenrahul;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Steaphenrrahul.AbstractComponenents.AbstractComponents;

public class ProductCataloguePage extends AbstractComponents {
	WebDriver  driver;
	
	public ProductCataloguePage(WebDriver driver){
	super(driver);
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css = ".mb-3")
	List<WebElement> Products;	
	
	@FindBy(css = ".ng-animating")
	WebElement spinner;
	
	By productsBy = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastContainer = By.id("toast-container");
	
	public List<WebElement> getProductlist() {
		waitForElementtoAppear(productsBy);
		return Products;
	}
	
	public WebElement getProductByName(String Productname) {
		WebElement prod = getProductlist().stream().filter(Product->
		Product.findElement(By.cssSelector("b")).getText().equals(Productname)).findFirst().orElse(null);
		return prod;
	}
	
	public void addProductToCart(String Productname) throws InterruptedException {
		WebElement prod = getProductByName(Productname);
		waitForElementtoAppear(toastContainer);
		waitForElementToDissapear(spinner);
		prod.findElement(addToCart).click();
		
		
	}

}
