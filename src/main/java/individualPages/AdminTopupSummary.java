package individualPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseclass.Base;

public class AdminTopupSummary extends Base {

	String AdminBaseUrl = prop.getProperty("adminUrl");

	@FindBy(xpath = "(//a[normalize-space(text())='FuelKad Customers'])[1]")
	private WebElement FuelKadCustomersMainMenu;

	@FindBy(xpath = "//a[normalize-space(text())='Top-up Summary']")
	private WebElement TopupSummarySubMenu;

	@FindBy(xpath = "//button[@class='dt-button buttons-csv buttons-html5']")
	private WebElement CSV_Download;

	@FindBy(xpath = "//button[@class='dt-button buttons-pdf buttons-html5']")
	private WebElement PDF_Download;

	@FindBy(id = "flatpickr")
	private WebElement dateFieldLocator;

	@FindBy(id = "topup")
	private WebElement TopupTypeFilter;

	@FindBy(xpath = "//button[contains(@type,'submit') and normalize-space()='Search']")
	private WebElement SearchBtn;

	@FindBy(xpath = "//button[contains(@type,'reset') and normalize-space()='Cancel']")
	private WebElement CancelBtn;

	public AdminTopupSummary(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
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

	public void clickOnCancelBtn() {
		CancelBtn.click();
	}
	
	public void ClickOnMenu() {
		FuelKadCustomersMainMenu.click();
		TopupSummarySubMenu.click();
		verifyUrlIsEqual(AdminBaseUrl + "admincustomertopupdetails.do", "CLICK_TopupSummaryMenu_MENU");
	}
	
	public void chooseOneMonthFilterDateAndSearch() {		
		selectTodayAndPreviousMonthDate(waitForElement(dateFieldLocator));
		SelectRandomDropdownFieldvalue(TopupTypeFilter);
		clickOnSearchBtn();
		verifyUrlIsEqual(AdminBaseUrl + "AdminSearchtopupdetails.do", "CLICK_SearchBtn");
		clickCSV_Download();
		clickPDF_Download();
		ClickOnPaginationButtonUntilDisabled();
		clickOnCancelBtn();
		verifyUrlIsEqual(AdminBaseUrl + "admincustomertopupdetails.do", "CLICK_FilterReset_Btn");
	}
	
	public void withoutFilter() {
		clickCSV_Download();
		clickPDF_Download();
		ClickOnPaginationButtonUntilDisabled();
	}
	
	public void emptyFilterSearch() {
		clickOnSearchBtn();
		verifyUrlIsEqual(AdminBaseUrl + "AdminVendorSearchTransactionDetails.do", "CLICK_SearchBtn");
		clickCSV_Download();
		clickPDF_Download();
		ClickOnPaginationButtonUntilDisabled();
		clickOnCancelBtn();
		verifyUrlIsEqual(AdminBaseUrl + "admincustomertopupdetails.do", "CLICK_FilterReset_Btn");
	}

}
