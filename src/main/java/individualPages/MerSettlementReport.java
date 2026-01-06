package individualPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import baseclass.Base;

public class MerSettlementReport extends Base {
	
	String MerchantBaseUrl = prop.getProperty("merUrl");
	
	@FindBy(xpath = "//a[contains(text(), 'Dashboard')]")
	private WebElement DashboardMenu;
	
	@FindBy(xpath = "//a[normalize-space(text())='Settlement Report']")
	private WebElement SettlementReportMenu;
	
	@FindBy(xpath = "//button[@class='dt-button buttons-csv buttons-html5']")
	private WebElement CSV_Download;
	
	@FindBy(xpath = "//button[@class='dt-button buttons-pdf buttons-html5']")
	private WebElement PDF_Download;
	
	@FindBy(xpath ="//button[@type='submit']")
	private WebElement searchFilterBtn;
	
	@FindBy(xpath ="//button[@type='reset']")
	private WebElement cancelBtn;
	
	@FindBy(id ="flatpickr")
	private WebElement dateFieldLocator;
	
	@FindBy(id ="amTime")
	private WebElement amFilterDropdown;
	
	@FindBy(id ="pmTime")
	private WebElement pmFilterDropdown;
	
	public MerSettlementReport(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnMenu() {
		DashboardMenu.click();
		SettlementReportMenu.click();
		Assert.assertEquals(driver.getCurrentUrl(), MerchantBaseUrl+"SettlementReport.do");
	}
	
	public void clickCSV_Download() {
		CSV_Download.click();
	}
	
	public void clickPDF_Download() {
		PDF_Download.click();
	}
	
	public void clickOnSearchBtn() {
		searchFilterBtn.click();
		Assert.assertEquals(driver.getCurrentUrl(), MerchantBaseUrl+"SearchSettlementReport.do");
	}
	
	public void clickOnResetBtn() {
		cancelBtn.click();
		Assert.assertEquals(driver.getCurrentUrl(), MerchantBaseUrl+"SettlementReport.do");
	}
	
	public void chooseFilterDateAndSearch() {
		selectTodayAndPreviousMonthDate(dateFieldLocator);
		SelectRandomDropdownFieldvalue(amFilterDropdown);
		SelectRandomDropdownFieldvalue(pmFilterDropdown);
	}

}
