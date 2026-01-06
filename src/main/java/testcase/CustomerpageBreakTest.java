package testcase;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseclass.Base;
import individualPages.CustAccountStatement;
import individualPages.CustAccountSummary;
import individualPages.CustSetupUserAccount;
import individualPages.CustShowFuelkadBalance;
import individualPages.CustTopupMainAccount;
import individualPages.CustTopupSummary;
import individualPages.CustTransactionSummary;
import individualPages.CustAddSecondaryCard;
import individualPages.CustLoadFuelcard;
import individualPages.CustLoadFuelkadBulkImport;
import pages.AdminPageBreak;
import pages.LoginPage;

public class CustomerpageBreakTest extends Base{

//	public CustomerpageBreakTest() {
//		super();
//
//	}

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

	@BeforeClass
	public void setup() 
	{
		
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
	
	}

	@AfterClass
	public void tearDown() 
	{
		driver.quit();
	}

	@Test
	public void dashboardPageBreak() throws InterruptedException, IOException {

		loginPage = new LoginPage(driver);
		adminPageBreak = new AdminPageBreak(driver);

		loginPage.login(prop.getProperty("CustomerUsername"), prop.getProperty("CustomerPassword"));
	//	adminPageBreak.termsAndConditions();
	//	adminPageBreak.AdmincheckBreak();
	}

//	@Test(dependsOnMethods = "dashboardPageBreak", priority = 1, enabled = true)
	public void checkCustomerPageIssues(){
		
		custAccountSummary = new CustAccountSummary(driver);
		
		// 1St Page
		custAccountSummary.clickCSV_Download();
		custAccountSummary.clickPDF_Download();
		custAccountSummary.clickEditAccountSettings();
		custAccountSummary.clickAllEditRightButtons();
		custAccountSummary.clickSecondaryCardAddBtn();
	//	custAccountSummary.clickAllActive_Inactive();
	
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
	public void CustAccountStatementTest() 
	{
		custAccountStatement = new CustAccountStatement(driver);
		custAccountStatement.clickOnMenu();
		custAccountStatement.chooseFilterDateAndSearch();
		custAccountStatement.clickOnSubMenus();
		custAccountStatement.ExportPDF();
		custAccountStatement.clickOnResetBtn();
	}
	
 //	@Test(priority = 5)
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
	
 //	@Test(priority = 6)
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
	
	@Test(priority = 10)
    public void CustLoadFuelcardBulkImportTest() {
    	custLoadFuelkadBulkImport = new CustLoadFuelkadBulkImport(driver);
    	custLoadFuelkadBulkImport.clickOnMenu();
    	custLoadFuelkadBulkImport.clickOnDownloadFuelkadBulkImport();
    	custLoadFuelkadBulkImport.clickOnSubmit();
    	custLoadFuelkadBulkImport.clickOnCancel();
    	
    	custLoadFuelkadBulkImport.chooseFilterDateAndSearch();
	}

}
