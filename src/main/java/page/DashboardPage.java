package page;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class DashboardPage {

	WebDriver driver;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[2]/div/h2")
	WebElement DASHBOARD_HEADER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Customers')]")
	WebElement CUSTOMER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//A[contains(text(),'Add Customer')]")
	WebElement ADD_CUSTOMER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'List Customers')]")
	WebElement LIST_CUSTOMER_ELEMENT;
	

	public void validateDashboardPage(String validationText) {
		Assert.assertEquals(DASHBOARD_HEADER_ELEMENT.getText(), validationText, "WRONG PAGE!!");

	}

	public void ClickOnCustomer() {
		CUSTOMER_ELEMENT.click();
	}

	public void ClickOnAddCustomer() {
		ADD_CUSTOMER_ELEMENT.click();
	}
	public void ClickOnListCustomer() throws InterruptedException {
		Thread.sleep(3000);
		LIST_CUSTOMER_ELEMENT.click();
	}
}
