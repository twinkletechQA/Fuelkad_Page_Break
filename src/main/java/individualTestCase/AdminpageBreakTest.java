package individualTestCase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import baseclass.Base;
import individualPages.AdminAllMerchantReport;
import individualPages.AdminDashboard;
import individualPages.AdminFinanceReport;
import individualPages.AdminFuelkadCustomers;
import pages.LoginPage;

public class AdminpageBreakTest extends Base{

	public AdminpageBreakTest() {
		super();

	}

	public WebDriver driver;

	LoginPage loginPage;
	AdminDashboard das;

	public void setup() {

		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));

	}

	public void tearDown() {

		driver.quit();

	}

	@Test
	public void dashboardPageBreak() throws InterruptedException, IOException {

		setup();
		loginPage = new LoginPage(driver);
		das = new AdminDashboard(driver);
		AdminFinanceReport financeReport = new AdminFinanceReport(driver);
		AdminAllMerchantReport allMerchantReport = new AdminAllMerchantReport(driver);
		AdminFuelkadCustomers fuelkadCustomer = new AdminFuelkadCustomers(driver);

		loginPage.login(prop.getProperty("AdminUsername"), prop.getProperty("AdminPassword"));
	
//		das.testCase1();
//		financeReport.testCase1();
//		allMerchantReport.testCase1();
		
		fuelkadCustomer.testCase1(); 
		
	}



}
