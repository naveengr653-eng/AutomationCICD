package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.ReUsableFunctions;

public class ConfirmationPage extends ReUsableFunctions{
	
	WebDriver driver;

	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1")
	WebElement Messageshown;
	@FindBy(xpath="//h1[text()=' Thankyou for the order. ']")
	WebElement ThankyouMessage;
	@FindBy(xpath="//td[@class='em-spacer-1']/label[@class='ng-star-inserted']")
	WebElement Orderid;
	@FindBy(xpath="//td//label[text()=' Orders History Page ']")
	WebElement HistoryPageLink;
	@FindBy(xpath="//button[text()='Go Back to Cart']")
	WebElement HistoryLoad;
	
	public boolean OderIsPlaced() {
		WaitForElementToApear(Messageshown);
		boolean OrderSuccess = ThankyouMessage.isDisplayed();
		return OrderSuccess;
	}
	
	public String getOrderId() {
		String text=Orderid.getText();
		String id = text.replace("|", "").trim();
		return id;
	}
	
	public OrderHistoryPage OpenOrderHistoryPage() {
		HistoryPageLink.click();
		WaitForElementToApear(HistoryLoad);
		return new OrderHistoryPage(driver);
	}
	
}
