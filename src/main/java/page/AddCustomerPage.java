package page;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AddCustomerPage extends BasePage {

	WebDriver driver;

	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//h5[contains(text(),'Add Contact')]")
	WebElement ADD_CONTACT_PAGE;
	@FindBy(how = How.XPATH, using = "//input[@id='account']")
	WebElement FULL_NAME_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"cid\"]")
	WebElement COMPANY_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='email']")
	WebElement EMAIL_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='phone']")
	WebElement PHONE_NUMBER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='address']")
	WebElement ADDRESS_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='city']")
	WebElement CITY_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='state']")
	WebElement STATE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='zip']")
	WebElement ZIP_CODE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//select[@id='country']")
	WebElement COUNTRY_ELEMENT;
	@FindBy(how = How.XPATH, using = "//select[@id='tags']")
	WebElement TAG_ELEMENT;
	@FindBy(how = How.XPATH, using = "//select[@id='group']")
	WebElement GROUP_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='password']")
	WebElement PASSWORD_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='cpassword']")
	WebElement CONFIRM_PASSWORD_ELEMENT;
	@FindBy(how = How.XPATH, using = "//button[@id='submit']")
	WebElement SAVE_BUTTON_ELEMENT;
	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-primary']")
	WebElement OK_BUTTON_ELEMENT;
	String InsertedName;
	

	public void ValidateAddContactPage(String AddContact) {
		Assert.assertEquals(ADD_CONTACT_PAGE.getText(), AddContact, "WRONG PAGE!");
	}

	public void InsertFullName(String FullName) {
		InsertedName = FullName + generateRandomNumber(99);
		FULL_NAME_ELEMENT.sendKeys(InsertedName);
	}

	public void SelectCompany(String visibleText) {
		SelectFromDropDown(COMPANY_ELEMENT, visibleText);
	}

	public void InsertEmail(String Email) {
		EMAIL_ELEMENT.sendKeys(generateRandomNumber(99) + Email);
	}

	public void InsertPhoneNumber(String phone) {
		PHONE_NUMBER_ELEMENT.sendKeys(phone);
	}

	public void Insertaddress(String Address) {
		ADDRESS_ELEMENT.sendKeys(Address);

	}

	public void Insertcity(String phone) {
		CITY_ELEMENT.sendKeys(phone);
	}

	public void Insertstate(String phone) {
		STATE_ELEMENT.sendKeys(phone);
	}

	public void Insertzip(String phone) {
		ZIP_CODE_ELEMENT.sendKeys(phone);
	}

	public void selectCountry(String visibleText) {
		SelectFromDropDown(COUNTRY_ELEMENT, visibleText);
	}

	public void selectTag(String visibleText) {
		SelectFromDropDown(TAG_ELEMENT, visibleText);
	}

	public void selectGroup(String visibleText) {
		SelectFromDropDown(GROUP_ELEMENT, visibleText);
	}

	public void insertPasswords(String Password, String ConfirmPassword) {
		PASSWORD_ELEMENT.sendKeys(Password);
		CONFIRM_PASSWORD_ELEMENT.sendKeys(ConfirmPassword);
	}

	public void clickOnSaveButton() {
		SAVE_BUTTON_ELEMENT.click();
	}

	public void validateInsertedName() {
		String Before = "//tbody/tr[";
		String After = "]/td[3]";
		String After_Delete="]/td[7]/a[2]";
		
		
		for (int i = 1; i <= 5; i++) {
			String ListedCustomer = driver.findElement(By.xpath(Before + i + After)).getText();
			System.out.println(ListedCustomer);
//			Assert.assertEquals(ListedCustomer, InsertedName, "WRONG NAME!");
//			break;
			if(ListedCustomer.equalsIgnoreCase(InsertedName)) {
				driver.findElement(By.xpath(Before + i + After_Delete)).click();
			}
		}
		
	}
	public void clickOnOkButton() throws InterruptedException {
		Thread.sleep(3000);
		OK_BUTTON_ELEMENT.click();
	}
}
