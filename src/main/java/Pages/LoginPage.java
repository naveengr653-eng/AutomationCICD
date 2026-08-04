package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.ReUsableFunctions;

public class LoginPage extends ReUsableFunctions{
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
				super(driver);
				this.driver=driver;
		PageFactory.initElements(driver,this);			
	}
	
	
	@FindBy(xpath="//input[@name='login']")
	WebElement LoginButton;
	@FindBy(xpath="//div[@class='card']")
	WebElement Items;
	By errorMsg=By.xpath("//div[contains(@class,'toast-message')]");
	
	public void OpenLoginPage(String URL) {		
		OpenUrl(URL);		
	}
	
	public HomePage Login(String UserName,String Password) throws InterruptedException {
		SetTesxtBasedOnPlaceHolder("email@example.com", UserName);
		SetTesxtBasedOnPlaceHolder("enter your passsword", Password);
		WaitForElementtoClick(LoginButton);
		LoginButton.click();
		WaitForElementToApear(Items);
		return new HomePage(driver);
	}
	
	public String getErrorMsg() {
		WaitForElementToApearBy(errorMsg);
		return (driver.findElement(errorMsg).getText());

	}

}
