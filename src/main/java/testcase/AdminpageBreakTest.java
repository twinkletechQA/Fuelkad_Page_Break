package testcase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import baseclass.Base;
import pages.AdminPageBreak;
import pages.LoginPage;

public class AdminpageBreakTest extends Base {

	public AdminpageBreakTest() {
		super();

	}

	public WebDriver driver;

	LoginPage loginPage;
	AdminPageBreak adminPageBreak;

	public void setup() {

		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));

	}

	public void tearDown() {

		driver.quit();

	}

	@Test
	public void dashboardPageBreak() throws InterruptedException, IOException {

		// try {

		setup();

		loginPage = new LoginPage(driver);
		adminPageBreak = new AdminPageBreak(driver);

		loginPage.login(prop.getProperty("AdminUsername"), prop.getProperty("AdminPassword"));
		adminPageBreak.AdmincheckBreak();

	}

}
