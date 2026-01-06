package testcase;

import java.io.IOException;

import org.json.JSONArray;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.opencsv.exceptions.CsvException;

import baseclass.Base;
import pages.AdminPageBreak;
import pages.AllMerchantReport;
import pages.FinanceReport;
import pages.LoginPage;

public class FinanceReporttest extends Base {

	public FinanceReporttest() {
		super();

	}

	public WebDriver driver;

	LoginPage loginPage;
	AdminPageBreak adminPageBreak;
	FinanceReport financeReport;
	AllMerchantReport allMerchantReport;

	@BeforeClass
	public void setup() {

		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		loginPage = new LoginPage(driver);
		
		loginPage.login(prop.getProperty("AdminUsername"), prop.getProperty("AdminPassword"));

	}

	@AfterClass
	public void tearDown() {

		driver.quit();

	}

//	@Test
	public void TestCase1() throws InterruptedException, IOException, CsvException {
		loginPage = new LoginPage(driver);
		adminPageBreak = new AdminPageBreak(driver);
		financeReport = new FinanceReport(driver);
		loginPage.login(prop.getProperty("AdminUsername"), prop.getProperty("AdminPassword"));
		JSONArray checkCondition = financeReport.checkCondition();
		financeReport.clickNextBTN();
		financeReport.clickPreviousBTN();
		JSONArray exportCsvAndGetValues = financeReport.ExportCsvAndGetValues();
		boolean compareJSONArrays = financeReport.compareJSONArrays(checkCondition, exportCsvAndGetValues);
		Assert.assertEquals(true, compareJSONArrays);
	}
	
	@Test
	public void TestCase2() throws IOException{
//		allMerchantReport = new AllMerchantReport(driver);
//		allMerchantReport.setDashboardMenu(allMerchantReport.getDashboardMenu());
//		allMerchantReport.setAllMerchantReportMenu(allMerchantReport.getAllMerchantReportMenu());
//		allMerchantReport.setMerchantDDFilter(allMerchantReport.getMerchantDDFilter());
//		allMerchantReport.setSearchBTN(allMerchantReport.getSearchBTN());
//		allMerchantReport.getPdfContent("file:///D:/Vignesh R (09-08-2024)/TSS Projects/Automation download files/Twinkle Team_Merchant_Report_23-10-2024 14_52_5.pdf");		
//		allMerchantReport.setExportPDFBTN(allMerchantReport.getExportPDFBTN());
//		System.out.println(allMerchantReport.readPDFInURL());

		 
		
	}

}
