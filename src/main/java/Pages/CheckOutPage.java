package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.ReUsableFunctions;

public class CheckOutPage extends ReUsableFunctions{
	
	WebDriver driver;
	
	public CheckOutPage(WebDriver driver) {
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement CountryField;
	@FindBy(xpath="//button[contains(@class,'list-group-item')]")
	WebElement Country;
	@FindBy(xpath="//a[text()='Place Order ']")
	WebElement PlaceOrderButton;
	
	public void SelctCountry(String CountryName) {
		Actions act=new Actions(driver);
 		act.sendKeys(CountryField, CountryName).build().perform();
 		WaitForElementToApear(Country);
 		driver.findElement(By.xpath("//button/following::span[normalize-space()='" + CountryName + "']")).click();
	}

	public ConfirmationPage OpenOrderConfiramtionPage() {
		PlaceOrderButton.click();
		return new ConfirmationPage(driver);
	}
	
}
