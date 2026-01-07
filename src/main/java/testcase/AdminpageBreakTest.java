package testcase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseclass.Base;
import individualPages.AdminDashboard;
import individualPages.AdminFinanceReport;
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
	private void checkDashboardTest() {
		adminDashboard = new AdminDashboard(driver);
		adminDashboard.ClickOnMenu();
		adminDashboard.SelectDatesFilter();
		adminDashboard.ClickSearchButton();
		adminDashboard.ClickOnMenu();
 
	}
	@Test(priority = 3)	
	private void CheckFinanceReport() {
		adminFinanceReport = new AdminFinanceReport(driver);
		adminFinanceReport.ClickOnMenu();
		adminFinanceReport.ClickSearchButton();
		adminFinanceReport.ClickExport();
		adminFinanceReport.ClickResetButton();
 	
}
	
	
	
	
}