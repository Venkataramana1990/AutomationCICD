package Steaphenrahul;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;


public class StandAloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String Productname = "ZARA COAT 3";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("steaphenrahul3@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Rahul@1996");
		driver.findElement(By.id("login")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		List<WebElement> Products = driver.findElements(By.cssSelector(".mb-3"));
		WebElement prod = Products.stream().filter(Product->Product.findElement(By.cssSelector("b")).getText().equals(Productname)).findFirst().orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		List <WebElement>cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean match = cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(Productname));
		Assert.assertTrue(match);
		driver.findElement(By.cssSelector("li[class='totalRow'] button[type='button']")).click();
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "India").build().perform();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".ta-results"))));
		driver.findElement(By.cssSelector(".ta-item:last-of-type")).click();
		WebElement element = driver.findElement(By.cssSelector("a.btnn.action__submit.ng-star-inserted"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().perform();
		String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(confirmMessage));
		
	}

}
