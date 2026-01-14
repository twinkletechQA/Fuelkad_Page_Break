package testcase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseclass.Base;
import individualPages.AdminAdjustMainACBalance;
import individualPages.AdminAllMerchantReport;
import individualPages.AdminAuditLog;
import individualPages.AdminBrandManagement;
import individualPages.AdminDailyMerchantReport;
import individualPages.AdminDashboard;
import individualPages.AdminFinanceReport;
import individualPages.AdminFuelPrice;
import individualPages.AdminFuelStation;
import individualPages.AdminFuelkadCustomers;
import individualPages.AdminFuelkadMerchants;
import individualPages.AdminFuelkadPromotions;
import individualPages.AdminFuelkadStatus;
import individualPages.AdminMerchantTransactionSummary;
import individualPages.AdminOnBoardCustomer;
import individualPages.AdminTopupCustomers;
import individualPages.AdminTopupSummary;
import individualPages.AdminTransactionSummary;
import individualPages.AdminVehicleMakeAndModel;
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
	AdminMerchantTransactionSummary adminMerchantTransactionSummary;
	AdminOnBoardCustomer adminOnBoardCustomer;
	AdminAuditLog adminAuditLog;
	AdminFuelkadPromotions adminFuelkadPromotions;
	AdminFuelPrice adminFuelPrice;
	AdminFuelkadStatus adminFuelkadStatus;
	AdminVehicleMakeAndModel adminVehicleMakeAndModel;
	AdminBrandManagement adminBrandManagement;
	AdminFuelkadMerchants adminFuelkadMerchants;
	AdminTransactionSummary adminTransactionSummary;
	AdminFuelStation adminFuelStation;
	AdminAdjustMainACBalance adminAdjustMainACBalance;
	AdminTopupSummary adminTopupSummary;

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

		// setup();

		loginPage = new LoginPage(driver);
		adminPageBreak = new AdminPageBreak(driver);

		loginPage.login(prop.getProperty("AdminUsername"), prop.getProperty("AdminPassword"));
		// adminPageBreak.AdmincheckBreak();

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

		// adminTransactionSummary.CheckCustomerID();
		adminTransactionSummary.TopupTypeDropDownSelect();
		// adminTransactionSummary.CheckCardHolderNameFilter();
		// adminTransactionSummary.CheckEmailFilter();
		adminTransactionSummary.ClickSearchButton();
		adminTransactionSummary.CSVDownload();
		adminTransactionSummary.PDFDownload();
		adminTransactionSummary.ClickCancelButton();

	}

	@Test(priority = 20)
	private void CheckOnBoardCuatomerTest() {
		adminOnBoardCustomer = new AdminOnBoardCustomer(driver);
		adminOnBoardCustomer.ClickOnMenu();
		adminOnBoardCustomer.clickOnRegisterBtn();
		adminOnBoardCustomer.clickOnCancelBtn();
		adminOnBoardCustomer.clickCSV_Download();
		adminOnBoardCustomer.clickPDF_Download();
		adminOnBoardCustomer.clickOnOnboardCustomerList();
	}

	@Test(priority = 21)
	private void CheckAuditLogTest() {
		adminAuditLog = new AdminAuditLog(driver);
		adminAuditLog.ClickOnMenu();
		adminAuditLog.clickOnSearchBtn();
		adminAuditLog.clickCSV_Download();
		adminAuditLog.clickPDF_Download();
		adminAuditLog.clickOnResetBtn();
		adminAuditLog.chooseFilterDateAndSearch();
		adminAuditLog.clickOnSearchBtn();
		ClickOnPaginationButtonUntilDisabled();
		adminAuditLog.clickOnResetBtn();
	}

	@Test(priority = 22)
	private void CheckFuelkadPromotionsTest() {
		adminFuelkadPromotions = new AdminFuelkadPromotions(driver);
		adminFuelkadPromotions.ClickOnMenu();
		adminFuelkadPromotions.clickOnSubmitBtn();
		adminFuelkadPromotions.clickOnCancelBtn();
		adminFuelkadPromotions.CheckImageIsThere();
	}

	@Test(priority = 23)
	private void CheckFuelPriceTest() {
		adminFuelPrice = new AdminFuelPrice(driver);
		adminFuelPrice.ClickOnMenu();
		adminFuelPrice.clickOnSearchBtn();
		adminFuelPrice.clickCSV_Download();
		adminFuelPrice.clickPDF_Download();

		adminFuelPrice.chooseFilterDateAndSearch();
		adminFuelPrice.clickOnSearchBtn();
		adminFuelPrice.clickCSV_Download();
		adminFuelPrice.clickPDF_Download();
		adminFuelPrice.clickOnResetBtn();

		adminFuelPrice.clickOnHistyoryOfFuelPrice();
	}

	@Test(priority = 24)
	private void CheckFuelkadStatusTest() {
		adminFuelkadStatus = new AdminFuelkadStatus(driver);

		adminFuelkadStatus.ClickOnMenu();
		adminFuelkadStatus.clickCSV_Download();
		adminFuelkadStatus.clickPDF_Download();

		adminFuelkadStatus.clickOnSearchBtn();
		adminFuelkadStatus.clickCSV_Download();
		adminFuelkadStatus.clickPDF_Download();

		adminFuelkadStatus.chooseFilterDateAndSearch();
		adminFuelkadStatus.clickOnSearchBtn();
		adminFuelkadStatus.clickCSV_Download();
		adminFuelkadStatus.clickPDF_Download();

		ClickOnPaginationButtonUntilDisabled();
		adminFuelkadStatus.clickOnResetBtn();
	}

	@Test(priority = 25)
	private void CheckVehicleMakeAndModelTest() {
		adminVehicleMakeAndModel = new AdminVehicleMakeAndModel(driver);

		adminVehicleMakeAndModel.ClickOnMenu();
		adminVehicleMakeAndModel.CheckMakeView();
		adminVehicleMakeAndModel.CheckModelView();
		adminVehicleMakeAndModel.CheckSubModelView();
		adminVehicleMakeAndModel.addMake();
		adminVehicleMakeAndModel.addModel();
		adminVehicleMakeAndModel.addSubModel();
	}

	@Test(priority = 26)
	private void CheckBrandManagementTest() {
		adminBrandManagement = new AdminBrandManagement(driver);

		adminBrandManagement.ClickOnMenu();
		adminBrandManagement.CheckProvinceView();
		adminBrandManagement.CheckTownView();
		adminBrandManagement.CheckLocationView();
		adminBrandManagement.CheckFuelBrandView();
	}

	@Test(priority = 27)
	private void CheckFuelkadMerchantsTest() {
		adminFuelkadMerchants = new AdminFuelkadMerchants(driver);
		adminFuelkadMerchants.ClickOnMenu();
		adminFuelkadMerchants.clickCSV_Download();
		adminFuelkadMerchants.clickPDF_Download();
		adminFuelkadMerchants.clickOnSearchBtn();
		adminFuelkadMerchants.clickOnResetBtn();
		adminFuelkadMerchants.clickOnCreateMerchantBtn();
		adminFuelkadMerchants.chooseFilterDateAndSearch();
		ClickOnPaginationButtonUntilDisabled();
	}

	@Test(priority = 28)
	private void CheckTransactionSummaryTest() {
		adminMerchantTransactionSummary = new AdminMerchantTransactionSummary(driver);
		adminMerchantTransactionSummary.withoutFilter();
		adminMerchantTransactionSummary.emptyFilterSearch();
		adminMerchantTransactionSummary.chooseOneMonthFilterDateAndSearch();
	}

	@Test(priority = 29)
	private void CheckAdminFuelStationTest() {
		adminFuelStation = new AdminFuelStation(driver);

		adminFuelStation.clickOnFuelStationMenu();
		adminFuelStation.clickOnAddNewStation();
		adminFuelStation.clickOnEditBtn();
	}

	@Test(priority = 30)
	private void CheckAdminAdjustMainACBalanceTest() {
		adminAdjustMainACBalance = new AdminAdjustMainACBalance(driver);

		adminAdjustMainACBalance.ClickOnMenu();
		adminAdjustMainACBalance.passValuesOnCustomerAdminName();
		adminAdjustMainACBalance.withoutFilter();
		adminAdjustMainACBalance.emptyFilterSearch();
		adminAdjustMainACBalance.chooseOneMonthFilterDateAndSearch();

	}

	@Test(priority = 31)
	private void CheckAdminTopupSummaryTest() {
		adminTopupSummary = new AdminTopupSummary(driver);

		adminTopupSummary.ClickOnMenu();
		adminTopupSummary.withoutFilter();
		adminTopupSummary.emptyFilterSearch();
		adminTopupSummary.chooseOneMonthFilterDateAndSearch();

	}

}
