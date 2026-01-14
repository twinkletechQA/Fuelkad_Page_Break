package individualPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseclass.Base;

public class AdminDailyMerchantReport extends Base{
	
	String AdminBaseUrl = prop.getProperty("adminUrl");

	@FindBy(xpath = "//*[@id=\"navbarsExample03\"]/ul/li[1]/a")
	private WebElement DASHBOARD_MENU;

	@FindBy(xpath = "//*[@id=\"navbarsExample03\"]/ul/li[1]/div/a[4]")
	private WebElement SUB_DASHBOARD_MENU;
	
	@FindBy(id = "flatpickr")
	private WebElement FILTER_DATE_FIELD;	
	
	@FindBy(xpath = "/html/body/div[4]/div[2]/div/div[2]/div/span[3]")
	private WebElement FILTER_FROM_DATE;

	@FindBy(xpath = "/html/body/div[4]/div[2]/div/div[2]/div/span[32]")
	private WebElement FILTER_TO_DATE;
	
	@FindBy(id ="merchantId")
	private WebElement MerchantDropdown;
	
	@FindBy(id ="vendorLocation")
	private WebElement MerchantStationDropdown;		

	@FindBy(xpath = "//*[@id=\"frmTransactions\"]/div/div/div[2]/div/div/div[1]/button")
	private WebElement SEARCH_BTN;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement Reset_Btn;
	
	@FindBy(xpath = "//*[@id=\"ExportPdf\"]/b")
	private WebElement ExportPDF;
	
	@FindBy(xpath = "//*[@id=\"buttons\"]/div/button")
	private WebElement ExportExcel;

	@FindBy(id = "dailyPeriodButton")
	private WebElement PeriodButton;
	
	@FindBy(id = "customerUsageButton")
	private WebElement CustomerUsage;	
	
	@FindBy(id = "customerPurchaseButton")
	private WebElement CustomerPurchase;
	
	@FindBy(xpath = "//*[@id=\"dailyPeriod12_wrapper\"]/div[1]/button/span")
	private WebElement DailyPeriodExportCSV;
	
	@FindBy(xpath = "//*[@id=\"customerUse_wrapper\"]/div[1]/button/span")
	private WebElement CustomerUsageCSV;
	
	@FindBy(xpath = "//*[@id=\"CustomerPurchase_wrapper\"]/div[1]/button/span")
	private WebElement CustomerPurchasesCSV;

	
	public AdminDailyMerchantReport(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}	

	public void ClickOnMenu() {
		DASHBOARD_MENU.click();
		SUB_DASHBOARD_MENU.click();			
	}
	
	public void WithoutStationFilterSearch() throws InterruptedException {
		selectTodayAndPreviousMonthDate(FILTER_DATE_FIELD);
		SelectRandomDropdownFieldvalue(MerchantDropdown);
		SEARCH_BTN.click();
		Thread.sleep(1000);
		ExportPDF.click();
		ExportExcel.click();		
		PeriodButton.click();
		DailyPeriodExportCSV.click();
		CustomerUsage.click();
		CustomerUsageCSV.click();
		CustomerPurchase.click();
		CustomerPurchasesCSV.click();
		Reset_Btn.click();
	}
	
	
	  public void WithStationfilter() throws InterruptedException {	  
	  selectTodayAndPreviousMonthDate(FILTER_DATE_FIELD);
	  SelectRandomDropdownFieldvalue(MerchantDropdown);
	  SelectRandomDropdownFieldvalue(MerchantStationDropdown); SEARCH_BTN.click();
	  Thread.sleep(1000); ExportPDF.click(); ExportExcel.click();
	  PeriodButton.click(); DailyPeriodExportCSV.click(); CustomerUsage.click();
	  CustomerUsageCSV.click(); CustomerPurchase.click();
	  CustomerPurchasesCSV.click(); Reset_Btn.click();
	  
	  
	  
	  }
	 
	
}
