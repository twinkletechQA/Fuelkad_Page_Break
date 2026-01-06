package individualPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import baseclass.Base;

public class MerchantDailyReport extends Base {
	
    String MerchantBaseUrl = prop.getProperty("merUrl");
	
	@FindBy(xpath = "//a[contains(text(), 'Dashboard')]")
	private WebElement DashboardMenu;
	
	@FindBy(xpath = "//a[normalize-space(text())='Settlement Report']")
	private WebElement SettlementReportMenu;
	
	public MerchantDailyReport(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnMenu() {
		DashboardMenu.click();
		SettlementReportMenu.click();
		Assert.assertEquals(driver.getCurrentUrl(), MerchantBaseUrl+"SettlementReport.do");
	}

}
