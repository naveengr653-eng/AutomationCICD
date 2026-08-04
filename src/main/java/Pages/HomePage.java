package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.ReUsableFunctions;



public class HomePage extends ReUsableFunctions{
	
	WebDriver driver;

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".ng-animating")
	WebElement Spinner;
	@FindBy(xpath="//a[text()='Get Shortlisted by Recruiters - Take QA Skill Assessments on TechSmartHire']")
	WebElement NewTab;
	@FindBy(xpath="//a[text()='Jobs']")
	WebElement JobButton;
	@FindBy(xpath="//button[@aria-label='Close popup']")
	WebElement ClosePopUp;

	public void AddProductToCart(String ProductName) throws InterruptedException {
		WaitForElementtoClick(driver.findElement(By.xpath("//button[text()=' Add To Cart']")));
		driver.findElement(By.xpath("(//b[text()='"+ProductName+"']/following::button[text()=' Add To Cart'])[1]")).click();
		WaitForElementToDisapear(Spinner);
		Thread.sleep(5000);
	}
	
	public void OpenNewTab() {
		WaitForElementtoClick(NewTab);
		NewTab.click();
		switchToChaildWindow();
		WaitandSwithtoFrame();
//		WaitForElementtoClick(ClosePopUp);
//		ClosePopUp.click();
		WaitForElementtoClick(JobButton);
		JobButton.click();
	}
	
}
