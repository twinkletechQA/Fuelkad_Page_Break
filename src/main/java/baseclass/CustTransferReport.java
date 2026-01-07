package individualPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import baseclass.Base;

public class CustTransferReport extends Base{
	
	String BaseUrl = prop.getProperty("custUrl");
	
	
	@FindBy (xpath = "//*[@id=\"navbarsExample03\"]/ul/li[4]/a")
	private WebElement ReportingDashboard;
	
	@FindBy (xpath = "//*[@id=\"navbarsExample03\"]/ul/li[4]/div/a[1]")
	private WebElement TransferReportMenu;
	
	@FindBy(id ="flatpickr")
	private WebElement dateFieldLocator;
	
	@FindBy(id ="search")
	private WebElement searchFilterBtn;
	
	@FindBy (xpath = "//*[@id=\"search\"]/b//*[@id=\"navbarsExample03\"]/ul/li[4]/a")
	private WebElement SearchButton;		
	
	@FindBy (xpath = "//*[@id=\"example_wrapper\"]/div[1]/button[1]/span")
	private WebElement CSVDownload;
	
	@FindBy (xpath = "//*[@id=\"example_wrapper\"]/div[1]/button[2]/span")
	private WebElement PDFDownload;	
	
	@FindBy (xpath = "//*[@id=\"search\"]/b")
	private WebElement ResetButton;
	
	public CustTransferReport(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnMenu() {
		
		waitForElement(ReportingDashboard).click();
		waitForElement(TransferReportMenu).click();
		Assert.assertEquals(driver.getCurrentUrl(), BaseUrl+"TransferReport.do");
		
	}
	
	public void ClickSearchButton() {
		SearchButton.click();
		Assert.assertEquals(driver.getCurrentUrl(), BaseUrl+"SearchTransferReport.do");

	}
	
	public void chooseFilterDateAndSearch() {
		selectTodayAndPreviousMonthDate(dateFieldLocator);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getCurrentUrl(), BaseUrl+"SearchTransferReport.do");
	
	}
	
	public void clickCSV_Download() {
		CSVDownload.click();
	}
	
	public void clickPDF_Download() {
		PDFDownload.click();
	}
	
	
	public void ClickResetButton() {
		ResetButton.click();
	}
	

	

}
