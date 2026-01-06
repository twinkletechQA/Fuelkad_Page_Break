package testcase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseclass.Base;
import individualPages.MerSettlementReport;
import individualPages.MerTransactionDetails;
import pages.AdminPageBreak;
import pages.LoginPage;

public class MerchantpageBreakTest extends Base{

	public MerchantpageBreakTest() {
		super();

	}

	public WebDriver driver;

	LoginPage loginPage;
	AdminPageBreak adminPageBreak;
	MerTransactionDetails merTransactionDetails;
	MerSettlementReport merSettlementReport;

	@BeforeClass
	public void setup() {

		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));

	}
	
	@AfterClass
	public void tearDown() {

		driver.quit();

	}

	@Test
	public void dashboardPageBreak() throws InterruptedException, IOException {

		// try {

	//	setup();

		loginPage = new LoginPage(driver);
		adminPageBreak = new AdminPageBreak(driver);

		loginPage.login(prop.getProperty("MerchantUsername"), prop.getProperty("MerchantPassword"));
	//	adminPageBreak.AdmincheckBreak();
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
	
    @Test(priority = 3)	
	public void CheckSettlementReportTest() {
		
    	merSettlementReport = new MerSettlementReport(driver);
    	merSettlementReport.clickOnMenu();
    	merSettlementReport.clickCSV_Download();
    	merSettlementReport.clickPDF_Download();
    	merSettlementReport.chooseFilterDateAndSearch();
    	merSettlementReport.clickOnSearchBtn();
    	merSettlementReport.clickOnResetBtn();
	}


}
