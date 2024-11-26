package Steaphenrahul.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Steaphenrahul.Landingpage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class baseTest {

	
	public WebDriver driver;
	
	public Landingpage landingPage;
	public WebDriver initializationDriver() throws IOException {
	
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"//src/main/java/Steaphenrahul/resources/Globaldata.properties");
		prop.load(file);
		String broswername =System.getProperty("browser")!=null ?System.getProperty("browser"): prop.getProperty("broswer");
		//String broswername = prop.getProperty("broswer");
		
		if(broswername.contains("chrome")) {
			
		ChromeOptions options = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		if(broswername.contains("headless")) {
		options.addArguments("headless");
		} 
		driver = new ChromeDriver(options);
		driver.manage().window().setSize(new Dimension(1440,900));//run in full screen
		}
		else if (broswername.equalsIgnoreCase("Edge")) {
			System.setProperty("WebDriver.driver.edge.driver", "Path");
		 driver = new EdgeDriver();
			
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		driver.manage().window().maximize();
		
		return driver;
	}
	
	@SuppressWarnings("deprecation")
	public static List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
	
		File file = new File(filePath);
	    //Reading Json to string
		String JsonData = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
		
		//String JsonData = FileUtils.readFileToString(new File(System.getProperty("user.dir")+"//src//test//java//Steaphenrahul//data//purchaseOrder.json").StandardCharsets.UTF_8);
		//Convert Json to Hashmap
		
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String,String>> data = mapper.readValue(JsonData,new TypeReference<List<HashMap<String, String>>>(){
			
		}); return data ;
	}
	
	public String getScreenshot(String testcasename, WebDriver driver) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File Source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir")+ "//reports//"+ testcasename + ".png");
		FileUtils.copyFile(Source, file);
		return System.getProperty("user.dir")+ "//reports//"+ testcasename + ".png";
	}

		
		
		@BeforeMethod(alwaysRun = true)
		public Landingpage launchApplication() throws IOException {
			driver = initializationDriver();
			landingPage = new Landingpage(driver);
			landingPage.goTo();
			return landingPage;
		}
		
		@AfterMethod(alwaysRun = true)
		 public void teardown() {
			driver.close();
		}
		
		
	
	}

