package individualPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import baseclass.Base;

public class CustLoadFuelcard extends Base {
	
	@FindBy(xpath = "//a[normalize-space(text())='Topup And Load']")
    private WebElement TopupAndLoadMenu;
	
	@FindBy(xpath = "//a[normalize-space(text())='Load Fuelcard']")
	private WebElement LoadFuelcardMenu;

	public CustLoadFuelcard(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnMenu() 
	{
		waitForElement(TopupAndLoadMenu).click();
		waitForElement(LoadFuelcardMenu).click();
		Assert.assertEquals(driver.getCurrentUrl(), getBaseURL()+"loadfuelcard.do");
	}
	
}
