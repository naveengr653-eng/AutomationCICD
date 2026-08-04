package Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Base.Retry;
import Pages.HomePage;
import Pages.LoginPage;

public class InvalidLogin extends BaseTest{

	@Test(groups= {"InvalidLogin"},retryAnalyzer=Retry.class)
	public void VerifyInvalidLogin() throws IOException, InterruptedException{
	
	String UserName="naveengr653@gmail.com";
	String Password="Test@Practice2";
	
	LoginPage LP = new LoginPage(driver);
	
	LP.OpenUrl("https://rahulshettyacademy.com/client");
	HomePage HP = LP.Login(UserName, Password);
	String ActhualErrorMsg = LP.getErrorMsg();
	Assert.assertEquals(ActhualErrorMsg, "Incorrect email or password.");
}
}
