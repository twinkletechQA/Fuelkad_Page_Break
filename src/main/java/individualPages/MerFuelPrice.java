package individualPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import baseclass.Base;

public class MerFuelPrice extends Base {
	
    String MerchantBaseUrl = prop.getProperty("merUrl");

	@FindBy(xpath = "//a[normalize-space(text())='Set Fuel Price']")
	private WebElement SetFuelPriceMenu;

	@FindBy(xpath = "//a[normalize-space(text())='Fuel Price']")
	private WebElement FuelPriceMenu;
	
	public MerFuelPrice(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnMenu() {
		SetFuelPriceMenu.click();
		FuelPriceMenu.click();
		Assert.assertEquals(driver.getCurrentUrl(), MerchantBaseUrl + "VendorAccountSetting.do");
	}

}
