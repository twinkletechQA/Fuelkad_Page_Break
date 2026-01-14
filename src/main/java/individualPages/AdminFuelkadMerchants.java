package individualPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseclass.Base;

public class AdminFuelkadMerchants extends Base {

	String AdminBaseUrl = prop.getProperty("adminUrl");

	@FindBy(xpath = "(//a[normalize-space(text())='FuelKad Merchants'])[1]")
	private WebElement FuelKadMerchantsMainMenu;

	@FindBy(xpath = "(//a[normalize-space(text())='FuelKad Merchants'])[2]")
	private WebElement FuelKadMerchantsSubMenu;

	@FindBy(xpath = "//h1[normalize-space(text())='FuelKad Merchants']")
	private WebElement FuelkadMerchantsTitle;

	@FindBy(xpath = "//h1[normalize-space(text())='FuelKad Merchants List']")
	private WebElement FuelkadMerchantsListTitle;

	@FindBy(xpath = "//button[@class='dt-button buttons-csv buttons-html5']")
	private WebElement CSV_Download;

	@FindBy(xpath = "//button[@class='dt-button buttons-pdf buttons-html5']")
	private WebElement PDF_Download;

	@FindBy(xpath = "//button[contains(@class,'btn-merchant') and normalize-space()='Create Merchant']")
	private WebElement CreateMerchantBtn;

	@FindBy(xpath = "//h1[normalize-space(text())='Add Merchant']")
	private WebElement CreateMerchantTitle;

	@FindBy(xpath = "//button[contains(@type,'submit') and normalize-space()='Create']")
	private WebElement AddMerchantCreateBtn;

	@FindBy(xpath = "//button[contains(@type,'reset') and normalize-space()='Back']")
	private WebElement AddMerchantBackBtn;

	@FindBy(id ="flatpickr")
	private WebElement dateFieldLocator;
	
	@FindBy(xpath = "//button[contains(@type,'submit') and normalize-space()='Search']")
	private WebElement SearchBtn;

	@FindBy(xpath = "//button[contains(@type,'reset') and normalize-space()='Reset']")
	private WebElement ResetBtn;

	public AdminFuelkadMerchants(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void ClickOnMenu() {
		FuelKadMerchantsMainMenu.click();
		FuelKadMerchantsSubMenu.click();
		verifyUrlIsEqual(AdminBaseUrl + "FuelKadVendors.do", "CLICK_FuelKadMerchant_MENU");
		verifyIsEqual(FuelkadMerchantsTitle.getText(), "FuelKad Merchants", "FuelKadMerchant_TITLE_CHECKING");
	}

	public void clickOnCreateMerchantBtn() {
		CreateMerchantBtn.click();
		verifyUrlIsEqual(AdminBaseUrl + "AddMerchant.do", "CLICK_AddMerchant_MENU");
		verifyIsEqual(CreateMerchantTitle.getText(), "Add Merchant", "AddMerchant_TITLE_CHECKING");
		AddMerchantCreateBtn.click();
		AddMerchantBackBtn.click();
		verifyUrlIsEqual(AdminBaseUrl + "FuelKadVendors.do", "CLICK_AddMerchantBackBtn_MENU");
	}

	public void clickCSV_Download() {
		CSV_Download.click();
	}

	public void clickPDF_Download() {
		PDF_Download.click();
	}

	public void clickOnSearchBtn() {
		SearchBtn.click();
	}

	public void clickOnResetBtn() {
		ResetBtn.click();
	}
	
	public void chooseFilterDateAndSearch() {
		
		selectTodayAndPreviousMonthDate(waitForElement(dateFieldLocator));	
	}

}
