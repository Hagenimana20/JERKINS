package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExelReader;

public class LoginTest {

	WebDriver driver;
	
	ExelReader exelRead= new ExelReader("MyExelData\\ExelData.xlsx");
	String username= exelRead.getCellData("LoginData", "userName", 2);
	String password= exelRead.getCellData("LoginData", "Password", 2);

	@Test
	public void validUserShouldBeAbleToLogin() throws InterruptedException  {

		driver = BrowserFactory.init();

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(username);
		loginPage.insertPassword(password);
		loginPage.clickSigninButton();

		Thread.sleep(3000);
		
		BrowserFactory.tearDown();
		

		

	}

}
