package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.LoginPage;
import page.ProfilePage;
import util.BrowserFactory;
import util.ExelReader;

public class AddCustomerTest {

	WebDriver driver;

	ExelReader exelRead = new ExelReader("MyExelData\\ExelData.xlsx");
	String username = exelRead.getCellData("LoginData", "userName", 2);
	String password = exelRead.getCellData("LoginData", "Password", 2);
	String fullname = exelRead.getCellData("AddContactData", "FullName", 2);
	String companyname = exelRead.getCellData("AddContactData", "CompanyName", 2);
	String Email = exelRead.getCellData("AddContactData", "Email", 2);
	String phone = exelRead.getCellData("AddContactData", "phone", 2);
	String address = exelRead.getCellData("AddContactData", "Address", 2);
	String city = exelRead.getCellData("AddContactData", "City", 2);
	String country = exelRead.getCellData("AddContactData", "Country", 2);
	String state = exelRead.getCellData("AddContactData", "State", 2);
	String zipcode = exelRead.getCellData("AddContactData", "Zip", 2);
	String dashboardHeader = exelRead.getCellData("AddContactData", "Header", 2);
	String TagName = exelRead.getCellData("AddContactData", "Tag", 2);
	String GroupName = exelRead.getCellData("AddContactData", "Group", 2);

	@Test
	public void UserShouldBeAbleToAddCustomer() throws InterruptedException {

		driver = BrowserFactory.init();

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(username);
		loginPage.insertPassword(password);
		loginPage.clickSigninButton();

		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashboardPage(dashboardHeader);
		dashboardPage.ClickOnCustomer();
		dashboardPage.ClickOnAddCustomer();

		AddCustomerPage AddCustomer = PageFactory.initElements(driver, AddCustomerPage.class);
		AddCustomer.ValidateAddContactPage("Add Contact");

		AddCustomer.InsertFullName(fullname);
		AddCustomer.SelectCompany(companyname);
		AddCustomer.InsertEmail(Email);
		AddCustomer.InsertPhoneNumber(phone);
		AddCustomer.Insertaddress(address);
		AddCustomer.Insertcity(city);
		AddCustomer.Insertstate(state);
		AddCustomer.Insertzip(zipcode);

		AddCustomer.selectCountry(country);
		AddCustomer.selectTag(TagName);
		AddCustomer.selectGroup(GroupName);

		AddCustomer.clickOnSaveButton();

		dashboardPage.ClickOnListCustomer();
		AddCustomer.validateInsertedName();
		AddCustomer.clickOnOkButton();
//		ProfilePage profPage=PageFactory.initElements(driver, ProfilePage.class);
//		profPage.validateInsertedName();
		

		BrowserFactory.tearDown();

	}

}
