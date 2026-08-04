package Test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UiTest {
	
	public static void main(String[]args) throws InterruptedException {
		
		String ProductName="ZARA COAT 3";
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@placeholder='email@example.com']")).sendKeys("naveengr653@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='enter your passsword']")).sendKeys("Test@Practice1");
		driver.findElement(By.xpath("//input[@name='login']")).click();
		
		//To Click on product add cart
 		driver.findElement(By.xpath("(//b[text()='"+ProductName+"']/following::button[text()=' Add To Cart'])[1]")).click();
		
		//Rahulshetty
//		List<WebElement> Products=driver.findElements(By.xpath("//div[contains(@class,'col-lg-4')]"));
//		WebElement Prod = Products.stream().filter(Product->Product.findElement(By.xpath("//b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
//		Prod.findElement(By.xpath("//button[text()=' Add To Cart']")).click();
 		Thread.sleep(2000);
 		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
// 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='toast-container']")));
 		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
 		driver.findElement(By.xpath("//button[contains(text(),'Cart')]")).click();
 		List<WebElement> CartProducts = driver.findElements(By.xpath("//div[@class='cartSection']/h3"));
 		boolean IsProdAvailable = CartProducts.stream().anyMatch(CartProduct->CartProduct.getText().equalsIgnoreCase(ProductName));
 		Assert.assertTrue(IsProdAvailable);
 		driver.findElement(By.xpath("//button[text()='Checkout']")).click();
 		Actions act=new Actions(driver);
 		act.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")), "india").build().perform();
 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class,'list-group-item')]")));
 		driver.findElement(By.xpath("//button/following::span[text()=' India']")).click();
 		driver.findElement(By.xpath("//a[text()='Place Order ']")).click();
 		boolean IsThankYouTextShown = driver.findElement(By.xpath("//h1[text()=' Thankyou for the order. ']")).isDisplayed();
 		Assert.assertTrue(IsThankYouTextShown);
 		driver.findElement(By.xpath("//td//label[text()=' Orders History Page ']")).click();
 		Thread.sleep(10000);
 		
 		driver.quit();
		
	}

}
