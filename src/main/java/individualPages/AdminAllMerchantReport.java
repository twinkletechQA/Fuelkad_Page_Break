package individualPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import baseclass.Base;

public class AdminAllMerchantReport extends Base {

	String AdminBaseUrl = prop.getProperty("adminUrl");


	@FindBy(xpath = "//*[@id=\"navbarsExample03\"]/ul/li[1]/a")
	private WebElement DASHBOARD_MENU;

	@FindBy(xpath = "//*[@id=\"navbarsExample03\"]/ul/li[1]/div/a[3]")
	private WebElement SUB_DASHBOARD_MENU;

	@FindBy(xpath = "//*[@id=\"merchantId\"]")
	private WebElement FILTER_MERCHANT_DD_FIELD;
	
	@FindBy(id ="vendorLocation")
	private WebElement MerchantStationDropdown;
	

	@FindBy(xpath = "//*[@id=\"frmTransactions\"]/div/div/div[2]/div/div/div[1]/button")
	private WebElement SEARCH_BTN;

	@FindBy(xpath = "//*[@id=\"frmTransactions\"]/div/div/div[2]/div/div/div[3]/button")
	private WebElement RESET_BTN;

	@FindBy(xpath = "//*[@id=\"ExportPdf\"]")
	private WebElement EXPORT_PDF_FIELD;

	@FindBy(xpath = "//*[@id=\"buttons\"]/div/button")
	private WebElement EXPORT_CSV_FIELD;

	@FindBy(xpath = "//*[@id=\"weeklyPeriodButton\"]")
	private WebElement WEEKLY_PERIOD_BTN;

	@FindBy(xpath = "//*[@id=\"weeklyPeriod12_wrapper\"]/div[1]/button")
	private WebElement WEEKLY_PERIOD_EXPORT_CSV_FIELD;

	@FindBy(xpath = "//*[@id=\"customerUsageButton\"]")
	private WebElement CUSTOMER_USAGE_BTN;

	@FindBy(xpath = "//*[@id=\"customerUse_wrapper\"]/div[1]/button")
	private WebElement CUSTOMER_USAGE_EXPORT_CSV_FIELD;

	@FindBy(xpath = "//*[@id=\"customerLoadTxButton\"]")
	private WebElement CUSTOMER_LOAD_TRANS_BTN;

	@FindBy(xpath = "//*[@id=\"CustomerLoadTx_wrapper\"]/div[1]/button")
	private WebElement CUSTOMER_LOAD_TRANS_EXPORT_CSV_FIELD;

	@FindBy(xpath = "//*[@id=\"customerPurchaseButton\"]")
	private WebElement CUSTOMER_PURCHASE_BTN;

	@FindBy(xpath = "//*[@id=\"CustomerPurchase_wrapper\"]/div[1]/button")
	private WebElement CUSTOMER_PURCHASE_EXPORT_CSV_FIELD;
	
	@FindBy(id = "taxInvoiceCommissionButton")
	private WebElement TaxInvoice_Commissions;

	public AdminAllMerchantReport(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void ClickOnMenu() {
		DASHBOARD_MENU.click();
		SUB_DASHBOARD_MENU.click();
		verifyUrlIsEqual(AdminBaseUrl+"GetMerchantReport.do", "CLICK_MAIN_MENU");
	}
	
	public void MerchantFilterDropdown() {
		SelectRandomDropdownFieldvalue(FILTER_MERCHANT_DD_FIELD);
	}
	
	public void ClickSearchButton() {
		SEARCH_BTN.click();
		verifyUrlIsEqual(AdminBaseUrl+"SearchMerchantReport.do", "SEARCH");
	}
	
	public void ClickResetButton() {
		RESET_BTN.click();
		verifyUrlIsEqual(AdminBaseUrl+"GetMerchantReport.do", "RESET");

	}
	
	public void ClickPDF() {
    EXPORT_PDF_FIELD.click();
		
	}
		
	public void ClickCSV() {
    EXPORT_CSV_FIELD.click();
		
	}
	
	
	public void WeeklyPeriodButton() {
	WEEKLY_PERIOD_BTN.click();
	WEEKLY_PERIOD_EXPORT_CSV_FIELD.click();	
		
	}
	public void CustomerUsageButton() {
	CUSTOMER_USAGE_BTN.click();
	CUSTOMER_USAGE_EXPORT_CSV_FIELD.click();		
		
	}
	

	public void CustomerLoadTransactions() {
	CUSTOMER_LOAD_TRANS_BTN.click();
	CUSTOMER_LOAD_TRANS_EXPORT_CSV_FIELD.click();
		
		
	}
	
	public void CustomerPurchases() {
	CUSTOMER_PURCHASE_BTN.click();
	CUSTOMER_PURCHASE_EXPORT_CSV_FIELD.click();		
		
	}
	public void TaxInvoiceCommissions() {
	TaxInvoice_Commissions.click();
		
	}
	
	
	public void WeeklyPeriodwithSations() {
	TaxInvoice_Commissions.click();
	CUSTOMER_LOAD_TRANS_EXPORT_CSV_FIELD.click();

	  }
	  
	  
	  
	 	 
	
	

}