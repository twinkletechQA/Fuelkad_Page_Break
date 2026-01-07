package individualPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import baseclass.Base;

public class MerDailyReport extends Base {

	String MerchantBaseUrl = prop.getProperty("merUrl");

	@FindBy(xpath = "//a[contains(text(), 'Dashboard')]")
	private WebElement DashboardMenu;

	@FindBy(xpath = "//a[contains(text(), 'Daily Report')]")
	private WebElement DailyReportMenu;

	@FindBy(id = "flatpickr")
	private WebElement dateFieldLocator;

	@FindBy(id = "merchantId")
	private WebElement MerchantDropdown;

	@FindBy(id = "vendorLocation")
	private WebElement MerchantStationDropdown;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement SearchButton;

	@FindBy(xpath = "//button[@type='reset']")
	private WebElement ResetButton;

	@FindBy(id = "ExportPdf")
	private WebElement PDFDownload;

	@FindBy(xpath = "//*[@id='buttons']/div/button")
	private WebElement ExportExcel;

	@FindBy(id = "dailyPeriodButton")
	private WebElement PeriodMenu;

	@FindBy(xpath = "//div[@id='dailyPeriod12_wrapper']//button[contains(@class,'buttons-csv')]")
	private WebElement PeriodCSVBtn;

	@FindBy(id = "customerUsageButton")
	private WebElement CustomerUsageMenu;

	@FindBy(xpath = "//div[@id='customerUse_wrapper']//button[contains(@class,'buttons-csv')]")
	private WebElement CustomerUsageCSVBtn;

	@FindBy(id = "customerPurchaseButton")
	private WebElement CustomerPurchasesMenu;

	@FindBy(xpath = "//div[@id='CustomerPurchase_wrapper']//button[contains(@class,'buttons-csv')]")
	private WebElement CustomerPurchasesCSVBtn;

	public MerDailyReport(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnMenu() {
		DashboardMenu.click();
		DailyReportMenu.click();
		Assert.assertEquals(driver.getCurrentUrl(), MerchantBaseUrl + "GetDailyVendorReport.do");
	}
	
	public void chooseFilterDateAndSearch() {
		selectTodayAndPreviousMonthDate(dateFieldLocator);
		clickOnSearchBtn();
	}
	
	public void chooseFilterMerchantDDAndSearch() {
		SelectRandomDropdownFieldvalue(MerchantDropdown);
		clickOnSearchBtn();
	}
	
	public void chooseFilterMerchantStationDDAndSearch() {
		SelectRandomDropdownFieldvalue(MerchantStationDropdown);
		clickOnSearchBtn();
	}

	public void clickOnSearchBtn() {
		SearchButton.click();
	}

	public void clickOnResetBtn() {
		ResetButton.click();
	}

	public void clickOnExportPDF() {
		PDFDownload.click();
	}

	public void clickOnExportExcel() {
		ExportExcel.click();
	}

	public void clickOnPeriodMenu() {
		PeriodMenu.click();
		PeriodCSVBtn.click();
	}
	
	public void clickOnCustomerUsageMenu() {
		CustomerUsageMenu.click();
		CustomerUsageCSVBtn.click();
	}
	
	public void clickOnCustomerPurchasesMenu() {
		CustomerPurchasesMenu.click();
		CustomerPurchasesCSVBtn.click();
	}

}
