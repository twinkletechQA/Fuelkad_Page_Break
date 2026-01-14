package testcase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseclass.Base;
import individualPages.AdminAllMerchantReport;
import individualPages.AdminDailyMerchantReport;
import individualPages.AdminDashboard;
import individualPages.AdminFinanceReport;
import individualPages.AdminFuelkadCustomers;
import individualPages.AdminTopupCustomers;
import individualPages.AdminTransactionSummary;
import pages.AdminPageBreak;

import pages.LoginPage;

public class AdminpageBreakTest extends Base {

	public AdminpageBreakTest() {
		super();
 
	}
 
	public WebDriver driver;
 
	LoginPage loginPage;
	AdminPageBreak adminPageBreak;
	AdminDashboard adminDashboard;
	AdminFinanceReport adminFinanceReport;
	AdminAllMerchantReport adminallMerchantReport;
	AdminDailyMerchantReport adminDailyMerchantReport;
	AdminFuelkadCustomers adminFuelkadCustomers;
	AdminTopupCustomers adminTopupCustomers;
	AdminTransactionSummary adminTransactionSummary;

	@BeforeClass
	public void setup() {
 
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
 
	}

	@AfterClass
	public void tearDown() {
		
		softAssert.assertAll();
		driver.quit();
 
	}
 
	@Test
	public void dashboardPageBreak() throws InterruptedException, IOException {
  
	//	setup();

		loginPage = new LoginPage(driver);
		adminPageBreak = new AdminPageBreak(driver);
 
		loginPage.login(prop.getProperty("AdminUsername"), prop.getProperty("AdminPassword"));
	//	adminPageBreak.AdmincheckBreak();

	}
	
	@Test(priority = 2)	
	public void checkDashboardTest() {
		adminDashboard = new AdminDashboard(driver);
		adminDashboard.ClickOnMenu();
		adminDashboard.SelectDatesFilter();
		adminDashboard.ClickSearchButton();
		adminDashboard.ClickOnMenu();
 
	}
	@Test(priority = 3)	
	public void CheckFinanceReport() {
		adminFinanceReport = new AdminFinanceReport(driver);
		adminFinanceReport.ClickOnMenu();
		adminFinanceReport.ClickSearchButton();
		adminFinanceReport.ClickExport();
		adminFinanceReport.ClickResetButton();
 	
}
	
	
	@Test(priority = 4)	
	public void CheckAllMerchantReport() {
		adminallMerchantReport = new AdminAllMerchantReport(driver);
		adminallMerchantReport.ClickOnMenu();
		adminallMerchantReport.MerchantFilterDropdown();
		adminallMerchantReport.ClickSearchButton();
		adminallMerchantReport.ClickResetButton();
		adminallMerchantReport.ClickPDF();
		adminallMerchantReport.ClickCSV();		
		adminallMerchantReport.WeeklyPeriodButton();
		adminallMerchantReport.CustomerUsageButton();
		adminallMerchantReport.CustomerLoadTransactions();
		adminallMerchantReport.CustomerPurchases();
		adminallMerchantReport.TaxInvoiceCommissions();

	}
	
	@Test(priority = 5)
	public void CheckDailyMerchantReport() throws InterruptedException {
		
		adminDailyMerchantReport = new AdminDailyMerchantReport(driver);
		adminDailyMerchantReport.ClickOnMenu();
		adminDailyMerchantReport.WithoutStationFilterSearch();
		adminDailyMerchantReport.WithStationfilter();

	}
	
	@Test(priority = 6)
	public void CheckFuelkadCustomers() throws InterruptedException {
		
		adminFuelkadCustomers = new AdminFuelkadCustomers(driver);
		adminFuelkadCustomers.ClickOnMenu();
		adminFuelkadCustomers.SearchButton();
		adminFuelkadCustomers.ExportPDF();
		adminFuelkadCustomers.ExportCSV();
		adminFuelkadCustomers.DeactivateButton();
		adminFuelkadCustomers.BlockButton();
		adminFuelkadCustomers.FilterSearch();
		
}
	
	@Test(priority = 7)	
	public void CheckTopupCustomers() {		
		adminTopupCustomers = new AdminTopupCustomers(driver);
		adminTopupCustomers.ClickOnMenu();
		adminTopupCustomers.DefaultDownloadCSVAndPDF();
		adminTopupCustomers.DateFilterSearch();
		adminTopupCustomers.TopupTypeDropDownSelect();
		adminTopupCustomers.ClickSearchButton();
		adminTopupCustomers.CSVDownload();
		adminTopupCustomers.PDFDownload();
		adminTopupCustomers.ClickCancelButton();
	}
	
	@Test(priority = 8)
	public void CheckTransactionSummary() {
		
		adminTransactionSummary = new AdminTransactionSummary(driver);
		adminTransactionSummary.ClickOnMenu();
		adminTransactionSummary.DefaultDownloadCSVAndPDF();
        adminTransactionSummary.SelectDatesFilter();
        
        //adminTransactionSummary.CheckCustomerID();
        adminTransactionSummary.TopupTypeDropDownSelect();
        //adminTransactionSummary.CheckCardHolderNameFilter();
        //adminTransactionSummary.CheckEmailFilter();
        adminTransactionSummary.ClickSearchButton();
        adminTransactionSummary.CSVDownload();
        adminTransactionSummary.PDFDownload();
        adminTransactionSummary.ClickCancelButton();
        
        
		
	}
}


	
	
