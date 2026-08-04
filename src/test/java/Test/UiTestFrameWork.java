package Test;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BaseTest;
import Base.Retry;
import Pages.CartPage;
import Pages.CheckOutPage;
import Pages.ConfirmationPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.OrderHistoryPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class UiTestFrameWork extends BaseTest{
	
//	String UserName="naveengr653@gmail.com";
//	String Password="Test@Practice1";
	String OrderID="";
	
		
		@Test(dataProvider="data2")
		public void PlaceOrderandVerifyHistoryPage(HashMap<String,String> input) throws IOException, InterruptedException{
		
//		String ProductName="ZARA COAT 3";
		String Country="India";
		
		LoginPage LP = new LoginPage(driver);
		
		LP.OpenUrl("https://rahulshettyacademy.com/client");
		HomePage HP = LP.Login(input.get("UserName"), input.get("Password"));		
		HP.AddProductToCart(input.get("ProductName"));		
		CartPage CP = HP.OpenCartPage();
		Assert.assertTrue(CP.CheckProductShown(input.get("ProductName")));
		CheckOutPage COP = CP.OpenCheckOutPage();
		COP.SelctCountry(Country);
		ConfirmationPage ConP = COP.OpenOrderConfiramtionPage();
		Assert.assertTrue(ConP.OderIsPlaced());
		OrderID = ConP.getOrderId();
		System.out.println(OrderID);
		OrderHistoryPage OH = ConP.OpenOrderHistoryPage();
		boolean IsOderShownInHistoryPageGrid = OH.IsOderPrecentGrid(OrderID);
		Assert.assertTrue(IsOderShownInHistoryPageGrid);
		
	}
//		@Test(dependsOnMethods={"PlaceOrderandVerifyHistoryPage"})
//		public void VerifyOrderInHistoryPage() throws InterruptedException {
//			
//			String UserName="naveengr653@gmail.com";
//			String Password="Test@Practice1";
//			
//			LoginPage LP = new LoginPage(driver);
//			
//			LP.OpenUrl("https://rahulshettyacademy.com/client");
//			LP.Login(UserName, Password);
//			OrderHistoryPage OH = LP.gotoOrderHistory();
//			System.out.println(OrderID);
//			boolean IsOderShownInHistoryPageGrid = OH.IsOderPrecentGrid(OrderID);
//			Assert.assertTrue(IsOderShownInHistoryPageGrid);
//		}

		
//		@DataProvider(name="data")
//		public Object[][] getdata() {
//		
//			return new Object [][] {
//				{"naveengr653@gmail.com","Test@Practice1","ZARA COAT 3"},
//				{"anshika@gmail.com","Iamking@000","ADIDAS ORIGINAL"}
//			};
//			
//		}
		
		@DataProvider(name="data2")
		public Object[][] getdata2() {
		HashMap<String,String> map1=new HashMap<String,String>();
		map1.put("UserName", "naveengr653@gmail.com");
		map1.put("Password", "Test@Practice1");
		map1.put("ProductName", "ADIDAS ORIGINAL");
		
		HashMap<String,String> map2=new HashMap<String,String>();
		map2.put("UserName", "naveen.can@gmail.com");
		map2.put("Password", "Test@123");
		map2.put("ProductName", "ZARA COAT 3");
		
		return new Object[][] {{map1},{map2}};
		
		}
}
