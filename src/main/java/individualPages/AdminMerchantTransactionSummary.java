package individualPages;

import baseclass.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminMerchantTransactionSummary extends Base {
	
String AdminBaseUrl = prop.getProperty("adminUrl");
	
	@FindBy(xpath = "//a[normalize-space(text())='FuelKad Merchants']")
	private WebElement FuelKadMerchantsMainMenu;
	
	@FindBy(xpath = "(//a[normalize-space(text())='Transaction Summary'])[2]")
	private WebElement TransactionSummarySubMenu;

	@FindBy(xpath = "//h1[normalize-space(text())='Transaction Summary']")
	private WebElement TransactionSummaryTitle;
	
	@FindBy(xpath = "//h1[normalize-space(text())='Transaction Summary List']")
	private WebElement TransactionSummaryListTitle;
	
	@FindBy(xpath = "//button[@class='dt-button buttons-csv buttons-html5']")
	private WebElement CSV_Download;

	@FindBy(xpath = "//button[@class='dt-button buttons-pdf buttons-html5']")
	private WebElement PDF_Download;
	
	@FindBy(id ="flatpickr")
	private WebElement dateFieldLocator;
	
	@FindBy(id ="status")
	private WebElement TransactionStatusFilter;
	
	@FindBy(id ="station")
	private WebElement StationStatusFilter;
	
	@FindBy(xpath = "//button[contains(@type,'submit') and normalize-space()='Search']")
	private WebElement SearchBtn;

	@FindBy(xpath = "//button[contains(@type,'reset') and normalize-space()='Reset']")
	private WebElement ResetBtn;
	
	public AdminMerchantTransactionSummary(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void ClickOnMenu() {
		FuelKadMerchantsMainMenu.click();
		TransactionSummarySubMenu.click();
		verifyUrlIsEqual(AdminBaseUrl + "AdminVendorVendorTransactionDetails.do", "CLICK_TransactionSummary_MENU");
		verifyIsEqual(TransactionSummaryTitle.getText(), "FuelKad Merchants", "TransactionSummary_TITLE_CHECKING");
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
	
	public void chooseOneMonthFilterDateAndSearch() {		
		selectTodayAndPreviousMonthDate(waitForElement(dateFieldLocator));
		SelectRandomDropdownFieldvalue(TransactionStatusFilter);
		SelectRandomDropdownFieldvalue(StationStatusFilter);
		clickOnSearchBtn();
		verifyUrlIsEqual(AdminBaseUrl + "AdminVendorSearchTransactionDetails.do", "CLICK_SearchBtn_MENU");
		clickCSV_Download();
		clickPDF_Download();
		ClickOnPaginationButtonUntilDisabled();
		clickOnResetBtn();
		verifyUrlIsEqual(AdminBaseUrl + "AdminVendorVendorTransactionDetails.do", "CLICK_FilterReset_MENU");
	}
	
	public void withoutFilter() {
		ClickOnMenu();
		clickCSV_Download();
		clickPDF_Download();
		ClickOnPaginationButtonUntilDisabled();
	}
	
	public void emptyFilterSearch() {
		clickOnSearchBtn();
		verifyUrlIsEqual(AdminBaseUrl + "AdminVendorSearchTransactionDetails.do", "CLICK_SearchBtn_MENU");
		clickCSV_Download();
		clickPDF_Download();
		ClickOnPaginationButtonUntilDisabled();
		clickOnResetBtn();
		verifyUrlIsEqual(AdminBaseUrl + "AdminVendorVendorTransactionDetails.do", "CLICK_FilterReset_MENU");
	}

}
