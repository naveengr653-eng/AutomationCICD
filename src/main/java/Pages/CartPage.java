package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.ReUsableFunctions;

public class CartPage extends ReUsableFunctions{
	
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='cartSection']/h3")
	WebElement CartProducts;
	@FindBy(xpath="//button[text()='Checkout']")
	WebElement CheckOutButton;
	
	public boolean CheckProductShown(String ProductName) {
		WaitForElementToApear(CartProducts);
 		boolean ProductShown = driver.findElement(By.xpath("//div[@class='cartSection']/h3[normalize-space()='"+ProductName+"']")).isDisplayed();
 		return ProductShown;
	}
	
	public CheckOutPage OpenCheckOutPage() {
		CheckOutButton.click();
		return new CheckOutPage(driver);
	}

}
