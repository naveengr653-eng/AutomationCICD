package Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public static WebDriver driver;
	public static String browser;
	
	public WebDriver InitiateDriver() throws IOException {
		
		Properties prop=new Properties();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\Properties\\Data.properties");
		prop.load(file);
		browser = System.getProperty("Browser") !=null ? System.getProperty("Browser") : prop.getProperty("Browser");
//		browser = prop.getProperty("Browser");
//		switch (browser){
//		
//		case "chrome" : 
//			WebDriverManager.chromedriver().setup();
//			driver=new ChromeDriver();
//			break;
//			
//		case "firefox" :
//			WebDriverManager.firefoxdriver().setup();
//			driver=new FirefoxDriver();
//			break;
//		
//		case "edge" :
//			WebDriverManager.edgedriver().setup();
//			driver=new EdgeDriver();
//			break;
//			
//		default:
//	        throw new IllegalArgumentException("Browser not supported: " + browser);
//			
//		}
		if(browser.contains("chrome")) {
			ChromeOptions options=new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			if(browser.contains("headless")) {
				options.addArguments("headless");
				options.addArguments("--window-size=1440,900");
			}
			driver=new ChromeDriver(options);
		
		}else if(browser.contains("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		
		}else if(browser.contains("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		if(!browser.contains("headless")) {
		driver.manage().window().maximize();
		}
		return driver;
	}
	
	@BeforeMethod(alwaysRun=true)
    public void launchBrowser() throws IOException {
        driver = InitiateDriver();
    }

    @AfterMethod(alwaysRun=true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
