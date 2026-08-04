package Test;

import java.io.IOException;

import org.testng.annotations.Test;

import Base.BaseTest;
import Base.Retry;
import Pages.HomePage;
import Pages.LoginPage;

public class SwitchTab extends BaseTest{

	@Test
	public void SwitchtoNewTab() throws IOException, InterruptedException{
	
	String UserName="naveengr653@gmail.com";
	String Password="Test@Practice1";
	
	LoginPage LP = new LoginPage(driver);
	
	LP.OpenUrl("https://rahulshettyacademy.com/client");
	HomePage HP = LP.Login(UserName, Password);
	HP.OpenNewTab();
	System.out.println("Pass");
	Thread.sleep(10000);
	
}
}
