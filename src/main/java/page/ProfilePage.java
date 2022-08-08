package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ProfilePage {

	WebDriver driver;
	public ProfilePage(WebDriver driver) {
		this.driver=driver;
	}
	
	
//	@FindBy(how = How.XPATH, using = "//tbody/tr[1]/td[3]/a")
//	WebElement PROFILE_PAGE_ELEMENT;
	
	public void validateInsertedName() {
		String Before="//tbody/tr[";
		String After="]/td[3]/a";
		for(int i=1; i<=5; i++) {
			String ListedCustomer=driver.findElement(By.xpath(Before+i+After)).getText();
			System.out.println(ListedCustomer);
		
			
		//	Assert.assertEquals(ListedCustomer,InsertedName, "WRONG NAME!");
		}
		
	}
}
