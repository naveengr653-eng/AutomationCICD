package Utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.CartPage;
import Pages.OrderHistoryPage;

public class ReUsableFunctions {
	
	WebDriver driver;
	WebDriverWait wait;

	public ReUsableFunctions(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[contains(text(),'Cart')]")
	WebElement CartButton;
	@FindBy(xpath="//button[contains(text(),'ORDERS')]")
	WebElement OrdersButton;
	
	public void OpenUrl(String URL) {
		driver.get(URL);
	}
	
	public void SetTesxtBasedOnPlaceHolder(String PlaceHolderValue, String InputText) {
		WebElement element = driver.findElement(By.xpath("//input[@placeholder='"+PlaceHolderValue+"']"));
		element.sendKeys(InputText);
	}
	
	public void WaitForElementToDisapear(WebElement Element) {
		wait.until(ExpectedConditions.invisibilityOf(Element));
	}
	
	public void WaitForElementToApear(WebElement Element) {
 		wait.until(ExpectedConditions.visibilityOf(Element)); 		
	}
	
	public void WaitForElementToApearBy(By Element) {
 		wait.until(ExpectedConditions.visibilityOfElementLocated(Element));		
	}
	
	public void WaitForElementtoClick(WebElement Element) {
		wait.until(ExpectedConditions.elementToBeClickable(Element));
	}
	
	public void WaitandSwithtoFrame() {
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
				By.cssSelector("iframe.razorpay-checkout-frame")));
	}
	
	public CartPage OpenCartPage() {
		CartButton.click();
		return new CartPage(driver);
	}
	
	public OrderHistoryPage gotoOrderHistory() {
		OrdersButton.click();
		return new OrderHistoryPage(driver);
	}
	
	public void switchToChaildWindow() {
		String ParentWindow= driver.getWindowHandle();
		Set<String> allWindows=driver.getWindowHandles();
		for(String NewWindow:allWindows) {
			if(!NewWindow.equals(ParentWindow)) {
				driver.switchTo().window(NewWindow);
			}
			break;
		}
	}
}
