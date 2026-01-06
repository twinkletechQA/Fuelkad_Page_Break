package individualPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import baseclass.Base;

public class CustAccountStatement extends Base {
	
	@FindBy(xpath = "//a[contains(text(), 'Dashboard')]")
	private WebElement DashboardMenu;
	
	@FindBy(xpath = "//a[normalize-space(text())='Account Statement']")
	private WebElement AccountStatementMenu;
	
	@FindBy(id ="flatpickr")
	private WebElement dateFieldLocator;
	
	@FindBy(id ="search")
	private WebElement SearchFilterBtn;
	
	@FindBy(id ="asdas")
	private WebElement ResetFilterBtn;
	
	@FindBy(id ="ExportPdf")
	private WebElement ExportPdfBtn;
	
	@FindBy(id ="accountSummaryButton")
	private WebElement AccountSummaryButtonBtn;
	
	@FindBy(id ="summaryByCardButton")
	private WebElement SummaryByCardButtonBtn;
	
	@FindBy(id ="usageReportButton")
	private WebElement UsageReportButtonBtn;
	
	public CustAccountStatement(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnMenu() 
	{
		DashboardMenu.click();
		waitForElement(AccountStatementMenu).click();
		Assert.assertEquals(driver.getCurrentUrl(), getBaseURL()+"accountStatement.do");
	}
	
	public void chooseFilterDateAndSearch()
	{
		selectTodayAndPreviousMonthDate(dateFieldLocator);
		SearchFilterBtn.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getCurrentUrl(), getBaseURL() + "SearchAccountStatement.do");
	}
	
	public void clickOnSubMenus()
	{
		SummaryByCardButtonBtn.click();
		UsageReportButtonBtn.click();
		AccountSummaryButtonBtn.click();
	}
	
	public void clickOnSearchBtn() 
	{
		SearchFilterBtn.click();
	}
	
	public void clickOnResetBtn() 
	{
		ResetFilterBtn.click();
	}
	
	public void ExportPDF() 
	{
		ExportPdfBtn.click();
	}

}
