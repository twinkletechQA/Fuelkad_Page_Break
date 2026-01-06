package individualPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import baseclass.Base;

public class MerTransactionDetails extends Base {
	
	String MerchantBaseUrl = prop.getProperty("merUrl");
	
	@FindBy(xpath = "//a[contains(text(), 'Dashboard')]")
	private WebElement DashboardMenu;
	
	@FindBy(xpath = "//a[normalize-space(text())='Transaction Details']")
	private WebElement TransactionDetailsMenu;
	
	@FindBy(xpath = "//button[@class='dt-button buttons-csv buttons-html5']")
	private WebElement CSV_Download;
	
	@FindBy(xpath = "//button[@class='dt-button buttons-pdf buttons-html5']")
	private WebElement PDF_Download;
	
	@FindBy(xpath ="//button[@type='submit']")
	private WebElement searchFilterBtn;
	
	@FindBy(xpath ="//button[@type='reset']")
	private WebElement resetBtn;
	
	@FindBy(id ="flatpickr")
	private WebElement dateFieldLocator;
	
	@FindBy(id ="status")
	private WebElement transactionStatusFilterDropdown;
	
	@FindBy(id ="station")
	private WebElement StationsFilterDropdown;

	
	public MerTransactionDetails(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnMenu() {
		DashboardMenu.click();
		TransactionDetailsMenu.click();
		Assert.assertEquals(driver.getCurrentUrl(), MerchantBaseUrl+"VendorTransactionDetails.do");
	}
	
	public void clickCSV_Download() {
		CSV_Download.click();
	}
	
	public void clickPDF_Download() {
		PDF_Download.click();
	}
	
	public void clickOnSearchBtn() {
		searchFilterBtn.click();
		Assert.assertEquals(driver.getCurrentUrl(), MerchantBaseUrl+"SearchTransactionDetails.do");
	}
	
	public void clickOnResetBtn() {
		resetBtn.click();
		Assert.assertEquals(driver.getCurrentUrl(), MerchantBaseUrl+"VendorTransactionDetails.do");
	}
	
	public void chooseFilterDateAndSearch() {
		selectTodayAndPreviousMonthDate(dateFieldLocator);
		SelectRandomDropdownFieldvalue(transactionStatusFilterDropdown);
		SelectRandomDropdownFieldvalue(StationsFilterDropdown);
	}
	
	

}
