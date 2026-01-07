package testcase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseclass.Base;
import individualPages.MerDailyReport;
import individualPages.MerFuelPrice;
import individualPages.MerFuelStationDevices;
import individualPages.MerSettlementReport;
import individualPages.MerTransactionDetails;
import individualPages.MerUserAccountSettings;
import individualPages.MerchantUsers;
import pages.AdminPageBreak;
import pages.LoginPage;

public class MerchantpageBreakTest extends Base {

	public MerchantpageBreakTest() {
		super();

	}

	public WebDriver driver;

	LoginPage loginPage;
	AdminPageBreak adminPageBreak;
	MerTransactionDetails merTransactionDetails;
	MerSettlementReport merSettlementReport;
	MerDailyReport merDailyReport;
	MerFuelStationDevices merFuelStationDevices;
	MerUserAccountSettings merUserAccountSettings;
	MerFuelPrice merFuelPrice;

	MerchantUsers merchantUsers;

	@BeforeClass
	public void setup() {

		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));

	}

	@AfterClass
	public void tearDown() {
		
		softAssert.assertAll();
		driver.quit();

	}

	@Test(priority = 1)
	public void dashboardPageBreak() throws InterruptedException, IOException {

		// setup();

		loginPage = new LoginPage(driver);
		adminPageBreak = new AdminPageBreak(driver);

		loginPage.login(prop.getProperty("MerchantUsername"), prop.getProperty("MerchantPassword"));
		// adminPageBreak.AdmincheckBreak();
	}

//	@Test(priority = 2)	
	public void CheckTransactionDetailsTest() {

		merTransactionDetails = new MerTransactionDetails(driver);
		merTransactionDetails.clickOnMenu();
		merTransactionDetails.clickCSV_Download();
		merTransactionDetails.clickPDF_Download();
		merTransactionDetails.chooseFilterDateAndSearch();
		merTransactionDetails.clickOnSearchBtn();
		merTransactionDetails.clickOnResetBtn();
	}

//  @Test(priority = 3)	
	public void CheckSettlementReportTest() {

		merSettlementReport = new MerSettlementReport(driver);
		merSettlementReport.clickOnMenu();
		merSettlementReport.clickCSV_Download();
		merSettlementReport.clickPDF_Download();
		merSettlementReport.chooseFilterDateAndSearch();
		merSettlementReport.clickOnSearchBtn();
		merSettlementReport.clickOnResetBtn();
	}

//  @Test(priority = 4)
	public void checkDailyReportTest() {

		merDailyReport = new MerDailyReport(driver);
		merDailyReport.clickOnMenu();
		merDailyReport.clickOnSearchBtn();
		merDailyReport.clickOnExportPDF();
		merDailyReport.clickOnExportExcel();
		merDailyReport.clickOnPeriodMenu();
		merDailyReport.clickOnCustomerUsageMenu();
		merDailyReport.clickOnCustomerPurchasesMenu();

		merDailyReport.chooseFilterDateAndSearch();
		merDailyReport.chooseFilterMerchantDDAndSearch();
		merDailyReport.chooseFilterMerchantStationDDAndSearch();

		merDailyReport.clickOnExportPDF();
		merDailyReport.clickOnExportExcel();
		merDailyReport.clickOnPeriodMenu();
		merDailyReport.clickOnCustomerUsageMenu();
		merDailyReport.clickOnCustomerPurchasesMenu();
	}

//	@Test(priority = 5)
	public void checkFuelStationDevicesTest() {

		merFuelStationDevices = new MerFuelStationDevices(driver);
		merFuelStationDevices.clickOnMenu();
		merFuelStationDevices.clickOnAddManageDevice();
		merFuelStationDevices.clickOnDeviceListEdit();
	}
	
//	@Test(priority = 6)
	public void checkUserAccountSettingsTest() {
		merUserAccountSettings = new MerUserAccountSettings(driver);
		merUserAccountSettings.clickOnMenu();
		merUserAccountSettings.clickOnPassResetLink();
		merUserAccountSettings.clickSaveBtn();
		merUserAccountSettings.clickBackBtn();
	}
	
	@Test(priority = 7)
	public void checkSetFuelPriceTest() {
		merFuelPrice = new MerFuelPrice(driver);
		merFuelPrice.clickOnMenu();
		merFuelPrice.clickOnSaveBtn();
		merFuelPrice.clickOnCancelBtn();
		merFuelPrice.clickCSV_Download();
		merFuelPrice.clickPDF_Download();
		merFuelPrice.clickOnHistyoryOfFuelPrice();
		merFuelPrice.clickOnFuelPriceListEdit();		
	}

//	@Test(priority = 8)
	private void MerchantUsersTest() {

		merchantUsers = new MerchantUsers(driver);
		merchantUsers.clickOnMenu();
		merchantUsers.ClickSaveButton();
		merchantUsers.ClickCancelButton();
		merchantUsers.clickCSV_Download();
		merchantUsers.clickPDF_Download();
	}

}
