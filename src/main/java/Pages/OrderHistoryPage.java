package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.ReUsableFunctions;

public class OrderHistoryPage extends ReUsableFunctions{
	
	WebDriver driver;

	public OrderHistoryPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//table/tbody/tr")
	List<WebElement> OrderRows;
	
	public boolean IsOderPrecentGrid(String expectedOrderId) {
		System.out.println(OrderRows.size());
		for (WebElement row : OrderRows) {
	        String orderId = row.findElement(By.xpath("th")).getText().trim();
	        if (orderId.equalsIgnoreCase(expectedOrderId)) {
	            return true;
	        }
	    }
	    return false;
	}
	
}
