package individualPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import baseclass.Base;

public class CustTopupSummary extends Base {
	
    String BaseUrl = prop.getProperty("custUrl");
		
	@FindBy(xpath = "//a[contains(text(), 'Dashboard')]")
	private WebElement DashboardMenu;
	
	@FindBy(xpath = "//a[normalize-space(text())='Top-up Summary']")
	private WebElement TopupSummaryMenu;
	
	@FindBy(xpath = "//button[@class='dt-button buttons-csv buttons-html5']")
	private WebElement CSV_Download;
	
	@FindBy(xpath = "//button[@class='dt-button buttons-pdf buttons-html5']")
	private WebElement PDF_Download;
	
	@FindBy(xpath ="//button[@type='submit']")
	private WebElement searchFilterBtn;
	
	@FindBy(xpath ="//button[@type='reset']")
	private WebElement cancelFilterBtn;
	
	@FindBy(id ="flatpickr")
	private WebElement dateFieldLocator;
	
	public CustTopupSummary(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnMenu() {
		DashboardMenu.click();
		waitForElement(TopupSummaryMenu).click();
		Assert.assertEquals(driver.getCurrentUrl(), BaseUrl+"topupdetails.do");
	}
	
	public void clickCSV_Download() {
		CSV_Download.click();
	}
	
	public void clickPDF_Download() {
		PDF_Download.click();
	}
	
	public void chooseFilterDateAndSearch() {
		selectTodayAndPreviousMonthDate(dateFieldLocator);
		searchFilterBtn.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getCurrentUrl(), BaseUrl+"Searchtopupdetails.do");

	}

}
