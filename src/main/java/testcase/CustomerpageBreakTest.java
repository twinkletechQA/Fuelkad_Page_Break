package testcase;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseclass.Base;
import individualPages.CustAccountStatement;
import individualPages.CustAccountSummary;
import individualPages.CustAddSecondaryCard;
import individualPages.CustDetailedReport;
import individualPages.CustGenerateSecondaryCards;
import individualPages.CustInvoice;
import individualPages.CustLoadFuelcard;
import individualPages.CustLoadFuelkadBulkImport;
import individualPages.CustSetupUserAccount;
import individualPages.CustShowFuelkadBalance;
import individualPages.CustSummaryReport;
import individualPages.CustTopupMainAccount;
import individualPages.CustTopupSummary;
import individualPages.CustTransactionSummary;
import individualPages.CustTransferReport;
import individualPages.CustUsers;
import pages.AdminPageBreak;
import pages.LoginPage;

public class CustomerpageBreakTest extends Base {

//	public CustomerpageBreakTest() {
//		super();
//
//	}

	// Test
	LoginPage loginPage;
	AdminPageBreak adminPageBreak;
	CustAccountSummary custAccountSummary;
	CustTransactionSummary custTransactionSummary;
	CustTopupSummary custTopupSummary;
	CustAccountStatement custAccountStatement;
	CustSetupUserAccount custSetupUserAccount;
	CustAddSecondaryCard custAddSecondaryCard;
	CustTopupMainAccount custTopupMainAccount;
	CustShowFuelkadBalance custShowFuelkadBalance;
	CustLoadFuelcard custLoadFuelcard;
	CustLoadFuelkadBulkImport custLoadFuelkadBulkImport;

	CustGenerateSecondaryCards custGenerateSecondaryCards;
	CustUsers custUsers;
	CustInvoice custInvoice;
	CustTransferReport custTransferReport;
	CustSummaryReport custSummaryReport;
	CustDetailedReport custDetailedReport;

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

		loginPage = new LoginPage(driver);
		adminPageBreak = new AdminPageBreak(driver);

		loginPage.login(prop.getProperty("CustomerUsername"), prop.getProperty("CustomerPassword"));
		// adminPageBreak.termsAndConditions();
		// adminPageBreak.AdmincheckBreak();
	}

//	@Test(dependsOnMethods = "dashboardPageBreak", priority = 1, enabled = true)
	public void checkCustomerPageIssues() {

		custAccountSummary = new CustAccountSummary(driver);

		// 1St Page
		custAccountSummary.clickCSV_Download();
		custAccountSummary.clickPDF_Download();
		custAccountSummary.clickEditAccountSettings();
		custAccountSummary.clickAllEditRightButtons();
		custAccountSummary.clickSecondaryCardAddBtn();
		// custAccountSummary.clickAllActive_Inactive();

	}

//	@Test(priority = 2, enabled = true)
	public void checkTransactionSummary() {

		custTransactionSummary = new CustTransactionSummary(driver);

		custTransactionSummary.clickOnMenu();
		custTransactionSummary.clickCSV_Download();
		custTransactionSummary.clickPDF_Download();
		custTransactionSummary.chooseFilterDateAndSearch();
		custTransactionSummary.clickCSV_Download();
		custTransactionSummary.clickPDF_Download();
	}

//	@Test(dependsOnMethods = "dashboardPageBreak", priority = 3, enabled = true)
	public void checkTopupSummary() {

		custTopupSummary = new CustTopupSummary(driver);

		custTopupSummary.clickOnMenu();
		custTopupSummary.clickCSV_Download();
		custTopupSummary.clickPDF_Download();
		custTopupSummary.chooseFilterDateAndSearch();
		custTopupSummary.clickCSV_Download();
		custTopupSummary.clickPDF_Download();
	}

//	@Test(priority = 4)
	public void CustAccountStatementTest() {
		custAccountStatement = new CustAccountStatement(driver);
		custAccountStatement.clickOnMenu();
		custAccountStatement.chooseFilterDateAndSearch();
		custAccountStatement.clickOnSubMenus();
		custAccountStatement.ExportPDF();
		custAccountStatement.clickOnResetBtn();
	}

	// @Test(priority = 5)
	public void CustSetupUserAccountTest() {
		custSetupUserAccount = new CustSetupUserAccount(driver);

		custSetupUserAccount.clickOnMenu();
		custSetupUserAccount.clickCancelBtn();
		custSetupUserAccount.clickSaveBtn();

		custSetupUserAccount.clickOnPassResetLink();
		custSetupUserAccount.clickOnSendRequestClose();
		custSetupUserAccount.clickOnSendRequestCancel();
		custSetupUserAccount.clickOnSendRequestSendValidation();
	}

	// @Test(priority = 6)
	public void CustAddSecondaryCardTest() {
		custAddSecondaryCard = new CustAddSecondaryCard(driver);
		custAddSecondaryCard.clickOnMenu();
		custAddSecondaryCard.clickCancelBtn();
		custAddSecondaryCard.clickSaveBtn();
	}

//	@Test(priority = 7)
	public void CustTopupMainAccountTest() {
		custTopupMainAccount = new CustTopupMainAccount(driver);

		custTopupMainAccount.clickOnMenu();
		custTopupMainAccount.clickOnPayBtn();
		custTopupMainAccount.clickOnTermsAndConditions();
	}

//	@Test(priority = 8)
	public void CustShowFuelkadBalanceTest() {
		custShowFuelkadBalance = new CustShowFuelkadBalance(driver);

		custShowFuelkadBalance.clickOnMenu();
		custShowFuelkadBalance.clickOnCSVDownload();
		custShowFuelkadBalance.clickOnPDFDownload();
		custShowFuelkadBalance.clickOnReverseCredit();
	}

//	@Test(priority = 9)
	public void CustLoadFuelcardTest() {
		custLoadFuelcard = new CustLoadFuelcard(driver);
		custLoadFuelcard.clickOnMenu();
	}

//	@Test(priority = 10)
	public void CustLoadFuelcardBulkImportTest() {
		custLoadFuelkadBulkImport = new CustLoadFuelkadBulkImport(driver);
		custLoadFuelkadBulkImport.clickOnMenu();
		custLoadFuelkadBulkImport.clickOnDownloadFuelkadBulkImport();
		custLoadFuelkadBulkImport.clickOnSubmit();
		custLoadFuelkadBulkImport.clickOnCancel();

		custLoadFuelkadBulkImport.chooseFilterDateAndSearch();
	}

	// @Test(priority = 11)
	public void CustGenerateSecondaryCardsTest() {

		// System.out.println("TEST 5");
		custGenerateSecondaryCards = new CustGenerateSecondaryCards(driver);

		custGenerateSecondaryCards.clickOnMenu();
		custGenerateSecondaryCards.clickPDF_Download();
		custGenerateSecondaryCards.clickCSV_Download();
		custGenerateSecondaryCards.ClickDownloadLink();
		custGenerateSecondaryCards.ClickSubmitButton();
		custGenerateSecondaryCards.ClickCancelButton();

	}

	// @Test(priority = 12)
	public void CustUsersTest() {

		// System.out.println("TEST 5");
		custUsers = new CustUsers(driver);

		custUsers.clickOnMenu();
		custUsers.clickPDF_Download();
		custUsers.clickCSV_Download();
		custUsers.ClickSaveButton();
		custUsers.ClickCancelButton();

	}

	// @Test(priority = 13)

	private void CustInvoiceTest() {

		custInvoice = new CustInvoice(driver);
		custInvoice.clickOnMenu();
		custInvoice.ClickSaveButton();
		custInvoice.ClickCancelButton();

	}

//		@Test(priority = 8)

	private void CusTransferReportTest() {

		custTransferReport = new CustTransferReport(driver);
		custTransferReport.clickOnMenu();
		custTransferReport.chooseFilterDateAndSearch();
		custTransferReport.ClickSearchButton();
		custTransferReport.clickCSV_Download();
		custTransferReport.clickPDF_Download();
		custTransferReport.ClickResetButton();

	}

//		@Test(priority = 9)

	private void CustSummaryReportTest() {

		custSummaryReport = new CustSummaryReport(driver);
		custSummaryReport.clickOnMenu();
		custSummaryReport.chooseFilterDateAndSearch();
		custSummaryReport.ClickSearchButton();
		custSummaryReport.clickPDF_Download();
		custSummaryReport.clickCSV_Download();
		custSummaryReport.ClickResetButton();

	}

	@Test(priority = 10)

	private void CustDetailedReportTest() {

		custDetailedReport = new CustDetailedReport(driver);
		custDetailedReport.clickOnMenu();
		custDetailedReport.chooseFilterDateAndSearch();
		custDetailedReport.SelectRandomDropdownFieldvalue();
		custDetailedReport.SelectCardNumberDropdownField();
		custDetailedReport.ClickSearchButton();
		custDetailedReport.clickCSV_Download();
		custDetailedReport.clickPDF_Download();
		custDetailedReport.clickResetButton();

	}
	
	private void Cust() {
		// tt
	}

}
