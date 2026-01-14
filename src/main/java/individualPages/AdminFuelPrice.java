package individualPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import baseclass.Base;

public class AdminFuelPrice extends Base {
	
	String AdminBaseUrl = prop.getProperty("adminUrl");
	
	@FindBy(xpath = "//a[normalize-space(text())='Settings']")
	private WebElement SettingsMainMenu;

	@FindBy(xpath = "//a[normalize-space(text())='Fuel Price']")
	private WebElement FuelPriceMenu;
	
	@FindBy(xpath = "//h1[normalize-space(text())='Fuel Price']")
	private WebElement FuelPriceTitle;
	
	@FindBy(xpath = "//button[@class='dt-button buttons-csv buttons-html5']")
	private WebElement CSV_Download;
	
	@FindBy(xpath = "//button[@class='dt-button buttons-pdf buttons-html5']")
	private WebElement PDF_Download;
	
	@FindBy(xpath ="//button[@type='submit']")
	private WebElement SearchBtn;
	
	@FindBy(xpath ="(//button[@type='reset'])[1]")
	private WebElement ResetBtn;
	
	@FindBy(xpath = "//h1[normalize-space(text())='Fuel Price History']")
	private WebElement FuelPriceHistoryTitle;
	
	@FindBy(xpath ="(//button[@type='reset'])[2]")
	private WebElement ViewHistoryOFFuelPriceBtn;
	
	@FindBy(xpath ="(//button[@type='reset'])[2]")
	private WebElement FuelPriceHistoryResetBtn;
	
	@FindBy(xpath ="(//button[@type='reset'])[1]")
	private WebElement FuelPriceHistoryBackBtn;
	
	@FindBy(id ="flatpickr")
	private WebElement dateFieldLocator;
	
	public AdminFuelPrice(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void ClickOnMenu() {
		SettingsMainMenu.click();
		FuelPriceMenu.click();
		verifyUrlIsEqual(AdminBaseUrl + "FuelAmountSave.do", "CLICK_FuelPrice_MENU");
		verifyIsEqual(FuelPriceTitle.getText(), "Audit Log","FuelPrice_TITLE_CHECKING");
	}
	
	public void clickOnSearchBtn() {
		SearchBtn.click();
	}
	
	public void clickOnResetBtn() {
		ResetBtn.click();
	}
	
	public void clickCSV_Download() {
		CSV_Download.click();
	}
	
	public void clickPDF_Download() {
		PDF_Download.click();
	}
	
	public void chooseFilterDateAndSearch() {
		selectTodayAndPreviousMonthDate(dateFieldLocator);	
	}
	
	public void clickOnHistyoryOfFuelPrice() {
		ViewHistoryOFFuelPriceBtn.click();
		verifyUrlIsEqual(AdminBaseUrl + "DownloadFuelAmountHistory.do","CLICK_ViewHistoryOFFuelPriceBtn");
		verifyIsEqual(FuelPriceHistoryTitle.getText(), "Fuel Price History","CLICK_ViewHistoryOFFuelPriceBtn");
		clickCSV_Download();
		clickPDF_Download();
		
		clickOnSearchBtn();
		verifyUrlIsEqual(AdminBaseUrl + "SearchFuelAmountHistory.do","CLICK_Search");
		clickCSV_Download();
		clickPDF_Download();
		
		chooseFilterDateAndSearch();
		clickOnSearchBtn();
		verifyUrlIsEqual(AdminBaseUrl + "SearchFuelAmountHistory.do","CLICK_Search");
		clickCSV_Download();
		clickPDF_Download();
		
		FuelPriceHistoryResetBtn.click();
		FuelPriceHistoryBackBtn.click();
		
	}

}
