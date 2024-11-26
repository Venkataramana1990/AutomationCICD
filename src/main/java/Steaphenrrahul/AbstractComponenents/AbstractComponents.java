package Steaphenrrahul.AbstractComponenents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Steaphenrahul.cartpage;

public class AbstractComponents {
    public WebDriver driver;
	public AbstractComponents(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css = "[routerlink*='cart']")
	WebElement cartHeader;
	
	@FindBy(css = "[routerlink*='myorders']")
	WebElement orderPage;
	
	@FindBy(css = ".ng-animating")
	WebElement animation;
	
	//driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
	
	public void waitForElementtoAppear(By findBy) {
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	
}
	public void waitForWebElementtoAppear(WebElement findBy) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}
	
	public void waitForElementToDissapear(WebElement element) throws InterruptedException {
		Thread.sleep(1000);
		/*wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(element));*/
	}
	
	public cartpage goToCartPage() throws InterruptedException {
	waitForElementToDissapear(animation);
	cartHeader.click();
	cartpage CartPage = new cartpage(driver);
	return CartPage;
	}
	public OrderPage goToOrdersPage() throws InterruptedException {
		waitForElementToDissapear(animation);
		orderPage.click();
		OrderPage orderPage = new OrderPage(driver);
		return orderPage;
		}
	
	}
