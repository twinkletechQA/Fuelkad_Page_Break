package individualPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import baseclass.Base;

public class AdminFuelkadPromotions extends Base {

	String AdminBaseUrl = prop.getProperty("adminUrl");

	@FindBy(xpath = "//a[normalize-space(text())='Settings']")
	private WebElement SettingsMainMenu;

	@FindBy(xpath = "//a[normalize-space(text())='FuelKad Promotions']")
	private WebElement FuelKadPromotionsSubMenu;

	@FindBy(xpath = "//h1[normalize-space(text())='FuelKad Promotions']")
	private WebElement FuelKadPromotionsTitle;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement SubmitBtn;

	@FindBy(xpath = "//button[@type='reset']")
	private WebElement CancelBtn;
	
	@FindBy(xpath = "//img[contains(@src,'PromptionImage')]")
	private WebElement Image;

	public AdminFuelkadPromotions(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void ClickOnMenu() {
		SettingsMainMenu.click();
		FuelKadPromotionsSubMenu.click();
		verifyUrlIsEqual(AdminBaseUrl + "FuelKadPromotions.do", "CLICK_FuelKadPromotions_MENU");
		verifyIsEqual(FuelKadPromotionsTitle.getText(), "FuelKad Promotions","FuelKadPromotions_TITLE_CHECKING");
	}
	
	public void clickOnSubmitBtn() {
		SubmitBtn.click();
	}
	
	public void clickOnCancelBtn() {
		CancelBtn.click();
	}
	
	public void CheckImageIsThere() {
		

			Boolean imageLoaded = (Boolean) ((JavascriptExecutor) driver)
			        .executeScript(
			            "return arguments[0].complete && "
			          + "typeof arguments[0].naturalWidth != 'undefined' && "
			          + "arguments[0].naturalWidth > 0",
			          Image
			        );

			softAssert.assertTrue(imageLoaded, "Image Not Loaded Fully");
	}

}
