package StepDef;

import org.testng.Assert;

import Base.BaseTest;
import Pages.CartPage;
import Pages.CheckOutPage;
import Pages.ConfirmationPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.OrderHistoryPage;
import Utils.ReUsableFunctions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PlaceOrderSD extends BaseTest{

	ReUsableFunctions rf;
	LoginPage LP;
	HomePage HP;
	CartPage CP;
	CheckOutPage COP;
	ConfirmationPage ConP;
	OrderHistoryPage OH;
	
	String OrderID;
	
	@Given("Land on login page")
	public void Land_on_login_page() {
		LP= new LoginPage(driver);
		LP.OpenUrl("https://rahulshettyacademy.com/client");
	}
	
	@Given("^Login with username (.+) and password (.+)$")
	public void Login_with_username_and_password(String username, String password) throws InterruptedException {
		 HP= LP.Login(username,password);
	}
	
	@When("^Add the product (.+) to cart and checkout with country (.+)$")
	public void Add_the_product_to_cart_and_checkout(String productName,String country) throws InterruptedException {
		 HP.AddProductToCart(productName);
		 CP = HP.OpenCartPage();
		Assert.assertTrue(CP.CheckProductShown(productName));
		 COP = CP.OpenCheckOutPage();
		 COP.SelctCountry(country);
	}
	
	@When("Confirm the order")
	public void Confirm_the_order() {
		 ConP = COP.OpenOrderConfiramtionPage();
		Assert.assertTrue(ConP.OderIsPlaced());
		OrderID = ConP.getOrderId();
	}
	
	@Then("Check order is avilable in history page")
	public void Check_order_is_avilable_in_history_page() {
		 OH = ConP.OpenOrderHistoryPage();
		boolean IsOderShownInHistoryPageGrid = OH.IsOderPrecentGrid(OrderID);
		Assert.assertTrue(IsOderShownInHistoryPageGrid);
	}
	
	@Then("Check Validation has shown")
	public void Check_Validation_has_shown() {
		String ActhualErrorMsg = LP.getErrorMsg();
		Assert.assertEquals(ActhualErrorMsg, "Incorrect email or password.");
	}
	
	
}
