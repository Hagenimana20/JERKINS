package page;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {

	WebDriver driver;

	public int generateRandomNumber(int boundaryNo) {
		Random rnd = new Random();
		int RandomNumber = rnd.nextInt(boundaryNo);
		return RandomNumber;
	}

	public void SelectFromDropDown(WebElement element, String VisibleText) {
		Select sel = new Select(element);
		sel.selectByVisibleText(VisibleText);
	}
}
